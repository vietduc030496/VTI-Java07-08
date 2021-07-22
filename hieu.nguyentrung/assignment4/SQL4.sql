#QUESTION 1: VIẾT LỆNH ĐỂ LẤY RA DANH SÁCH NHÂN VIÊN VÀ THÔNG TIN PHÒNG BAN CỦA HỌ
SELECT ACCOUNTID, USERNAME, FULLNAME, DEPARTMENT.DEPARTMENTID
FROM `ACCOUNT` AS ACC
INNER JOIN DEPARTMENT
ON ACC.DEPARTMENTID = DEPARTMENT.DEPARTMENTID;

#QUESTION 2: VIẾT LỆNH ĐỂ LẤY RA THÔNG TIN CÁC ACCOUNT ĐƯỢC TẠO SAU NGÀY 20/12/2010 
SELECT *
FROM `ACCOUNT` AS ACC
WHERE CREATEDATE > 2010-12-20;

#QUESTION 3: VIẾT LỆNH ĐỂ LẤY RA TẤT CẢ CÁC DEVELOPER
SELECT * FROM POSITION;
SELECT ACCOUNTID, USERNAME, FULLNAME, DEPARTMENTID, POSITION.POSITIONID, POSITIONNAME
FROM `ACCOUNT` AS ACC
INNER JOIN POSITION
ON ACC.POSITIONID = POSITION.POSITIONID
WHERE  POSITIONNAME = "DEVELOPER";

#QUESTION 4: VIẾT LỆNH ĐỂ LẤY RA DANH SÁCH CÁC PHÒNG BAN CÓ >3 NHÂN VIÊN 
SELECT  DEPARTMENT.DEPARTMENTID, DEPARTMENTNAME
FROM `ACCOUNT` AS ACC
INNER JOIN DEPARTMENT
ON ACC.DEPARTMENTID = DEPARTMENT.DEPARTMENTID
GROUP BY ACC.DEPARTMENTID
HAVING COUNT(ACC.DEPARTMENTID) >3;

#QUESTION 5: VIẾT LỆNH ĐỂ LẤY RA DANH SÁCH CÂU HỎI ĐƯỢC SỬ DỤNG TRONG ĐỀ THI NHIỀU NHẤT 
SELECT QUESTIONID, COUNT(*) AS MAX_NUM 
FROM EXAMQUESTION 
GROUP BY QUESTIONID
HAVING COUNT(*) = (SELECT MAX(COUNTS.COUNT) FROM (SELECT COUNT(*) AS COUNT FROM EXAMQUESTION GROUP BY QUESTIONID) AS COUNTS );

#QUESTION 6: THÔNG KÊ MỖI CATEGORY QUESTION ĐƯỢC SỬ DỤNG TRONG BAO NHIÊU QUESTION
SELECT CATEGORYID , COUNT(*) AS NUMBER_OF_QUESTION
FROM QUESTION
GROUP BY CATEGORYID;

#QUESTION 7: THÔNG KÊ MỖI QUESTION ĐƯỢC SỬ DỤNG TRONG BAO NHIÊU EXAM
SELECT QUESTIONID, COUNT(*) AS NUM_OF_EXAM 
FROM EXAMQUESTION
GROUP BY QUESTIONID;
#QUESTION 8: LẤY RA QUESTION CÓ NHIỀU CÂU TRẢ LỜI NHẤT 
SELECT QUESTIONID, COUNT(*) AS MAX_NUM_OF_ANSWER FROM ANSWER
GROUP BY QUESTIONID
HAVING COUNT(*) = (SELECT MAX(COUNTS.COUNT) FROM (SELECT COUNT(*) AS COUNT FROM ANSWER GROUP BY QUESTIONID) AS COUNTS );

#QUESTION 9: THỐNG KÊ SỐ LƯỢNG ACCOUNT TRONG MỖI GROUP 
SELECT G.GROUPID, G.GROUPNAME ,COUNT(*) AS NUM_OF_ACCCOUNT FROM GROUPACCOUNT
INNER JOIN `GROUP` AS G
ON GROUPACCOUNT.GROUPID = G.GROUPID
GROUP BY GROUPID;

