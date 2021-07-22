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
