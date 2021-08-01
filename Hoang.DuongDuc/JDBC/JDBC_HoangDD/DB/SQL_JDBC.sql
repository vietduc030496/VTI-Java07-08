
CREATE TABLE `Class`(
	`Idclass` INT NOT NULL AUTO_INCREMENT,
	`ClassName` VARCHAR(50) NOT NULL,
    `scholastic` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`Idclass`)
    );
CREATE TABLE `student`(
	`Idstudent` INT NOT NULL AUTO_INCREMENT,
	`firstName` VARCHAR(50) NOT NULL,
    `lastName` VARCHAR(50) NOT NULL,
    `gender` VARCHAR(50) NOT NULL,
    `DOB` date NOT NULL,
    `address` VARCHAR(50) NOT NULL,
    `phoneNumber` VARCHAR(50) NOT NULL,
    `Email` VARCHAR(50) NOT NULL,
    `IDclass` int,
    PRIMARY KEY (`Idstudent`)
    );
CREATE TABLE `transcript`(
	`Idstudent` INT NOT NULL ,
	`Idsubject` INT NOT NULL ,
    `mark` double NOT NULL 
    );
CREATE TABLE `subject`(
	`Idsubject` INT NOT NULL AUTO_INCREMENT,
	`subjectName` VARCHAR(50) NOT NULL ,
    `numberofcredits` int NOT NULL,
     PRIMARY KEY (`Idsubject`)
    );
ALTER TABLE `student` ADD CONSTRAINT `FK_student` FOREIGN KEY (idclass) REFERENCES `class`(idclass) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `transcript` ADD CONSTRAINT `FK_transcript1` FOREIGN KEY (Idstudent) REFERENCES `student`(Idstudent) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `transcript` ADD CONSTRAINT `FK_transcript2` FOREIGN KEY (Idsubject) REFERENCES `subject`(Idsubject) ON DELETE CASCADE ON UPDATE CASCADE;

insert into `class` (ClassName, scholastic) values ('class1','2020-2021'),('class2','2020-2021'),('class3','2020-2021'),('class4','2020-2021'),('class5','2020-2021');
insert into `student` (firstname, lastname, gender, DOB, address, phoneNumber,Email, IDclass) values ('first1','last1','nam','1999-09-15','Ha Noi','0312456728','stu1@gmail.com',1),
('first2','last2','nu','1999-09-16','Ha Noi','0312456727','stu2@gmail.com',1),
('first3','last3','nam','1999-08-15','Ha Noi','0312456726','stu3@gmail.com',2),
('first4','last4','nu','1999-08-16','Ha Noi','0312456725','stu4@gmail.com',2),
('first5','last5','nam','1999-07-15','Ha Noi','0312456724','stu5@gmail.com',3),
('first6','last6','nu','1999-07-16','Ha Noi','0312456723','stu6@gmail.com',3),
('first7','last7','nam','1999-06-15','Ha Noi','0312456722','stu7@gmail.com',4),
('first8','last8','nu','1999-06-16','Ha Noi','0312456721','stu8@gmail.com',4),
('first9','last9','nam','1999-05-15','Ha Noi','0312456720','stu9@gmail.com',5),
('first10','last10','nam','1999-05-18','Ha Noi','0312456719','stu10@gmail.com',5);
insert into `student` (firstname, lastname, gender, DOB, address, phoneNumber,Email, IDclass) values('first11','last11','nu','1999-04-18','Ha Noi','0312456718','stu11@gmail.com',1);
insert into `subject`(subjectName,numberofcredits) values ('subject1',1),('subject2',2),('subject3',3),('subject4',4),('subject5',3);
insert into `transcript`(Idstudent,Idsubject, mark) values (1,1,8.0),(2,1,7.0),(3,2,6.0),(4,2,7.5),(5,3,8.8),(6,3,9.0),(7,4,5.0),(8,4,3.0),(9,5,10.0),(10,5,9.5);
insert into `transcript`(Idstudent,Idsubject, mark) values(1,5,7.0);
insert into `transcript`(Idstudent,Idsubject, mark) values(11,1,7.5);
/*Q2*/
select st.Idstudent, st.firstName, st.lastName, st.DOB, st.gender, cl.ClassName
from `student` st
left join `class` cl on
	st.Idclass = cl.Idclass;
    
/*Q3?*/
With CTE1 AS(
    SELECT 		cr.Idclass, cr.ClassName, gender,Idstudent
    FROM		student AS s
                    RIGHT JOIN	class AS cr
                                  ON			s.Idclass = cr.Idclass),
     CTE2 AS(
         SELECT 		CTE1.Idclass, CTE1.gender, CTE1.Idstudent,count(*) num_of_male
         FROM		CTE1
         WHERE		CTE1.gender = "Nam"
         GROUP BY	CTE1.Idclass
     ),
     CTE3 AS(
         SELECT 		CTE1.Idclass, CTE1.gender, CTE1.Idstudent,count(*) num_of_female
         FROM		CTE1
         WHERE		CTE1.gender = "Nu"
         GROUP BY	CTE1.Idclass
     )
