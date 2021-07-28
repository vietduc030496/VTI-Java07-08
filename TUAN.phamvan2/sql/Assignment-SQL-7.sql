-- Q1
DROP TRIGGER IF EXISTS condition_to_input_group;
DELIMITER //
	CREATE TRIGGER condition_to_input_group
	BEFORE INSERT ON `group`
	FOR EACH ROW
	BEGIN
		IF DATEDIFF(NEW.CreateDate, NOW()) < 365 THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'Can not input in group with a creation date before 1 year ago';
		END IF;
	END//
DELIMITER ;

INSERT INTO `group` (GroupID, 	GroupName,	 CreatorID, 	CreateDate		 ) 
VALUES 				('11', 	   'Accountant', 	'1', 	"2021-07-24 00:00:00");

-- Q2 
DROP TRIGGER IF EXISTS not_add_to_sale;
DELIMITER //
CREATE TRIGGER not_add_to_sale
BEFORE INSERT ON `account`
FOR EACH ROW
BEGIN
	IF NEW.DepartmentID = '2' THEN 
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'Department "Sale" cannot add more user';
	END IF;
END//
DELIMITER ;

INSERT INTO `account`(Email					, Username	  , FullName	  , Gender, DepartmentID, PositionID, CreateDate )
VALUES 				('tuanpv2406@gmail.com'	,'tuanpv2406' ,'Pham Van Tuan', 'M'	  ,   '2'		,   '1'		,'2020-03-05');

-- Q3
DROP TRIGGER IF EXISTS max_users_in_group;
DELIMITER //
CREATE TRIGGER max_users_in_group
BEFORE INSERT ON `groupaccount`
FOR EACH ROW
BEGIN
	IF (SELECT COUNT(*) FROM `groupaccount` GROUP BY NEW.GroupID) > 5 THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = '1 group has a maximum of 5 users';
    END IF;
END//
DELIMITER ;

INSERT INTO `groupaccount` (GroupID	, AccountID, JoinDate	)
VALUES 					   (   1	,    5	   ,'2020-03-05');

-- Q4
DROP TRIGGER IF EXISTS max_questions_in_exam;
DELIMITER //
CREATE TRIGGER max_questions_in_exam
BEFORE INSERT ON `examquestion`
FOR EACH ROW
BEGIN
	IF (SELECT COUNT(*) FROM `examquestion` GROUP BY NEW.ExamID) > 10 THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = '1 exam has a maximum of 10 questions';
    END IF;
END//
DELIMITER ;

INSERT INTO `examquestion`(ExamID, QuestionID) 
VALUES 					  (	  2  ,		8    );

-- Q5
DROP TRIGGER IF EXISTS conditions_to_delete_acct;
DELIMITER //
CREATE TRIGGER conditions_to_delete_acct
BEFORE DELETE ON `account`
FOR EACH ROW
BEGIN
	IF OLD.Email = 'admin@gmail.com' THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'This is an admin account, not allowed to delete';
    END IF;
END//
DELIMITER ;

DELETE FROM `account` a
WHERE a.Email = 'admin@gmail.com';

-- Q6
DROP TRIGGER IF EXISTS waiting_department;
DELIMITER //
CREATE TRIGGER waiting_department
BEFORE INSERT ON `account`
FOR EACH ROW
BEGIN
	IF NEW.DepartmentID = null THEN
		SET NEW.DepartmentID = 11;
	END IF;
END//
DELIMITER ;

INSERT INTO `account`(Email					, Username	  , FullName	  , Gender, DepartmentID, PositionID, CreateDate )
VALUES 				('tuanpv2406@gmail.com'	,'tuanpv2406' ,'Pham Van Tuan', 'M'	  ,   null		,   '1'		,'2020-03-05');

-- Q7
DROP TRIGGER IF EXISTS max_answers_in_question;
DELIMITER //
CREATE TRIGGER max_answers_in_question
BEFORE INSERT ON `answer`
FOR EACH ROW
BEGIN
	IF 
		(SELECT COUNT(*) FROM `answer` a GROUP BY NEW.QuestionID) > 4 
		AND (SELECT COUNT(*) FROM `answer` a GROUP BY a.isCorrect HAVING a.isCorrect = 1) > 2
	THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = '1 exam only allows to create a maximum of 4 answers for each question, which has a maximum of 2 correct answers';
    END IF;
