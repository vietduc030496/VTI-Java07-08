CREATE TABLE `Department` (
	DepartmentID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    DepartmentName VARCHAR(50) NOT NULL
    );

CREATE TABLE `Position` (
	PositionID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    PositionName VARCHAR(50) NOT NULL
    );

CREATE TABLE `Account` (
	AccountID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    Email VARCHAR(50) NOT NULL,
    UserName VARCHAR(50) NOT NULL,
    FullName VARCHAR(50) NOT NULL,
    DepartmentID INT NOT NULL,
    PositionID INT NOT NULL,
	CreateDate DATE NOT NULL,
    FOREIGN KEY (DepartmentID) REFERENCES `Department`(DepartmentID),
	FOREIGN KEY (PositionID) REFERENCES `Position`(PositionID)
    );

CREATE TABLE `Group` (
	GroupID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    GroupName VARCHAR(50) NOT NULL,
    CreatorID INT NOT NULL,
    CreateDate DATE NOT NULL
    );

CREATE TABLE `GroupAccount` (
	GroupID INT NOT NULL,
    AccountID INT NOT NULL,
    JoinDate DATE NOT NULL,
    FOREIGN KEY (GroupID) REFERENCES `Group`(GroupID),
    FOREIGN KEY (AccountID) REFERENCES `Account`(AccountID)
    );
    
CREATE TABLE `TypeQuestion`(
	TypeID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    TypeName VARCHAR(50) NOT NULL
    );

CREATE TABLE `CategoryQuestion`(
	CategoryID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    CategoryName VARCHAR(50) NOT NULL
    );

CREATE TABLE `Question`(
	QuestionID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    Content VARCHAR(100) NOT NULL,
    CategoryID INT NOT NULL,
    TypeID INT NOT NULL,
    CreatorID INT NOT NULL,
    CreateDate DATE NOT NULL,
    FOREIGN KEY (CategoryID) REFERENCES `CategoryQuestion`(CategoryID),
    FOREIGN KEY (TypeID) REFERENCES `TypeQuestion`(TypeID)
    );

CREATE TABLE `Answer`(
	AnswerID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    Content VARCHAR(100) NOT NULL,
    QuestionID INT NOT NULL,
    isCorrect BOOLEAN NOT NULL,
    FOREIGN KEY (QuestionID) REFERENCES `Question`(QuestionID)
    );

CREATE TABLE `Exam`(
	ExamID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `Code` INT NOT NULL,
    Title VARCHAR(50) NOT NULL,
    CategoryID INT NOT NULL,
    Duration INT NOT NULL,
    CreatorID INT NOT NULL,
    CreateDate DATE NOT NULL,
    FOREIGN KEY (CategoryID) REFERENCES `CategoryQuestion`(CategoryID)
    );

CREATE TABLE `ExamQuestion`(
	ExamID INT NOT NULL,
    QuestionID INT NOT NULL,
    FOREIGN KEY (ExamID) REFERENCES `Exam`(ExamID),
    FOREIGN KEY (QuestionID) REFERENCES `Question`(QuestionID)
    );