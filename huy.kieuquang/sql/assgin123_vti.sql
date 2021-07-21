create database assign12;

use assign12;

drop table if exists department;
create table department(
	departmentID int auto_increment primary key,
    departmentName varchar(255)
);

drop table if exists positions;
create table positions(
	positionID int auto_increment primary key,
    positionName varchar(255)
);

drop table if exists accounts;
create table accounts(
	accountID int auto_increment primary key,
    email varchar(255),
    username varchar(255),
    fullname varchar(255),
    departmentID int,
    positionID int,
    createDate date,
    foreign key (departmentID) references department(departmentID),
    foreign key (positionID) references positions(positionID)
);

drop table if exists groupp;
create table groupp(
	groupID int auto_increment primary key,
    groupName varchar(255),
    creatorID int,
    createDate date	
);

drop table if exists groupAccount;
create table groupAccount(
	groupID int,
    accountID int,
    joinDate date,
    primary key (groupID, accountID)
);

drop table if exists typeQuestion;
create table typeQuestion(
	typeID int auto_increment primary key,
    typeName varchar(255)
);

drop table if exists categoryQuestion;
create table categoryQuestion(
	categoryID int auto_increment primary key,
    categoryName varchar(255)
);

drop table if exists question;
create table question(
	questionID int auto_increment primary key,
    content varchar(255),
    categoryID int,
    typeID int,
    creatorID int,
    createDate date,
    foreign key (categoryID) references categoryQuestion(categoryID),
    foreign key (typeID) references typeQuestion(typeID),
    foreign key (creatorID) references accounts(accountID)
);

drop table if exists answer;
create table answer(
	answerID int auto_increment primary key,
    content varchar(255),
    questionID int,
    isCorrect bit default 1,
    foreign key (questionID) references question(questionID)
);

drop table if exists exam;
create table exam(
	examID int auto_increment primary key,
    `code` varchar(255),
    title varchar(255),
    categoryID int,
    duration int,
    creatorID int,
    createDate date,
	foreign key (categoryID) references categoryQuestion(categoryID),
    foreign key (creatorID) references accounts(accountID)
);

drop table if exists examQuestion;
create table examQuestion(
	examID int,
    questionID int,
    foreign key (questionID) references question(questionID),
    foreign key (examID) references exam(examID),
    primary key (examID, questionID)
);

-- insert department
INSERT INTO `assign12`.`department` (`departmentName`) VALUES ('sale');
INSERT INTO `assign12`.`department` (`departmentName`) VALUES ('marketing');
INSERT INTO `assign12`.`department` (`departmentName`) VALUES ('hr');
INSERT INTO `assign12`.`department` (`departmentName`) VALUES ('it');
INSERT INTO `assign12`.`department` (`departmentName`) VALUES ('accounting');

-- insert position
INSERT INTO `assign12`.`positions` (`positionName`) VALUES ('dev');
INSERT INTO `assign12`.`positions` (`positionName`) VALUES ('test');
INSERT INTO `assign12`.`positions` (`positionName`) VALUES ('scrum master');
INSERT INTO `assign12`.`positions` (`positionName`) VALUES ('pm');

-- insert account
INSERT INTO `assign12`.`accounts` (`email`, `username`, `fullname`, `departmentID`, `positionID`, `createDate`) VALUES ('abc@gmail.com', 'acc1', 'tran duc hung', '1', '1', '2021-07-20');
INSERT INTO `assign12`.`accounts` (`email`, `username`, `fullname`, `departmentID`, `positionID`, `createDate`) VALUES ('abc@gmail.com', 'acc2', 'tran duc dung', '2', '2', '2021-07-20');
INSERT INTO `assign12`.`accounts` (`email`, `username`, `fullname`, `departmentID`, `positionID`, `createDate`) VALUES ('abc@gmail.com', 'acc3', 'tran duc huy', '3', '3', '2021-07-20');
INSERT INTO `assign12`.`accounts` (`email`, `username`, `fullname`, `departmentID`, `positionID`, `createDate`) VALUES ('abc@gmail.com', 'acc4', 'tran duc long', '4', '4', '2021-07-20');
INSERT INTO `assign12`.`accounts` (`email`, `username`, `fullname`, `departmentID`, `positionID`, `createDate`) VALUES ('abc@gmail.com', 'acc5', 'tran duc son', '5', '1', '2021-07-20');
INSERT INTO `assign12`.`accounts` (`email`, `username`, `fullname`, `departmentID`, `positionID`, `createDate`) VALUES ('abc@gmail.com', 'acc6', 'tran duc toan', '5', '2', '2021-07-20');
INSERT INTO `assign12`.`accounts` (`email`, `username`, `fullname`, `departmentID`, `positionID`, `createDate`) VALUES ('abc@gmail.com', 'acc7', 'Duong duc bo', '4', '3', '2021-07-20');
INSERT INTO `assign12`.`accounts` (`email`, `username`, `fullname`, `departmentID`, `positionID`, `createDate`) VALUES ('abc@gmail.com', 'acc8', 'tran duc tung', '3', '3', '2021-07-20');
INSERT INTO `assign12`.`accounts` (`email`, `username`, `fullname`, `departmentID`, `positionID`, `createDate`) VALUES ('abc@gmail.com', 'acc9', 'tran duc chi', '1', '2', '2021-07-20');
INSERT INTO `assign12`.`accounts` (`email`, `username`, `fullname`, `departmentID`, `positionID`, `createDate`) VALUES ('abc@gmail.com', 'acc10', 'tran duc nam', '1', '1', '2021-07-20');

