-- Question 1: Them it nhat 10 record vao moi table
INSERT INTO `Department` (DepartmentName) VALUES ("Administration"),
("Marketing"),
("Purchasing"),
("Human Resources"),
("IT"),
("Public Relations"),
("Sales"),
("Executive"),
("Finance"),
("Accounting");
INSERT INTO `Position` (PositionName) VALUES ("Dev"),
("Test"),
("Scrum Master"),
("PM"),
("developer"),
("Position6"),
("Position7"),
("Position8"),
("Position9"),
("Position10");
INSERT INTO `Account` (Email,UserName,FullName,DepartmentID,PositionID,CreateDate) VALUES ("a@gmail.com","thinh1","phamxuanthinh",1,1,"2021-07-20"),
("b@gmail.com","long1","vuhailong",2,2,"2019-06-05"),
("c@gmail.com","duc1","vuanhduc",3,10,"2020-12-20"),
("d@gmail.com","thuy1","phamxuanthuy",3,1,"2018-07-20"),
("e@gmail.com","hieu1","vumanhhieu",5,5,"2020-01-02"),
("f@gmail.com","ngo1","donghaingo",6,8,"2019-12-20"),
("g@gmail.com","quang1","phamhuyquang",7,1,"2019-02-20"),
("h@gmail.com","cuong1","nguyendangcuong",8,2,"2020-02-15"),
("j@gmail.com","vietanh1","phamvietanh",9,9,"2017-01-20"),
("k@gmail.com","dat1","phamthanhdat",10,3,"2021-07-20");


INSERT INTO `Group` (GroupName,CreatorID,CreateDate) VALUES ("Group1",1,"2021-07-01"),
("Group2",1,"2017-01-01"),
("Group3",1,"2020-07-01"),
("Group4",1,"2019-07-01"),
("Group5",1,"2017-01-01"),
("Group6",1,"2021-07-01"),
("Group7",4,"2020-01-01"),
("Group8",4,"2017-07-01"),
("Group9",4,"2018-07-01"),
("Group10",4,"2019-01-01");
INSERT INTO `GroupAccount` (GroupID,AccountID,JoinDate) VALUES (1,1,"2021-07-20"), 
(1,10,"2021-07-20"),
(2,9,"2017-01-20"),
(3,3,"2020-12-20"),
(4,6,"2019-12-20"),
(4,8,"2020-02-15"),
(7,5,"2020-01-02"),
(9,4,"2018-07-20"),
(10,7,"2019-02-20"),
(10,2,"2019-06-05");
INSERT INTO `TypeQuestion` (TypeName) VALUES ("Type1"),
("Type2"),
("Type3"),
("Type4"),
("Type5"),
("Type6"),
("Type7"),
("Type8"),
("Type9"),
("Type10");
INSERT INTO `CategoryQuestion` (CategoryName) VALUES ("Category1"),
("Category2"),
("Category3"),
("Category4"),
("Category5"),
("Category6"),
("Category7"),
("Category8"),
("Category9"),
("Category10");
INSERT INTO `Question` (Content,CategoryID,TypeID,CreatorID,CreateDate) VALUES ("Question1",1,1,1,"2021-07-01"),
("Question2",1,2,1,"2018-01-01"),
("Question3",2,1,1,"2019-07-01"),
("Question4",4,2,1,"2020-01-01"), 
("Question5",5,5,1,"2020-07-01"),
("Question6",6,6,4,"2021-01-01"), 
("Cauhoi7",6,7,4,"2018-01-01"),
("Question8",6,7,4,"2019-01-01"),
("Cauhoi9",7,9,4,"2018-07-01"),
("Question10",9,10,4,"2021-07-01");
INSERT INTO `Answer` (Content,QuestionID,isCorrect) VALUES ("Answer1",1,true),
("Answer2",1,false),
("Answer3",1,false),
("Answer4",1,false),
("Answer5",2,true),
("Answer6",4,true),
("Answer7",7,false),
("Answer8",8,true),
("Answer9",9,false),
("Answer10",10,true);
INSERT INTO `Exam` (`Code`,Title,CategoryID,Duration,CreatorID,CreateDate) VALUES (1,"Exam1",1,30,1,"2021-07-01"),
(2,"Exam2",1,90,1,"2021-07-01"),
(3,"Exam3",2,120,1,"2019-07-01"),
(4,"Exam4",4,30,1,"2020-01-01"),
(5,"Exam5",4,90,1,"2020-01-01"),
(6,"Exam6",5,60,1,"2020-07-01"),
(7,"Exam7",5,180,1,"2020-07-01"),
(8,"Exam8",6,180,4,"2019-01-01"),
(9,"Exam9",7,120,4,"2020-07-01"),
(10,"Exam10",9,60,4,"2021-07-01");
INSERT INTO `ExamQuestion` (ExamID,QuestionID) VALUES (1,1),
 (1,2),
 (2,1),
 (3,3),
 (4,4),
 (5,4),
 (6,5),
 (8,7),
 (8,8),
 (10,10);
 
