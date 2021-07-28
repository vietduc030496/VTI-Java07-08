/*Question 1*/

DROP TRIGGER IF EXISTS trigger_create_Time;

DELIMITER //
	CREATE TRIGGER  trigger_create_Time
    BEFORE INSERT ON `group`
    FOR EACH ROW
    BEGIN
		IF NEW.createDate > date_add(now(),interval 365 day) THEN
			signal sqlstate '45000'
			SET message_text ='Khong duoc insert quá 1 năm từ thời gian hiện tại'; 
		END IF;
    END //
DELIMITER ;
INSERT INTO `group`(GroupName, CreatorID, CreateDate)
VALUES ('Groupnew', 2,"2022-11-11");
SELECT * FROM `group`;
/*================================================================================================================================*/
/*Question 2*/
DROP TRIGGER IF EXISTS trigger_create_Department_Sale;

DELIMITER //
	CREATE TRIGGER  trigger_create_Department_Sale
    BEFORE INSERT ON `account`
    FOR EACH ROW
    BEGIN
		DECLARE IDsale INT;
		SET @IDsale = 0;
		select departmentID into @IDsale
        from department
        where DepartmentName = 'Sale' limit 1;
		IF NEW.DepartmentID = @IDsale THEN
			signal sqlstate '45000'
			SET message_text ='Department "Sale" cannot add more user'; 
		END IF;
    END //
DELIMITER ;
INSERT INTO `ACCOUNT`(EMAIL,USERNAME,FULLNAME,DEPARTMENTID,POSITIONID,CREATEDATE) VALUES("AC10@GMAIL.COM", "AC10","A C VAN 10",1,3,"2021-07-24");
/*================================================================================================================================*/
/*Question 3 */ 
DROP TRIGGER IF EXISTS trigger_create_user_Of_group;

DELIMITER //
	CREATE TRIGGER  trigger_create_user_Of_group
    BEFORE INSERT ON `groupaccount`
    FOR EACH ROW
    BEGIN
		IF NEW.GroupID IN (	SELECT GroupID 
							FROM groupaccount
							GROUP BY GroupID
							HAVING COUNT(GroupID) >= 5
						) THEN
			signal sqlstate '45000'
			SET message_text ='Số account thuộc group đến giới hạn'; 
		END IF;
    END //
DELIMITER ;
INSERT INTO GROUPACCOUNT(GROUPID,ACCOUNTID,JOINDATE) VALUES(5, 2,"2020-09-10");
INSERT INTO GROUPACCOUNT(GROUPID,ACCOUNTID,JOINDATE) VALUES(5, 3,"2020-09-10");
INSERT INTO GROUPACCOUNT(GROUPID,ACCOUNTID,JOINDATE) VALUES(5, 4,"2020-09-10");
INSERT INTO GROUPACCOUNT(GROUPID,ACCOUNTID,JOINDATE) VALUES(5, 5,"2020-09-10");
INSERT INTO GROUPACCOUNT(GROUPID,ACCOUNTID,JOINDATE) VALUES(5, 7,"2020-09-10");
INSERT INTO GROUPACCOUNT(GROUPID,ACCOUNTID,JOINDATE) VALUES(5, 6,"2020-09-10");
/*================================================================================================================================*/
/*Question 4*/
DROP TRIGGER IF EXISTS trigger_max_question_Of_exam;

DELIMITER //
	CREATE TRIGGER  trigger_max_question_Of_exam
    BEFORE INSERT ON `examquestion`
    FOR EACH ROW
    BEGIN
		DECLARE amount INT default(
			select count(new.ExamID) 
            from examquestion
            group by ExamID limit 1);
		IF amount >10 THEN
			signal sqlstate '45000'
			SET message_text ='Số question thuộc exam đến giới hạn'; 
		END IF;
    END //
DELIMITER ;
INSERT INTO EXAMQUESTION(EXAMID,QUESTIONID) VALUES(5, 2);
/*================================================================================================================================*/
/*Question 5*/
DROP TRIGGER IF EXISTS trigger_delete_gmail;

DELIMITER //
	CREATE TRIGGER  trigger_delete_gmail
    BEFORE delete ON `account`
    FOR EACH ROW
    BEGIN
		IF old.email ='admin@gmail.com' THEN
			signal sqlstate '45000'
			SET message_text ='tài khoản admin không thể xóa'; 
		END IF;
    END //
DELIMITER ;
DELETE FROM `account` 
WHERE		A.email =  "a6@gmail.com";
/*================================================================================================================================*/
/*Question 6 */
DROP TRIGGER IF EXISTS trigger_create_account_department_auto;

DELIMITER //
	CREATE TRIGGER  trigger_create_account_department_auto
    BEFORE insert ON `account`
    FOR EACH ROW
    BEGIN
		IF isnull(new.departmentID)  THEN
			SET new.departmentID ='6'; 
		END IF;
    END //
DELIMITER ;
INSERT INTO `ACCOUNT`(EMAIL,USERNAME,FULLNAME,POSITIONID,CREATEDATE) VALUES("AC11@GMAIL.COM", "AC11","A C VAN 11",3,"2021-07-24");
/*================================================================================================================================*/
/*Question 7 - rơi vào elseif là không nhập được nữa*/
DROP TRIGGER IF EXISTS trigger_max_answer_of_question;