#QUESTION 10: TÌM CHỨC VỤ CÓ ÍT NGƯỜI NHẤT 
SELECT ACC.POSITIONID, POSITION.POSITIONNAME, COUNT(*) AS MIN_OF_POSITION FROM `ACCOUNT` AS ACC
INNER JOIN POSITION 
ON ACC.POSITIONID = POSITION.POSITIONID
GROUP BY POSITIONID
HAVING COUNT(*) = (SELECT MIN(COUNTS.COUNT) FROM (SELECT COUNT(*) AS COUNT FROM `ACCOUNT` GROUP BY POSITIONID) AS COUNTS );

#QUESTION 11: THỐNG KÊ MỖI PHÒNG BAN CÓ BAO NHIÊU DEV, TEST, SCRUM MASTER, PM 
SELECT ACC.DEPARTMENTID , ACC.POSITIONID , P.POSITIONNAME , COUNT(P.POSITIONID) AS NUM_OF_EMPLOYEE FROM `ACCOUNT` AS ACC
INNER JOIN POSITION AS P
ON ACC.POSITIONID = P.POSITIONID
GROUP BY DEPARTMENTID , POSITIONID
ORDER BY DEPARTMENTID;

#QUESTION 12: LẤY THÔNG TIN CHI TIẾT CỦA CÂU HỎI BAO GỒM: THÔNG TIN CƠ BẢN CỦA QUESTION, LOẠI CÂU HỎI, AI LÀ 
#NGƯỜI TẠO RA CÂU HỎI, CÂU TRẢ LỜI LÀ GÌ, … 
SELECT * FROM QUESTION 
NATURAL JOIN TYPEQUESTION 
LEFT JOIN ANSWER
ON QUESTION.QUESTIONID = ANSWER.QUESTIONID;

#QUESTION 13: LẤY RA SỐ LƯỢNG CÂU HỎI CỦA MỖI LOẠI TỰ LUẬN HAY TRẮC NGHIỆM 
SELECT *,COUNT(QUESTION.TYPEID) AS NUM_OF_QUESTION
FROM TYPEQUESTION 
LEFT JOIN QUESTION 
ON QUESTION.TYPEID = TYPEQUESTION.TYPEID
GROUP BY TYPEQUESTION.TYPEID;

#QUESTION 14: LẤY RA GROUP KHÔNG CÓ ACCOUNT NÀO
SELECT DISTINCT GROUPID, GROUPNAME 
FROM `GROUP` AS G 
WHERE NOT EXISTS (SELECT *FROM GROUPACCOUNT AS GA WHERE GA.GROUPID = G.GROUPID );

#QUESTION 15: LẤY RA GROUP CÓ ACCOUNT 
SELECT DISTINCT GROUPID, GROUPNAME 
FROM `GROUP` AS G 
WHERE EXISTS (SELECT *FROM GROUPACCOUNT AS GA WHERE GA.GROUPID = G.GROUPID );

#QUESTION 16: LẤY RA QUESTION KHÔNG CÓ ANSWER NÀO 
SELECT DISTINCT QUESTIONID, CONTENT
FROM QUESTION 
WHERE NOT EXISTS (SELECT *
				   FROM ANSWER
                   WHERE ANSWER.QUESTIONID = QUESTION.QUESTIONID );
#QUESTION 17:
#A
SELECT ACCOUNTID FROM GROUPACCOUNT
WHERE GROUPID=1;
#B
SELECT ACCOUNTID FROM GROUPACCOUNT
WHERE GROUPID=2;
#C
SELECT ACCOUNTID FROM GROUPACCOUNT
WHERE GROUPID=1
UNION DISTINCT
SELECT ACCOUNTID FROM GROUPACCOUNT
WHERE GROUPID=2;

#QUESTION 18:
SELECT G.GROUPID,G.GROUPNAME,COUNT(GA.GROUPID) AS NUM_OF_EMPLOYEE_IN_GROUP
FROM `GROUP` AS G LEFT JOIN GROUPACCOUNT AS GA 
ON G.GROUPID = GA.GROUPID
GROUP BY G.GROUPID 
HAVING NUM_OF_EMPLOYEE_IN_GROUP > 7
UNION DISTINCT
SELECT G.GROUPID,G.GROUPNAME,COUNT(GA.GROUPID) AS NUM_OF_EMPLOYEE_IN_GROUP
FROM `GROUP`AS G LEFT JOIN GROUPACCOUNT AS GA 
ON G.GROUPID = GA.GROUPID
GROUP BY G.GROUPID 
HAVING NUM_OF_EMPLOYEE_IN_GROUP < 5;