-- insert group
INSERT INTO `assign12`.`groupp` (`groupName`, `creatorID`, `createDate`) VALUES ('gr1', '5', '2019-12-10');
INSERT INTO `assign12`.`groupp` (`groupName`, `creatorID`, `createDate`) VALUES ('gr2', '4', '2021-07-20');
INSERT INTO `assign12`.`groupp` (`groupName`, `creatorID`, `createDate`) VALUES ('gr3', '3', '2021-07-20');
INSERT INTO `assign12`.`groupp` (`groupName`, `creatorID`, `createDate`) VALUES ('gr4', '2', '2021-07-20');
INSERT INTO `assign12`.`groupp` (`groupName`, `creatorID`, `createDate`) VALUES ('gr5', '1', '2021-07-20');
INSERT INTO `assign12`.`groupp` (`groupName`, `creatorID`, `createDate`) VALUES ('gr6', '6', '2021-07-20');
INSERT INTO `assign12`.`groupp` (`groupName`, `creatorID`, `createDate`) VALUES ('gr7', '7', '2021-07-20');
INSERT INTO `assign12`.`groupp` (`groupName`, `creatorID`, `createDate`) VALUES ('gr8', '8', '2021-07-20');
INSERT INTO `assign12`.`groupp` (`groupName`, `creatorID`, `createDate`) VALUES ('gr9', '9', '2021-07-20');
INSERT INTO `assign12`.`groupp` (`groupName`, `creatorID`, `createDate`) VALUES ('gr10', '10', '2021-07-20');

-- insert groupAccount
INSERT INTO `assign12`.`groupaccount` (`groupID`, `accountID`, `joinDate`) VALUES ('1', '1', '2021-06-10');
INSERT INTO `assign12`.`groupaccount` (`groupID`, `accountID`, `joinDate`) VALUES ('2', '2', '2021-06-11');
INSERT INTO `assign12`.`groupaccount` (`groupID`, `accountID`, `joinDate`) VALUES ('3', '3', '2021-06-12');
INSERT INTO `assign12`.`groupaccount` (`groupID`, `accountID`, `joinDate`) VALUES ('4', '4', '2021-06-13');
INSERT INTO `assign12`.`groupaccount` (`groupID`, `accountID`, `joinDate`) VALUES ('1', '5', '2021-06-14');
INSERT INTO `assign12`.`groupaccount` (`groupID`, `accountID`, `joinDate`) VALUES ('2', '6', '2021-06-15');
INSERT INTO `assign12`.`groupaccount` (`groupID`, `accountID`, `joinDate`) VALUES ('3', '7', '2021-06-16');
INSERT INTO `assign12`.`groupaccount` (`groupID`, `accountID`, `joinDate`) VALUES ('5', '8', '2021-06-17');
INSERT INTO `assign12`.`groupaccount` (`groupID`, `accountID`, `joinDate`) VALUES ('6', '9', '2021-06-18');
INSERT INTO `assign12`.`groupaccount` (`groupID`, `accountID`, `joinDate`) VALUES ('7', '10', '2021-06-19');

-- insert typeQuestion
INSERT INTO `assign12`.`typequestion` (`typeName`) VALUES ('Essay');
INSERT INTO `assign12`.`typequestion` (`typeName`) VALUES ('Multiple-Choice');