END//
DELIMITER ;

INSERT INTO Answer (  Content	 , QuestionID, isCorrect)
VALUES 			   (N'Trả lời 05',     1     ,	   0	);

-- Q8
DROP TRIGGER IF EXISTS auto_edit_user_info;
DELIMITER //
CREATE TRIGGER auto_edit_user_info
BEFORE INSERT ON `account`
FOR EACH ROW
BEGIN
	CASE LCASE(NEW.Gender) 
		WHEN 'nam' THEN 
			SET NEW.Gender = 'M';
		WHEN 'nu' THEN 
			SET NEW.Gender = 'F';
		ELSE 
			SET NEW.Gender = 'U';
	END CASE;
END//
DELIMITER ;

INSERT INTO `account`(Email					, Username	  , FullName	  , Gender, DepartmentID, PositionID, CreateDate )
VALUES 				('tuanpv2406@gmail.com'	,'tuanpv2406' ,'Pham Van Tuan', 'nam' ,   '1'		,   '1'		,'2020-03-05');

-- Q9
DROP TRIGGER IF EXISTS condition_to_delete_exam;
DELIMITER //
CREATE TRIGGER condition_to_delete_exam
BEFORE DELETE ON `exam`
FOR EACH ROW
BEGIN
	IF DATEDIFF(OLD.CreateDate, NOW()) < 2 THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'Not allowed to delete a new exam created 2 days ago';
    END IF;
END//
DELIMITER ;

DELETE FROM `exam` 
WHERE ExamID = 11;

-- Q10
DROP TRIGGER IF EXISTS condition_to_ud_question;
DELIMITER //
CREATE TRIGGER condition_to_ud_question
BEFORE UPDATE ON `examquestion`
FOR EACH ROW
BEGIN
		IF OLD.QuestionID IN (	
			SELECT QuestionID
			FROM `examquestion`
			GROUP BY QuestionID
		) THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'Only update or delete the question which is not in any exam';
    END IF;
END//
DELIMITER ;

-- Q12
DROP TRIGGER IF EXISTS exam_info;
DELIMITER //
CREATE TRIGGER exam_info
BEFORE UPDATE ON `exam`
FOR EACH ROW
BEGIN
	CASE  
		WHEN NEW.Duration <= 30 THEN 
			SET NEW.Duration = 'Short time';
		WHEN NEW.Duration > 60 THEN 
			SET NEW.Duration = 'Long time';
		ELSE 
			SET NEW.Duration = 'Medium time';
	END CASE;
END//
DELIMITER ;

UPDATE `exam`
SET Duration = Duration;

-- Q13
DROP FUNCTION IF EXISTS accts_in_group_info;
DELIMITER //
CREATE FUNCTION the_number_user_amount(count INTEGER) RETURNS VARCHAR(45)
DETERMINISTIC
	BEGIN
		DECLARE type_number VARCHAR(45) DEFAULT  "";
		IF count <= 5 THEN
			SET type_number = "Few";
		ELSEIF count <= 20 THEN
			SET type_number = "Normal";
		ELSE
			SET type_number = "Higher";
		END IF;
	RETURN type_number;
	END//
DELIMITER ;

SELECT g.GroupName, COUNT(ga.GroupID) AS quantity, 
	   the_number_user_amount(COUNT(ga.GroupID)) AS the_number_user_amount
FROM `group` g LEFT JOIN `groupaccount` ga ON g.GroupID = ga.GroupID
GROUP BY g.GroupID;

-- Q14
DROP FUNCTION IF EXISTS users_in_dept_info;
DELIMITER //
CREATE FUNCTION quantity(count INTEGER) RETURNS VARCHAR(45)
DETERMINISTIC
	BEGIN
		DECLARE type_number VARCHAR(45) DEFAULT  "";
		IF count > 0 THEN
			SET type_number = count;
		ELSE
			SET type_number = "Khong co user";
		END IF;
	RETURN type_number;
	END//
DELIMITER ;

SELECT d.DepartmentName, quantity(COUNT(a.DepartmentID)) AS quantity
FROM `department` d 
INNER JOIN `account` a ON d.DepartmentID = a.DepartmentID
GROUP BY d.DepartmentID;