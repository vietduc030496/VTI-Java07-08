DROP PROCEDURE IF EXISTS get_account;
DELIMITER $$
CREATE PROCEDURE get_account(IN in_dept_name VARCHAR(50))
			BEGIN
				SELECT 		dept.departmentID,dept.departmentName,accountID
                FROM		`account` AS acc
                INNER JOIN 	department AS dept
                ON			acc.departmentID = dept.departmentID
                WHERE		dept.departmentName = in_dept_name;
			END$$
DELIMITER ;

-- USE
CALL get_account('DEV');

-- Question 2: Tạo store để in ra số lượng account trong mỗi gro
DROP PROCEDURE IF EXISTS get_num;
DELIMITER $$
CREATE PROCEDURE get_num()
			BEGIN 
				SELECT		g.groupName, ga.groupID, count(ga.groupID) AS num_of_acc
                FROM 		`group` AS g
                INNER JOIN	groupaccount AS ga
                ON 			g.groupID = ga.groupID
                GROUP BY	g.groupID;
			END$$
DELIMITER $$
CALL get_num();

#Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại
DROP PROCEDURE IF EXISTS get_num_question;
DELIMITER $$
CREATE PROCEDURE get_num_question()
			BEGIN
				SELECT		tq.typeName, tq.typeID, q.content, q.createDate
                FROM		question AS q
                INNER JOIN 	typequestion AS tq
                ON 			q.typeID = tq.typeID
                WHERE		MONTH(q.createDate) = MONTH(current_date())
                GROUP BY	q.typeID;
			END$$
DELIMITER ;
CALL get_num_question();

-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
DROP PROCEDURE IF EXISTS get_id_tquestion_max;
DELIMITER $$
CREATE PROCEDURE get_id_tquestion_max(OUT out_id_typequestion_max INT)
			BEGIN
				SELECT 		q.typeID INTO out_id_typequestion_max
                FROM		question AS q
                INNER JOIN 	typequestion AS tq
                ON 			q.typeID = tq.typeID
                GROUP BY	q.typeID
                HAVING 		count(q.typeID) = (SELECT MAX(num_of_max_question) 
														FROM(
															SELECT 		tq.typeID, tq.typeName, count(q.typeID) AS num_of_max_question
															FROM		question AS q
															INNER JOIN 	typequestion AS tq
															ON 			q.typeID = tq.typeID
															GROUP BY	q.typeID) AS max_question);
			END$$
DELIMITER ;
SET@id_typequestion_max ='';
CALL get_id_tquestion_max(@id_typequestion_max);
SELECT @id_typequestion_max;

#Question 5: Sử dụng store ở question 4 để tìm ra tên của type question
DROP PROCEDURE IF EXISTS get_name_of_typequestion;
DELIMITER $$
CREATE PROCEDURE get_name_of_typequestion(IN in_id_typequestion_max INT)
			BEGIN
				SELECT		tq.typeName 
                FROM		typequestion AS tq
                WHERE		tq.typeID = in_id_typequestion_max;
			END$$
DELIMITER ;
CALL get_name_of_typequestion(@id_typequestion_max);

#Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên
#chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa chuỗi của
#người dùng nhập vào

DROP PROCEDURE IF EXISTS group_user;
DELIMITER $$
CREATE PROCEDURE group_user(IN in_string VARCHAR(50))
		BEGIN
			SELECT		g.groupName
            FROM		`group` AS g
            WHERE		g.groupName LIKE CONCAT("%", in_string, "%")
            UNION
            SELECT		acc.username
            FROM		`account` AS acc
            WHERE		acc.username LIKE CONCAT("%", in_string, "%");
        END$$
DELIMITER ;
CALL group_user("p2");

#Question7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và trong store sẽ tự động gán
DROP PROCEDURE IF EXISTS fullName_email;
DELIMITER $$
CREATE PROCEDURE fullName_email(IN in_fullName VARCHAR(50),
								IN in_email VARCHAR(50),
                                OUT out_username VARCHAR(50),
                                OUT out_positionID INT,
                                OUT out_departmentID INT
                                )
		BEGIN
			SET out_username 	=	(SELECT SUBSTRING(in_email,1,LOCATE("@",in_email)-1));
            SET out_positionID 	= 	(SELECT positionID
										FROM `position` AS p
                                        WHERE p.positionName = "developer");
			SET out_departmentID =	(SELECT departmentID
										FROM department AS dept
                                        WHERE dept.departmentName = "phong cho");
        END$$
