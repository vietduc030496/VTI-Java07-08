-- Q1 Tạo strore nhập vào tên phòng ban in ra danh sách account thuộc phòng ban
DROP PROCEDURE IF EXISTS list_acc_by_dpmt_name;
DELIMITER $$
CREATE PROCEDURE list_acc_by_dpmt_name(IN department_name VARCHAR(45))
	BEGIN 
		SELECT	acc.AccountID,acc.Email,acc.FullName,department_name as 'Department'
		FROM	tblaccount acc
        WHERE	acc.DepartmentID IN (
									SELECT	dpmt.DepartmentID
                                    FROM	tbldepartment dpmt
                                    WHERE	dpmt.DepartmentName = department_name
		);
	END$$
DELIMITER ;
CALL 	list_acc_by_dpmt_name('department1');

-- Q2 Tạo store in ra số lượng account trong mỗi group
DROP PROCEDURE IF EXISTS count_acc;
DELIMITER $$
CREATE PROCEDURE count_acc()
	BEGIN
		SELECT		gr.GroupName, COUNT(gr_acc.GroupID) AS 'soluong'
		FROM		tblgroup gr LEFT JOIN tblgroupaccount gr_acc ON gr.GroupID = gr_acc.GroupID
		GROUP BY	gr.GroupID;
	END$$
DELIMITER ;
CALL 	count_acc();

-- Q3 Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại
DROP PROCEDURE IF EXISTS count_question;
DELIMITER $$
CREATE PROCEDURE count_question()
	BEGIN
		SELECT		que.TypeID, COUNT(que.TypeID) AS 'soluong'
		FROM		tblquestion que
        WHERE		que.CreateDate like '2021-11-%'
		GROUP BY	que.TypeID;
	END$$
DELIMITER ;
CALL 	count_question();

-- Q4 Tạo store để trả ra id của type question có nhiều câu hỏi nhất
DROP PROCEDURE IF EXISTS count_question;
DELIMITER $$
CREATE PROCEDURE count_question(OUT type_id_max INT)
	BEGIN
		SELECT		que.TypeID INTO type_id_max
		FROM		tblquestion que
		GROUP BY	que.TypeID
		ORDER BY	COUNT(que.TypeID) DESC
		LIMIT		1;
	END$$
DELIMITER ;
SET 	@type_id_max =' ';
CALL 	count_question(@type_id_max);
SELECT 	@type_id_max;

-- Q5 Sử dụng store ở question 4 để tìm ra tên của typequestion
DROP PROCEDURE IF EXISTS question_name_by_id;
DELIMITER $$
CREATE PROCEDURE question_name_by_id()
	BEGIN
		SET 		@type_id_max =' ';
		CALL 		count_question(@type_id_max);
		SELECT		*
		FROM		tbltypequestion type_que
		WHERE		type_que.TypeID in (
											SELECT 	@type_id_max
		);
	END$$
DELIMITER ;
CALL question_name_by_id();

-- Q6 Trả về group or fullname của chuỗi nhập vào
DROP PROCEDURE IF EXISTS group_or_fullname;
DELIMITER $$
CREATE PROCEDURE group_or_fullname(IN str varchar(45))
	BEGIN
		SELECT		gr.GroupName as 'Name'
		FROM		tblgroup gr
		WHERE		gr.GroupName like CONCAT("%",str,"%")
        UNION
        SELECT		acc.FullName
		FROM		tblaccount acc
		WHERE		acc.FullName like CONCAT("%",str,"%");
	END$$
DELIMITER ;
CALL group_or_fullname('o');

-- Q7 Hiển thị thông tin từ fullname và email
DROP PROCEDURE IF EXISTS add_account;
DELIMITER $$
CREATE PROCEDURE add_account(INOUT 	inout_fullname 	varchar(45),
							 INOUT 	inout_gmail 	varchar(45),
                             OUT	out_posID 		INT,
                             OUT	out_dpmtID		INT,
                             OUT 	out_username 	varchar(45))
	BEGIN
        SET		out_posID 	=(SELECT	PositionID FROM tblposition pos WHERE pos.PositionName = 'developer');
        SET 	out_dpmtID	=(SELECT	DepartmentID FROM tbldepartment dpmt WHERE dpmt.DepartmentName = 'default');
        SET		out_username=(SELECT substring(inout_gmail,1,locate('@',inout_gmail)-1));

	END$$
DELIMITER ;
SET 	@inout_fullname = 'Nguyen Van A';
SET 	@inout_email = 'nguyenvana@gmail.com';
SET 	@out_posID = '',@out_dpmtID = '',@out_username = '';
CALL 	add_account(@inout_fullname,@inout_email,@out_posID,@out_dpmtID,@out_username);
SELECT 	@inout_fullname AS FullName,
		@inout_email 	AS Email,
        @out_username 	AS UserName,
        @out_posID 		AS PositionID,
        @out_dpmtID 	AS DepartmentID;


