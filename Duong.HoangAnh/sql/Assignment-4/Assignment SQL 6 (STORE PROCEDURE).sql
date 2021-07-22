-- 1)
DROP PROCEDURE IF EXISTS Show_Account_Each_Department;
delimiter //
CREATE PROCEDURE Show_Account_Each_Department(IN DepartmentName VARCHAR(50))
	BEGIN
		SELECT * 
        FROM `Account` acc
        LEFT JOIN `Department` depart 
        ON acc.DepartmentID = depart.DepartmentID
        WHERE depart.DepartmentName = DepartmentName;
	END //
delimiter ;
CALL Show_Account_Each_Department("sale");

-- 2)
DROP PROCEDURE IF EXISTS Find_Amount_Account_Each_Group;
delimiter //
CREATE PROCEDURE Find_Amount_Account_Each_Group(IN GroupName VARCHAR(50), OUT AmountAccount INT)
	BEGIN
		SELECT count(grAcc.AccountID) INTO AmountAccount
        FROM `GroupAccount` grAcc
        LEFT JOIN `Group` gr 
        ON grAcc.GroupID = gr.GroupID
        WHERE gr.GroupName = GroupName
        GROUP BY grAcc.GroupID;
	END //
delimiter ;
CALL Find_Amount_Account_Each_Group("hello",@AmountAccount);
SELECT @AmountAccount;

-- 3)
DROP PROCEDURE IF EXISTS Amount_Question_Of_Type_In_Month;
delimiter //
CREATE PROCEDURE Amount_Question_Of_Type_In_Month(IN TypeName VARCHAR(50), OUT AmountQuestion INT)
	BEGIN
		SELECT count(ques.QuestionID) INTO AmountQuestion
        FROM `TypeQuestion` typeQues
        LEFT JOIN `Question` ques 
        ON typeQues.TypeID = ques.TypeID
        WHERE typeQues.TypeName = TypeName 
        AND MONTH(ques.CreateDate) = MONTH(NOW())
        AND YEAR(ques.CreateDate) = YEAR(NOW())
        GROUP BY typeQues.TypeID;
	END //
delimiter ;
CALL Amount_Question_Of_Type_In_Month("trac nhiem",@AmountQuestion);
SELECT @AmountQuestion;

-- 4)
DROP PROCEDURE IF EXISTS Show_ID_Max_Question;
delimiter //
CREATE PROCEDURE Show_ID_Max_Question(OUT type_id INT)
	BEGIN
		WITH Find_Max_Question(TypeID, AmountQuestion) AS (
			SELECT typeQues.TypeID, count(ques.QuestionID) AS AmountQuestion
			FROM `TypeQuestion` typeQues
			LEFT JOIN `Question` ques 
			ON typeQues.TypeID = ques.TypeID
			GROUP BY typeQues.TypeID
        )
		SELECT TypeID INTO type_id
        FROM Find_Max_Question
        WHERE AmountQuestion = (
			SELECT max(AmountQuestion) 
            FROM Find_Max_Question
            )
		LIMIT 1;
	END //
delimiter ;
CALL Show_ID_Max_Question(@TypeID);
SELECT @TypeID;

-- 5) 
DROP PROCEDURE IF EXISTS Find_Name_Type_Max_Question;
delimiter //
CREATE PROCEDURE Find_Name_Type_Max_Question(OUT type_name VARCHAR(50))
	BEGIN
		CALL Show_ID_Max_Question(@TypeID);
		SELECT typeQues.TypeName INTO type_name
        FROM `TypeQuestion` typeQues
        WHERE typeQues.TypeID = @TypeID;
	END //
delimiter ;
CALL Find_Name_Type_Max_Question(@TypeName);
SELECT @TypeName;

-- 6)
DROP PROCEDURE IF EXISTS Find_Group_or_Account;
delimiter //
CREATE PROCEDURE Find_Group_or_Account(IN input_string VARCHAR(50))
	BEGIN
		SELECT gr.GroupName as 'Name'
		FROM `Group` gr
		WHERE gr.GroupName like CONCAT("%",input_string,"%")
        UNION
        SELECT acc.FullName
		FROM `Account` acc
		WHERE acc.FullName like CONCAT("%",input_string,"%");
	END //
delimiter ;
CALL Find_Group_or_Account("ye");

