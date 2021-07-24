-- Question 1: Tao strigger khong cho phep nguoi dung nhap vao group co ngay tao truoc 1 nam truoc
DROP TRIGGER IF EXISTS trigger_question1;
DELIMITER $$

CREATE TRIGGER trigger_question1
BEFORE INSERT ON `Group`
FOR EACH ROW
BEGIN
	IF NEW.CreateDate<DATE_SUB(NOW(), INTERVAL 1 YEAR) THEN
    SIGNAL SQLSTATE "12345"
    SET MESSAGE_TEXT="ngay tao phai lon hon 1 nam truoc";
	END IF;
END $$
DELIMITER ;
SHOW TRIGGERS;
INSERT INTO `Group` (GroupName,CreatorID,CreateDate) 
VALUES ("Group999",1,"2020-07-24");
SELECT * 
FROM `Group`;
-- Question 2: Tao strigger khong cho phep nguoi dung them bat cu user nao vao department sales nua
DROP TRIGGER IF EXISTS trigger_question2;
DELIMITER $$
CREATE TRIGGER trigger_question2
BEFORE INSERT ON `Account`
FOR EACH ROW
BEGIN
	IF NEW.DepartmentID=7 THEN
	SIGNAL SQLSTATE "12345"
	SET MESSAGE_TEXT="Phong ban sales khong the add them user";
    END IF;
END $$;
DELIMITER ;
SHOW TRIGGERS;
INSERT INTO `Account` (Email,UserName,FullName,DepartmentID,PositionID,CreateDate) 
VALUES ("a2@gmail.com","thinh2","phamxuanthinh2",7,1,"2021-07-20");
SELECT * 
FROM `Account`;
-- Question 3: Cau hinh 1 group co nhieu nhat la 5 user
DROP TRIGGER IF EXISTS trigger_question3;
DELIMITER $$
CREATE TRIGGER trigger_question3
BEFORE INSERT ON `GroupAccount`
FOR EACH ROW
BEGIN
	DECLARE count_user_group INT;
    SET count_user_group=
    (SELECT COUNT(`GroupAccount`.GroupID)
    FROM `GroupAccount`
    WHERE `GroupAccount`.GroupID=NEW.GroupId
    GROUP BY `GroupAccount`.GroupID);
    IF count_user_group>5 THEN
    SIGNAL SQLSTATE "12345"
    SET MESSAGE_TEXT="1 nhom khong duoc qua 5 user";
    END IF;
END $$
DELIMITER ;
SHOW TRIGGERS;
INSERT INTO `GroupAccount` (GroupID,AccountID,JoinDate) VALUES (1,1,"2021-07-20"),(1,1,"2021-07-20"),(1,1,"2021-07-20"),(1,1,"2021-07-20"),(1,1,"2021-07-20");
SELECT * FROM `GroupAccount`;
-- Question 4: Cau hinh 1 bai thi co nhieu nhat la 10 question
DROP TRIGGER IF EXISTS trigger_question4;
DELIMITER $$
CREATE TRIGGER trigger_question4
BEFORE INSERT ON `ExamQuestion`
FOR EACH ROW
BEGIN
	DECLARE count_question_exam INT;
    SET count_question_exam=
    (SELECT COUNT(`ExamQuestion`.ExamID)
    FROM `ExamQuestion`
    WHERE `ExamQuestion`.ExamID=NEW.ExamID
    GROUP BY `ExamQuestion`.ExamID);
    IF count_question_exam>10 THEN
    SIGNAL SQLSTATE "12345"
    SET MESSAGE_TEXT="1 exam khong duoc qua 10 question";
    END IF;
END $$
DELIMITER ;
SHOW TRIGGERS;
INSERT INTO `ExamQuestion` (ExamID,QuestionID) VALUES (1,1),(1,2),(1,1),(1,2),(1,1),(1,2),(1,1),(1,2),(1,1),(1,2);
SELECT * FROM `ExamQuestion`;
-- Question 5: Tao trigger khong cho phep nguoi dung xoa tai khoan co email la admin@gmail.com, con lai cac tai khoan khac thi se cho phep xoa va se xoa tat ca thong tin lien quan den user do
DROP TRIGGER IF EXISTS trigger_question5;
DELIMITER $$
CREATE TRIGGER trigger_question5
BEFORE DELETE ON `Account`
FOR EACH ROW
BEGIN
	IF OLD.Email="admin@gmail.com" THEN
    SIGNAL SQLSTATE "12345"
    SET MESSAGE_TEXT="khong duoc xoa tai khoan email admin";
    ELSE
	DELETE 
    FROM `Group`
    WHERE `Group`.CreatorID=OLD.AccountID;
	DELETE 
    FROM `GroupAccount`
    WHERE `GroupAccount`.GroupID=(
    SELECT GroupID 
    FROM `Group`
	WHERE `Group`.CreatorID=OLD.AccountID);
	DELETE 
    FROM `Question`
    WHERE `Question`.CreatorID=OLD.AccountID;
	DELETE 
    FROM `Exam`
    WHERE `Exam`.CreatorID=OLD.AccountID;
	DELETE 
    FROM `Answer`
    WHERE `Answer`.QuestionID=(
    SELECT QuestionID 
    FROM `Question`
	WHERE `Question`.CreatorID=OLD.AccountID);
	DELETE 
    FROM `ExamQuestion`
    WHERE `Exam`.ExamID=(
    SELECT ExamID 
    FROM `Exam`
	WHERE `Exam`.CreatorID=OLD.AccountID);
    END IF;
