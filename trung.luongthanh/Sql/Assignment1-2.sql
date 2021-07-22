create database if not exists  assignment12;
use assignment12;
create table if not exists Department(
	DepartmentID INT auto_increment,
    DepartmentName varchar(50) not null,
    primary key(DepartmentID)
);
CREATE TABLE if not exists `Position`(
	PositionID	INT auto_increment primary key,
    PositionName	VARCHAR(50) not null
);
create table if not exists `Account`(
	AccountID int auto_increment primary key,
    Email VARCHAR(50) not null,
    Username varchar(50) not null,
    FullName varchar(50) not null,
    DepartmentID int not null,
    PositionID int not null,
    CreatDATE datetime default now(),
    FOREIGN KEY(DepartmentID) REFERENCES Department(DepartmentID),
    FOREIGN KEY(PositionID) REFERENCES `Position`(PositionID)
);
create table if not exists `Group`(
	GroupID int not null auto_increment,
    GroupName varchar(70) not null,
    CreatorID int not null,
    CreateDate datetime default now(),
    primary key(GroupID),
    foreign key (CreatorID) references `Account`(AccountID)
);
create table if not exists `GroupAccount`(
	GroupID int not null,
    AccountID varchar(50) not null,
    JoinDate datetime default now(),
    PRIMARY KEY (GroupID,AccountID)
);
create table if not exists `TypeQuestion`(
	TypeID int auto_increment primary key,
    TypeName varchar(50) not null
);
create table if not exists CategoryQuestion(
	CategoryID int auto_increment primary key,
    CategoryName varchar(50) not null
);
create table if not exists Question(
	QuestionID int auto_increment primary key,
    Content varchar(200) not null,
    CategoryID int not null,
    TypeID int not null,
    CreatorID int not null,
    CreateDate datetime default now(),
    FOREIGN KEY(CategoryID) 	REFERENCES CategoryQuestion(CategoryID),
    FOREIGN KEY(TypeID) 		REFERENCES TypeQuestion(TypeID),
    FOREIGN KEY(CreatorID) 		REFERENCES `Account`(AccountId)
);
create table if not exists Answer(
	AnswerID int auto_increment primary key,
    Content varchar(50) not null,
    QuestionID int not null,
    isCorrect boolean,
    FOREIGN KEY(QuestionID) REFERENCES Question(QuestionID)
);
create table if not exists Exam(
	ExamID int auto_increment primary key,
    `Code` char(10) not null,
    Title varchar(50) not null,
    CategoryID int not null,
    Duration int not null,
    CreatorID int not null,
    CreateDate datetime default now(),
    FOREIGN KEY(CategoryID) REFERENCES CategoryQuestion(CategoryID),
    FOREIGN KEY(CreatorID) 	REFERENCES `Account`(AccountId)
);
create table if not exists ExamQuestion(
	ExamID int not null,
    QuestionID int not null,
    FOREIGN KEY(QuestionID) REFERENCES Question(QuestionID),
    FOREIGN KEY(ExamID) REFERENCES Exam(ExamID),
    PRIMARY KEY (ExamID,QuestionID)
);

