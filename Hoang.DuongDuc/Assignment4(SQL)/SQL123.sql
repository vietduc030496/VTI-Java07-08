create table `department`(
	`DepartmentID` int not null auto_increment,
	`DepartmentName` varchar(50) not null,
    primary key (`DepartmentID`)
    );
create table `position`(
	`PositionID` int not null auto_increment,
	`PositionName` varchar(25) not null,
    primary key (`PositionID`)
    );
create table `account`(
	`AccountID` int not null auto_increment,
	`Email` varchar(50) not null,
    `Username` varchar(50) not null,
    `FullName` varchar(50) not null,
    `DepartmentID` int not null,
    `PositionID` int not null,
    `CreateDate` date not null,
    primary key (`AccountID`)
    );
create table `group`(
	`GroupID` int not null auto_increment,
	`GroupName` varchar(50) not null,
    `CreatorID` int not null,
    `CreateDate` date not null, 
    primary key (`GroupID`)
    );
create table `groupaccount`(
	`GroupID` int not null,
	`JoinDate` date not null,
    `AccountID` int not null,
    constraint `GAunique` unique (`GroupID` ,`AccountID`)
);
create table `typequestion`(
	`TypeID` int not null auto_increment,
	`TypeName` varchar(25) not null,
    primary key (`TypeID`)
    );
create table `categoryquestion`(
	`CategoryID` int not null auto_increment,
	`CategoryName` varchar(25) not null,
    primary key (`CategoryID`)
    );
create table `question`(
	`QuestionID` int not null auto_increment,
	`Content` varchar(25) not null,
    `CategoryID` int not null,
	`TypeID` int not null,
    `CreatorID` int not null,
    `CreateDate` date not null,
    primary key (`QuestionID`)
    );
create table `anwser`(
	`AnswerID` int not null auto_increment,
	`Content` varchar(50) not null,
    `QuestionID` int not null,
    `isCorrect` boolean not null,
    primary key (`AnswerID`)
);
create table `exam`(
	`ExamID` int not null auto_increment,
	`Code` varchar(15) not null,
    `Title` varchar(50) not null,
    `Duration` double not null,
    `CategoryID` int not null,
    `CreatorID` int not null,
    `CreateDate` date not null,
    primary key (`ExamID`)
    );
create table `examquestion`(
	`ExamID` int not null,
    `QuestionID` int not null,
    constraint `EQunique` unique (`ExamID` ,`QuestionID`)
);
alter table `account` add constraint `fk_account1` foreign key (DepartmentID) REFERENCES `department`(DepartmentID) on delete cascade on update cascade;
alter table `account` add constraint `fk_account2` foreign key (PositionID) REFERENCES `position`(PositionID) on delete cascade on update cascade;
alter table `group` add constraint `fk_group` foreign key (CreatorID) REFERENCES `account`(AccountID) on delete cascade on update cascade;
alter table `groupaccount` add constraint `fk_groupaccount1` foreign key (GroupID) REFERENCES `group`(GroupID) on delete cascade on update cascade;
alter table `groupaccount` add constraint `fk_groupaccount2` foreign key (AccountID) REFERENCES `account`(AccountID) on delete cascade on update cascade;
alter table `question` add constraint `fk_question1` foreign key (CategoryID) REFERENCES `categoryquestion`(CategoryID) on delete cascade on update cascade;
alter table `question` add constraint `fk_question2` foreign key (TypeID) REFERENCES `typequestion`(TypeID) on delete cascade on update cascade;
alter table `question` add constraint `fk_question3` foreign key (CreatorID) REFERENCES `account`(AccountID) on delete cascade on update cascade;
alter table `anwser` add constraint `fk_anwser` foreign key (QuestionID) REFERENCES `question`(QuestionID) on delete cascade on update cascade;
alter table `exam` add constraint `fk_exam1` foreign key (CategoryID) REFERENCES `categoryquestion`(CategoryID) on delete cascade on update cascade;
alter table `exam` add constraint `fk_exam2` foreign key (CreatorID) REFERENCES `account`(AccountID) on delete cascade on update cascade;
alter table `examquestion` add constraint `fk_examquestion1` foreign key (ExamID) REFERENCES `exam`(ExamID) on delete cascade on update cascade;
alter table `examquestion` add constraint `fk_examquestion2` foreign key (QuestionID) REFERENCES `question`(QuestionID) on delete cascade on update cascade;

