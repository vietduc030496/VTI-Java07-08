create database if not exists  company;
use company ;

create table if not exists  department(
	DepartmentID int auto_increment primary key ,
    DepartmentName varchar (255) 
);

create table if not exists Position (
	PositionID int auto_increment primary key ,
    PositionName varchar(225)  
);
create table if not exists account(
	AccountID int auto_increment primary key ,
    Email varchar(225),
    Username varchar(225),
    Fullname varchar(225),
    DepartmentID int,
    foreign key (DepartmentID) references Department(DepartmentID),
    PositionID int ,
    foreign  key (PositionID) references Position (PositionID),
    CreateDate date
    
) ;

create table if not exists group_table   (
	GroupID int auto_increment primary key ,
    GroupName varchar(255) ,
    CreatorID int,
    foreign key (CreatorID) references account(AccountID),
    CreateDate date 
    
);
create table if not exists GroupAccount(
	GroupID int auto_increment primary key,
    AccountID int,
    foreign key (AccountID)  references account(AccountID),
    JoinDate date
);
create table if not exists TypeQuestion(
	TypeID int auto_increment primary key,
    TypeName varchar(225)
);

create table if not exists CategoryQuestion(
	CategoryID int auto_increment primary key,
    CategoryName varchar(225) 
);
create table if not exists Question(
	QuestionID int auto_increment primary key,
    Content varchar(225),
    CategoryID int,
    foreign key (CategoryID) references CategoryQuestion(CategoryID),
    TypeID int ,
    foreign key (TypeID) references TypeQuestion(TypeID),
    CreatorID int ,
    foreign key (CreatorID) references account(AccountID),
    CreateDate date
    
);
create table if not exists Answer(
	 AnswerID int auto_increment primary key ,
     Content varchar(225),
     QuestionID int,
     foreign key (QuestionID) references Question(QuestionID),
     isCorrect boolean
);
create table if not exists Exam(
	ExamID int auto_increment primary key,
    Code int(10) ,
    Title varchar (225),
    CategoryID int,
    foreign key (categoryID) references CategoryQuestion(CategoryID),
    Duration int(10),
    CreatorID int,
    foreign key (CreatorID) references account(AccountID),
    CreateDate date
    
);
create table if not exists ExamQuestion(
	ExamID int ,
    foreign key (ExamID) references Exam(ExamID),
    QuestionID int ,
    foreign key(QuestionID) references Question(QuestionID)
);









