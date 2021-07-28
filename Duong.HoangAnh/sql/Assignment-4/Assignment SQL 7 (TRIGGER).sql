use Exam;
-- 1)
DROP TRIGGER IF EXISTS before_group_insert;
DELIMITER //
CREATE TRIGGER before_group_insert
BEFORE INSERT ON `Group`
FOR EACH ROW
	BEGIN
		IF (NEW.CreateDate < DATE_SUB(NOW(), INTERVAL 1 YEAR)) THEN 
			SIGNAL SQLSTATE '50001' SET MESSAGE_TEXT = 'The Group weren"t created 1 year ago!';
		END IF;
    END //
DELIMITER ;
insert into `Group`(GroupName, CreatorID, CreateDate) value("lololo", 2, "2019-12-20");
-- 2)
DROP TRIGGER IF EXISTS befort_department_sale_insert;
DELIMITER //
CREATE TRIGGER befort_department_sale_insert
BEFORE INSERT ON `Account`
FOR EACH ROW
	BEGIN
		DECLARE department_name VARCHAR(50) 
        DEFAULT(SELECT DepartmentName
				FROM `Department`
				WHERE DepartmentID = NEW.DepartmentID);
		IF (department_name like "%sale%") THEN 
			SIGNAL SQLSTATE '50001' SET MESSAGE_TEXT = 'Department "Sale" cannot add more user!';
		END IF;
    END //
DELIMITER ;
INSERT INTO `Account`(Email, UserName, FullName, DepartmentID, PositionID, CreateDate) 
VALUE("duoeqeqwng@gmail.com", "duongduong", "vo lua da0", 3, 6, "2019-11-20");

-- 3)
DROP TRIGGER IF EXISTS befort_group_max_five_insert;
DELIMITER //
CREATE TRIGGER befort_group_max_five_insert
BEFORE INSERT ON `GroupAccount`
FOR EACH ROW
	BEGIN
		DECLARE group_member INT 
        DEFAULT (SELECT count(AccountID)
				 FROM `GroupAccount`
				 WHERE GroupID = NEW.GroupID
				 GROUP BY GroupID);
		IF (group_member >= 5) THEN 
			SIGNAL SQLSTATE '50001' SET MESSAGE_TEXT = 'Group had 5 member!';
		END IF;
    END //
DELIMITER ;

-- 4)
DROP TRIGGER IF EXISTS befort_exam_max_ten_insert;
DELIMITER //
CREATE TRIGGER befort_exam_max_ten_insert
BEFORE INSERT ON `ExamQuestion`
FOR EACH ROW
	BEGIN
		SET @amount_question = (SELECT count(QuestionID)
							  FROM `ExamQuestion`
                              WHERE ExamID = NEW.ExamID
							  GROUP BY ExamID);
		IF (@amount_question >= 10) THEN 
			SIGNAL SQLSTATE '50001' SET MESSAGE_TEXT = 'Exam had 10 question!';
		END IF;
    END //
DELIMITER ;

-- 5)
DROP TRIGGER IF EXISTS befort_account_email_delete;
DELIMITER //
CREATE TRIGGER befort_account_email_delete
BEFORE DELETE ON `Account`
FOR EACH ROW
	BEGIN
		IF (OlD.Email like "%admin@gmail.com%") THEN 
			SIGNAL SQLSTATE '50001' SET MESSAGE_TEXT = 'This is admin email, Counld"t delete!';
		END IF;
    END //
DELIMITER ;
INSERT INTO `Account`(Email, UserName, FullName, DepartmentID, PositionID, CreateDate) 
VALUE("admin@gmail.com", "duongduong", "hoang anh duong", 2, 1,now());
DELETE FROM `Account` 
WHERE Email LIKE '%admin@gmail.com%';

-- 6)
DROP TRIGGER IF EXISTS before_account_insert;
DELIMITER //
CREATE TRIGGER before_account_insert
BEFORE INSERT ON `Account`
FOR EACH ROW
	BEGIN
		DECLARE waiting_department_id INT 
        DEFAULT (SELECT DepartmentID
				 FROM `Department`
				 WHERE DepartmentName like "%waiting Department%");
		IF (NEW.DepartmentID IS NULL) THEN 
            SET NEW.DepartmentID = waiting_department_id;
		END IF;
    END //
DELIMITER ;
INSERT INTO `Account`(Email, UserName, FullName, PositionID, CreateDate) 
VALUE("admin@gmail.com", "duongduong", "hoang anh duong", 1,now());
SELECT 
    *
FROM
    `Account`;
-- 7)
DROP TRIGGER IF EXISTS before_answer_insert;
DELIMITER //
CREATE TRIGGER before_answer_insert
BEFORE INSERT ON `Answer`
FOR EACH ROW
	BEGIN
		DECLARE amount_answer INT 
        DEFAULT (SELECT count(AnswerID)
				 FROM `Answer`
				 GROUP BY QuestionID);
		DECLARE amount_correct_answer INT 
        DEFAULT (SELECT count(AnswerID)
				 FROM `Answer`
				 WHERE isCorrect = true
				 GROUP BY QuestionID);
		IF (amount_answer >= 4) THEN 
			SIGNAL SQLSTATE '50001' SET MESSAGE_TEXT = 'The question had 4 answer!';
		ELSEIF (amount_correct_answer >= 2 AND NEW.isCorrect = true) THEN 
			SIGNAL SQLSTATE '50001' SET MESSAGE_TEXT = 'The question had 2 correct answer!';
		END IF;
    END //
