# QUESTION 1: THEM 5 BAN GHI
INSERT INTO DEPARTMENT VALUES (NULL,"SALE"),
(NULL,"DEV"),
(NULL,"TESTER"),
(NULL,"HR"),
(NULL,"BA"),
(NULL, "Phong cho");

INSERT INTO POSITION VALUES (NULL,"POSITION1"),
(NULL,"POSITION2"),
(NULL,"POSITION3"),
(NULL,"POSITION4"),
(NULL,"POSITION5");
INSERT INTO POSITION VALUES (NULL, "DEVELOPER");

INSERT INTO `GROUP` VALUES (NULL,"GROUP1",1,"2021-07-19"),
(NULL,"GROUP2",2,"2021-07-05"),
(NULL,"GROUP3",3,"2021-07-01"),
(NULL,"GROUP4",4,"2019-07-19"),
(NULL,"GROUP5",5,"2020-07-19"),
(NULL,"GROUP6",6,"2020-06-25"),
(NULL,"GROUP7",7,"2018-01-15");


INSERT INTO `ACCOUNT` VALUES (NULL,"VANTRUONG@GMAIL.COM","VANTRUONG","TRUONGVANTRUONG","M",2,4,"2021-11-11"),
(NULL,"DDDDD@GMAIL.COM","DDDD","DDDDDDD","F",5,3,"2021-11-11"),
(NULL,"HIEUNGUYEN@GMAIL.COM","HIEUNGUYEN","NGUYENTRUNGHIEU","M",3,4,"2021-11-11"),
(NULL,"A@GMAIL.COM","A","AAAAAAA","F",1,2,"2021-11-11"),
(NULL,"B@GMAIL.COM","B","NGUYENVANB","M",4,1,"2021-11-11"),
(NULL,"DAVIDROBERTFILO@GMAIL.COM","DAVIDROBERTFILOOOOOOO","DAVIDROBERTFILO","M",2,4,"2021-11-11"),
(NULL,"CCCCCCCCCC","CCCCCCCCCCCC","DAVIDROBERTFILOCCCC","M",2,6,"2021-11-11"),
(NULL,"HHHHHH@GMAIL","HHHHHHH","DAVIDHHHHHH","M",2,6,"2021-11-11"),
(NULL,"admin@gmail.com","admin","adminsystem","M",2,1,"2021-11-11");
INSERT INTO `account` VALUES (null, "hieudepzai@gmail.com", "hieudepzai", "hieunguyen","M",1, 3,"2021-07-23");


INSERT INTO GROUPACCOUNT VALUES (1,1,"2021-11-11"),
(2,2,"2021-11-11"),
(3,3,"2021-11-11"),
(1,4,"2021-11-11"),
(2,5,"2021-11-11");

INSERT INTO TYPEQUESTION VALUES (NULL,"ESSAY"),
(NULL,"MULTI-CHOICE"),
(NULL,"TYPEQUESTION1"),
(NULL,"TYPEQUESTION2"),
(NULL,"TYPEQUESTION3");

INSERT INTO CATEGORYQUESTION VALUES (NULL,"JAVA"),
(NULL,"HTML"),
(NULL,"CSS"),
(NULL,"PYTHON"),
(NULL,"PHP");


INSERT INTO QUESTION VALUES (NULL,"QUESTION1",1,1,1,"2021-11-11"),
(NULL,"QUESTION2",2,2,1,"2021-11-11"),
(NULL,"QUESTION3",3,3,1,"2021-11-11"),
(NULL,"CÂU HỎI THỨ 1",4,3,1,"2021-11-11"),
(NULL,"CÂU HỎI THỨ 2",3,2,1,"2021-11-11"),
(NULL,"CÂU HỎI THỨ 3",3,2,1,"2021-07-11");

INSERT INTO ANSWER VALUES (NULL,"ANSWER1",1,TRUE),
(NULL,"ANSWER2",2,TRUE),
(NULL,"ANSWER3",3,FALSE),
(NULL,"ANSWER4",1,FALSE),
(NULL,"ANSWER5",1,TRUE),
(NULL,"ANSWER6",1,FALSE);
INSERT INTO ANSWER VALUES (NULL,"A",1,TRUE),
(NULL,"B",2,TRUE),
(NULL,"C",3,FALSE);
INSERT INTO ANSWER VALUES (NULL,"D",1,TRUE),(NULL,"E",1,TRUE),(NULL,"F",1,TRUE);

