#CREATE SCHEMA demo_jdbc
CREATE TABLE ClassRoom (
classID		INT PRIMARY KEY AUTO_INCREMENT,
className	VARCHAR(50),
schoolYear	VARCHAR(50)
);

CREATE TABLE Student (
studentID		INT PRIMARY KEY AUTO_INCREMENT,
classID			INT,
firstName		VARCHAR(50),
`name`			VARCHAR(50),
gender			VARCHAR(50),
birthDate		DATE,
address			VARCHAR(50),
phoneNumber		VARCHAR(50),
email		VARCHAR(50)
);

CREATE TABLE Transcript (
studentID		INT,
subjectID		INT,
score			FLOAT
);

CREATE TABLE `Subject` (
subjectID		INT PRIMARY KEY AUTO_INCREMENT,
subjectName		VARCHAR(50),
credits			INT
);

ALTER TABLE Student ADD FOREIGN KEY (classID) REFERENCES Classroom(classID) ON DELETE CASCADE;
ALTER TABLE Transcript ADD FOREIGN KEY (studentID) REFERENCES Student(studentID) ON DELETE CASCADE;
ALTER TABLE Transcript ADD FOREIGN KEY (subjectID) REFERENCES `Subject`(subjectID) ON DELETE CASCADE;

INSERT INTO Classroom VALUES(NULL,"CN09","D17"),
(NULL,"CN08","D18"),
(NULL,"CN10","D19"),
(NULL,"CN02","D15"),
(NULL,"CN05","D14"),
(NULL,"CN11","D09");
INSERT INTO Student VALUES(NULL,1,"Nguyen", "Hieu", "Male", "1999-03-29", "Ha Noi","0999999999", "hieunguyen@gmail.com"),
(NULL,2,"Nguyen", "Nghia", "Male", "2005-08-08", "Nam Dinh","0888888888", "nghianguyen@gmail.com"),
(NULL,3,"Tran", "Dung", "Male", "2010-11-11", "Ha Noi","0666666666", "dungtran@gmail.com"),
(NULL,4,"Ngo", "Hoang", "Male", "2015-12-12", "Ha Noi","0555555555", "hoangngo@gmail.com");
INSERT INTO student(classID, firstName,`name`, gender, birthDate, address, phoneNumber, email ) 
VALUES(5,"Tran", "Hoa", "Female", "1980-10-10", "Nam Dinh","0686868688", "hoatran@gmail.com");
INSERT INTO student(classID, firstName,`name`, gender, birthDate, address, phoneNumber, email ) 
VALUES(5,"Tran", "Hoa", "Male", "1980-10-10", "Nam Dinh","0686868688", "hoatran@gmail.com");
INSERT INTO student(classID, firstName,`name`, gender, birthDate, address, phoneNumber, email ) 
VALUES(5,"Tran", "Hoa", "Female", "1980-10-10", "Nam Dinh","0686868688", "hoatran@gmail.com");

INSERT INTO `Subject` VALUES(NULL, "Java", 5),
(NULL, "PHP", 3),
(NULL, "HTML", 2),
(NULL, "Lavarel", 2),
(NULL, "Ruby", 3);

INSERT INTO Transcript VALUES(1,1,9.5),
(1,2,9),
(2,3,5),
(3,1,8),
(4,2,3),
(5,4,10);
INSERT INTO Transcript VALUES
(2,1,8),
(4,1,5),
(5,1,3);

#Question 1:
#Question 2:
SELECT			studentID, CONCAT(firstName," " , `name`)AS fullName , `name`, birthDate, gender, className
FROM			student AS s
NATURAL JOIN	classroom AS cr;
delete 
FROM	student
Where studentID = 9;
 




#Question 3
With CTE1 AS(
		SELECT 		cr.classID,className, gender,studentID
		FROM		student AS s
		RIGHT JOIN	classroom AS cr
		ON			s.classID = cr.classID),