END $$
DELIMITER ;
SHOW TRIGGERS;
INSERT INTO `Account` (Email,UserName,FullName,DepartmentID,PositionID,CreateDate) VALUES ("admin@gmail.com","thinh4","phamxuanthinh4",1,1,"2021-07-20");
DELETE FROM `Account`
WHERE `Account`.Email="admin@gmail.com";
SELECT * FROM `Account`;
-- Question 6: Khong su dung cau hinh default cho field departmentid cuat table account, tao trigger cho phep nguoi dung khi tao account khong dien vao departmentid thi se duoc phan vao phong ban waiting department
DROP TRIGGER IF EXISTS trigger_question6;
DELIMITER $$
CREATE TRIGGER trigger_question6
BEFORE INSERT ON `Account`
FOR EACH ROW
BEGIN
	IF NEW.DepartmentID IS NULL THEN
    SET NEW.DepartmentID=5;
    END IF;
END $$
DELIMITER ;
INSERT INTO `Account` (Email,UserName,FullName,PositionID,CreateDate) VALUES ("n@gmail.com","anh","phamvietanh",1,"2021-07-20");
SELECT * FROM `Account`;
-- Question 7: Cau hinh 1 bai thi chi cho phep user tao toi da 4 answers cho moi question, trong do co toi da 2 dap an dung
DROP TRIGGER IF EXISTS trigger_question7;
DELIMITER $$
CREATE TRIGGER trigger_question7
BEFORE INSERT ON `Answer`
FOR EACH ROW
BEGIN
	DECLARE count_answer_question INT;
    DECLARE count_answer_correct INT;
    SET count_answer_question=
	(SELECT COUNT(`Answer`.QuestionID) 
    FROM `Answer`
    WHERE `Answer`.QuestionID=NEW.QuestionID
    GROUP BY `Answer`.QuestionID);
	SET count_answer_correct=
	(SELECT COUNT(`Answer`.QuestionID) 
    FROM `Answer`
    WHERE `Answer`.QuestionID=NEW.QuestionID
    AND `Answer`.isCorrect=true
    GROUP BY `Answer`.QuestionID);
    IF count_answer_question>4 THEN
    SIGNAL SQLSTATE "12345"
    SET MESSAGE_TEXT="chi toi da 4 answer cho mot question";
    ELSEIF count_answer_correct>2 THEN
	SIGNAL SQLSTATE "12345"
    SET MESSAGE_TEXT="chi toi da 2 answer dung cho mot question";
    END IF;
END $$
DELIMITER ;
INSERT INTO `Answer` (Content,QuestionID,isCorrect) VALUES ("Answer1",10,true),("Answer1",10,true);
SELECT * FROM `Answer`;
-- Question 8: Viet strigger sua lai du lieu cho dung: neu nguoi dung nhap vao gender cua account la nam, nu, chua xac dinh thi doi thanh M,F,U cho giong voi cau hinh o database
DROP TRIGGER IF EXISTS trigger_question8;
DELIMITER $$
CREATE TRIGGER trigger_question8
BEFORE INSERT ON `Account`
FOR EACH ROW
BEGIN
	IF NEW.Gender="nam" THEN
    SET NEW.Gender="M";
	ELSEIF NEW.Gender="nu" THEN
    SET NEW.Gender="F";
	ELSEIF NEW.Gender="chua xac dinh" THEN
    SET NEW.Gender="U";
    END IF;
END $$
DELIMITER ;
INSERT INTO `Account` (Email,UserName,FullName,PositionID,CreateDate) VALUES ("n@gmail.com","anh","phamvietanh",1,"2021-07-20");
SELECT * FROM `Account`;
-- Question 9: Viet strigger khong cho phep nguoi dung xoa bai thi moi tao duoc 2 ngay
DROP TRIGGER IF EXISTS trigger_question9;
DELIMITER $$
CREATE TRIGGER trigger_question9
BEFORE DELETE ON `Exam`
FOR EACH ROW
BEGIN

	IF OLD.CreateDate>=DATE_SUB(NOW(), INTERVAL 2 DAY) THEN
    SIGNAL SQLSTATE "12345"
    SET MESSAGE_TEXT="khong duoc xoa bai thi moi tao 2 ngay";
	END IF;