/*Question 1*/
insert into department(DepartmentName) values("Sale");
insert into department(DepartmentName) values("Marketing");
insert into department(DepartmentName) values("Accounting");
insert into department(DepartmentName) values("Human Resources");
insert into department(DepartmentName) values("Administration");
insert into `position`(PositionName) values("Dev");
insert into `position`(PositionName) values("Test");
insert into `position`(PositionName) values("PM");
insert into `position`(PositionName) values("BA");
insert into `position`(PositionName) values("HR");
insert into `account`(Email,Username,FullName,DepartmentID,PositionID,CreateDate) values("ac1@gmail.com", "ac1","a c van 1",5,3,"2021-07-13");
insert into `account`(Email,Username,FullName,DepartmentID,PositionID,CreateDate) values("ac2@gmail.com", "ac2","a c van 12",4,2,"2021-07-14");
insert into `account`(Email,Username,FullName,DepartmentID,PositionID,CreateDate) values("ac3@gmail.com", "ac3","a c van 123",3,1,"2021-07-15");
insert into `account`(Email,Username,FullName,DepartmentID,PositionID,CreateDate) values("ac4@gmail.com", "ac4","a c van 1234",2,5,"2021-07-16");
insert into `account`(Email,Username,FullName,DepartmentID,PositionID,CreateDate) values("ac5@gmail.com", "ac5","a c van 12345",1,4,"2021-07-17");
insert into `account`(Email,Username,FullName,DepartmentID,PositionID,CreateDate) values("ac6@gmail.com", "ac6","D c van 123456 o",2,3,"2021-07-18");
insert into `account`(Email,Username,FullName,DepartmentID,PositionID,CreateDate) values("ac7@gmail.com", "ac7","a c van 123daihon",3,5,"2021-07-19");
insert into `group`(GroupName,CreatorID,CreateDate) values("gr1", 4,"2021-08-24");
insert into `group`(GroupName,CreatorID,CreateDate) values("gr2", 1,"2018-08-25");
insert into `group`(GroupName,CreatorID,CreateDate) values("gr3", 2,"2021-08-23");
insert into `group`(GroupName,CreatorID,CreateDate) values("gr4", 5,"2021-08-26");
insert into `group`(GroupName,CreatorID,CreateDate) values("gr5", 3,"2021-07-27");
insert into `group`(GroupName,CreatorID,CreateDate) values("gr6", 4,"2021-08-24");
insert into groupaccount(GroupID,AccountID,JoinDate) values(5, 3,"2021-09-04");
insert into groupaccount(GroupID,AccountID,JoinDate) values(3, 2,"2021-09-05");
insert into groupaccount(GroupID,AccountID,JoinDate) values(1, 1,"2021-09-06");
insert into groupaccount(GroupID,AccountID,JoinDate) values(4, 4,"2021-09-07");
insert into groupaccount(GroupID,AccountID,JoinDate) values(2, 5,"2021-09-08");
insert into typequestion(TypeName) values("Trắc nghiệm tô");
insert into typequestion(TypeName) values("Trắc nghiệm khoanh");
insert into typequestion(TypeName) values("Trắc nghiệm điền");
insert into typequestion(TypeName) values("Tự luận");
insert into typequestion(TypeName) values("Trắc nghiệm giải thích");
insert into categoryquestion(CategoryName) values("Java");
insert into categoryquestion(CategoryName) values("DotNet");
insert into categoryquestion(CategoryName) values("SQL");
insert into categoryquestion(CategoryName) values("PHP");
insert into categoryquestion(CategoryName) values("HTML/CSS");
insert into question(Content,CategoryID,TypeID,CreatorID,CreateDate) values("content 1", 3, 5, 3,"2021-06-20");
insert into question(Content,CategoryID,TypeID,CreatorID,CreateDate) values("câu hỏi content 2", 2, 4, 1,"2021-06-22");
insert into question(Content,CategoryID,TypeID,CreatorID,CreateDate) values("content 3", 1, 3, 3,"2021-06-24");
insert into question(Content,CategoryID,TypeID,CreatorID,CreateDate) values("content 4", 5, 2, 4,"2021-06-26");
insert into question(Content,CategoryID,TypeID,CreatorID,CreateDate) values("content 5", 4, 1, 2,"2021-06-28");
insert into anwser(Content,QuestionID,isCorrect) values("Content A1", 3, true);
insert into anwser(Content,QuestionID,isCorrect) values("Content A11", 3, false);
insert into anwser(Content,QuestionID,isCorrect) values("Content A12", 3, false);
insert into anwser(Content,QuestionID,isCorrect) values("Content A13", 3, true);
insert into anwser(Content,QuestionID,isCorrect) values("Content A2", 4, false);
insert into anwser(Content,QuestionID,isCorrect) values("Content A3", 5, false);
insert into anwser(Content,QuestionID,isCorrect) values("Content A4", 1, true);
insert into anwser(Content,QuestionID,isCorrect) values("Content A5", 2, true);
insert into exam(`Code`,Title,CategoryID,Duration,CreatorID,CreateDate) values("MD01", "Kiểm tra 1", 2, 90, 3,"2019-09-01");
insert into exam(`Code`,Title,CategoryID,Duration,CreatorID,CreateDate) values("MD02", "Kiểm tra 2", 3, 60, 4,"2019-09-03");
insert into exam(`Code`,Title,CategoryID,Duration,CreatorID,CreateDate) values("MD03", "Kiểm tra 3", 4, 50, 5,"2021-09-04");
insert into exam(`Code`,Title,CategoryID,Duration,CreatorID,CreateDate) values("MD04", "Kiểm tra 4", 5, 30, 1,"2019-09-20");
insert into exam(`Code`,Title,CategoryID,Duration,CreatorID,CreateDate) values("MD05", "Kiểm tra 5", 1, 90, 2,"2021-09-06");
insert into examquestion(ExamID,QuestionID) values(1, 3);
insert into examquestion(ExamID,QuestionID) values(3, 5);
insert into examquestion(ExamID,QuestionID) values(2, 4);
insert into examquestion(ExamID,QuestionID) values(5, 1);
insert into examquestion(ExamID,QuestionID) values(4, 2);

