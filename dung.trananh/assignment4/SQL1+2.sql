create schema `vti`;

create table department (
	departmentID int primary key auto_increment,
    departmentName varchar(50));

create table `position` (
	positionID int primary key auto_increment,
    positionName varchar(50));

create table `account` (
	accountID int primary key auto_increment,
    email varchar(50),
    username varchar(50),
    fullname varchar(50),
    departmentID int,
    positionID int,
	createDate date);

create table `group` (
	groupID int primary key auto_increment,
    groupName varchar(50),
    creatorID int,
    createDate date);

create table groupaccount (
	groupID int,
    accountID int,
    joinDate date);
    
create table typequestion(
	typeID int primary key auto_increment,
    typeName varchar(50));

create table categoryquestion(
	categoryID int primary key auto_increment,
    categoryName varchar(50));

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
    title varchar(50),
    categoryID int,
    duration float,
    creatorID int,
    createDate date);

create table examquestion(
	examID int,
    questionID int);
    
alter table `account` add foreign key (departmentID) references department(departmentID);
alter table `account` add foreign key (positionID) references `position`(positionID);
alter table groupaccount add foreign key (groupID) references `group`(groupID) ;
alter table groupaccount add foreign key (accountID) references `account`(accountID);
alter table question add foreign key (categoryID) references categoryquestion(categoryID);
alter table question add foreign key (typeID) references typequestion(typeID);
alter table answer add foreign key (questionID) references question(questionID);
alter table  exam add foreign key (categoryID) references categoryquestion(categoryID);
alter table examquestion add foreign key (examID) references exam(examID);
alter table examquestion add foreign key (questionID) references question(questionID);
alter table question add foreign key (creatorID) references `account`(accountID);