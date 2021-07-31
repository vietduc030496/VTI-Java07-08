create database jdbcvti;
use jdbcvti;

create table tbl_lop(
id bigint auto_increment primary key,
name varchar(255),
year varchar(255)
);

create table tbl_student(
id bigint auto_increment primary key,
name varchar(255),
first_name varchar(255),
gender varchar(255),
dob datetime,
address varchar(255),
phone varchar(255),
email varchar(255),
lop_id bigint,
foreign key (lop_id) references tbl_lop(id)
);

create table tbl_subject(
id bigint auto_increment primary key,
name varchar(255),
number integer
);

create table tbl_subject_score(
student_id bigint,
subject_id bigint,
score float,
foreign key (student_id) references tbl_student(id),
foreign key (subject_id) references tbl_subject(id)
);

insert into tbl_lop(name,year) values ("cn1","2017-2018");
insert into tbl_lop(name,year) values ("cn2","2018-2019");
insert into tbl_lop(name,year) values ("cn3","2019-2020");
insert into tbl_lop(name,year) values ("cn4","2020-2021");
insert into tbl_lop(name,year) values ("cn5","2021-2022");

insert into tbl_student(name,first_name,gender,dob,address,phone,email,lop_id) 
values ("Đạt","Trần Hữu","MALE","1999-07-19 06:41:46","Bắc Ninh","0123456789","dat@gmail.com",1);
insert into tbl_student(name,first_name,gender,dob,address,phone,email,lop_id) 
values ("Tuấn","Phạm Văn","MALE","200-07-15 06:41:46","Nam định","0147852369","tuan@gmail.com",2);
insert into tbl_student(name,first_name,gender,dob,address,phone,email,lop_id) 
values ("a","nguyen thi","FEMALE","2001-07-19 06:41:46","hn","012347895","a@gmail.com",3);
insert into tbl_student(name,first_name,gender,dob,address,phone,email,lop_id) 
values ("b","tran thi","FEMALE","2002-07-19 06:41:46","hanam","012346547","b@gmail.com",4);
insert into tbl_student(name,first_name,gender,dob,address,phone,email,lop_id) 
values ("c","nguyen van","MALE","2003-07-19 06:41:46","ac","0123856789","c@gmail.com",5);

insert into tbl_subject(name,number) values ("toan",3);
insert into tbl_subject(name,number) values ("van",2);
insert into tbl_subject(name,number) values ("anh",3);
insert into tbl_subject(name,number) values ("hoa",3);
insert into tbl_subject(name,number) values ("sinh",3);

insert into tbl_subject_score(student_id,subject_id,score) values (1,1,8);
insert into tbl_subject_score(student_id,subject_id,score) values (2,2,9);
insert into tbl_subject_score(student_id,subject_id,score) values (3,3,10);
insert into tbl_subject_score(student_id,subject_id,score) values (4,4,7);
insert into tbl_subject_score(student_id,subject_id,score) values (5,5,8);

SET GLOBAL log_bin_trust_function_creators = 1;

DROP procedure IF EXISTS `get_student_top5_score_subject`;

DELIMITER $$
USE `jdbcvti`$$
CREATE PROCEDURE `get_student_top5_score_subject` (in subject_id bigint)
BEGIN
	select  distinct s.id,s.name,s.first_name,s.gender,s.dob,s.address,s.phone,s.email,s.lop_id
    from tbl_student s inner join tbl_subject_score ss on ss.student_id = s.id
    inner join (	Select distinct a.score,a.subject_id  from tbl_subject_score a 
    where a.subject_id = subject_id order by a.score desc limit 5) s1 on (s1.subject_id = ss.subject_id and s1.score = ss.score);
END$$

DELIMITER ;

USE `jdbcvti`;
DROP procedure IF EXISTS `get_arv_score`;

DELIMITER $$
USE `jdbcvti`$$
CREATE PROCEDURE `get_arv_score` (in student_id bigint)
BEGIN
    select avg(ss.score) as score,ss.student_id,ss.subject_id from tbl_subject_score ss where ss.student_id=student_id ;
END$$

DELIMITER ;


USE `jdbcvti`;
DROP function IF EXISTS `get_totals`;

USE `jdbcvti`;
DROP function IF EXISTS `jdbcvti`.`get_totals`;
;

DELIMITER $$
USE `jdbcvti`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `get_totals`(student_id bigint) RETURNS int
BEGIN
		DECLARE  totals INTEGER;
	    select sum(s.number) INTO totals  from tbl_subject_score ss 
        inner join tbl_subject s on s.id = ss.subject_id where ss.student_id = student_id;
RETURN (totals); 
END$$

