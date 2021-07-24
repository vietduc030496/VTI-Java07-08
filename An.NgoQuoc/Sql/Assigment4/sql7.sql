-- Q1 Tao trigger khong cho phep nguoi dung nhap vao group co ngay tao nho hon 1 nam truoc
DROP TRIGGER IF EXISTS creat_group_1_year;
DELIMITER $$
	CREATE TRIGGER creat_group_1_year
    BEFORE INSERT ON tblgroup
    FOR EACH ROW
    BEGIN
		IF NEW.CreateDate < DATE_SUB(CURDATE(), INTERVAL 1 YEAR) THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Ngay tao qua 1 nam truoc';
        END IF;
    END $$
DELIMITER ;

-- Q2 Tao trigger khong cho phep nguoi dung them user vao phong ban Sale va hien thong bao
DROP TRIGGER IF EXISTS cannot_add_in_dpmt_Sale;
DELIMITER $$
	CREATE TRIGGER cannot_add_in_dpmt_Sale
    BEFORE INSERT ON tblaccount
    FOR EACH ROW
    BEGIN
		IF NEW.DepartmentID = (	SELECT 	DepartmentID 
								FROM 	tbldepartment
                                WHERE 	DepartmentName = 'Sale' 
							  )THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Department "Sale" cannot add more user';
        END IF;
    END $$
DELIMITER ;

-- Q3 Cau hinh 1 group co nhieu nhat 5 acc
DROP TRIGGER IF EXISTS 	max_5_acc_in_gr;
DELIMITER $$
	CREATE TRIGGER 		max_5_acc_in_gr
    BEFORE INSERT ON 	tblgroupaccount
    FOR EACH ROW
    BEGIN
		IF NEW.GroupID IN (	SELECT 		GroupID 
							FROM 		tblgroupaccount
							GROUP BY 	GroupID
							HAVING		COUNT(GroupID) >= 5
						)	THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Group co toi da 5 thanh vien';
        END IF;
    END $$
DELIMITER ;

-- Q4 Cau hinh bai thi co nhieu nhat 10 cau hoi
DROP TRIGGER IF EXISTS 	max_10_que_in_exam;
DELIMITER $$
	CREATE TRIGGER 		max_10_que_in_exam
    BEFORE INSERT ON 	tblexamquestion
    FOR EACH ROW
    BEGIN
		IF NEW.ExamID IN (	SELECT 		ExamID 
							FROM 		tblexamquestion
							GROUP BY 	ExamID
							HAVING		COUNT(ExamID) >= 10
						)	THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Bai thi co toi da 10 cau hoi';
        END IF;
    END $$
DELIMITER ;

-- Q5 Khong cho phep xoa tai khoan co email admin@gmail.comcon lai xoa het cac ban lien quan
DROP TRIGGER IF EXISTS 	cannot_delete_admin;
DELIMITER $$
	CREATE TRIGGER 		cannot_delete_admin
    BEFORE DELETE ON 	tblaccount
    FOR EACH ROW
    BEGIN
		IF OLD.Email =  'admin@gmail.com' THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = "This is admin's account. You can't delete";
        END IF;
    END $$
DELIMITER ;

-- Q6 Khong nhap departmentId de mac dinh la phong cho
DROP TRIGGER IF EXISTS 	set_dpmt_if_null;
DELIMITER $$
	CREATE TRIGGER 		set_dpmt_if_null
    BEFORE INSERT ON 	tblaccount
    FOR EACH ROW
    BEGIN
		IF NEW.DepartmentID = "" THEN
			SET NEW.DepartmentID = 6;
        END IF;
    END $$
DELIMITER ;

-- Q7 Cau hinh 1 bai thi chi cho tao toi da 4 answers cho moi question, trong do co toi da 2 dap an dung
DROP TRIGGER IF EXISTS 	exam_question_answers;
DELIMITER $$
	CREATE TRIGGER 		exam_question_answers
    BEFORE INSERT ON 	tblanswer
    FOR EACH ROW
    BEGIN 
        IF NEW.QuestionID IN (	SELECT ans.QuestionID
								FROM tblanswer ans
								GROUP BY ans.QuestionID
								HAVING count(ans.QuestionID) >= 4 
							)	THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Moi cau hoi co toi da 4 cau tra loi va 2 cau tra loi dung';
		ELSEIF NEW.QuestionID IN (	SELECT ans.QuestionID
								FROM tblanswer ans
                                WHERE ans.isCorrect = 1
								GROUP BY ans.QuestionID
								HAVING count(ans.QuestionID) >= 2
							)	THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Moi cau hoi co toi da 4 cau tra loi va 2 cau tra loi dung';
		END IF;
    END $$
DELIMITER ;

