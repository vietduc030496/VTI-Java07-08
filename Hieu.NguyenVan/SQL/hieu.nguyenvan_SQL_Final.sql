
-- question a,
create database if not exists school ;
use school;

CREATE TABLE IF NOT EXISTS Student(
	RN INT (10) auto_increment primary key ,
    Name VARCHAR(225) ,
    Age INT (3),
    Gender VARCHAR(225)
) ;
CREATE TABLE IF NOT EXISTS  Subject(
	sID INT(10) AUTO_INCREMENT PRIMARY KEY,
    sName VARCHAR(225) 
);


CREATE TABLE IF NOT EXISTS  StudentSubject(
	RN INT  ,
    FOREIGN KEY (RN) REFERENCES Student(RN),
    sID INT ,
    FOREIGN KEY (sID) REFERENCES Subject(sID),
    Mark INT ,
    PRIMARY KEY(RN,sID),
    Date DATE
) ;

-- INSERT INTO Student(Name ,Age, Gender) values ('Nguyen van acc 1',20,'Nam');
-- INSERT INTO Student(Name ,Age, Gender) values ('Nguyen van acc 2',20,'Nam');
-- INSERT INTO Student(Name ,Age, Gender) values ('Nguyen van acc 3',20,'Nam');
-- INSERT INTO Student(Name ,Age, Gender) values ('Nguyen van acc 4',20,'Nu');
-- INSERT INTO Student(Name ,Age, Gender) values ('Nguyen van acc 5',20,'Nu');
-- INSERT INTO Student(Name ,Age, Gender) values ('Nguyen van acc 6',20,'Nam');
-- INSERT INTO Student(Name ,Age, Gender) values ('Nguyen van acc 7',20,'Nu');
-- INSERT INTO Subject(sName ) values ('Toan');
-- INSERT INTO Subject(sName ) values ('Ly');
-- INSERT INTO Subject(sName ) values ('Hoa');
-- INSERT INTO Subject(sName ) values ('Van');
-- INSERT INTO Subject(sName ) values ('Anh');

-- INSERT INTO StudentSubject(RN,sID,Mark,Date ) values ('1',1,9,'2020-10-12');
-- INSERT INTO StudentSubject(RN,sID,Mark,Date ) values ('1',2,8,'2020-10-12');
-- INSERT INTO StudentSubject(RN,sID,Mark,Date ) values ('1',3,4,'2020-10-12');
-- INSERT INTO StudentSubject(RN,sID,Mark,Date ) values ('2',1,5,'2020-10-12');
-- INSERT INTO StudentSubject(RN,sID,Mark,Date ) values ('2',2,7,'2020-10-12');
-- INSERT INTO StudentSubject(RN,sID,Mark,Date ) values ('2',3,8,'2020-10-12');
-- INSERT INTO StudentSubject(RN,sID,Mark,Date ) values ('3',1,3,'2020-10-12');
-- INSERT INTO StudentSubject(RN,sID,Mark,Date ) values ('3',2,10,'2020-10-12');
-- INSERT INTO StudentSubject(RN,sID,Mark,Date ) values ('3',3,6,'2020-10-12');   

-- question b , cau a:,lay mon hoc khong co diem 
SELECT 
    subject.sID, sName
FROM
    subject
        LEFT JOIN
    studentsubject ON subject.sID = studentsubject.sID
WHERE
    RN IS NULL;
    
-- question b,cau b :lay danh sach cac mon hoc co it nhat 2 diem 

SELECT 
    subject.sID, sName, COUNT(sName) as numberOfMark
FROM
    subject
        LEFT JOIN
    studentsubject ON subject.sID = studentsubject.sID
    group by sName 
having count(sName) > 2 ;

 -- question c :tao view all thong tin 
-- CREATE VIEW StudentInfo as 
-- SELECT student.RN,subject.sID,Name, Age, sName, Mark, Date, CASE 
-- 		WHEN Gender = 'Nam' 
-- 			THEN "Male"
-- 		WHEN Gender = 'Nu' 
-- 			THEN "female"
--             	WHEN Gender IS NULL 
-- 			THEN "Unknow" 
--         END Gender    
-- from student
-- INNER join studentsubject on student.RN =  studentsubject.RN
-- INNER JOIN subject on subject.sID = studentsubject.sID ;

 SELECT * from StudentInfo ;

-- question d1 :tao trigger 

drop trigger if exists CasUpdate ;
DELIMITER $$
	create trigger CasUpdate 
    before update on subject 
    for each row 
    begin 
		update studentsubject 
        SET sID = new.sID
        Where sID = old.sID;
	end $$
DELIMITER ;

drop trigger if exists casDel ;
DELIMITER $$
	create trigger casDel 
    before DELETE on student 
    for each row 
    begin 
		delete FROM studentsubject WHERE RN=old.RN;
	end $$
DELIMITER ;

-- question e ,

DELIMITER $$ 
create procedure deleteStudent(in studentName varchar(225),in Mark INT(225) )
	begin 
		DELETE from student  WHERE Name =studentName;
        
	end $$
DELIMITER ;
set @namestring= 'nguyen van a';
set @email ='10';
call deleteStudent(@nameString , @email);