DELIMITER ;

-- 8)
DROP TRIGGER IF EXISTS before_account_gender_insert;
DELIMITER //
CREATE TRIGGER before_account_gender_insert
BEFORE INSERT ON `Account`
FOR EACH ROW
	BEGIN
		IF (NEW.Gender like "%nam%") THEN
			SET NEW.Gender = "M";
        ELSEIF (NEW.Gender like "%nu%") THEN
			SET NEW.Gender = "F";
        ELSEIF (NEW.Gender like "%chua xac dinh%" OR NEW.Gender IS NULL) THEN
			SET NEW.Gender = "U";
		END IF;
    END //
DELIMITER ;
INSERT INTO `Account`(Email, UserName, FullName, Gender, DepartmentID, PositionID, CreateDate) 
VALUE("duoeqeqwng@gmail.com", "duongduong", "vo lua da0","chua xac dinh", 3, 6, "2019-11-20");
SELECT 
    *
FROM
    `Account`;

-- 9)
DROP TRIGGER IF EXISTS before_exam_two_day_ago_delete;
DELIMITER //
CREATE TRIGGER before_exam_two_day_ago_delete
BEFORE DELETE ON `Exam`
FOR EACH ROW
	BEGIN
		SET @create_date = (SELECT CreateDate 
							FROM `Exam`
							WHERE ExamID = OLD.ExamID);
		IF (@create_date > DATE_SUB(NOW(), INTERVAL 2 DAY)) THEN
			SIGNAL SQLSTATE '50001' SET MESSAGE_TEXT = 'The exam were be created two day ago, could"t delete!';
		END IF;
    END //
DELIMITER ;
INSERT INTO `Exam`(Code_Exam, Title, CategoryID, Duration, CreatorID, CreateDate) 
VALUE("adawdawf","dawdaw",1,"10:59:11",1, now());
SELECT * FROM `Exam`;
DELETE FROM `Exam`
WHERE ExamID = 13;

-- 10)
DROP TRIGGER IF EXISTS before_question_delete;
DELIMITER //
CREATE TRIGGER before_question_delete
BEFORE DELETE ON `Question`
FOR EACH ROW
	BEGIN
		DECLARE amount_exam INT 
        DEFAULT (SELECT count(ExamID) 
				 FROM `ExamQuestion`
				 WHERE QuestionID = OLD.QuestionID
				 GROUP BY QuestionID);
		IF (amount_exam > 0) THEN
			SIGNAL SQLSTATE '50001' SET MESSAGE_TEXT = 'Question belong to a exam or more, could"t delete!!';
		END IF;
    END //
DELIMITER ;

-- 12)
DROP FUNCTION IF EXISTS classify_duration;
DELIMITER //
CREATE FUNCTION classify_duration(Duration INT) RETURNS VARCHAR(50)
DETERMINISTIC
	BEGIN
		DECLARE DurationText VARCHAR(50) DEFAULT "";
        IF(Duration <= 30) THEN
			SET DurationText =  "Short Time";
		ELSEIF (Duration > 30 AND Duration <= 60) THEN
			SET DurationText = "Medium Time";
		ELSEIF (Duration > 60) THEN
			SET DurationText = "Long Time";
		END IF;
        RETURN DurationText;
    END //
DELIMITER ;
SELECT *,classify_duration(Duration)
FROM `Exam`;

-- 13)
DROP FUNCTION IF EXISTS the_number_user_amount;
DELIMITER //
CREATE FUNCTION the_number_user_amount(Amount_user INT) RETURNS VARCHAR(50)
DETERMINISTIC
	BEGIN
		DECLARE levelText VARCHAR(50) DEFAULT "";
        IF(Amount_user <= 5) THEN
			SET levelText =  "few";
		ELSEIF (Amount_user > 5 AND Duration <= 20) THEN
			SET levelText = "normal";
		ELSE
			SET levelText = "higher";
		END IF;
        RETURN levelText;
    END //
DELIMITER ;
SELECT gr.GroupID, gr.GroupName, count(grAcc.AccountID), the_number_user_amount(count(grAcc.AccountID))
FROM `Group` gr
JOIN `GroupAccount` grAcc on gr.GroupID = grAcc.GroupID 
GROUP BY gr.GroupID;

-- 14)
DROP FUNCTION IF EXISTS amount_user_department;
DELIMITER //
CREATE FUNCTION amount_user_department(Amount_user INT) RETURNS VARCHAR(45)
DETERMINISTIC
	BEGIN
		DECLARE type_deparment VARCHAR(45) DEFAULT  "";
		IF (Amount_user > 0) THEN
			SET type_deparment = Amount_user;
		ELSE
			SET type_deparment = "khong co user";
		END IF;
	RETURN type_deparment;
	END //
DELIMITER ;

SELECT depart.DepartmentName, amount_user_department(count(acc.DepartmentID)) AS amount_user
FROM `Department` depart 
LEFT JOIN `Account` acc ON depart.DepartmentID = acc.DepartmentID
GROUP BY depart.DepartmentID;