-- insert categoryQuestion
INSERT INTO `assign12`.`categoryquestion` (`categoryName`) VALUES ('java');
INSERT INTO `assign12`.`categoryquestion` (`categoryName`) VALUES ('python');
INSERT INTO `assign12`.`categoryquestion` (`categoryName`) VALUES ('js');
INSERT INTO `assign12`.`categoryquestion` (`categoryName`) VALUES ('ruby');
INSERT INTO `assign12`.`categoryquestion` (`categoryName`) VALUES ('php');
INSERT INTO `assign12`.`categoryquestion` (`categoryName`) VALUES ('html');
INSERT INTO `assign12`.`categoryquestion` (`categoryName`) VALUES ('c++');
INSERT INTO `assign12`.`categoryquestion` (`categoryName`) VALUES ('assembly');
INSERT INTO `assign12`.`categoryquestion` (`categoryName`) VALUES ('c#');
INSERT INTO `assign12`.`categoryquestion` (`categoryName`) VALUES ('r');

-- insert Question
INSERT INTO `assign12`.`question` (`content`, `categoryID`, `typeID`, `creatorID`, `createDate`) VALUES ('aaaaaa', '1', '1', '1', '2021-05-10');
INSERT INTO `assign12`.`question` (`content`, `categoryID`, `typeID`, `creatorID`, `createDate`) VALUES ('cau hoi b', '2', '2', '2', '2021-05-11');
INSERT INTO `assign12`.`question` (`content`, `categoryID`, `typeID`, `creatorID`, `createDate`) VALUES ('adadad', '3', '2', '10', '2021-05-12');
INSERT INTO `assign12`.`question` (`content`, `categoryID`, `typeID`, `creatorID`, `createDate`) VALUES ('bbbb', '4', '2', '3', '2021-05-13');
INSERT INTO `assign12`.`question` (`content`, `categoryID`, `typeID`, `creatorID`, `createDate`) VALUES ('cccc', '5', '1', '4', '2021-05-14');
INSERT INTO `assign12`.`question` (`content`, `categoryID`, `typeID`, `creatorID`, `createDate`) VALUES ('dddd', '6', '1', '5', '2021-05-15');
INSERT INTO `assign12`.`question` (`content`, `categoryID`, `typeID`, `creatorID`, `createDate`) VALUES ('eeee', '7', '2', '6', '2021-05-16');
INSERT INTO `assign12`.`question` (`content`, `categoryID`, `typeID`, `creatorID`, `createDate`) VALUES ('fffff', '8', '1', '7', '2021-05-17');
INSERT INTO `assign12`.`question` (`content`, `categoryID`, `typeID`, `creatorID`, `createDate`) VALUES ('gggg', '9', '1', '8', '2021-05-18');
INSERT INTO `assign12`.`question` (`content`, `categoryID`, `typeID`, `creatorID`, `createDate`) VALUES ('hhhh', '10', '2', '9', '2021-05-19');

-- insert answer
INSERT INTO `assign12`.`answer` (`content`, `questionID`, `isCorrect`) VALUES ('a', '1', b'1');
INSERT INTO `assign12`.`answer` (`content`, `questionID`, `isCorrect`) VALUES ('b', '1', b'0');
INSERT INTO `assign12`.`answer` (`content`, `questionID`, `isCorrect`) VALUES ('c', '1', b'0');
INSERT INTO `assign12`.`answer` (`content`, `questionID`, `isCorrect`) VALUES ('d', '1', b'1');
INSERT INTO `assign12`.`answer` (`content`, `questionID`, `isCorrect`) VALUES ('e', '5', b'0');
INSERT INTO `assign12`.`answer` (`content`, `questionID`, `isCorrect`) VALUES ('f', '6', b'0');
INSERT INTO `assign12`.`answer` (`content`, `questionID`, `isCorrect`) VALUES ('g', '7', b'0');
INSERT INTO `assign12`.`answer` (`content`, `questionID`, `isCorrect`) VALUES ('h', '8', b'1');
INSERT INTO `assign12`.`answer` (`content`, `questionID`, `isCorrect`) VALUES ('i', '9', b'1');
INSERT INTO `assign12`.`answer` (`content`, `questionID`, `isCorrect`) VALUES ('k', '10', b'0');

