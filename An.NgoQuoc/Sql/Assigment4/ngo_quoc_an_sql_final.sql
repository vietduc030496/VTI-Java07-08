-- CREATE DATABASE mark;
USE mark;
CREATE TABLE IF NOT EXISTS student(
	RN INT NOT NULL AUTO_INCREMENT,
    `Name` VARCHAR(45) NOT NULL,
    Age INT NOT NULL,
    Gender VARCHAR(45) NOT NULL,
    PRIMARY KEY (RN)
);
CREATE TABLE IF NOT EXISTS `subject`(
	sID INT NOT NULL AUTO_INCREMENT,
    sName VARCHAR(45) UNIQUE NOT NULL,
    PRIMARY KEY (sID)
);
CREATE TABLE IF NOT EXISTS studentsubject(
	RN INT NOT NULL,
    sID INT NOT NULL,
	Mark FLOAT NOT NULL,
    `Date` DATE NOT NULL,
    PRIMARY KEY (RN,sID),
    foreign key (RN) references student(RN),
    foreign key (sID) references `subject`(sID)
);

-- a)
INSERT INTO student VALUES 
(NULL,'Ngo Quoc An 1','22','Nam'),
(NULL,'Ngo Quoc An 2','19','Nam'),
(NULL,'Ngo Quoc An 3','18','Nu'),
(NULL,'Ngo Quoc An 4','17','Nam'),
(NULL,'Ngo Quoc An 5','20','Nu');

INSERT INTO `subject` VALUES 
(NULL, 'Toan roi rac 1'),
(NULL, 'Toan roi rac 2'),
(NULL, 'Toan roi rac 3'),
(NULL, 'Toan roi rac 4');

INSERT INTO studentsubject VALUES 
(1,1,'9.8','2021-07-27'),
(1,2,'5.8''2021-07-27'),
(1,3,'9.6','2021-07-27'),
(2,1,'3.5','2021-07-27'),
(2,3,'6.8','2021-07-27'),
(3,1,'7.8','2021-07-27'),
(3,4,'5.8','2021-07-27'),
(4,4,'9.1','2021-07-27'),
(4,5,'7.2','2021-07-27');

-- b) 
-- Lấy tất cả các môn học không có bất kì điểm nào
SELECT sub.sID,sub.sName
FROM `subject` sub LEFT JOIN studentsubject stu_sub ON sub.sID = stu_sub.sID
GROUP BY sub.sID
HAVING COUNT(stu_sub.sID) = 0;
-- Lấy danh sách các môn học có ít nhất 2 điểm
SELECT sub.sID,sub.sName
FROM `subject` sub LEFT JOIN studentsubject stu_sub ON sub.sID = stu_sub.sID
GROUP BY sub.sID
HAVING COUNT(stu_sub.sID) >= 2;

-- c) Tạo "StudentInfo" view có các thông tin về học sinh bao gồm:
-- RN,sID,Name, Age, Gender, sName, Mark, Date. Với cột Gender show
-- Male để thay thế cho 0, Female thay thế cho 1 và Unknow thay thế cho null.
CREATE VIEW StudentInfo AS
	SELECT 	stu.RN,sub.sID,stu.Name, stu.Age,
			CASE
				WHEN stu.Gender = 1 THEN 'Female'
				WHEN stu.Gender = 0 THEN 'Male'
				WHEN stu.Gender = NULL THEN 'Unknow'
			END Gender,
			sub.sName,stu_sub.Mark, stu_sub.Date
    FROM	studentsubject stu_sub 
    JOIN 	student stu ON stu_sub.RN = stu.RN
    JOIN	`subject` sub ON stu_sub.sID = sub.sID;
    
-- d)
-- Trigger CasUpdate: khi thay đổi data của cột sID, thì giá trị của cột sID của table StudentSubject cũng thay đổi theo
DROP TRIGGER IF EXISTS CasUpdate;
DELIMITER $$
	CREATE TRIGGER CasUpdate
    BEFORE UPDATE ON `subject`
    FOR EACH ROW
    BEGIN
		UPDATE 	studentsubject stu_sub
        SET		stu_sub.sID = NEW.sID
        WHERE	stu_sub.sID = OLD.sID
        ;
    END $$
DELIMITER ;
UPDATE 	subject sub
SET		sub.sID = 6
WHERE	sub.sID = 5;
-- Trigger casDel: Khi xóa 1 student, các dữ liệu của table StudentSubject cũng sẽ bị xóa theo
DROP TRIGGER IF EXISTS CasUpdate;
DELIMITER $$
	CREATE TRIGGER CasUpdate
    BEFORE DELETE ON student
    FOR EACH ROW
    BEGIN
		DELETE 
        FROM	studentsubject stu_sub
        WHERE	stu_sub.RN = OLD.RN
        ;
    END $$
DELIMITER ;
DELETE 
FROM	student stu
WHERE	stu.RN = 5;

-- e)
DROP PROCEDURE IF EXISTS delete_student;
DELIMITER $$
CREATE PROCEDURE delete_student(IN stu_name VARCHAR(45), IN mark_stu FLOAT)
	BEGIN 
		DELETE 
        FROM 	studentsubject stu_sub
        WHERE	stu_sub.RN IN (SELECT sty.RN FROM student stu WHERE stu.Name = stu_name) AND stu_sub.Mark = mark_stu;
	END$$
DELIMITER ;
CALL 	delete_student('Ngo Quoc An 1', '9.8');