-- Q8 Nhập loại câu hỏi và liệt kê câu hỏi có content dài nhất
DROP PROCEDURE IF EXISTS show_question;
DELIMITER $$
CREATE PROCEDURE show_question(IN str varchar(45))
	BEGIN
		DECLARE type_id int DEFAULT (SELECT type_que.TypeID FROM tbltypequestion type_que WHERE type_que.TypeName = str);
		SELECT	*
        FROM	tblquestion que
		WHERE 	que.TypeID = type_id
        AND 	length(que.Content) = (
								SELECT	max(length(que.Content))
                                FROM	tblquestion que
                                WHERE 	que.TypeID = type_id
                                );
	END$$
DELIMITER ;
CALL show_question("Essay");

-- Q9 Xóa exam theo id
DROP PROCEDURE IF EXISTS delete_exam;
DELIMITER $$
CREATE PROCEDURE delete_exam(IN examid int)
	BEGIN
		DECLARE row_bang_phu INT DEFAULT 0;
        DECLARE row_bang_chinh INT DEFAULT 0;
        
		DELETE
        FROM	tblexamquestion exq
        WHERE 	exq.ExamID = examid;    
        SET row_bang_phu = (SELECT ROW_COUNT());
        DELETE
        FROM	tblexam ex
        WHERE 	ex.ExamID = examid;
        SET row_bang_chinh = (SELECT ROW_COUNT());
		SELECT row_bang_phu + row_bang_chinh as count;
	END$$
DELIMITER ;
CALL delete_exam("13");

-- Q10 Tìm vào xóa các exam từ 3 năm trước, hiển thị số bản ghi bị xóa
DROP PROCEDURE IF EXISTS delete_exam_by_year;
DELIMITER $$
CREATE PROCEDURE delete_exam_by_year(IN year_exam VARCHAR(45), OUT exam_id INT)
	BEGIN
		SELECT 	ex.ExamID INTO exam_id
        FROM	tblexam ex
        WHERE 	ex.CreateDate like CONCAT(year_exam,'%')
        LIMIT 1;
	END$$
DELIMITER ;
SET 	@exam_id = '';
CALL 	delete_exam_by_year('2020',@exam_id);
CALL	delete_exam(@exam_id);

-- Q11 Xóa phòng ban và chuyển acc về phòng ban default
DROP PROCEDURE IF EXISTS delete_department;
DELIMITER $$
CREATE PROCEDURE delete_department(IN dpmt_name VARCHAR(45))
	BEGIN
		DECLARE dpmt_id INT DEFAULT (SELECT dpmt.DepartmentID FROM tbldepartment dpmt WHERE dpmt.DepartmentName = dpmt_name);
        DECLARE dpmt_id_default INT DEFAULT (SELECT dpmt.DepartmentID FROM tbldepartment dpmt WHERE dpmt.DepartmentName = 'default');
        
		UPDATE	tblaccount
        SET		tblaccount.DepartmentID = dpmt_id_default
        WHERE	tblaccount.DepartmentID = dpmt_id;
        
        DELETE 	
        FROM	tbldepartment dpmt
        WHERE 	dpmt.DepartmentID= dpmt_id;
	END$$
DELIMITER ;
CALL delete_department("department5");

-- Q12 In ra mỗi tháng có bao nhiêu câu hỏi được tạo
DROP PROCEDURE IF EXISTS count_question_by_month;
DELIMITER $$
CREATE PROCEDURE count_question_by_month()
	BEGIN
		SELECT		MONTH(que.CreateDate) as'Tháng' ,count(que.QuestionID) as 'soluong'
		FROM		tblquestion que
		WHERE		YEAR(que.CreateDate) = YEAR(CURDATE())
		GROUP BY 	MONTH(que.CreateDate)
        ORDER BY 	MONTH(que.CreateDate);
	END$$
DELIMITER ;
CALL count_question_by_month();

-- Q13 in ra số câu hỏi trong sáu tháng gần nhất
DROP PROCEDURE IF EXISTS count_question_by_6_month;
DELIMITER $$
CREATE PROCEDURE count_question_by_6_month()
	BEGIN	
		SELECT		MONTH(que.CreateDate) as'Tháng' ,count(que.QuestionID) as 'soluong'
		FROM		tblquestion que
        WHERE		que.CreateDate >= DATE_SUB(CURDATE(),INTERVAL 12 MONTH)
		GROUP BY 	MONTH(que.CreateDate)
        ORDER BY 	MONTH(que.CreateDate);
	END$$
DELIMITER ;
CALL count_question_by_6_month();