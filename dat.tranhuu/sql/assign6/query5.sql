-- quest1
USE vti1;
DROP TRIGGER IF EXISTS insert_group;
DELIMITER $$
	CREATE TRIGGER insert_group
	BEFORE INSERT ON tbl_group
	FOR EACH ROW
	BEGIN
		IF DATEDIFF(NOW(),NEW.created_date) > 365 THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'ko duoc them ';
		END IF;
	END$$
DELIMITER ;
INSERT INTO tbl_group(name,created_date,account_id) VALUES ("name12","2019-07-18 06:41:46","11");

-- Quest2 
DROP TRIGGER IF EXISTS insert_sale;
DELIMITER //
CREATE TRIGGER insert_sale
BEFORE INSERT ON tbl_account
FOR EACH ROW
BEGIN
	IF NEW.department_id = (SELECT id FROM tbl_department WHERE tbl_department.name LIKE "sale" LIMIT 1) THEN 
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'cannot add more user';
	END IF;
END//
DELIMITER ;
INSERT INTO tbl_account(email,username,fullname,created_date,department_id,position_id) 
VALUES ("email50@gmail.com","username50","abc Nguyễn ádasd","2021-07-16 06:41:46","10","4");

-- Quest3
DROP TRIGGER IF EXISTS max_acc_group;
DELIMITER //
CREATE TRIGGER max_acc_group
BEFORE INSERT ON tbl_group_account
FOR EACH ROW
BEGIN
	IF (SELECT COUNT(group_id) FROM tbl_group_account GROUP BY NEW.group_id) > 5 THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'group full';
    END IF;
END//
DELIMITER ;

INSERT INTO tbl_group_account(join_date,group_id,account_id) VALUES ("2021-07-18 06:41:46",9,2);

-- Quest4
DROP TRIGGER IF EXISTS max_questions;
DELIMITER //
CREATE TRIGGER max_questions
BEFORE INSERT ON tbl_exam_question
FOR EACH ROW
BEGIN
	IF (SELECT COUNT(exam_id) FROM tbl_exam_question GROUP BY NEW.exam_id) > 10 THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'exam full';
    END IF;
END//
DELIMITER ;

INSERT INTO tbl_exam_question(question_id,exam_id) VALUES (1,2);

-- Quest5
DROP TRIGGER IF EXISTS delete_acc;
DELIMITER //
CREATE TRIGGER delete_acc
BEFORE DELETE ON tbl_account
FOR EACH ROW
BEGIN
	IF OLD.email = 'admin@gmail.com' THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'can not delete';
    END IF;
END//
DELIMITER ;
DELETE FROM tbl_account WHERE email = 'admin@gmail.com';

-- Quest6
DROP TRIGGER IF EXISTS waiting_department;
DELIMITER //
CREATE TRIGGER waiting_department
BEFORE INSERT ON tbl_account
FOR EACH ROW
BEGIN
	IF NEW.department_id is null THEN
		SET NEW.department_id = (SELECT id FROM tbl_department WHERE NAME LIKE 'waiting department' LIMIT 1);
	END IF;
END//
DELIMITER ;

INSERT INTO tbl_account(email,username,fullname,created_date,position_id) 
VALUES ("email23@gmail.com","username24","fullname1","2021-07-19 06:41:46","1");

-- Quest7
DROP TRIGGER IF EXISTS max_answer;
DELIMITER //
CREATE TRIGGER max_answer
BEFORE INSERT ON tbl_answer
FOR EACH ROW
BEGIN
	IF 
		(SELECT COUNT(question_id) FROM tbl_answer  GROUP BY NEW.question_id) > 4 
		AND (SELECT COUNT(*) FROM tbl_answer a GROUP BY a.is_correct,question_id HAVING (a.is_correct = 1 AND a.question_id=NEW.question_id)) >= 2
	THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'cant insert';
    END IF;
END//
DELIMITER ;
INSERT INTO tbl_answer(content,is_correct,question_id) VALUES ("anwser1",0,1);

-- Quest8
ALTER TABLE tbl_account ADD gender VARCHAR(10);
DROP TRIGGER IF EXISTS edit_user;
DELIMITER //
CREATE TRIGGER edit_user
BEFORE INSERT ON tbl_account
FOR EACH ROW
BEGIN
	CASE LCASE(NEW.gender) 
		WHEN 'nam' THEN 
			SET NEW.gender = 'M';
		WHEN 'nu' THEN 
			SET NEW.gender = 'F';
		ELSE 
			SET NEW.gender = 'U';
	END CASE;
END//
DELIMITER ;

INSERT INTO tbl_account(email,username,fullname,created_date,department_id,position_id,gender) 
VALUES ("admin1@gmail.com","admin1","abc Nguyễn ádasd","2021-07-16 06:41:46","1","4","nam");

-- Quest9
DROP TRIGGER IF EXISTS delete_exam;
DELIMITER //
CREATE TRIGGER delete_exam
BEFORE DELETE ON tbl_exam
FOR EACH ROW
BEGIN
	IF DATEDIFF(NOW(),OLD.created_date ) < 2 THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'cant delete';
    END IF;
END//
DELIMITER ;
 SET SQL_SAFE_UPDATES = 0;
INSERT INTO tbl_exam(code,title,durantion,created_date,category_id,account_id) 
VALUES ("code1","title1",90,NOW(),2,3);
DELETE FROM tbl_exam WHERE DATEDIFF(NOW(),created_date ) < 2;

-- Quest10
DROP TRIGGER IF EXISTS update_question;
DELIMITER //
CREATE TRIGGER update_question
BEFORE UPDATE ON tbl_exam_question
FOR EACH ROW
BEGIN
		IF OLD.question_id IN (	
			SELECT distinct(question_id)
			FROM tbl_exam_question
		) THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'cant action';
    END IF;
END//
DELIMITER ;