SELECT 		CTE1.Idclass, CTE1.className, COALESCE(CTE2.num_of_male, 0) num_of_male, COALESCE(CTE3.num_of_female,0)num_of_female
FROM 		CTE1
                LEFT JOIN	CTE2
                             ON			CTE1.Idclass = CTE2.Idclass
                LEFT JOIN	CTE3
                             ON			CTE1.Idclass = CTE3.Idclass
Group BY	CTE1.Idclass;

/*Q4*/
select st.Idstudent, cl.ClassName,sj.subjectName, tr.mark
from `student` as st
left join `transcript`as tr on
	st.Idstudent = tr.Idstudent
left join `class` as cl on
	st.IdClass= cl.IDclass
left join `subject` as sj on
	tr.Idsubject= sj.Idsubject
where st.Idstudent =?;

/*Q5*/
Select CS.Idclass , COUNT(cs.Idclass)as So_Luong_Sinh_Vien
from(
select st.Idstudent, st.gender, cl.ClassName, cl.IDclass
from `student` st
left join `class` cl on
	st.Idclass = cl.Idclass) as CS
group by cs.Idclass;

/*Q6*/
select ma.Idsubject,ma.subjectName, ma.Idstudent, ma.firstName, ma.lastName, ma.gender, ma.DOB, min(ma.mark) as MinOfMark
from(select st.Idstudent,st.firstName, st.lastName, st.gender, st.DOB ,sj.IDsubject,sj.subjectName, tr.mark
from `student` as st
right join `transcript`as tr on
	st.Idstudent = tr.Idstudent
left join `subject` as sj on
	tr.Idsubject= sj.Idsubject)as ma
group by ma.subjectName;

/*Q7*/
DROP PROCEDURE IF EXISTS GET_Mark_of_5MAX_student_from_IdSubject;
DELIMITER //
CREATE PROCEDURE GET_Mark_of_5MAX_student_from_IdSubject (IN ID_subject INT)
  BEGIN
	select ma.Idsubject,ma.subjectName, ma.Idstudent, ma.firstName, ma.lastName, ma.gender, ma.DOB, ma.mark
	from(select st.Idstudent,st.firstName, st.lastName, st.gender, st.DOB ,sj.IDsubject,sj.subjectName, tr.mark
		from `student` as st
		right join `transcript`as tr on
			st.Idstudent = tr.Idstudent
		left join `subject` as sj on
			tr.Idsubject= sj.Idsubject)as ma
	where ma.Idsubject = ID_subject
	group by ma.mark
	ORDER BY ma.mark DESC LIMIT 5;
  END//
DELIMITER ;
CALL GET_Mark_of_5MAX_student_from_IdSubject(?);

/*Q8*/
DROP PROCEDURE IF EXISTS GET_AVG_Mark_of_student;
DELIMITER //
CREATE PROCEDURE GET_AVG_Mark_of_student (IN ID_stu INT)
  BEGIN
	select  ma.Idstudent, ma.firstName, ma.lastName, ma.gender, ma.DOB, avg(ma.mark) as DiemTB
	from(select st.Idstudent,st.firstName, st.lastName, st.gender, st.DOB ,sj.IDsubject,sj.subjectName, tr.mark
		from `student` as st
		right join `transcript`as tr on
			st.Idstudent = tr.Idstudent
		left join `subject` as sj on
			tr.Idsubject= sj.Idsubject)as ma
	where ma.Idstudent = ID_stu;
  END//
DELIMITER ;
CALL GET_AVG_Mark_of_student(?);

/*Q9*/
Drop function IF EXISTS   Sum_tuition;
DELIMITER //
CREATE function Sum_tuition ( ID_stu INT ) returns int
READS SQL DATA
DETERMINISTIC
  BEGIN
	DECLARE _tuition int DEFAULT null;
    select sum(crst.numberofcredits)*500000 into _tuition
	from
		(select  ma.Idstudent, ma.firstName, ma.lastName, ma.gender, ma.DOB, ma.subjectName, ma.numberofcredits
		 from(select st.Idstudent,st.firstName, st.lastName, st.gender, st.DOB ,sj.IDsubject,sj.subjectName,sj.numberofcredits
			 from `student` as st
			 right join `transcript`as tr on
				st.Idstudent = tr.Idstudent
			 left join `subject` as sj on
				tr.Idsubject= sj.Idsubject)as ma
		 where ma.Idstudent = ID_stu) crst;
    return _tuition;
  END//
DELIMITER ;
select IDstudent, Sum_tuition(Idstudent) as TongHocPhi_VND
from student
where Idstudent = ?;