-- 7)
DROP PROCEDURE IF EXISTS Input_Account;
delimiter //
CREATE PROCEDURE Input_Account(IN full_name VARCHAR(50), IN email VARCHAR(50),OUT result VARCHAR(50))
	BEGIN
		INSERT INTO `Account`(Email, UserName, FullName, DepartmentID, PositionID, CreateDate)
		VALUE(email, SUBSTRING_INDEX(email, "@", 1), full_name, 1, 1, now());
        SET @isExists = (SELECT count(*) FROM `Account` acc WHERE acc.Email = email);
		IF (@isExists > 0) THEN
			SET @output = "Thanh Cong";
			SELECT @output INTO result;
		ELSE 
			SET @output = "That Bai";
			SELECT @output INTO result;
		END IF;
	END //
delimiter ;
CALL Input_Account("hoang anh duong", "duondasd@gmail.com", @output);
SELECT @output;

-- 8)
DROP PROCEDURE IF EXISTS Long_Or_Short_Content;
delimiter //
CREATE PROCEDURE Long_Or_Short_Content(IN Multiple_Choice INT,OUT result VARCHAR(1000))
	BEGIN
		IF(Multiple_Choice = 1) THEN
			SELECT ques.Content INTO result
			FROM `Question` ques
			ORDER BY LENGTH(ques.Content) DESC
			LIMIT 1;
        ELSE
			SELECT ques.Content INTO result
			FROM `Question` ques
			ORDER BY LENGTH(ques.Content) ASC
			LIMIT 1;
		END IF;
	END //
delimiter ;
CALL Long_Or_Short_Content(1, @output);
SELECT @output;

-- 9)
DROP PROCEDURE IF EXISTS Delete_Exam;
delimiter //
CREATE PROCEDURE Delete_Exam(IN exam_id INT,OUT result VARCHAR(1000))
	BEGIN
		SET @isExists = (SELECT count(*) 
						 FROM `Exam` ex 
                         WHERE ex.ExamID = exam_id);
                         
		IF (@isExists > 0) 
        THEN DELETE 
			 FROM `Exam` ex 
			 WHERE ex.ExamID = exam_id;
             SET @result = "Xoa Thanh Cong !";
             SELECT @result INTO result;
        ELSE
			SET @result = "Ban Ghi Khong Ton Tai!";
			SELECT @result INTO result;
        END IF;
	END //
delimiter ;
CALL Delete_Exam(1, @output);
SELECT @output;

-- 10)
DROP PROCEDURE IF EXISTS Delete_Exam_Three_Year_Ago;
delimiter //
CREATE PROCEDURE Delete_Exam_Three_Year_Ago()
	BEGIN
		SELECT * 
		FROM `Exam` ex 
		WHERE ex.CreateDate < DATE_SUB(NOW(), INTERVAL 3 YEAR);
        
        DELETE 
		FROM `Exam` ex 
		WHERE ex.CreateDate < DATE_SUB(NOW(), INTERVAL 3 YEAR);
	END //
delimiter ;
CALL Delete_Exam_Three_Year_Ago();

-- 11)
DROP PROCEDURE IF EXISTS Delete_Department;
delimiter //
CREATE PROCEDURE Delete_Department(IN department_name VARCHAR(50))
	BEGIN
		UPDATE `Account` acc
        JOIN `Department` depart 
        ON acc.DepartmentID = depart.DepartmentID
        SET acc.DepartmentID = 1
        WHERE depart.DepartmentName = department_name;
        
        DELETE
        FROM `Department` depart
        WHERE depart.DepartmentName = department_name;
        
        SELECT * FROM `Department`;
	END //
delimiter ;
CALL Delete_Department("sale");

-- 12)
DROP PROCEDURE IF EXISTS Amount_Question;
delimiter //
CREATE PROCEDURE Amount_Question()
	BEGIN
        SELECT MONTH(ques.CreateDate) as _Month ,count(ques.QuestionID) as Amount
		FROM `Question` ques
		WHERE YEAR(ques.CreateDate) = YEAR(NOW())
		GROUP BY MONTH(ques.CreateDate)
        ORDER BY MONTH(ques.CreateDate);
	END //
delimiter ;
CALL Amount_Question();

-- 13)
DROP PROCEDURE IF EXISTS Amount_Question_Near_By_Six_Month;
delimiter //
CREATE PROCEDURE Amount_Question_Near_By_Six_Month()
	BEGIN	
		SELECT MONTH(ques.CreateDate) as _Month ,count(ques.QuestionID) as Amount
		FROM `Question` ques
        WHERE ques.CreateDate >= DATE_SUB(NOW(),INTERVAL 6 MONTH)
		GROUP BY MONTH(ques.CreateDate)
        ORDER BY MONTH(ques.CreateDate);
	END //
delimiter ;
CALL Amount_Question_Near_By_Six_Month();