-- insert exam
INSERT INTO `assign12`.`exam` (`code`, `title`, `categoryID`, `duration`, `creatorID`, `createDate`) VALUES ('c01', 'a', '1', '60', '1', '2019-12-10');
INSERT INTO `assign12`.`exam` (`code`, `title`, `categoryID`, `duration`, `creatorID`, `createDate`) VALUES ('c02', 'b', '2', '90', '2', '2019-12-25');
INSERT INTO `assign12`.`exam` (`code`, `title`, `categoryID`, `duration`, `creatorID`, `createDate`) VALUES ('c03', 'c', '3', '120', '3', '2019-12-25');
INSERT INTO `assign12`.`exam` (`code`, `title`, `categoryID`, `duration`, `creatorID`, `createDate`) VALUES ('c04', 'd', '4', '120', '4', '2019-12-25');
INSERT INTO `assign12`.`exam` (`code`, `title`, `categoryID`, `duration`, `creatorID`, `createDate`) VALUES ('c05', 'e', '5', '60', '5', '2019-12-25');
INSERT INTO `assign12`.`exam` (`code`, `title`, `categoryID`, `duration`, `creatorID`, `createDate`) VALUES ('c06', 'f', '6', '90', '6', '2019-12-25');
INSERT INTO `assign12`.`exam` (`code`, `title`, `categoryID`, `duration`, `creatorID`, `createDate`) VALUES ('c07', 'g', '7', '90', '7', '2019-12-20');
INSERT INTO `assign12`.`exam` (`code`, `title`, `categoryID`, `duration`, `creatorID`, `createDate`) VALUES ('c08', 'h', '8', '60', '8', '2019-12-21');
INSERT INTO `assign12`.`exam` (`code`, `title`, `categoryID`, `duration`, `creatorID`, `createDate`) VALUES ('c09', 'i', '9', '120', '9', '2019-12-22');
INSERT INTO `assign12`.`exam` (`code`, `title`, `categoryID`, `duration`, `creatorID`, `createDate`) VALUES ('c10', 'k', '10', '120', '10', '2019-12-25');

-- insert examQuestion
INSERT INTO `assign12`.`examquestion` (`examID`, `questionID`) VALUES ('6', '10');
INSERT INTO `assign12`.`examquestion` (`examID`, `questionID`) VALUES ('2', '9');
INSERT INTO `assign12`.`examquestion` (`examID`, `questionID`) VALUES ('3', '8');
INSERT INTO `assign12`.`examquestion` (`examID`, `questionID`) VALUES ('4', '9');
INSERT INTO `assign12`.`examquestion` (`examID`, `questionID`) VALUES ('5', '8');
INSERT INTO `assign12`.`examquestion` (`examID`, `questionID`) VALUES ('6', '1');
INSERT INTO `assign12`.`examquestion` (`examID`, `questionID`) VALUES ('7', '2');
INSERT INTO `assign12`.`examquestion` (`examID`, `questionID`) VALUES ('8', '3');
INSERT INTO `assign12`.`examquestion` (`examID`, `questionID`) VALUES ('9', '4');
INSERT INTO `assign12`.`examquestion` (`examID`, `questionID`) VALUES ('10', '5');

/*============================== query =======================================*/
-- q2
select * 
from department ;

-- q3
select DepartmentID 
from department 
where DepartmentName ='sale';

-- q4
select * 
from accounts 
order by length(Fullname) desc;

-- q5
select * 
from accounts
where DepartmentID = 3
order by length(Fullname) desc;

-- q6
select g.groupName
from groupp g
where CreateDate <'2019-12-20';

-- q7
select a.questionID, count(questionID) 
from answer a
group by QuestionID
having count(QuestionID)>=4;

-- q8
select *
from  exam e
where cast(e.createDate as date) < '2019-12-20';

-- q9
select  * 
from groupp 
order by CreateDate DESC 
limit 5;

-- q10
select count(a.departmentID) as SoNhanVien
from accounts a
where a.departmentID = 2
group by a.departmentID;

-- q11
select * 
from accounts a
where a.fullname like 'D%o';

-- q12
set sql_safe_updates = 0;
delete from exam e
where cast(e.createDate as date) < '2019-12-20';
set sql_safe_updates = 1;

-- q13
set sql_safe_updates = 0;
delete from question q
where q.content like 'cau hoi%';
set sql_safe_updates = 1;

-- q14
update accounts a
set Fullname ='Nguyen Ba Loc ',Email ='loc.nguyenba@vti.com.vn'
where a.accountID = 5;

-- q15
set sql_safe_updates = 0;
update groupaccount
set groupID = 4
where accountID = 5;
set sql_safe_updates = 1;