DELIMITER ;
SET	@in_fullname ="Nguyen Trung Hieu",
	@in_email = "trunghieunguyen@gmail.com",
    @out_username = "",
    @out_positionID = "",
    @out_departmentID = "";
CALL fullName_email(@in_fullname, @in_email, @out_username, @out_positionID, @out_departmentID);
SELECT 	@in_fullname,
		@in_email,
        @out_username,
        @out_positionID,
        @out_departmentID;
        
#Question 8: thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất
DROP PROCEDURE IF EXISTS compare_content;
DELIMITER $$
CREATE PROCEDURE compare_content(IN in_string VARCHAR(50))
		BEGIN
			SELECT 		q.typeID, tq.typeName, q.content
            FROM 		question AS q
            INNER JOIN	typequestion AS tq
            ON			q.typeID = tq.typeID
            WHERE		length(q.content) =(SELECT MAX(LENGTH(max_length.content))
											FROM(
												SELECT 		q.typeID, tq.typeName, q.content
												FROM 		question AS q
												INNER JOIN	typequestion AS tq
												ON			q.typeID = tq.typeID) AS max_length);
        END$$
DELIMITER ;
SET @in_string ='Multi-Choice';
CALL compare_content(@in_string);

#Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
DROP PROCEDURE IF EXISTS delete_exam;
DELIMITER $$
CREATE PROCEDURE delete_exam(IN in_id INT)
		BEGIN
			DELETE 
            FROM		exam 
            WHERE		in_id = exam.examID;
        END$$
DELIMITER ;
SET @in_id =1;
CALL delete_exam(@in_id);
SELECT * FROM exam;

#Question 10: Tim ra cac exam duoc tao tu 3 nam truoc va xoa cac exam do di, in so luong record da remove
DROP PROCEDURE IF EXISTS delete_exam_by_year;
DELIMITER $$
CREATE PROCEDURE delete_exam_by_year(IN year_exam VARCHAR(50), OUT exam_id INT)
	BEGIN
		DELETE 
		FROM		exam AS e
        WHERE 		e.CreateDate LIKE CONCAT(year_exam,"%");
	END$$
DELIMITER ;
SET 	@exam_id ='';
CALL 	delete_exam_by_year('2018',@exam_id);
SELECT * FROM exam;

#Question 11: Xóa phòng ban bằng cách nhập vào tên phòng ban, và các account sẽ chuyển về phòng ban default là phong ban chờ việc
DROP PROCEDURE IF EXISTS delete_department;
DELIMITER $$
CREATE PROCEDURE delete_department(IN in_dept_name VARCHAR(50))
	BEGIN
		UPDATE `account` AS acc
        NATURAL JOIN department
        SET acc.departmentID = 11
		WHERE department.departmentName = in_dept_name;
        
        DELETE FROM department
        WHERE departmentName = in_dept_name;
        
	END$$
DELIMITER ;
CALL delete_department("BA");


#Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay
DROP PROCEDURE IF EXISTS num_of_question_by_month;
DELIMITER $$
CREATE PROCEDURE num_of_question_by_month()
	BEGIN
		SELECT		MONTH(q.CreateDate) AS `month` , count(q.QuestionID) AS num_of_question
		FROM		question q
		WHERE		YEAR(q.CreateDate) = YEAR(CURDATE())
        ORDER BY 	MONTH(q.CreateDate);
	END$$
DELIMITER ;
CALL num_of_question_by_month();

#Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6 tháng gần đây nhất
DROP PROCEDURE IF EXISTS get_count_question_in_six_month;
DELIMITER $$
CREATE PROCEDURE get_count_question_in_six_month()
	BEGIN
        SELECT
			SUM(CASE
					WHEN MONTH(createDate) = "1" THEN 1
                    ELSE 0
				END) month_1,
			SUM(CASE
					WHEN MONTH(createDate) = "2" THEN 1
                    ELSE 0
				END) month_2,
			SUM(CASE
					WHEN MONTH(createDate) = "3" THEN 1
                    ELSE 0
				END) month_3,
			SUM(CASE
					WHEN MONTH(createDate) = "4" THEN 1
                    ELSE 0
				END) month_4,
			SUM(CASE
					WHEN MONTH(createDate) = "5" THEN 1
                    ELSE 0
				END) month_5,
			SUM(CASE
					WHEN MONTH(createDate) = "6" THEN 1
                    ELSE 0
				END) month_6		
		FROM question;
	END$$
DELIMITER ;

CALL get_count_question_in_six_month();