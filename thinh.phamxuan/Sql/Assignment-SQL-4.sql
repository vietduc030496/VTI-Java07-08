-- Question 1: Viet lenh de lay ra danh sach nhan vien va thong tin phong ban cua ho
SELECT *
FROM `Account`
INNER JOIN `Department`
ON `Account`.DepartmentID=`Department`.DepartmentID;
-- Question 2: Viet lenh de lay ra thong tin cac account duoc tao sau ngay 20/12/2010
SELECT *
FROM `Account`
WHERE CreateDate>'2010-12-20';
-- Question 3: Viet lenh de lay ra tat ca cac developer
SELECT *
FROM `Account`
INNER JOIN `Position`
ON `Account`.PositionID=`Position`.PositionID
WHERE `Position`.PositionName='developer';
-- Question 4: Viet lenh de lay ra danh sach cac phong ban co >1 nhan vien
SELECT DepartmentName
FROM `Department`
INNER JOIN `Account`
ON `Department`.DepartmentID=`Account`.DepartmentID
GROUP BY `Department`.DepartmentID
HAVING COUNT(`Department`.DepartmentID)>1;

-- Question 5: Viet lenh de lay ra danh sach cau hoi duoc su dung trong de thi nhieu nhat
SELECT Content
FROM `Question`
INNER JOIN `ExamQuestion`
ON `Question`.QuestionID=`ExamQuestion`.QuestionID
GROUP BY `Question`.QuestionID
HAVING COUNT(`Question`.QuestionID)=
(SELECT MAX(TOTAL) FROM
(SELECT COUNT(*) AS TOTAL
 FROM `Question`
 INNER JOIN `ExamQuestion`
 ON `Question`.QuestionID=`ExamQuestion`.QuestionID
 GROUP BY `Question`.QuestionID) AS C);


-- Question 6: Thong ke moi category question duoc su dung trong bao nhieu question
SELECT CategoryName, COUNT(CategoryName) AS TOTAL
FROM `CategoryQuestion`
INNER JOIN `Question`
ON `CategoryQuestion`.CategoryID=`Question`.CategoryID
GROUP BY `CategoryQuestion`.CategoryID;

-- Question 7: Thong ke moi question duoc su dung trong bao nhieu Exam
SELECT Content,COUNT(`Question`.QuestionID) AS TOTAL
FROM `Question`
INNER JOIN `ExamQuestion`
ON `Question`.QuestionID=`ExamQuestion`.QuestionID
GROUP BY `Question`.QuestionID;
-- Question 8: Lay ra question co nhieu cau tra loi nhat
SELECT `C`.Content, MAX(TOTAL) FROM (
SELECT `Question`.Content,COUNT(`Question`.QuestionID) AS TOTAL
FROM `Question`
INNER JOIN `Answer`
ON `Question`.QuestionID=`Answer`.QuestionID
GROUP BY `Question`.QuestionID) AS C;
-- Question 9: Thong ke so luong account trong moi group

SELECT COUNT(`GroupAccount`.AccountID) AS TOTAL,`Group`.GroupName 
FROM `GroupAccount`
INNER JOIN `Account`
ON `GroupAccount`.AccountID=`Account`.AccountID
INNER JOIN `Group`
ON `GroupAccount`.GroupID=`Group`.GroupID
GROUP BY `GroupAccount`.AccountID;
-- Question 10: Tim chuc vu co it nguoi nhat

-- CHI LAY 1 THANG MIN
SELECT MIN(TOTAL),`C`.PositionName FROM (
SELECT COUNT(`Position`.PositionID) AS TOTAL,`Position`.PositionName
FROM `Position`
INNER JOIN `Account`
ON `Position`.PositionID=`Account`.PositionID
GROUP BY `Position`.PositionID) AS C;
 
-- LIET KE TAT CA CAC THANG MIN
SELECT COUNT(`Position`.PositionID) AS TOTAL,`Position`.PositionName
FROM `Position`
INNER JOIN `Account`
ON `Position`.PositionID=`Account`.PositionID
GROUP BY `Position`.PositionID
HAVING TOTAL= 
(SELECT MIN(TOTAL2) FROM 
(SELECT COUNT(`Position`.PositionID) AS TOTAL2 FROM `Position`
INNER JOIN `Account`
ON `Position`.PositionID=`Account`.PositionID
GROUP BY `Position`.PositionID) AS C);