DELIMITER //
	CREATE TRIGGER  trigger_max_answer_of_question
    BEFORE INSERT ON `answer`
    FOR EACH ROW
    BEGIN
		IF  NEW.QuestionID IN (	SELECT A.QuestionID 
								FROM answer A
								GROUP BY A.questionID
								HAVING COUNT(A.QuestionID) >= 4) THEN
			signal sqlstate '45000'
			SET message_text ='Số answer thuộc question đến giới hạn'; 
		elseif  NEW.QuestionID IN (	SELECT A.QuestionID 
									FROM answer A
									where A.isCorrect = 1
									GROUP BY A.QuestionID
									HAVING COUNT(A.QuestionID) >= 2) then
			signal sqlstate '45000'
			SET message_text ='Số answer true thuộc question đến giới hạn'; 
		END IF;
    END //
DELIMITER ;
INSERT INTO answer(CONTENT,QUESTIONID,ISCORRECT) VALUES("CONTENT 11111", 4, true);
INSERT INTO answer(CONTENT,QUESTIONID,ISCORRECT) VALUES("CONTENT A11123", 3, false);
/*================================================================================================================================*/
/*Question 8*/
ALTER TABLE `Account`
ADD gender varchar(50);
DROP TRIGGER IF EXISTS trigger_autofix_gender_Account;

DELIMITER //
	CREATE TRIGGER  trigger_autofix_gender_Account
    BEFORE insert ON `account`
    FOR EACH ROW
    BEGIN
		IF new.gender = 'nam'  THEN
			SET new.gender ='M'; 
		elseIF new.gender = 'nữ'  THEN
			SET new.gender ='F'; 
		else  
			SET new.gender ='U'; 
		END IF;
    END //
DELIMITER ;
INSERT INTO `ACCOUNT`(EMAIL,USERNAME,FULLNAME,DEPARTMENTID,POSITIONID,CREATEDATE,gender) VALUES("AC131@GMAIL.COM", "AC113","A C VAN 131",5,5,"2021-07-24", 'ko biết');
/*================================================================================================================================*/
/*Question 9*/
DROP TRIGGER IF EXISTS trigger_delete_exam_2day;

DELIMITER //
	CREATE TRIGGER  trigger_delete_exam_2day
    BEFORE delete ON `exam`
    FOR EACH ROW
    BEGIN
		IF  0 < date_sub(CURDATE(),interval 2 day)- old.createDate THEN
			signal sqlstate '45000'
			SET message_text ='Không thể xóa bài thi'; 
		END IF;
    END //
DELIMITER ;
delete from `exam`
where createDate = '2021-07-21';
/*================================================================================================================================*/
/*Question 10*/
DROP TRIGGER IF EXISTS trigger_delete_question;

DELIMITER //
	CREATE TRIGGER  trigger_delete_question
    BEFORE delete ON `question`
    FOR EACH ROW
    BEGIN
		IF old.questionID = (select questionID
							  from examquestion
                              group by QuestionID limit 1) THEN
			signal sqlstate '45000'
			SET message_text ='Question tồn tại trong exam, không thể xóa'; 
		END IF;
    END //
DELIMITER ;
DELETE FROM `question`
WHERE		Q.QuestionID =  "4";
/*---------------------------------------------------------------------*/
DROP TRIGGER IF EXISTS trigger_update_question;

DELIMITER //
	CREATE TRIGGER  trigger_update_question
    BEFORE update ON `question`
    FOR EACH ROW
    BEGIN
		IF old.questionID = (select questionID
							  from examquestion
                              group by QuestionID limit 1) THEN
			signal sqlstate '45000'
			SET message_text ='Question tồn tại trong exam, không thể sửa'; 
		END IF;
    END //
DELIMITER ;
UPDATE question
SET content = "GG content dai qua"
WHERE questionID =4;
/*================================================================================================================================*/
/*Question 12*/
select *, 
case 
	when E.Duration -'30' <= 0 then 'Short time'
    when E.Duration -'60' <= 0 and E.Duration-'30' > 0 then 'Medium time'
    when E.Duration- '60' > 0  then 'Long time'
    ELSE 'Unknow'
end as `Time`
from `exam` E;
/*================================================================================================================================*/
/*Question 13*/
select GA.GroupID, count(*) as So_Luong,
case 
	when (select count(*)
		  from groupaccount GR
          where GR.GroupID = GA.GroupID) <= 5 then 'Few'
    when (select count(*)
		  from groupaccount GR
          where GR.GroupID = GA.GroupID) <= 20 and
          (select count(*)
		  from groupaccount GR
          where GR.GroupID = GA.GroupID) >5 then 'Normal'
   when (select count(*)
		  from groupaccount GR
          where GR.GroupID = GA.GroupID) >20 then 'Higher'
end as The_number_user_amount
from `groupaccount` GA
group by GA.groupID;
/*================================================================================================================================*/
/*Question 14*/
SELECT dept.departmentID,
CASE
	WHEN NOT EXISTS (SELECT 1 
					 FROM `account` AS acc1
                     WHERE acc1.departmentID = dept.departmentID)
			THEN "Khong co User"
		ELSE COUNT(acc.DepartmentID)
END The_number_user_of_Department
FROM department AS dept 
LEFT JOIN `account` AS acc ON 
	dept.departmentID = acc.departmentID
GROUP BY dept.departmentID;
