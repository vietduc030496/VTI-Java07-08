-- Question 1: Tao store de nguoi dung nhap vao ten phong ban va in ra tat ca cac account thuoc phong ban do
DROP PROCEDURE IF EXISTS get_account_department;
DELIMITER $$
CREATE PROCEDURE get_account_department (IN in_name_department VARCHAR(50))
	BEGIN
		SELECT 		`Account`.AccountID,`Account`.Email,`Account`.UserName,`Account`.FullName,`Department`.DepartmentName 
        FROM		`Account`
        INNER JOIN 	`Department`
        ON			`Account`.DepartmentID=`Department`.DepartmentID
        WHERE		`Department`.DepartmentName=in_name_department;
	END $$
DELIMITER ;

CALL get_account_department ("Purchasing");
-- Question 2: Tao store de in ra so luong account trong moi group
DROP PROCEDURE IF EXISTS get_count_group;
DELIMITER $$
CREATE PROCEDURE get_count_group()
	BEGIN
		SELECT `Group`.GroupName,COUNT(`GroupAccount`.AccountID) AS TOTAL
        FROM `GroupAccount`
        INNER JOIN `Group`
        ON `GroupAccount`.GroupID=`Group`.GroupID
        GROUP BY `GroupAccount`.AccountID;
	END $$
DELIMITER ;

CALL get_count_group();
-- Question 3: Tao store thong ke moi type question co bao nhieu question duoc tao trong thang hien tai
DROP PROCEDURE IF EXISTS count_type_question;
DELIMITER $$
CREATE PROCEDURE count_type_question()
	BEGIN
		SELECT `TypeQuestion`.TypeName,COUNT(`TypeQuestion`.TypeID)
        FROM `Question`
        INNER JOIN `TypeQuestion`
        ON `Question`.TypeID=`TypeQuestion`.TypeID
        WHERE MONTH(`Question`.CreateDate)=MONTH(NOW())
		GROUP BY `TypeQuestion`.TypeID;
	END $$
DELIMITER ;

CALL count_type_question;
-- Question 4: Tao store de tra ra id cua type question co nhieu cau hoi nhat
DROP PROCEDURE IF EXISTS get_id_type_question;
DELIMITER $$
CREATE PROCEDURE get_id_type_question(OUT out_id_type_question INT)
	BEGIN
		SELECT `Question`.TypeID INTO out_id_type_question
        FROM `Question`
        INNER JOIN `TypeQuestion`
        ON `Question`.TypeID=`TypeQuestion`.TypeID
        GROUP BY `Question`.TypeID
        HAVING COUNT(`Question`.TypeID)=
        (SELECT MAX(TOTAL)
        FROM (SELECT COUNT(`Question`.TypeID) AS TOTAL
        FROM `Question`
        INNER JOIN `TypeQuestion`
        ON `Question`.TypeID=`TypeQuestion`.TypeID
        GROUP BY `Question`.TypeID) AS C);
	END $$
DELIMITER ;

SET @id_type_question=0;
CALL get_id_type_question(@id_type_question);
SELECT @id_type_question;

-- Question 5: Su dung store o question 4 de tim ra ten cua type question
DROP PROCEDURE IF EXISTS get_name_type_question;
DELIMITER $$
CREATE PROCEDURE get_name_type_question(IN in_id_type_question INT)
	BEGIN
		SELECT `TypeQuestion`.TypeName 
        FROM `TypeQuestion`
        WHERE `TypeQuestion`.TypeId=in_id_type_question;
	END $$
DELIMITER ;
CALL get_name_type_question(@id_type_question);

-- Question 6: Viet 1 store cho phep nguoi dung nhap vao 1 chuoi va tra ve group co ten chua chuoi cua nguoi dung nhap vao hoac tra ve user co username chua chuoi cua nguoi dung nhap vao
DROP PROCEDURE IF EXISTS get_group_or_user;
DELIMITER $$
CREATE PROCEDURE get_group_or_user(IN in_string VARCHAR(50))
	BEGIN 
		SELECT `Group`.GroupName
        FROM `Group`
        WHERE `Group`.GroupName LIKE CONCAT("%",in_string,"%")
        UNION
        SELECT `Account`.FullName
        FROM `Account`
        WHERE `Account`.FullName LIKE CONCAT("%",in_string,"%");
	END $$
DELIMITER ;
CALL get_group_or_user("g");
-- Question 7: Viet 1 store cho phep nguoi dung nhap vao thong tin fullName,email va trong store se tu dong gan
DROP PROCEDURE IF EXISTS create_account;
DELIMITER $$
CREATE PROCEDURE create_account(IN in_full_name VARCHAR(50), IN in_email VARCHAR(50))
	BEGIN
		DECLARE UserName VARCHAR(50);
        DECLARE PositionID INT;
        DECLARE DepartmentID INT;
        SET UserName=SUBSTRING_INDEX(in_email,'@',1);
        SET PositionID=(SELECT 	`Position`.PositionID FROM `Position` WHERE `PositionName`="developer");
        SET DepartmentID=5;
        INSERT INTO `Account` (Email,UserName,FullName,DepartmentID,PositionID,CreateDate) VALUES (in_email,UserName,in_full_name,DepartmentID,PositionID,CURDATE());
	END $$