-- Question 2: Lay ra tat ca cac phong ban
SELECT * FROM `Department`;
-- Question 3: Lay ra id cua phong ban Sale
SELECT DepartmentID 
FROM `Department` 
WHERE DepartmentName='Sales';
-- Question 4: Lay ra thong tin account co full name dai nhat va sap xep chung theo thu tu giam dan
SELECT *
FROM `Account`
WHERE LENGTH(FullName) = 
(SELECT MAX(LENGTH(FullName)) 
FROM `Account`);
-- Question 5: Lay ra thong tin account co full name dai nhat va thuoc deparment id=3
SELECT *
FROM `Account`
WHERE LENGTH(FullName) = 
(SELECT MAX(LENGTH(FullName)) 
FROM `Account`
WHERE DepartmentID=3)
AND DepartmentID=3;

-- Question 6: Lay ra ten group da tham gia truoc ngay 20/12/2019
SELECT GroupName 
FROM `Group`
WHERE CreateDate<'2019-12-20';
-- Question 7: Lay ra id cua question co >= 4 cau tra loi
SELECT QuestionID
FROM `Answer`
GROUP BY QuestionID
HAVING COUNT(QuestionID)>=4;
-- Question 8: Lay ra cac ma de thi co thoi gian thi >=60 phut va duoc tao truoc ngay 20/12/2019
SELECT `Code` 
FROM `Exam`
WHERE Duration>=60 AND CreateDate<'2019-12-20';
-- Question 9: Lay ra 5 group duoc tao gan day nhat
SELECT *
FROM `Group`
ORDER BY CreateDate DESC
LIMIT 5;
-- Question 10: Dem so nhan vien thuoc department co id=2
SELECT COUNT(*)
FROM `Account`
WHERE DepartmentID=2;
-- Question 11: Lay ra nhan vien co ten bat bau bang chu d va ket thuc bang chu o
SELECT *
FROM `Account`
WHERE FullName LIKE 'd%o';
-- Question 12: Xoa tat ca cac exam duoc tao truoc ngay 20/12/2019
DELETE
FROM `Exam`
WHERE CreateDate<'2019-12-20';
-- Question 13: Xoa tat ca cac question co noi dung bat dau bang tu cau hoi
DELETE 
FROM `Question`
WHERE Content LIKE 'cauhoi%';
-- Question 14: Update thong tin cua account co id=5 thanh ten nguyenbaloc va email thanh loc.nguyenba@vti.com.vn
UPDATE `Account`
SET FullName='nguyenbaloc', Email='loc.nguyenba@vti.com.vn'
WHERE AccountID=5; 
-- Question 15: Update account co id=5 se thuoc group co id=4
UPDATE `GroupAccount`
SET GroupID=4
WHERE AccountID=5;
