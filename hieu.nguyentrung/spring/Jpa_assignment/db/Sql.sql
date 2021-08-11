CREATE SCHEMA jpa_demo;
CREATE TABLE Employee(
	employeeID 	INT PRIMARY KEY AUTO_INCREMENT,
    firstName	VARCHAR(50),
    lastName	VARCHAR(50),
    email		VARCHAR(50),
    phone		VARCHAR(50)
);