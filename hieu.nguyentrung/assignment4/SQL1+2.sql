CREATE SCHEMA `INTERNSHIPVTI`;

CREATE TABLE DEPARTMENT (
	DEPARTMENTID INT PRIMARY KEY AUTO_INCREMENT,
    DEPARTMENTNAME VARCHAR(100));

CREATE TABLE `POSITION` (
	POSITIONID INT PRIMARY KEY AUTO_INCREMENT,
    POSITIONNAME VARCHAR(100));

CREATE TABLE `ACCOUNT` (
	ACCOUNTID INT PRIMARY KEY AUTO_INCREMENT,
    EMAIL VARCHAR(100),
    USERNAME VARCHAR(100),
    FULLNAME VARCHAR(100),
    DEPARTMENTID INT,
    POSITIONID INT,
	CREATEDATE DATE);

CREATE TABLE `GROUP` (
	GROUPID INT PRIMARY KEY AUTO_INCREMENT,
    GROUPNAME VARCHAR(100),
    CREATORID INT,
    CREATEDATE DATE);

CREATE TABLE GROUPACCOUNT (
	GROUPID INT,
    ACCOUNTID INT,
    JOINDATE DATE);
    
CREATE TABLE TYPEQUESTION(
	TYPEID INT PRIMARY KEY AUTO_INCREMENT,
    TYPENAME VARCHAR(100));

CREATE TABLE CATEGORYQUESTION(
	CATEGORYID INT PRIMARY KEY AUTO_INCREMENT,
    CATEGORYNAME VARCHAR(100));

CREATE TABLE QUESTION(
	QUESTIONID INT PRIMARY KEY AUTO_INCREMENT,
    CONTENT VARCHAR(100),
    CATEGORYID INT,
    TYPEID INT,
    CREATORID INT,
    CREATEDATE DATE);

CREATE TABLE ANSWER(
	ANSWERID INT PRIMARY KEY AUTO_INCREMENT,
    CONTENT VARCHAR(100),
    QUESTIONID INT,
    ISCORRECT BOOLEAN);

CREATE TABLE EXAM(
	EXAMID INT PRIMARY KEY AUTO_INCREMENT,
    `CODE` INT,
    TITLE VARCHAR(100),
    CATEGORYID INT,
    DURATION FLOAT,
    CREATORID INT,
    CREATEDATE DATE);

CREATE TABLE EXAMQUESTION(
	EXAMID INT,
    QUESTIONID INT);

ALTER TABLE `ACCOUNT` ADD FOREIGN KEY (DEPARTMENTID) REFERENCES DEPARTMENT(DEPARTMENTID) ON DELETE CASCADE;
ALTER TABLE `ACCOUNT` ADD FOREIGN KEY (POSITIONID) REFERENCES `POSITION`(POSITIONID)ON DELETE CASCADE;
ALTER TABLE GROUPACCOUNT ADD FOREIGN KEY (GROUPID) REFERENCES `GROUP`(GROUPID) ON DELETE CASCADE ;
ALTER TABLE GROUPACCOUNT ADD FOREIGN KEY (ACCOUNTID) REFERENCES `ACCOUNT`(ACCOUNTID) ON DELETE CASCADE;
ALTER TABLE QUESTION ADD FOREIGN KEY (CATEGORYID) REFERENCES CATEGORYQUESTION(CATEGORYID) ON DELETE CASCADE;
ALTER TABLE QUESTION ADD FOREIGN KEY (TYPEID) REFERENCES TYPEQUESTION(TYPEID) ON DELETE CASCADE;
ALTER TABLE ANSWER ADD FOREIGN KEY (QUESTIONID) REFERENCES QUESTION(QUESTIONID) ON DELETE CASCADE;
ALTER TABLE  EXAM ADD FOREIGN KEY (CATEGORYID) REFERENCES CATEGORYQUESTION(CATEGORYID) ON DELETE CASCADE;
ALTER TABLE EXAMQUESTION ADD FOREIGN KEY (EXAMID) REFERENCES EXAM(EXAMID) ON DELETE CASCADE;
ALTER TABLE EXAMQUESTION ADD FOREIGN KEY (QUESTIONID) REFERENCES QUESTION(QUESTIONID) ON DELETE CASCADE;