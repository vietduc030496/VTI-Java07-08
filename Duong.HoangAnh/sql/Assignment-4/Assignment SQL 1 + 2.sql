drop database if exists Exam;
create database if not exists Exam;
use Exam;
create table if not exists `Department`(
	DepartmentID int not null auto_increment,
    DepartmentName varchar(100) not null,
    primary key(DepartmentID)
);
create table if not exists `Position`(
	PositionID int not null auto_increment,
    PositionName varchar(100) not null,
    primary key(PositionID)
);
create table if not exists `Account`(
	AccountID int not null auto_increment,
    Email varchar(45) not null,
    UserName varchar(45) not null,
    FullName varchar(45) not null,
    DepartmentID int not null,
    PositionID int not null,
    CreateDate timestamp,
    primary key(AccountID),
    foreign key (DepartmentID) references `Department`(DepartmentID),
    foreign key (PositionID) references `Position`(PositionID)
);
create table if not exists `Group`(
	GroupID int not null auto_increment,
    GroupName varchar(100) not null,
    CreatorID int not null,
    CreateDate timestamp,
    primary key(GroupID),
    foreign key (CreatorID) references `Account`(AccountID)
);

create table if not exists `GroupAccount`(
	GroupID int not null,
    AccountID int not null,
    JoinDate timestamp,
    foreign key (AccountID) references `Account`(AccountID),
    foreign key (GroupID) references `Group`(GroupID)
);

create table if not exists `TypeQuestion`(
	TypeID int not null auto_increment,
    TypeName varchar(100) not null,
    primary key(TypeID)
);

create table if not exists `CategoryQuestion`(
	CategoryID int not null auto_increment,
    CategoryName varchar(100) not null,
    primary key(CategoryID)
);

create table if not exists `Question`(
	QuestionID int not null auto_increment,
    Content varchar(100) not null,
    CategoryID int not null,
    TypeID int not null,
    CreatorID int not null,
    CreateDate timestamp,
    primary key(QuestionID),
    foreign key (CreatorID) references `Account`(AccountID),
    foreign key (TypeID) references `TypeQuestion`(TypeID),
    foreign key (CategoryID) references `CategoryQuestion`(CategoryID)
);

create table if not exists `Answer`(
	AnswerID int not null auto_increment,
    Content varchar(100) not null,
    QuestionID int not null,
    isCorrect boolean ,
    primary key(AnswerID),
    foreign key(QuestionID) references `Question`(QuestionID)
);

create table if not exists `Exam`(
	ExamID int not null auto_increment,
    Code_Exam varchar(100) not null,
    Title varchar(100) not null,
    CategoryID int not null,
    Duration time not null,
    CreatorID int not null,
    CreateDate timestamp,
    primary key(ExamID),
    foreign key (CreatorID) references `Account`(AccountID),
    foreign key(CategoryID) references `CategoryQuestion`(CategoryID)
);

create table if not exists `ExamQuestion`(
	ExamID int not null ,
    QuestionID int not null,
	foreign key(ExamID) references `Exam`(ExamID),
	foreign key(QuestionID) references `Question`(QuestionID)
);