DELIMITER ;

CALL create_account("ngovantung","tung@gmail.com");
SELECT * 
FROM `Account`
WHERE `Account`.FullName="ngovantung"; 

-- Question 8: Viet 1 store cho phep nguoi dung nhap vao essay hoac multiple-choice de thong ke cau hoi essay hoac multiple-choice nao co content dai nhat
DROP PROCEDURE IF EXISTS get_essay_or_multiple_choice;
DELIMITER $$
CREATE PROCEDURE get_essay_or_multiple_choice(IN in_type_question VARCHAR(50))
	BEGIN
		SELECT `Question`.Content,`TypeQuestion`.TypeName
        FROM `Question`
        INNER JOIN `TypeQuestion`
        ON `Question`.TypeID=`TypeQuestion`.TypeID
        WHERE `TypeQuestion`.TypeName=in_type_question
        AND LENGTH(`Question`.Content)=
		(SELECT MAX(LENG)
        FROM (SELECT LENGTH(`Question`.Content) AS LENG
        FROM `Question`
        INNER JOIN `TypeQuestion`
        ON `Question`.TypeID=`TypeQuestion`.TypeID
		WHERE `TypeQuestion`.TypeName=in_type_question) AS C);
	END $$
DELIMITER ;

CALL get_essay_or_multiple_choice("Type2");

-- Question 9: Viet 1 store cho phep nguoi dung xoa exam dua vao id
DROP PROCEDURE IF EXISTS delete_exam_id;
DELIMITER $$
CREATE PROCEDURE delete_exam_id(IN in_exam_id INT)
	BEGIN
		DELETE FROM `Exam`
        WHERE `Exam`.ExamID=in_exam_id;
	END $$
DELIMITER ;
CALL delete_exam_id(10);
SELECT * FROM `Exam`;
-- Question 10: Tim ra cac exam duoc tao tu 3 nam truoc va xoa cac exam do di, sau do in ra so luong record da remove tu cac table lien quan trong khi removing
DROP PROCEDURE IF EXISTS delete_exam;
DELIMITER $$
CREATE PROCEDURE delete_exam(OUT out_count_record INT)
	BEGIN
		SELECT COUNT(*) AS TOTAL INTO out_count_record
        FROM `Exam`
		WHERE YEAR(`Exam`.CreateDate)=YEAR(NOW())-3;
		DELETE FROM `Exam`
        WHERE YEAR(`Exam`.CreateDate)=YEAR(NOW())-3;
	END $$
DELIMITER ;
INSERT INTO `Exam` (`Code`,Title,CategoryID,Duration,CreatorID,CreateDate) VALUES (11,"Exam11",1,30,1,"2018-07-01");
SET @count_record=0;
CALL delete_exam(@count_record);
SELECT @count_record;
SELECT * FROM `Exam`;
-- Question 11: Viet store cho phep nguoi dung xoa phong ban bang cach nguoi dung nhap vao ten phong ban va cac account thuoc phong ban do se duoc chuyen ve phong ban default la phong ban cho viec
DROP PROCEDURE IF EXISTS delete_department;
DELIMITER $$
CREATE PROCEDURE delete_department(IN in_name_department VARCHAR(50))
	BEGIN
		UPDATE `Account`
        SET `Account`.DepartmentID=10
        WHERE `Account`.DepartmentID=
        (SELECT `Department`.DepartmentID 
        FROM `Department`
        WHERE `Department`.DepartmentName=in_name_department);
		DELETE FROM `Department`
        WHERE `Department`.DepartmentName=in_name_department;
	END $$
DELIMITER ;
CALL delete_department("Sales");
SELECT * FROM `Account`;
-- Question 12: Viet store de in ra moi thang co bao nhieu cau hoi duoc tao trong nam nay
DROP PROCEDURE IF EXISTS count_question_created;
DELIMITER $$
CREATE PROCEDURE count_question_created()
	BEGIN
		SELECT MONTH(`Question`.CreateDate) AS MONTH,COUNT(MONTH(`Question`.CreateDate)) AS COUNT
        FROM `Question`
        WHERE YEAR(`Question`.CreateDate)=YEAR(NOW())
        GROUP BY MONTH(`Question`.CreateDate);
	END $$
DELIMITER ;
CALL count_question_created();


-- Question 13: Viet store de in ra moi thang co bao nhieu cau hoi duoc tao trong 6 thang gan day nhat (neu thang nao khong co thi se in ra la "khong co cau hoi nao trong thang")
DROP PROCEDURE IF EXISTS count_question_created_2;
DELIMITER $$
CREATE PROCEDURE count_question_created_2()
	BEGIN
		SELECT MONTH(`Question`.CreateDate) AS MONTH,COUNT(MONTH(`Question`.CreateDate)) AS COUNT
        FROM `Question`
        WHERE `Question`.CreateDate>=DATE_SUB(NOW(), INTERVAL 6 MONTH)
        GROUP BY MONTH(`Question`.CreateDate);
	END $$
DELIMITER ;
CALL count_question_created_2();


        