CTE2 AS(
		SELECT 		CTE1.classID, CTE1.gender, CTE1.studentID , count(*) num_of_male
        FROM		CTE1
        WHERE		CTE1.gender = "Male"
        GROUP BY	CTE1.classID
        
),
CTE3 AS(
		SELECT 		CTE1.classID, CTE1.gender, CTE1.studentID,count(*) num_of_female
        FROM		CTE1
        WHERE		CTE1.gender = "Female"
        GROUP BY	CTE1.classID
)
SELECT 		CTE1.classID,CTE1.className, CTE2.num_of_male, CTE3.num_of_female
FROM 		CTE1
LEFT JOIN	CTE2
ON			CTE1.classID = CTE2.classID
LEFT JOIN	CTE3
ON			CTE1.classID = CTE3.classID
Group BY	CTE1.classID;	
select * from student;

#Question 4
WITH CTE1 AS(
	SELECT		studentID, t.subjectID, subjectName
    FROM		transcript AS t
    LEFT JOIN	`subject` AS s
    ON			t.subjectID = s.subjectID
)
SELECT			s.studentID, cr.className, CTE1.subjectName, t.score
FROM			student AS s
NATURAL JOIN	classroom AS cr
NATURAL JOIN	transcript AS t
NATURAL JOIN	CTE1;

#Question 5:
SELECT 		cr.classID,className, count(s.classID) AS num_of_student
FROM		student AS s
RIGHT JOIN	classroom AS cr
ON			s.classID = cr.classID
GROUP By	s.classID;

SELECT 		s.classID,className, studentID, firstName, `name`, gender, birthDate
FROM		student AS s
NATURAL JOIN	classroom AS cr
ORDER BY	classID;

#Question 6:
SELECT			s.subjectID, subjectName, t.studentID, stu.firstName, stu.`name`, gender, MIN(t.score) AS minScore
FROM			`subject` AS s
NATURAL JOIN	transcript AS t
NATURAL JOIN	student AS stu
GROUP BY		subjectName;

#Question 7

DROP PROCEDURE IF EXISTS get_max_score;
DELIMITER $$
CREATE PROCEDURE get_max_score(IN in_subjectID INT)
			BEGIN
				SELECT  		subjectID, studentID, classID, firstName, `name`, gender, score
                FROM			student AS stu
                NATURAL JOIN 	transcript AS t
                WHERE 			subjectID = in_subjectID
                GROUP BY		score
                ORDER BY 		score DESC
                LIMIT	4;
			END$$
DELIMITER ;
CALL get_max_score(1);

#Question 8
DROP PROCEDURE IF EXISTS get_avg_score;
DELIMITER $$
CREATE PROCEDURE get_avg_score(IN in_studentID INT)
			BEGIN
				SELECT			stu.studentID, firstName, `name`, ROUND(AVG(score),2) AS avgScore
                FROM			student AS stu
                LEFT JOIN		transcript AS t
                ON				stu.studentID = t.studentID
				where			stu.studentID = in_studentID;
			END$$
DELIMITER ;
CALL get_avg_score(1);

#Question 9:
SET GLOBAL log_bin_trust_function_creators = 1;
DROP FUNCTION IF EXISTS get_tuition;
DELIMITER $$
CREATE FUNCTION get_tuition(in_studentID INT)
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE 		one_credit 	INT DEFAULT 500;
    DECLARE			tuition		INT DEFAULT	0;
	WITH CTE1 AS(
		SELECT 			studentID, subjectID, SUM(credits) AS sum_credits
        FROM			`subject` AS sub
        NATURAL JOIN	transcript AS t
        GROUP BY		studentID
    )
    SELECT			(one_credit  * CTE1.sum_credits) INTO tuition 
	FROM			CTE1
	WHERE			CTE1.studentID = in_studentID;
RETURN (tuition);
END$$
DELIMITER ;



