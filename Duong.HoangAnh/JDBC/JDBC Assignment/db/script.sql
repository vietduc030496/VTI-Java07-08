DROP DATABASE IF EXISTS jdbc_database;
CREATE DATABASE IF NOT EXISTS jdbc_database;
USE jdbc_database;
CREATE TABLE IF NOT EXISTS `Class` (
	classID 	INT AUTO_INCREMENT,
    className 	VARCHAR(45) NOT NULL,
    schoolYear 	VARCHAR(45) NOT NULL,
    PRIMARY KEY (classID)
);
CREATE TABLE IF NOT EXISTS `Student` (
	studentID 	INT AUTO_INCREMENT,
    firstName 	VARCHAR(45) NOT NULL,
    lastName 	VARCHAR(45) NOT NULL,
    gender 		INT NOT NULL,
    birthDay 	DATE NOT NULL,
    address 	VARCHAR(65) NOT NULL,
    phone 		VARCHAR(12) NOT NULL,
    email 		VARCHAR(45) NOT NULL,
    classID 	INT,
    PRIMARY KEY (studentID),
    FOREIGN KEY (classID)
		REFERENCES `Class` (classID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
CREATE TABLE IF NOT EXISTS `Subject` (
	subjectID 		INT AUTO_INCREMENT,
    subjectName 	VARCHAR(45) NOT NULL,
    credits 		INT NOT NULL,
    PRIMARY KEY (subjectID)
);
CREATE TABLE IF NOT EXISTS `MarkBoard` (
	studentID 	INT NOT NULL,
	subjectID 	INT NOT NULL,
    mark 		INT NOT NULL,
    FOREIGN KEY (studentID)
		REFERENCES `Student` (studentID)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
	FOREIGN KEY (subjectID)
		REFERENCES `Subject` (subjectID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

INSERT INTO `Class`(className, schoolYear)
VALUE ("Lop 1A", "2000-2001"),
	  ("Lop 2C", "2003-2004"),
	  ("Lop 4D", "2008-2009"),
	  ("Lop 5A", "2020-2021"),
	  ("Lop 3B", "2014-2019");
INSERT INTO `Subject`(subjectName, credits)
VALUE ("Math", 3),
	  ("English", 5),
      ("History", 2),
      ("Biology", 3),
      ("Physics", 4);
INSERT INTO `Student`(firstName, lastName, gender, birthDay, address, phone, email, classID)
VALUE ("luu", 	"hoa vinh",	 1, "1999-09-10", "144 xuan thuy", 0989222333, "luu@1419.com", 1),
	  ("tieu", 	"cai", 		 1, "2001-09-19", "147 xuan thuy", 0989989333, "tieu@1419.com", 1),
	  ("cong", 	"ton sach",  2, "2002-09-19", "247 xuan thuy", 0982389333, "cong@1419.com", 1),
	  ("tong", 	"giang", 	 1, "2003-09-19", "347 xuan thuy", 0931298933, "tong@1419.com", 2),
	  ("cuu", 	"van long",  2, "2004-09-19", "447 xuan thuy", 0989336753, "cuu@1419.com", 2);
INSERT INTO `MarkBoard`(studentID, subjectID, mark)
VALUE (1, 1, 10),(1, 2, 5),(1, 3, 8),(1, 4, 4),(1, 5, 6),
      (2, 1, 10),(2, 2, 10),(2, 3, 9),(2, 4, 9),(2, 5, 6),
      (3, 1, 8),(3, 2, 9),(3, 3, 8),(3, 4, 7),(3, 5, 6),
      (4, 1, 7),(4, 2, 7),(4, 3, 8),(4, 4, 8),(4, 5, 9),
      (5, 1, 9),(5, 2, 9),(5, 3, 9),(5, 4, 10),(5, 5, 10);

DELIMITER //
CREATE FUNCTION change_gender(gender INT) RETURNS VARCHAR(10)
DETERMINISTIC
	BEGIN
		DECLARE type_gender VARCHAR(10) DEFAULT  "";
		IF (gender = 1) THEN
			SET type_gender = "Nam";
		ELSEIF (gender = 2) THEN
			SET type_gender = "Nu";
		ELSE  
			SET type_gender = "Ko XD";
		END IF;
		RETURN type_gender;
	END //
DELIMITER;

DELIMITER //
CREATE PROCEDURE show_student()
	BEGIN	
		SELECT	stu.studentID AS `ID`,
				CONCAT(stu.firstName ," ", stu.lastName) AS `Full name`,
                stu.birthDay AS `BirthDay`,
                change_gender(stu.gender) AS `Gender`,
                cla.className AS `Class name`
        FROM `Student` stu
        LEFT JOIN `Class` cla ON stu.classID = cla.classID;
	END //
DELIMITER ;

DELIMITER //
CREATE FUNCTION count_gender(classID INT, gender INT) RETURNS INT
DETERMINISTIC
	BEGIN
		DECLARE amount INT DEFAULT (SELECT COUNT(stu.gender)
									FROM `Class` cla
									LEFT JOIN `Student` stu ON cla.classID = stu.classID
									WHERE stu.gender = gender
									GROUP BY cla.classID
                                    HAVING cla.classID = classID);
		IF (amount IS NULL) THEN
			SET amount = 0;
		END IF;
		RETURN amount;
	END //
DELIMITER;

DELIMITER //
CREATE PROCEDURE show_amount_male_female_in_class()
	BEGIN	
		SELECT	cla.className AS `Class name`,
				count_gender(cla.classID, 1) AS `Male`,
				count_gender(cla.classID, 2) AS `Female`
        FROM `Class` cla;
	END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE show_mark_board_student(IN studentID INT)
	BEGIN	
		WITH mark_board_subject_cte(studentID, subjectName, mark) AS(
			SELECT markB.studentID,
				   sub.subjectName,
                   markB.mark
			FROM `MarkBoard` markB
            LEFT JOIN `Subject` sub ON markB.subjectID = sub.subjectID
        )
		SELECT	stu.studentID AS `ID`,
				cla.className AS `Class name`,
				markBCTE.subjectName AS `Subject`,
                markBCTE.mark AS `Mark`
        FROM `Student` stu
        LEFT JOIN `Class` cla ON stu.classID = cla.classID
        LEFT JOIN `mark_board_subject_cte` markBCTE ON stu.studentID = markBCTE.studentID
        WHERE stu.studentID = studentID;
	END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE count_student_class(IN classID INT, OUT amount INT)
	BEGIN	
		SELECT	COUNT(stu.studentID) INTO amount
        FROM `Class` cla
        LEFT JOIN `Student` stu ON cla.classID = stu.classID
        WHERE cla.classID = classID
        GROUP BY cla.classID;
	END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE show_student_in_class(IN classID INT)
	BEGIN	
		SELECT	cla.classID AS `ID`,
				cla.className AS `Class name`,
				stu.firstName AS `First name`, 
                stu.lastName AS `Last name`,
                change_gender(stu.gender) AS `Gender`,
                stu.birthDay AS `BirthDay`
        FROM `Class` cla
        LEFT JOIN `Student` stu ON cla.classID = stu.classID
        WHERE cla.classID = classID;
	END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE find_student_min_mark(IN ID INT)
	BEGIN	
		WITH mark_board_subject_cte(subjectID, studentID, mark) AS (
			SELECT subjectID, studentID, mark
            FROM `MarkBoard`
            WHERE subjectID = ID
        )
        SELECT cla.classID AS `ID`,
			   cla.className AS `Class name`,
			   stu.firstName AS `First name`, 
			   stu.lastName AS `Last name`,
			   change_gender(stu.gender) AS `Gender`,
			   stu.birthDay AS `BirthDay`,
               cte.mark AS `Mark`
        FROM `Student` stu
        JOIN `Class` cla ON stu.classID = cla.classID
        JOIN mark_board_subject_cte cte ON stu.studentID = cte.studentID
        WHERE cte.mark = (SELECT MIN(mark) FROM mark_board_subject_cte);
	END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE find_top_three_mark(IN ID INT)
	BEGIN	
		SELECT subjectID, studentID, mark
		FROM `MarkBoard`
		WHERE subjectID = ID
        GROUP BY mark
        ORDER BY mark DESC
        LIMIT 3;
	END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE select_student_top_three_mark(IN ID INT, IN mark INT)
	BEGIN	
		SELECT cla.classID AS `ID`,
			   cla.className AS `Class name`,
			   stu.firstName AS `First name`, 
			   stu.lastName AS `Last name`,
			   change_gender(stu.gender) AS `Gender`,
			   stu.birthDay AS `BirthDay`,
               markB.mark AS `Mark`
        FROM `Student` stu
        JOIN `Class` cla ON stu.classID = cla.classID
        JOIN `MarkBoard` markB ON stu.studentID = markB.studentID
        WHERE subjectID = ID AND markB.mark = mark;
	END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE average_mark_student(IN ID INT, OUT average DOUBLE)
	BEGIN	
		SELECT AVG(mark) INTO average
        FROM `MarkBoard`
        WHERE studentID = ID;
	END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE calc_amount_monney(IN ID INT, OUT amount INT)
	BEGIN	
		SELECT SUM(sub.credits) INTO amount
        FROM `MarkBoard` maskB
        JOIN `Subject` sub ON maskB.subjectID = sub.subjectID
        WHERE studentID = ID;
	END //
DELIMITER ;