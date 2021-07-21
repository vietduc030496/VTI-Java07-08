-- Q1
SELECT * FROM `account`
INNER JOIN `department` ON account.DepartmentID = department.DepartmentID;
-- Q2
SELECT * FROM `account` WHERE CreateDate > 20/12/2010;
-- Q3
SELECT * FROM `account`
INNER JOIN `position` ON account.PositionID = position.PositionID
WHERE PositionName = "Dev"; 
-- Q4
SELECT * FROM `account`
INNER JOIN `department` ON account.DepartmentID = department.DepartmentID
GROUP BY DepartmentName
HAVING count(*) > 3;
-- Q5
SELECT * FROM question
INNER JOIN examquestion ON question.QuestionID = examquestion.QuestionID
GROUP BY examquestion.QuestionID 
HAVING count(*) = (SELECT max(ch) FROM (SELECT count(*) as ch FROM examquestion GROUP BY examquestion.QuestionID) as chmax);
-- Q6
SELECT categoryquestion.CategoryID, categoryquestion.CategoryName, count(categoryquestion.CategoryID) as So_Luong
FROM categoryquestion 
INNER JOIN question ON categoryquestion.CategoryID = question.CategoryID
GROUP BY question.CategoryID;
-- Q7
SELECT question.QuestionID, count(question.QuestionID) as So_Luong
FROM question 
INNER JOIN examquestion ON question.QuestionID = examquestion.QuestionID
GROUP BY question.QuestionID;
-- Q8
SELECT * FROM question
INNER JOIN answer ON question.QuestionID = answer.QuestionID
GROUP BY answer.QuestionID 
HAVING count(*) = (SELECT max(ctl) FROM (SELECT count(*) as ctl FROM answer GROUP BY answer.QuestionID) as ctlmax);
-- Q9
SELECT`group`.GroupID, `group`.GroupName, count(`group`.GroupID) as So_luong FROM `group`
INNER JOIN groupaccount ON `group`.GroupID = groupaccount.GroupID
GROUP BY `group`.GroupID;
-- Q10
SELECT p.PositionID, p.PositionName, count(*) as So_Luong FROM `account` a 
INNER JOIN position p on a.PositionID = p.PositionID
GROUP BY a.PositionID
HAVING So_Luong = (SELECT min(c) FROM (SELECT count(*) as c FROM `account` a GROUP BY a.PositionID) as cv);

-- Q11
SELECT d.DepartmentID, d.DepartmentName, p.PositionName, count(a.PositionID) as So_Luong
FROM `account` a, department d, position p
WHERE a.DepartmentID = d.DepartmentID AND a.PositionID = p.PositionID
GROUP BY p.PositionID, a.DepartmentID;

-- Q12
SELECT * FROM question q 
INNER JOIN typequestion tq ON q.TypeID = tq.TypeID
INNER JOIN categoryquestion cq ON q.CategoryID = cq.CategoryID
INNER JOIN answer an ON q.QuestionID =an.QuestionID
WHERE isCorrect = 1;

-- Q13
SELECT tq.TypeID, tq.TypeName, count(q.TypeID) as So_Luong FROM typequestion tq 
INNER JOIN question q on q.TypeID = tq.TypeID
group by tq.TypeID;

-- Q14
SELECT g.GroupID, g.GroupName, count(ga.GroupID) as So_Luong FROM `group` g 
INNER JOIN groupaccount ga on g.GroupID = ga.GroupID
group by g.GroupID
having So_Luong = '0';

-- Q15
-- giống Q14	

-- Q16
SELECT q.QuestionID, q.Content, q.CategoryID, q.TypeID, count(a.QuestionID) as So_Luong FROM question q 
INNER JOIN answer a on a.QuestionID = q.QuestionID
group by q.QuestionID
having So_Luong = '0';

-- Q17a
SELECT * FROM `account` a WHERE a.DepartmentID = '1';
-- Q17b
SELECT * FROM `account` a WHERE a.DepartmentID = '2';
-- Q17c
SELECT * FROM `account` a WHERE a.DepartmentID = '1'
UNION DISTINCT 
SELECT * FROM `account` a WHERE a.DepartmentID = '2';

-- Q18a
SELECT g.GroupID, g.GroupName, count(ga.GroupID) as So_Luong FROM `group` g 
INNER JOIN groupaccount ga on g.GroupID = ga.GroupID
group by g.GroupID having So_Luong > 7;
-- Q18b
SELECT g.GroupID, g.GroupName, count(ga.GroupID) as So_Luong FROM `group` g 
INNER JOIN groupaccount ga on g.GroupID = ga.GroupID
group by g.GroupID having So_Luong < 5;
-- Q18c
SELECT g.GroupID, g.GroupName, count(ga.GroupID) as So_Luong FROM `group` g 
INNER JOIN groupaccount ga on g.GroupID = ga.GroupID
group by g.GroupID having So_Luong > 7
UNION DISTINCT
SELECT g.GroupID, g.GroupName, count(ga.GroupID) as So_Luong FROM `group` g 
INNER JOIN groupaccount ga on g.GroupID = ga.GroupID
group by g.GroupID having So_Luong < 5;
