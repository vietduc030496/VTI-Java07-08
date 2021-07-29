CREATE DATABASE training;
USE training;

CREATE TABLE Department (
    DepartmentID INT AUTO_INCREMENT,
    DepartmentName VARCHAR(250),
    PRIMARY KEY (DepartmentID)
);

INSERT INTO Department(DepartmentName) VALUES ('Division 1'), ('Division 2'), ('Project 2');
SELECT * FROM department;