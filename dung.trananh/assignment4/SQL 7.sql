#Question 1
DROP TRIGGER IF EXISTS trigger_create_Group;
DELIMITER $$
	CREATE TRIGGER trigger_create_Group
    BEFORE INSERT ON `group`
    FOR EACH ROW
    BEGIN
		
        IF NEW.`createDate` < "2021-01-01" THEN
			SIGNAL SQLSTATE '12345' 
            SET MESSAGE_TEXT = "createDate must be less than 1 year since now";
		END IF;
	
    END $$
DELIMITER ;

INSERT INTO `group` VALUES (null,"G8",8,"2021-01-15");

#Question 2
DROP TRIGGER IF EXISTS trigger_create_Account_For_Department;
DELIMITER $$
	CREATE TRIGGER trigger_create_Account_For_Department
    BEFORE INSERT ON `account`
    FOR EACH ROW
    BEGIN
		
        IF NEW.`departmentID` = 1 THEN
			SIGNAL SQLSTATE '12345' 
            SET MESSAGE_TEXT = "Dept Sale can't add more user";
		END IF;
	
    END $$
DELIMITER ;

INSERT INTO `account` VALUES (null,"ngohoang@gmail.com","ngohoang","ngohuyhoang",1,2,"2021-07-19");

#Question 3
DROP TRIGGER IF EXISTS trigger_Max_Account_For_Group;
DELIMITER $$
	CREATE TRIGGER trigger_Max_Account_For_Group
    BEFORE INSERT ON groupaccount
    FOR EACH ROW
    BEGIN
		DECLARE counters int;
        
		SELECT COUNT(ga.groupID) INTO counters 
        FROM groupaccount AS ga
        WHERE ga.groupID = NEW.groupID;
        
        IF counters = 5 THEN
			SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = "Beyond the limit 5 user";
        END IF;    
    END $$
DELIMITER ;

INSERT INTO groupaccount VALUES (3,5,"2021-07-24");

#Question 4
DROP TRIGGER IF EXISTS trigger_Max_Question_For_Exam;
DELIMITER $$
	CREATE TRIGGER trigger_Max_Question_For_Exam
    BEFORE INSERT ON examquestion
    FOR EACH ROW
    BEGIN
		DECLARE counters int;
        
		SELECT COUNT(eq.examID) INTO counters 
        FROM examquestion AS eq
        WHERE eq.examID = NEW.examID;
        
        IF counters = 10 THEN
			SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = "Beyond the limit 10 question";
        END IF;    
    END $$
DELIMITER ;

INSERT INTO examquestion VALUES (1,5);

#Question 5
DELETE FROM `account`
WHERE accountID=14;

DROP TRIGGER IF EXISTS trigger_Delete_Account;
DELIMITER $$
	CREATE TRIGGER trigger_Delete_Account
    BEFORE DELETE ON `account`
    FOR EACH ROW
    BEGIN
		DECLARE email_account varchar(50);
        
        SELECT email INTO email_account FROM `account` 
		WHERE accountID = OLD.accountID; 
		
        IF email_account = "admin@gmail.com" THEN
			SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = "Can't delete admin account";
		ELSE
			DELETE FROM groupaccount
			WHERE `accountID`= OLD.accountID;
        
			DELETE FROM question
			WHERE `creatorID`= OLD.accountID;
		END IF;
    END $$
DELIMITER ;

#Question 6
DROP TRIGGER IF EXISTS trigger_Insert_Account_No_Dept;
DELIMITER $$
	CREATE TRIGGER trigger_Insert_Account_No_Dept
    BEFORE INSERT ON `account`
    FOR EACH ROW
    BEGIN
		IF NEW.departmentID IS NULL THEN
            SET NEW.departmentID = 6;
        END IF;
    END $$
DELIMITER ;

INSERT INTO `account`(accountID,email,username,fullname,positionID,createDate) VALUES (null,"hieunguyen@gmail.com","hieunguyen","nguyentronghien",4,"2021-07-19");

#Question 7

