#Question 1: Tao trigger khong cho phep nguoi dung nhap vao group co ngay tao truoc 1 nam truoc
INSERT INTO `group` (createDate)
VALUES		("2022-11-11");

DROP TRIGGER IF EXISTS trigger_unallow_user_create_date;
DELIMITER $$
	CREATE TRIGGER trigger_unallow_user_create_date
    BEFORE INSERT ON `group`
    FOR EACH ROW
    BEGIN
		IF NEW.CreateDate < DATE_SUB(CURDATE(), INTERVAL 1 YEAR) THEN
			SIGNAL SQLSTATE "45000"
            SET MESSAGE_TEXT = "Unallow!! Please try again";
        END IF;
    END $$
DELIMITER ;

#Question 2 : Tao trigger khong cho phep them user vao dept "Sale", khi them hien thong bao 
INSERT INTO `account`(username, departmentID)
VALUES		("Hieunguyen",1);
DROP TRIGGER IF EXISTS trigger_no_add_user;
DELIMITER $$
	CREATE TRIGGER  trigger_no_add_user
    BEFORE INSERT ON `account` 
    FOR EACH ROW
    BEGIN
		IF NEW.departmentID = 1 THEN
			SIGNAL SQLSTATE	'45000'
			SET message_text ='Department Sale cannot add more user';
		END IF;
    END $$
DELIMITER ;

#Question 3 : Cau hinh 1 group co nhieu nhat la 5 user
DROP TRIGGER IF EXISTS trigger_max_Account;
DELIMITER $$
    CREATE TRIGGER trigger_max_Account
    BEFORE INSERT ON groupaccount
    FOR EACH ROW
    BEGIN
        DECLARE counters int DEFAULT(SELECT count(*) FROM groupaccount AS ga
									WHERE NEW.groupID = ga.groupID
									GROUP BY groupID
                                    );
        IF counters = 5 THEN 
            SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = "Max 5 user each group";
        END IF;
    END $$
DELIMITER ;
SELECT * FROM groupaccount ;
INSERT INTO groupaccount VALUES (2,3,"2021-11-11");

#Question 4 : Cau hinh 1 bai thi co nhieu nhat la 10 question
DROP TRIGGER IF EXISTS trigger_max_question;
DELIMITER $$
    CREATE TRIGGER trigger_max_question
    BEFORE INSERT ON examquestion
    FOR EACH ROW
    BEGIN
        DECLARE counters int DEFAULT(SELECT count(*) FROM examquestion AS eq
									WHERE NEW.examID = eq.examID
									GROUP BY examID
                                    );
        IF counters = 10 THEN 
            SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = "Max 10 questions each exam";
        END IF;
    END $$
DELIMITER ;
SELECT * FROM examquestion ;
INSERT INTO examquestion VALUES (1,3);

#Question 5: Tao trigger khong cho phep nguoi dung xoa tai khoan co email "admin@gmail.com", con lai thi co the xoa
DROP TRIGGER IF EXISTS trigger_disallow_delete;
DELIMITER $$
    CREATE TRIGGER trigger_disallow_delete
    BEFORE DELETE ON `account`
    FOR EACH ROW
    BEGIN
		IF OLD.email ="admin@gmail.com" THEN
            SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = "This is admin's account. You can't delete";
        END IF;
    END $$
DELIMITER ;
DELETE FROM `account` AS acc
WHERE		acc.email =  "admin@gmail.com";

#Question 6: tạo trigger cho phép người dùng khi tạo account không điền vào departmentID thì sẽ được phân vào phòng ban "phong cho"
DROP TRIGGER IF EXISTS trigger_deparment_auto;
DELIMITER $$
    CREATE TRIGGER trigger_deparment_auto
    BEFORE INSERT ON `account`
    FOR EACH ROW
    BEGIN
		IF isnull(NEW.departmentID) THEN
            SET  NEW.departmentID = 6;
        END IF;
    END $$
DELIMITER ;

INSERT INTO `account`(accountID, email, username, fullname, gender, positionID, createDate) 
VALUES (null, 'hieudepzai@gmail.com', 'hieudepzai', 'hieunguyen',"M",3,'2021-07-23');

#Question 7:Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi question, trong đó có tối đa 2 đáp án đúng
#Cau nay chua toi uu
DROP TRIGGER IF EXISTS trigger_max_answers;
DELIMITER $$
    CREATE TRIGGER trigger_max_answers
    BEFORE INSERT ON `answer`
    FOR EACH ROW
    BEGIN
		DECLARE counters int DEFAULT(SELECT count(*) FROM answer AS a
									WHERE NEW.questionID = a.questionID
									GROUP BY questionID
                                    );
        IF counters = 4 THEN 
            SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = "Max 4 answers each question";
        END IF;
    END $$
