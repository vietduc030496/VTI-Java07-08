create database  company;
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

