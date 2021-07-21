-- Q2
SELECT * FROM department;
-- Q3
SELECT DepartmentID FROM department WHERE DepartmentName = "Sale";
-- Q4 
SELECT * FROM account 
WHERE LENGTH(Fullname) = (SELECT MAX(LENGTH(Fullname)) FROM `Account`)
ORDER BY Fullname DESC;
-- Q5
SELECT * FROM account
WHERE LENGTH(Fullname) = (SELECT MAX(LENGTH(Fullname)) FROM `Account`) AND DepartmentID = 3
ORDER BY Fullname DESC;
-- Q6
SELECT GroupName FROM `group` WHERE CreateDate < 20/12/2019;
-- Q7
SELECT QuestionID FROM `answer` GROUP BY QuestionID HAVING count(QuestionID) >= 4;
-- Q8
SELECT ExamID FROM `exam` WHERE Duration >= 60 AND CreateDate < 20/12/2019; 
-- Q9
SELECT * FROM `group` ORDER BY CreateDate DESC LIMIT 5;
-- Q10
SELECT count(AccountID) as So_NV FROM `account` WHERE DepartmentID = 2;  
-- Q11
SELECT Fullname FROM `Account`
WHERE (SUBSTRING_INDEX(FullName, ' ', -1)) LIKE 'D%o' ;
-- Q12
DELETE FROM `exam` WHERE CreateDate < '2019-12-20';
-- Q13
DELETE FROM `question` WHERE (SUBSTRING_INDEX(Content, ' ', 2)) = "câu hỏi";
-- Q14
UPDATE `account` SET Fullname = "Nguyễn Bá Lộc" AND email = "loc.nguyenba@vti.com.vn" WHERE AccountID = 5; 
-- Q15
UPDATE `groupaccount` SET AccountID = 5 WHERE GroupID = 4;