#Question 8
DROP TRIGGER IF EXISTS trigger_Update_Gender_Account;
DELIMITER $$
	CREATE TRIGGER trigger_Update_Gender_Account
    BEFORE INSERT ON `account`
    FOR EACH ROW
    BEGIN
		CASE 
			WHEN NEW.gender = "nam" THEN 
				SET NEW.gender ="M";
            WHEN NEW.gender = "nu" THEN
				SET NEW.gender = "N";
            WHEN NEW.gender ="c xd" THEN
				SET NEW.gender ="U";
		END CASE;
    END $$
DELIMITER ;

INSERT INTO `account` VALUES (null,"hieunguyen@gmail.com","hieunguyen","nguyentronghien",2,4,"2021-07-19","nam");

#Question 9 
DELETE FROM exam
WHERE examID=4;

DROP TRIGGER IF EXISTS trigger_Not_Delete_Exam_Less_2Days;
DELIMITER $$
	CREATE TRIGGER trigger_Not_Delete_Exam_Less_2Days
    BEFORE DELETE ON exam
    FOR EACH ROW
    BEGIN
		
        IF DATE_ADD( OLD.createDate , INTERVAL 2 DAY) > CURRENT_DATE() THEN
			SIGNAL SQLSTATE "45000"
            SET MESSAGE_TEXT ="Can't delete exam less than 2 days";        
        END IF;
    END $$
DELIMITER ;

#Question 10.1
DELETE FROM question
WHERE questionID=7;

DROP TRIGGER IF EXISTS trigger_Delete_Question_Not_In_Exam;
DELIMITER $$
	CREATE TRIGGER trigger_Delete_Question_Not_In_Exam
    BEFORE DELETE ON question
    FOR EACH ROW
    BEGIN
		
        IF EXISTS ( SELECT 1 FROM examquestion
					WHERE questionID = OLD.questionID) 
		THEN 
			SIGNAL SQLSTATE "45000"
            SET MESSAGE_TEXT = "Can't delete question exists in exam ";
			
        END IF;
    END $$
DELIMITER ;

#Question 10.2
DROP TRIGGER IF EXISTS trigger_Update_Question_Not_In_Exam;
DELIMITER $$
	CREATE TRIGGER trigger_Update_Question_Not_In_Exam
    BEFORE UPDATE ON question
    FOR EACH ROW
    BEGIN
		
        IF EXISTS ( SELECT 1 FROM examquestion
					WHERE questionID = OLD.questionID) 
		THEN 
			SIGNAL SQLSTATE "45000"
            SET MESSAGE_TEXT = "Can't delete question exists in exam ";
			
        END IF;
    END $$
DELIMITER ;
UPDATE question
SET content = "GG"
WHERE questionID =6;

#Question 12
SELECT examID, title,
	CASE 
		WHEN duration <= 0.5 
			THEN "Short Time"
		WHEN duration > 0.5 AND duration <= 1.0
			THEN "Medium Time"
		WHEN duration > 1.0
			THEN "Long Time"
	END time_description
FROM exam;

#Question 13
SELECT ga1.groupID, COUNT(*) AS num_of_acc_each_group,
	CASE 
		WHEN (SELECT COUNT(*) FROM groupaccount AS ga2
				WHERE ga2.groupID = ga1.groupID) <= 5 
            THEN "Few"
		WHEN (SELECT COUNT(*) FROM groupaccount AS ga2
				WHERE ga2.groupID = ga1.groupID) >5 AND 
            (SELECT COUNT(*) FROM groupaccount AS ga2
				WHERE ga2.groupID = ga1.groupID) <=20
			THEN "Normal"
		WHEN (SELECT COUNT(*) FROM groupaccount AS ga2
				WHERE ga2.groupID = ga1.groupID) >20
            THEN "Higher"
	END the_number_user_amount
FROM groupaccount AS ga1
GROUP BY ga1.groupID;

#Question 14
SELECT dept.departmentID, 
CASE
		WHEN NOT EXISTS (SELECT 1 FROM `account` AS acc2
				WHERE acc2.departmentID = dept.departmentID)
			THEN "Khong co User"
		ELSE COUNT(acc.departmentID)
	END dept_description
FROM department AS dept LEFT JOIN `account` AS acc 
ON dept.departmentID = acc.departmentID
GROUP BY dept.departmentID;