-- Q8 Cau hinh gender thanh M,F,U 
DROP TRIGGER IF EXISTS 	set_gender;
DELIMITER $$
	CREATE TRIGGER 		set_gender
    BEFORE INSERT ON 	tblaccount
    FOR EACH ROW
    BEGIN
		
		IF NEW.Gender = "Nam" THEN
			SET NEW.Gender = "M";
		ELSEIF NEW.Gender = "Nu" THEN
			SET NEW.Gender = "F";
		ELSE 
			SET NEW.Gender = "U";
        END IF;
    END $$
DELIMITER ;

-- Q9 khong cho phep xoa bai thi moi tao dc 2 ngay
DROP TRIGGER IF EXISTS 	cannot_delete_exam_2day;
DELIMITER $$
	CREATE TRIGGER 		cannot_delete_exam_2day
    BEFORE DELETE ON 	tblexam
    FOR EACH ROW
    BEGIN
		IF OLD.CreateDate < DATE_SUB(CURDATE(), INTERVAL 2 DAY) THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Cannot delete exam create 2 days before';
        END IF;
    END $$
DELIMITER ;

-- Q10 khong dc xoa question da co trong de thi
DROP TRIGGER IF EXISTS 	cannot_delete_que_exist_in_exam;
DELIMITER $$
	CREATE TRIGGER 		cannot_delete_que_exist_in_exam
    BEFORE DELETE ON 	tblquestion
    FOR EACH ROW
    BEGIN
		IF OLD.QuestionID in (	SELECT 		QuestionID
								FROM 		tblexamquestion
								group by 	QuestionID
							) 	THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Unable to delete question that already exists on the exam';
        END IF;
    END $$
DELIMITER ;

-- Q11 khong dc update question da co trong de thi
DROP TRIGGER IF EXISTS 	cannot_update_que_exist_in_exam;
DELIMITER $$
	CREATE TRIGGER 		cannot_update_que_exist_in_exam
    BEFORE UPDATE ON 	tblquestion
    FOR EACH ROW
    BEGIN
		IF OLD.QuestionID in (	SELECT 		QuestionID
								FROM 		tblexamquestion
								group by 	QuestionID
							) 	THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Unable to update question that already exists on the exam';
        END IF;
    END $$
DELIMITER ;

-- Q12 Lay ra thong tin exam trong do durati <= 30 doi thanh 'short time', <60 'mediun time', >60 'long time'
DROP FUNCTION IF EXISTS set_type_duration;
DELIMITER $$
CREATE FUNCTION set_type_duration(duration INTEGER) RETURNS VARCHAR(45)
DETERMINISTIC
	BEGIN
		DECLARE type_duration VARCHAR(45) DEFAULT  "";
		IF duration <= 30 THEN
			SET type_duration = "Short time";
		ELSEIF duration <= 60 THEN
			SET type_duration = "Medium time";
		ELSE
			SET type_duration = "Long time";
		END IF;
	RETURN type_duration;
	END$$
DELIMITER ;

SELECT *,set_type_duration(Duration) as TypeDuration
FROM tblexam;

-- Q13 Thong ke so acc trong gr va in ra theo quy tac
DROP FUNCTION IF EXISTS number_user_amount;
DELIMITER $$
CREATE FUNCTION number_user_amount(count INTEGER) RETURNS VARCHAR(45)
DETERMINISTIC
	BEGIN
		DECLARE type_number VARCHAR(45) DEFAULT  "";
		IF count <= 5 THEN
			SET type_number = "few";
		ELSEIF count <= 20 THEN
			SET type_number = "normal";
		ELSE
			SET type_number = "higher";
		END IF;
	RETURN type_number;
	END$$
DELIMITER ;

SELECT 		gr.GroupName, 
			COUNT(gr_acc.GroupID) AS amount, 
			number_user_amount(COUNT(gr_acc.GroupID)) AS type_amount
FROM 		tblgroup gr LEFT JOIN tblgroupaccount gr_acc ON gr.GroupID = gr_acc.GroupID
GROUP BY 	gr.GroupID;

-- Q14 Thong ke moi phong ban co bao nhieu user neu khong co thay doi gia tri 0 thanh "khong co user"
DROP FUNCTION IF EXISTS number_user_dpmt;
DELIMITER $$
CREATE FUNCTION number_user_dpmt(count INTEGER) RETURNS VARCHAR(45)
DETERMINISTIC
	BEGIN
		DECLARE type_number VARCHAR(45) DEFAULT  "";
		IF count > 0 THEN
			SET type_number = count;
		ELSE
			SET type_number = "khong co user";
		END IF;
	RETURN type_number;
	END$$
DELIMITER ;

SELECT 		dpmt.DepartmentName, 
			number_user_dpmt(COUNT(acc.DepartmentID)) AS soluong
FROM 		tbldepartment dpmt LEFT JOIN tblaccount acc ON dpmt.DepartmentID = acc.DepartmentID
GROUP BY 	dpmt.DepartmentID;