-- Question 1: Tao view co chua danh sach nhan vien trong phong ban sale

CREATE VIEW listEmployeeSale AS
SELECT AccountID,Email,UserName,FullName
FROM `Account`
WHERE `Account`.DepartmentID=
(SELECT DepartmentID
FROM `Department`
WHERE `Department`.DepartmentName="Sales");

SELECT * FROM listEmployeeSale;
-- Question 2: Tao view co chua thong tin account tham gia nhieu group nhat

CREATE VIEW listInfoAccount AS
SELECT `Account`.AccountID,`Account`.Email,`Account`.UserName,`Account`.FullName
FROM `Account`
INNER JOIN `GroupAccount`
ON `Account`.AccountID=`GroupAccount`.AccountID
GROUP BY `Account`.AccountID
HAVING COUNT(`Account`.AccountID)=
(SELECT MAX(TOTAL) FROM
(SELECT COUNT(*) AS TOTAL
FROM `Account`
INNER JOIN `GroupAccount`
ON `Account`.AccountID=`GroupAccount`.AccountID
GROUP BY `Account`.AccountID) AS C);

SELECT * FROM listInfoAccount;
-- Question 3: Tao view	co chua cau hoi co nhung content qua dai va xoa no di

CREATE VIEW questionContent AS
SELECT *
FROM `Question`
WHERE LENGTH(Content)>10;
SELECT * FROM questionContent;
DROP VIEW questionContent;
DELETE 
FROM `Question`
WHERE LENGTH(Content)>10;
SELECT * FROM `Question`;
-- Question 4: Tao view co chua danh sach cac phong ban co nhieu nhan vien nhat
CREATE VIEW listDepartment AS
SELECT `Department`.DepartmentID,`Department`.DepartmentName
FROM `Department`
INNER JOIN `Account`
ON `Department`.DepartmentID=`Account`.DepartmentID
GROUP BY `Department`.DepartmentID
HAVING COUNT(`Department`.DepartmentID)=
(SELECT MAX(TOTAL) FROM
(SELECT COUNT(*) AS TOTAL
FROM `Department`
INNER JOIN `Account`
ON `Department`.DepartmentID=`Account`.DepartmentID
GROUP BY `Department`.DepartmentID) AS C);

SELECT * FROM listDepartment;
-- Question 5: Tao view co chua tat ca cac cau hoi do user ho nguyen tao
INSERT INTO `Question` (Content,CategoryID,TypeID,CreatorID,CreateDate) VALUES ("Question1",1,1,8,"2021-07-01");

CREATE VIEW listQuestion AS
SELECT * 
FROM `Question`
WHERE `Question`.CreatorID
IN
(SELECT AccountID
FROM `Account`
WHERE `Account`.FullName LIKE 'nguyen%'
);

SELECT * FROM listQuestion;