END $$
DELIMITER ;
INSERT INTO `Exam` (`Code`,Title,CategoryID,Duration,CreatorID,CreateDate) VALUES (11,"Exam99",1,30,1,"2021-07-23");
DELETE FROM `Exam` WHERE `Exam`.ExamID=12;

-- Question 10: Viet strigger chi cho phep nguoi dung duoc update, delete cac question khi question do chua nam trong exam nao
DROP TRIGGER IF EXISTS trigger_question10a;
DELIMITER $$
CREATE TRIGGER trigger_question10a
BEFORE DELETE ON `Question`
FOR EACH ROW
BEGIN
	DECLARE count_question_exam INT;
    SET count_question_exam=
    (SELECT COUNT(`ExamQuestion`.QuestionID)
    FROM `ExamQuestion`
    WHERE `ExamQuestion`.QuestionID=OLD.QuestionID
    GROUP BY `ExamQuestion`.QuestionID);
    IF count_question_exam>0 THEN
    SIGNAL SQLSTATE "12345"
    SET MESSAGE_TEXT="khong duoc delete cac question da nam trong exam";
    END IF;
END $$
DELIMITER ;
DELETE FROM `Question` WHERE `Question`.QuestionID=1;
SELECT * FROM `Question`;


DROP TRIGGER IF EXISTS trigger_question10b;
DELIMITER $$
CREATE TRIGGER trigger_question10b
BEFORE UPDATE ON `Question`
FOR EACH ROW
BEGIN
	DECLARE count_question_exam INT;
    SET count_question_exam=
    (SELECT COUNT(`ExamQuestion`.QuestionID)
    FROM `ExamQuestion`
    WHERE `ExamQuestion`.QuestionID=OLD.QuestionID
    GROUP BY `ExamQuestion`.QuestionID);
    IF count_question_exam>0 THEN
    SIGNAL SQLSTATE "12345"
    SET MESSAGE_TEXT="khong duoc update cac question da nam trong exam";
    END IF;
END $$
DELIMITER ;
UPDATE `Question` 
SET `Question`.Content="abc" 
WHERE `Question`.QuestionID=1;
SELECT * FROM `Question`;


-- Question 12: Lay ra thong tin exam trong do duration<=30 doi thanh "short time", 30<duration<=60 doi thanh "medium time", duration>60 doi thanh "long time"
DROP TRIGGER IF EXISTS trigger_question12;
DELIMITER $$
CREATE TRIGGER trigger_question12
BEFORE UPDATE ON `Exam`
FOR EACH ROW
BEGIN
	IF NEW.Duration<=30 THEN
    SET NEW.Duration="short time";
	ELSEIF NEW.Duration>30 AND NEW.Duration<=60 THEN
    SET NEW.Duration="medium time";
	ELSEIF NEW.Duration>60 THEN
    SET NEW.Duration="long time";
    END IF;
END $$
DELIMITER ;
ALTER TABLE `Exam` MODIFY Duration VARCHAR(50);
SET sql_safe_updates = 0;
UPDATE `Exam` 
SET `Exam`.Duration=`Exam`.Duration;
SET sql_safe_updates = 1;
SELECT * FROM `Exam`;

-- Question 13: Thong ke so account trong moi group va in ra them 1 column nua co ten la the_number_user_amount va mang gia tri duoc quy dinh
SELECT `GroupAccount`.GroupID,COUNT(`GroupAccount`.GroupID) AS TOTAL,
CASE	
	WHEN(COUNT(`GroupAccount`.GroupID))<=5 THEN "few"
	WHEN(COUNT(`GroupAccount`.GroupID))>5 AND COUNT(`GroupAccount`.GroupID)<=20
		THEN "normal"
	WHEN(COUNT(`GroupAccount`.GroupID))>20
		THEN "higher"    
	END the_number_user_amount
FROM `GroupAccount`
GROUP BY `GroupAccount`.GroupID;

-- Question 14: Thong ke moi phong ban co bao nhieu user, neu phong ban nao khong co user thi se thay doi gia tri 0 thanh "khong co user"
SELECT `Department`.DepartmentID,
CASE
	WHEN NOT EXISTS(SELECT 1 FROM `Account` WHERE `Account`.DepartmentID=`Department`.DepartmentID)
		THEN "khong co user"
	ELSE COUNT(`Account`.DepartmentID)
END	TOTAL
FROM `Department`
LEFT JOIN `Account`
ON `Department`.DepartmentID=`Account`.DepartmentID
GROUP BY `Department`.DepartmentID;



