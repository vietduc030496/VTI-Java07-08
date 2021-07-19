create table department(
	departmentID int primary key auto_increment,
	departmentName varchar(25));
    
create table  `position`(
	positionID int primary key auto_increment,
	positionName varchar(25));
    
create table  `account` (
	accountID int primary key auto_increment,
	email varchar(25),
    username varchar(25),
    fullname varchar(25),
    positionID int,
    createDate date);
    
create table  `group` (
	groupID int primary key auto_increment,
    groupname varchar(25),
    creatorID int,
    createDate date);
    
create table  groupaccount (
	groupID int primary key auto_increment,
    AccountID int,
    johnDate date);

create table typequestion(
	typeID int primary key auto_increment,
	typeName varchar(25));
    
create table categoryquestion (
	categoryID int primary key auto_increment,
	categoryName varchar(25));
    
create table  question (
	questionID int primary key auto_increment,
	content varchar(25),
    categoryID int,
    typeID int,
    creatorID int,
    createDate date);
    
create table  answer (
	answerID int primary key auto_increment,
    content varchar(25),
    questionID int,
    isCorrect boolean);
    
create table  exam (
	examID int primary key auto_increment,
    `code` int,
    title varchar(25),
     categoryID int,
     duration float,
     creatorID int,
     createDate date
     );