DELIMITER ;
SELECT * FROM answer;
INSERT INTO answer VALUES (NULL,"C",3,FALSE);


#Question 8: Viết trigger sửa lại dữ liệu cho đúng: nếu người dùng nhập vào gender của account là nam nữ,
#chưa xác định thì sẽ đổi lại thành M, F, U cho giống với hình ở database
DROP TRIGGER IF EXISTS trigger_update_data;
DELIMITER $$
    CREATE TRIGGER trigger_update_data
    BEFORE INSERT ON `account`
    FOR EACH ROW
    BEGIN
	#	UPDATE	`account`
		SET NEW.gender = CASE NEW.gender
        WHEN "nam" 	THEN "M"
        WHEN "nu"	THEN "N"
        ELSE "U"
        END;
    END $$
DELIMITER ;
INSERT INTO `account` VALUES(NULL,"tranmanhthang@gmail.com","thangtran","trananhthang","nam",2,1,"2021-11-11");
Select * from `account`;

#Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày, chua chay
DROP TRIGGER IF EXISTS trigger_unallow_delete;
DELIMITER $$
	CREATE TRIGGER trigger_unallow_delete
    BEFORE DELETE ON exam
    FOR EACH ROW
    BEGIN
		IF date_add(OLD.createDate, INTERVAL 2 DAY) > NOW() THEN
            SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = "You can't delete this exam !!!";
        END IF;
    END $$
DELIMITER ;
select * from exam;
DELETE FROM exam
WHERE createDate = "2021-07-24";	

#question 10:Người dùng chỉ được update, delete các question khi question đó chưa nằm trong exam nào
DROP TRIGGER IF EXISTS trigger_unallow_delete_question;
DELIMITER $$
	CREATE TRIGGER trigger_unallow_delete_question
    BEFORE DELETE ON question
    FOR EACH ROW
    BEGIN
		IF EXISTS (	SELECT *
					FROM 		question AS q 
					INNER JOIN	examquestion AS eq
                    ON			q.questionID = eq.questionID	
                    WHERE		OLD.questionID = eq.questionID) 
			THEN
            SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = "You can't delete this exam !!!";
        END IF;
    END $$
DELIMITER ;
select * from examquestion;
select * from question;
DELETE FROM question
WHERE question.questionID = "1";

#question 12:Lấy ra thông tin exam :
# duration <= 30(0.5) --> "Short time"
# 30(0.5)< duration <= 60(1.0) -->"Medium time"
# duration > 60(1.0) --> "Long time"

SELECT 		*,
CASE		
	WHEN		duration <=	0.5 					THEN 	"Short time"
	WHEN		0.5 < duration AND duration <= 1.0 	THEN 	"Medium time"
	WHEN		duration >1.0						THEN	"Long time"
	ELSE		"Unknow"
END			`time`
FROM		exam;


#Question 13: thong ke acc trong moi group 
SELECT ga.groupID, COUNT(*) AS num_of_acc,
	CASE 
		WHEN (	SELECT 		COUNT(*) 
				FROM 		groupaccount AS ga1
				WHERE 		ga1.groupID = ga.groupID) <= 5 
			THEN "few"
		WHEN (	SELECT 		COUNT(*) 
				FROM 		groupaccount AS ga1
				WHERE 		ga1.groupID = ga.groupID) >5 
                AND 
            (	SELECT 		COUNT(*) 
				FROM 		groupaccount AS ga1
				WHERE 		ga1.groupID = ga.groupID) <= 20
			THEN "normal"
		WHEN (	SELECT 		COUNT(*) 
				FROM 		groupaccount AS ga1
				WHERE 		ga1.groupID = ga.groupID) > 20
            THEN "higher"
	END 	num_user
FROM 		groupaccount AS ga
GROUP BY 	ga.groupID;

#Question 14 :Thong ke moi phong ban co bao nhieu user, khong co user thi tu 0-->khong co user
SELECT dept.departmentID, 
CASE
		WHEN NOT EXISTS (SELECT 		1 
						FROM 			`account` AS acc1
						WHERE 			acc1.departmentID = dept.departmentID)
			THEN "Khong co User"
		ELSE "Deu co User"
END 		num_user_of_dept
FROM 		department AS dept 
LEFT JOIN 	`account` AS acc 
ON 			dept.departmentID = acc.departmentID
GROUP BY 	dept.departmentID;




