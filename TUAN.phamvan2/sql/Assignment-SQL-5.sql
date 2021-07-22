-- Q1
-- Subquery
CREATE OR REPLACE VIEW DSNV_Sale
AS 
	SELECT * 
    FROM `account` a
    WHERE a.DepartmentID = (
		SELECT d.DepartmentID
        FROM `department` d
        WHERE d.DepartmentName = "Sale"
    );
SELECT *
FROM DSNV_Sale;
-- CTE
WITH DSNV_Sale AS(
	SELECT a.*, d.DepartmentName
	FROM `account` a 
	INNER JOIN `department` d	ON	a.DepartmentID = d.DepartmentID
	WHERE d.DepartmentName = 'Sale'
)
SELECT *
FROM DSNV_Sale;

-- Q2
-- Subquery
CREATE OR REPLACE VIEW InfoAccJoinGroupMax
AS 
	SELECT a.*, COUNT(ga.AccountID) AS 'So luong'
    FROM `account` a
	INNER JOIN `groupaccount` ga ON a.AccountID = ga.AccountID
	GROUP BY ga.AccountID
	HAVING count(*) = (
		SELECT max(acc) 
		FROM (
			SELECT count(*) acc 
            FROM `groupaccount` ga
            GROUP BY ga.AccountID
		) AS joinmax
	);
SELECT * 
FROM InfoAccJoinGroupMax;
-- CTE
WITH InfoAccJoinGroupMax AS (
	SELECT max(acc) 
	FROM (
		SELECT count(*) acc 
		FROM `groupaccount` ga
		GROUP BY ga.AccountID
	) AS joinmax
)
SELECT A.*, COUNT(ga.AccountID) AS 'So luong'
FROM `account` a
INNER JOIN `groupaccount` ga ON a.AccountID = ga.AccountID
GROUP BY ga.AccountID
HAVING count(*) = (SELECT * FROM InfoAccJoinGroupMax);

-- Q3
-- Subquery
CREATE OR REPLACE VIEW LongQuestion
AS
	SELECT *
    FROM `question`
    WHERE LENGTH(Content) > 300;
DELETE FROM LongQuestion;
-- CTE
WITH LongQuestion AS (
	SELECT *
    FROM `question` q
    WHERE LENGTH(Content) > 300
)
DELETE q 
FROM `question` q
INNER JOIN LongQuestion lq ON q.QuestionID = lq.QuestionID;

-- Q4
-- Subquery
CREATE OR REPLACE VIEW DeptHasEmpMax
AS 
	SELECT d.*, COUNT(d.DepartmentID) AS 'So luong'
    FROM `department` d
	INNER JOIN `account` a ON a.DepartmentID = d.DepartmentID
	GROUP BY a.DepartmentID
	HAVING count(*) = (
		SELECT max(emp) 
		FROM (
			SELECT count(*) emp 
            FROM `account` a
            GROUP BY a.DepartmentID
		) AS empmax
	)
    LIMIT 1;
SELECT * 
FROM DeptHasEmpMax;
-- CTE
WITH DeptHasEmpMax AS (
	SELECT max(emp) 
	FROM (
		SELECT count(*) emp 
		FROM `account` a
		GROUP BY a.DepartmentID
	) AS empmax
)
SELECT d.*, COUNT(d.DepartmentID) AS 'So luong'
FROM `department` d
INNER JOIN `account` a ON a.DepartmentID = d.DepartmentID
GROUP BY a.DepartmentID
HAVING count(*) = (SELECT * FROM DeptHasEmpMax)
LIMIT 1;

-- Q5
-- Subquery
CREATE OR REPLACE VIEW QuestionByNguyen
AS
	SELECT q.*, a.FullName
	FROM `question` Q 
	INNER JOIN `account` a ON q.CreatorID = a.AccountID
	WHERE SUBSTRING_INDEX(FullName,' ',1) = 'Nguyen';
SELECT * 
FROM QuestionByNguyen;
-- CTE
WITH QuestionByNguyen AS (
	SELECT q.*, a.FullName
	FROM `question` Q 
	INNER JOIN `account` a ON q.CreatorID = a.AccountID
	WHERE SUBSTRING_INDEX(FullName,' ',1) = 'Nguyen'
)
SELECT * 
FROM QuestionByNguyen;