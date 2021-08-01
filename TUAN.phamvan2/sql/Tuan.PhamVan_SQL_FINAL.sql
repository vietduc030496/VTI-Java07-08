-- a)
/*============================== CREATE DATABASE =======================================*/
/*======================================================================================*/
DROP DATABASE IF EXISTS FinalExam;
CREATE DATABASE FinalExam;
USE FinalExam;

/*============================== CREATE TABLE=== =======================================*/
/*======================================================================================*/

-- create table 1: Student
DROP TABLE IF EXISTS `Student`;
CREATE TABLE `Student`(
	RN 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    StudentName 	NVARCHAR(30) NOT NULL UNIQUE KEY,
    Age 			INT NOT NULL,
    Gender 			TINYINT 
);

-- create table 2: Subject
DROP TABLE IF EXISTS `Subject`;
CREATE TABLE `Subject` (
	sID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    sName			NVARCHAR(30) NOT NULL UNIQUE KEY
);

-- create table 3: StudentSubject
DROP TABLE IF EXISTS `StudentSubject`;
CREATE TABLE `StudentSubject`(
	RN					TINYINT UNSIGNED,
    sID					TINYINT UNSIGNED,
    Mark				INT NOT NULL,
    ssDate				DATETIME NOT NULL,
    PRIMARY KEY(RN, sID),
    FOREIGN KEY(RN) REFERENCES Student(RN),
    FOREIGN KEY(sID) REFERENCES `Subject`(sID)
    
);

INSERT INTO `Student`(StudentName, 		  Age, 	Gender) 
VALUES 				 ('Nguyen Hai Dang',  26, 	0),
					 ('Tong Quang Anh',   22, 	0),
                     ('Nguyen Van Chien', 29, 	null);
				
INSERT INTO `Subject`(	  sName		)
VALUES 				 ('Toan cao cap'),
					 ('Tin hoc co so'),
                     ('Vat ly');
                     
INSERT INTO `StudentSubject`(RN, 	sID, 	Mark, 		ssDate  ) 
VALUES 						(1, 	2, 	   10, '2021-07-20'), 
							(3, 	2, 	   8, '2021-07-21'),  
                            (2, 	3,     9, '2021-07-22');
                     
-- b)
SELECT sub.sID, sub.sName, count(sub.sID) AS So_Luong FROM `Subject` sub 
INNER JOIN `StudentSubject` ss ON sub.sID = ss.sID
GROUP BY sub.sID
HAVING So_Luong = 0;           

SELECT sub.sID, sub.sName, count(sub.sID) AS So_Luong FROM `Subject` sub 
INNER JOIN `StudentSubject` ss ON sub.sID = ss.sID
GROUP BY sub.sID
HAVING So_Luong >= 2; 

-- c)
CREATE OR REPLACE VIEW StudentInfo
AS 
	(SELECT stu.RN, ss.sID, stu.StudentName, stu.Age, stu.Gender, aa.sName, ss.Mark, ss.ssDate
	FROM `Student` stu INNER JOIN
	`StudentSubject` ss ON ss.RN = stu.RN INNER JOIN
	`Subject` sub ON sub.sID = ss.sID);
SELECT * FROM StudentInfo;

-- d)
DROP TRIGGER IF EXISTS CasUpdate;
DELIMITER //
CREATE TRIGGER CasUpdate
AFTER UPDATE ON `Subject`
FOR EACH ROW
BEGIN

END//
DELIMITER ;


DROP TRIGGER IF EXISTS CasDel;
DELIMITER //
CREATE TRIGGER CasDel
BEFORE DELETE ON `Subject`
FOR EACH ROW
BEGIN

END//
DELIMITER ;
DELETE FROM `Student`
WHERE RN = 1;

-- e)
DROP PROCEDURE IF EXISTS delete_student_info;
DELIMITER //
CREATE PROCEDURE delete_student_info(IN student_name VARCHAR(45), IN mark INT)
	BEGIN
		DELETE FROM `StudentSubject` WHERE StudentSubject.RN IN 
		(SELECT RN FROM `Student` stu WHERE stu.StudentName = student_name) AND StudentSubject.Mark < mark;
	END//
DELIMITER ;
CALL delete_student_info('Tong Quang Anh', 9);