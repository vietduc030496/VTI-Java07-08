create database exam;
use exam;
create table if not exists tblDepartment(
	DepartmentID int not null auto_increment,
    DepartmentName varchar(45) not null,
    primary key (DepartmentID)
);

create table if not exists tblPosition(
	PositionID int not null auto_increment,
    PositionName varchar(45) not null,
    primary key (PositionID)
);

create table if not exists tblAccount(
	AccountID int not null auto_increment,
    Email varchar(45) not null,
    Username varchar(45) not null,
    FullName varchar(45) not null,
    DepartmentID int not null,
    PositionID int not null,
    CreateDate date not null,
    primary key (AccountID),
    foreign key (DepartmentID) references tblDepartment(DepartmentID),
    foreign key (PositionID) references tblPosition(PositionID)
);

create table if not exists tblGroup(
	GroupID int not null auto_increment,
    GroupName varchar(45) not null,
    CreatorID int not null,
    CreateDate date not null,
    primary key (GroupID)
);

create table if not exists tblGroupAccount(
	GroupID int not null auto_increment,
    AccountID varchar(45) not null,
    JoinDate date not null,
    primary key (GroupID,AccountID)
);    

create table if not exists tblTypeQuestion(
	TypeID int not null auto_increment,
    TypeName varchar(45) not null,
    primary key (TypeID)
);

create table if not exists tblCategoryQuestion(
	CategoryID int not null auto_increment,
    CategoryName varchar(45) not null,
    primary key (CategoryID)
);

create table if not exists tblQuestion(
	QuestionID int not null auto_increment,
    Content varchar(45) not null,
    CategoryID int not null,
	TypeID int not null,
    CreatorID int not null,
    CreateDate date not null,
    primary key (QuestionID),
    foreign key (CategoryID) references tblCategoryQuestion(CategoryID),
    foreign key (TypeID) references tblTypeQuestion(TypeID)
);

create table if not exists tblAnswer(
	AnswerID int not null auto_increment,
    Content varchar(45) not null,
    QuestionID int not null,
    isCorrect boolean not null,
    primary key (AnswerID),
    foreign key (QuestionID) references tblQuestion(QuestionID)
);

create table if not exists tblExam(
	ExamID int not null auto_increment,
    ExamCode varchar(45) not null,
    Title varchar(45) not null,
    CategoryID int not null,
    Duration int not null,
    CreatorID int not null,
    CreateDate datetime not null,
    primary key (ExamID),
    foreign key (CategoryID) references tblCategoryQuestion(CategoryID)
);

create table if not exists tblExamQuestion(
	ExamID int not null,
    QuestionID int not null,
    primary key (ExamID,QuestionID)
);   