-- Question 11: Thong ke moi phong ban co bao nhieu dev,test,scrum master,PM
SELECT `Department`.DepartmentName,`Position`.PositionName,COUNT(`Position`.PositionID) AS TOTAL
FROM `Department`
INNER JOIN `Account`
ON `Department`.DepartmentID=`Account`.DepartmentID
INNER JOIN `Position`
ON `Account`.PositionID=`Position`.PositionID
GROUP BY `Account`.DepartmentID,`Position`.PositionID;

-- Question 12: Lay thong tin chi tiet cua cau hoi bao gom: thong tin co ban cua question, loai cau hoi, ai la nguoi tao ra cau hoi, cau tra loi la gi

SELECT `Question`.QuestionID,`Question`.Content,`CategoryQuestion`.CategoryName,`TypeQuestion`.TypeName,`Account`.FullName AS CreatorName,`Question`.CreateDate,`Answer`.Content
FROM `Question`
INNER JOIN `CategoryQuestion`
ON `Question`.CategoryID=`CategoryQuestion`.CategoryID
INNER JOIN `TypeQuestion`
ON `Question`.TypeID=`TypeQuestion`.TypeID
INNER JOIN `Account`
ON `Question`.CreatorID=`Account`.AccountID
INNER JOIN `Answer`
ON `Question`.QuestionID=`Answer`.QuestionID;
-- Question 13: Lay ra so luong cau hoi cua moi loai tu luan hay trac nghiem
SELECT `Question`.TypeID,`TypeQuestion`.TypeName,COUNT(`Question`.TypeID)
FROM `Question`
INNER JOIN `TypeQuestion`
ON `Question`.TypeID=`TypeQuestion`.TypeID
GROUP BY TypeID;
-- Question 14: Lay ra group khong co account nao
SELECT `Group`.GroupID,`Group`.GroupName
FROM `Group`
WHERE `Group`.GroupID NOT IN 
(SELECT `GroupAccount`.GroupID
FROM `GroupAccount`
INNER JOIN `Account`
ON `GroupAccount`.AccountID=`Account`.AccountID);

-- Question 15: Lay ra group khong co account nao
SELECT `Group`.GroupID,`Group`.GroupName
FROM `Group`
WHERE `Group`.GroupID NOT IN 
(SELECT `GroupAccount`.GroupID
FROM `GroupAccount`
INNER JOIN `Account`
ON `GroupAccount`.AccountID=`Account`.AccountID);
-- Question 16: Lay ra question khong co answer nao
SELECT `Question`.QuestionID,`Question`.Content
FROM `QUESTION`
WHERE `Question`.QuestionID NOT IN 
(SELECT `Question`.QuestionID
FROM `Question`
INNER JOIN `Answer`
ON `Question`.QuestionID=`Answer`.QuestionID);
-- Question 17: 
SELECT *
FROM `GroupAccount`
WHERE `GroupAccount`.GroupID=1
UNION DISTINCT
SELECT *
FROM `GroupAccount`
WHERE `GroupAccount`.GroupID=2;
-- Question 18: 
SELECT `Group`.GroupID,`Group`.GroupName
FROM `GroupAccount`
INNER JOIN `Account`
ON `GroupAccount`.AccountID=`Account`.AccountID
INNER JOIN `Group`
ON `GroupAccount`.GroupID=`Group`.GroupID
GROUP BY GroupID
HAVING COUNT(`GroupAccount`.GroupID)>5
UNION DISTINCT
SELECT `Group`.GroupID,`Group`.GroupName
FROM `GroupAccount`
INNER JOIN `Account`
ON `GroupAccount`.AccountID=`Account`.AccountID
INNER JOIN `Group`
ON `GroupAccount`.GroupID=`Group`.GroupID
GROUP BY GroupID
HAVING COUNT(`GroupAccount`.GroupID)<7;