/*Question 2*/
select *
from department;

/*Question 3*/
select DepartmentID
from department 
where DepartmentName = "Sale";

/*Question 4*/
select * 
from  `account` 
order by length(FullName) desc ;

/*Question 5*/
select * 
from  `account`
where `account`.DepartmentID = 3
order by length(FullName) desc limit 1;

/*Question 6*/
select GroupName
from `group`
where CreateDate < "2019-12-20";

/*Question 7*/
select QuestionID 
from `anwser`
group by QuestionID
having COUNT(QuestionID) >= 4;

/*Question 8*/
select `Code`
from `exam`
where CreateDate < "2019-12-20" and Duration >= 60;

/*Question 9*/
select * 
from  `group` 
order by CreateDate desc limit 5;

/*Question 10*/
select count(AccountID) as "Tong so nhan vien"
from `account`
where `account`.DepartmentID = 2;

/*Question 11*/
select *
from `account`
where FullName like 'D%o';

/*Question 12*/
delete 
from exam 
where CreateDate < "20/12/2019";

/*Question 13*/
delete 
from question 
where Content like 'câu hỏi%';

/*Question 14*/
update `account`
set FullName = 'Nguyễn Bá Lộc' and Email ='loc.nguyenba@vti.com.vn'
where AccountID = 5;

/*Question 15*/
update `groupaccount`
set GroupID = 4 
where AccountID = 5;