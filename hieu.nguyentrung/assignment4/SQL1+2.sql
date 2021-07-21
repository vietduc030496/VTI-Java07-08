create schema `internshipVTI`;

create table department (
	departmentID int primary key auto_increment,
    departmentName varchar(100));

create table `position` (
	positionID int primary key auto_increment,
    positionName varchar(100));

create table `account` (
	accountID int primary key auto_increment,
    email varchar(100),
    username varchar(100),
    fullname varchar(100),
    departmentID int,
    positionID int,
	createDate date);

create table `group` (
	groupID int primary key auto_increment,
    groupName varchar(100),
    creatorID int,
    createDate date);

create table groupaccount (
	groupID int,
    accountID int,
    joinDate date);
    
create table typequestion(
	typeID int primary key auto_increment,
    typeName varchar(100));

create table categoryquestion(
	categoryID int primary key auto_increment,
    categoryName varchar(100));

create table question(
	questionID int primary key auto_increment,
    content varchar(100),
    categoryID int,
    typeID int,
    creatorID int,
    createDate date);

create table answer(
	answerID int primary key auto_increment,
    content varchar(100),
    questionID int,
    isCorrect boolean);

create table exam(
	examID int primary key auto_increment,
    `code` int,
    title varchar(100),
    categoryID int,
    duration float,
    creatorID int,
    createDate date);

create table examquestion(
	examID int,
    questionID int);

alter table `account` add foreign key (departmentID) references department(departmentID) on delete cascade;
alter table `account` add foreign key (positionID) references `position`(positionID)on delete cascade;
alter table groupaccount add foreign key (groupID) references `group`(groupID) on delete cascade ;
alter table groupaccount add foreign key (accountID) references `account`(accountID) on delete cascade;
alter table question add foreign key (categoryID) references categoryquestion(categoryID) on delete cascade;
alter table question add foreign key (typeID) references typequestion(typeID) on delete cascade;
alter table answer add foreign key (questionID) references question(questionID) on delete cascade;
alter table  exam add foreign key (categoryID) references categoryquestion(categoryID) on delete cascade;
alter table examquestion add foreign key (examID) references exam(examID) on delete cascade;
alter table examquestion add foreign key (questionID) references question(questionID) on delete cascade;