INSERT INTO EXAM VALUES (NULL,1,"EXAM1",1,2.5,1,"2021-11-11"),
(NULL,2,"EXAM2",2,1.5,2,"2021-11-11"),
(NULL,3,"EXAM3",3,1.5,3,"2021-11-11"),
(NULL,4,"EXAM4",3,3.0,3,"2018-11-11"),
(NULL,5,"EXAM5",3,1.0,3,"2018-11-11");
INSERT INTO EXAM VALUES (NULL,1,"EXAM1",1,2.5,1,"2021-07-24");

INSERT INTO EXAMQUESTION VALUES (1,1),
(2,2),
(3,3),
(1,2),
(3,2);

# QUESTION 2: LAY RA TAT CA CAC PHONG BAN
SELECT * FROM DEPARTMENT;

# QUESTION 3:LAY RA ID CUA " SALE"
SELECT DEPARTMENTID FROM DEPARTMENT
WHERE DEPARTMENTNAME ="SALE";

# QUESTION 4: LAY ACCOUNT CO FULL NAME DAI NHAT
SELECT * FROM `ACCOUNT` AS ACC
WHERE (SELECT LENGTH(ACC.FULLNAME))= (SELECT MAX(LENGTH(ACC1.FULLNAME)) FROM `ACCOUNT` AS ACC1 );

# QUESTION 4 : SAP XEP GIAM DAN
SELECT * FROM `ACCOUNT`
ORDER BY LENGTH(FULLNAME) DESC;

# QUESTION 5: ACC CO FULLNAME DAI NHAT && DEPARTMENTID = 3
SELECT * FROM `ACCOUNT` AS ACC
WHERE LENGTH(ACC.FULLNAME) = ( SELECT MAX(LENGTH(ACC1.FULLNAME)) FROM `ACCOUNT` AS ACC1 ) 
AND ACC.DEPARTMENTID = 3;

# QUESTION 6: LAY GROUP TRUOC 20/12/2019
SELECT GROUPNAME FROM `GROUP`
WHERE CREATEDATE < "2019-12-20";

# QUESTION 7: LAY ID CUA QUESTION >=4 CAU TRA LOI
SELECT QUESTIONID FROM ANSWER
GROUP BY QUESTIONID
HAVING COUNT(QUESTIONID) >=4;

# QUESTION 8: LAY MA DE THI TIME >=60PHUT(1.0 GIO)  && TRUOC 20/12/2019
SELECT `CODE` FROM EXAM 
WHERE DURATION >= 1.0 AND CREATEDATE < "2019-12-20";

# QUESTION 9: LAY RA 5 GROUP DUOC TAO GAN NHAT
SELECT * FROM `GROUP`
ORDER BY CREATEDATE DESC
LIMIT 5;

# QUESTION 10: DEM SO NHAN VIEN DEPARTMENT2 CO ID =2
SELECT COUNT(*) AS AMOUNT_OF_EMP FROM `ACCOUNT`
WHERE DEPARTMENTID = 2;

# QUESTION 11: LAY NHAN VIEN BAT DAU BANG D VA KET THUC BANG O
SELECT * FROM `ACCOUNT`
WHERE FULLNAME LIKE "D%O";

# QUESTION 12: XOA EXAM TRUOC 20/12/2019
DELETE FROM EXAM 
WHERE CREATEDATE < "2019-12-20";

# QUESTION 13 XOA QUESTION CO NOI DUNG BAT DAU " CAU HOI"
SELECT * FROM QUESTION;
DELETE FROM QUESTION 
WHERE CONTENT LIKE "CÂU HỎI%";

# QUESTION 14: UPDATE THONG TIN
SELECT * FROM `ACCOUNT`;
UPDATE `ACCOUNT` 
SET FULLNAME ="NGUYỄN BÁ LỘC",EMAIL = "LOC.NGUYENBA@VTI.COM.VN"
WHERE ACCOUNTID =5;

# QUESTION 15: UPDATE ACC CO ID-5 SE THUOC GROUP CO ID=4
SELECT * FROM GROUPACCOUNT;
UPDATE GROUPACCOUNT
SET GROUPID = 4
WHERE ACCOUNTID = 5;