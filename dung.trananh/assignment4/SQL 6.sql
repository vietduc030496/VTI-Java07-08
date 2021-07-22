#Question 1
DROP PROCEDURE IF EXISTS getAccountName;
DELIMITER $$
CREATE PROCEDURE getAccountName(IN in_dept_name varchar(50))
	BEGIN
		SELECT dept.departmentName, acc.accountID, acc.username,acc.fullname,acc.email
        FROM `account` AS acc INNER JOIN department as dept
        ON acc.departmentID = dept.departmentID
        WHERE dept.departmentName = in_dept_name
        COLLATE utf8mb4_0900_ai_ci;
	END$$
DELIMITER ;
CALL getAccountName('Marketing');

#Question 2
DROP PROCEDURE IF EXISTS getAccountCounters;
DELIMITER $$
CREATE PROCEDURE getAccountCounters()
	BEGIN
		SELECT `group`.groupID, `group`.groupName ,count(*) AS num_of_acc_each_group 
        FROM groupaccount INNER JOIN `group`
		ON groupaccount.groupID = `group`.groupID
		GROUP BY groupID;
	END$$
DELIMITER ;
CALL getAccountCounters();

#Question 3
DROP PROCEDURE IF EXISTS getQuestionCountersCurrentMonth;
DELIMITER $$
CREATE PROCEDURE getQuestionCountersCurrentMonth()
	BEGIN
		SELECT typequestion.typeID , typequestion.typeName ,count(*) AS num_of_question_each_type 
        FROM question NATURAL JOIN typequestion 
        WHERE MONTH(question.createDate) = MONTH(current_date())
		GROUP BY typeID;
	END$$
DELIMITER ;
CALL getQuestionCountersCurrentMonth();

#Question 4
DROP PROCEDURE IF EXISTS getTypeQuestionMaxCounters;
DELIMITER $$
CREATE PROCEDURE getTypeQuestionMaxCounters(OUT id_type_question int)
	BEGIN
		SELECT typeID INTO id_type_question
        FROM question 
		GROUP BY typeID
		HAVING count(*) = (SELECT MAX(counts.count) FROM 
								(SELECT count(*) AS count FROM question
								 GROUP BY typeID) AS counts );
	END$$
DELIMITER ;
SET @id_type=0;
CALL getTypeQuestionMaxCounters(@id_type);
SELECT @id_type;

#Question 5
DROP PROCEDURE IF EXISTS getTypeQuestionName;
DELIMITER $$
CREATE PROCEDURE getTypeQuestionName(IN id_type_question int)
	BEGIN
		SELECT typeName
        FROM typequestion
		WHERE typeID = id_type_question
        COLLATE utf8mb4_0900_ai_ci;
	END$$
DELIMITER ;
CALL getTypeQuestionName(@id_type);

#Question 6
DROP PROCEDURE IF EXISTS getGroupNameOrUserName;
DELIMITER $$
CREATE PROCEDURE getGroupNameOrUserName(IN input_name varchar(50))
	BEGIN
		SELECT groupName
        FROM `group`
		WHERE groupName LIKE CONCAT('%', input_name , '%')
        COLLATE utf8mb4_0900_ai_ci;
        
        SELECT username
        FROM `account`
        WHERE username LIKE CONCAT('%' + input_name + '%')
        COLLATE utf8mb4_0900_ai_ci;
	END$$
DELIMITER ;

CALL getGroupNameOrUserName('G1');

#Question 7
DROP PROCEDURE IF EXISTS createNewAccount;
DELIMITER $$
CREATE PROCEDURE createNewAccount(IN input_fullname varchar(50),IN email varchar(50))
	BEGIN
        DECLARE user_name varchar(50);
        DECLARE position_id INT;
        DECLARE department_id INT;
        
        SET user_name = SUBSTRING(email, 1, POSITION('@' IN email) -1);
        SET position_id = (SELECT positionID FROM position WHERE positionName="Dev");
        SET department_id = (SELECT departmentID FROM department WHERE departmentName="Waiting Room");

        INSERT INTO `account` VALUES (null,email,user_name,input_fullname,department_id,position_id,"2021-07-22");
	END$$
DELIMITER ;

CALL createNewAccount('trananhdung','dungtran240799@gmail.com');

#Question 8
DROP PROCEDURE IF EXISTS getQuestionMaxContent;
DELIMITER $$
CREATE PROCEDURE getQuestionMaxContent(IN input_type_question varchar(50))
	BEGIN
        SELECT question.questionID, question.content
        FROM question NATURAL JOIN typequestion
        WHERE length(content) = ( SELECT max(length(content)) 
								  FROM question NATURAL JOIN typequestion
								  WHERE typequestion.typeName = input_type_question
                                  COLLATE utf8mb4_0900_ai_ci)
        AND typequestion.typeName = input_type_question
        COLLATE utf8mb4_0900_ai_ci;
	END$$
DELIMITER ;

CALL getQuestionMaxContent('Essay');

#Question 9
DROP PROCEDURE IF EXISTS deleteExamById;
DELIMITER $$
CREATE PROCEDURE deleteExamById(IN id_exam int)
	BEGIN
        DELETE FROM exam
        WHERE examID = id_exam;
	END$$
DELIMITER ;
SET @id_exam = 1;
CALL deleteExamByI(@id_exam);

#Question 10

#Question 11
DROP PROCEDURE IF EXISTS deleteDepartmentByName;
DELIMITER $$
CREATE PROCEDURE deleteDepartmentByName(IN dept_name varchar(50))
	BEGIN
		UPDATE `account`
        NATURAL JOIN department
        SET `account`.departmentID = 6
		WHERE department.departmentName = dept_name
        COLLATE utf8mb4_0900_ai_ci;
        
        DELETE FROM department
        WHERE departmentName = dept_name
        COLLATE utf8mb4_0900_ai_ci;
	END$$
DELIMITER ;

CALL deleteDepartmentByName('Sale');

#Question 12
DROP PROCEDURE IF EXISTS getQuestionCounterEachMonth;
DELIMITER $$
CREATE PROCEDURE getQuestionCounterEachMonth()
	BEGIN
        SELECT MONTH(createDate), COUNT(*) AS num_of_question_each_month
        FROM question
        WHERE YEAR(createDate)= "2021"
        GROUP BY MONTH(createDate); 
	END$$
DELIMITER ;

CALL getQuestionCounterSixMonth();

#Question 13
DROP PROCEDURE IF EXISTS getQuestionCounterSixMonth;
DELIMITER $$
CREATE PROCEDURE getQuestionCounterSixMonth()
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

CALL getQuestionCounterSixMonth();
