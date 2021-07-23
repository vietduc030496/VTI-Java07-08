-- Q1
DROP PROCEDURE IF EXISTS input_dept;
DELIMITER //
CREATE PROCEDURE input_dept(IN department_name VARCHAR(45)) 
	BEGIN
		SELECT *
        FROM `account` acct
		INNER JOIN (
			SELECT * 
            FROM (
				SELECT d.DepartmentID, d.DepartmentName
                FROM `account` a
				INNER JOIN `department` d ON d.DepartmentID = a.DepartmentID 
                GROUP BY d.DepartmentName, d.DepartmentID
			) AS tb1
            WHERE tb1.DepartmentName = department_name
		) AS tb2 ON tb2.DepartmentID = acct.DepartmentID;
    END//
DELIMITER ;
-- use
CALL input_dept ('Sale');
SELECT *;

-- Q2
DROP PROCEDURE IF EXISTS get_number_of_employee_each_group;
DELIMITER //
CREATE PROCEDURE get_number_of_employee_each_group()
	BEGIN
		SELECT g.GroupID, g.GroupName, count(g.GroupID) as 'So luong'
        FROM `group` g
		INNER JOIN groupaccount ga ON ga.GroupID = g.GroupID
		GROUP BY g.GroupID;
    END//
DELIMITER ;
-- use
CALL get_number_of_employee_each_group();
SELECT *;

-- Q3
DROP PROCEDURE IF EXISTS statistic_question;
DELIMITER //
CREATE PROCEDURE statistic_question(IN this_month VARCHAR(4))
BEGIN
	SELECT tq.TypeID, tq.TypeName, count(tq.TypeID) as 'So luong'
	FROM `typequestion` tq 
	INNER JOIN `question` q ON tq.TypeID = q.TypeID AND MONTH(q.CreateDate) = this_month
	GROUP BY q.TypeID;
END//
DELIMITER ;
-- use
CALL statistic_question('04');
SELECT *;

-- Q4
DROP PROCEDURE IF EXISTS type_question_max;
DELIMITER //
CREATE PROCEDURE type_question_max(OUT type_id_max INT)
BEGIN
	SELECT q.TypeID INTO type_id_max
	FROM `question` q
	GROUP BY q.TypeID
	ORDER BY COUNT(q.TypeID) DESC
	LIMIT 1;
END//
DELIMITER ;
-- use
SET @type_id_max = '';
CALL type_question_max(@type_id_max);
SELECT @type_id_max LIMIT 1;

-- Q5
DROP PROCEDURE IF EXISTS name_question_max;
DELIMITER //
CREATE PROCEDURE name_question_max()
BEGIN
	SET @type_id_max = '';
    CALL type_question_max(@type_id_max);
    SELECT TQ.TypeName
    FROM `typequestion` tq 
    WHERE tq.TypeID IN (
		SELECT @type_id_max
    );
END//
DELIMITER ;
-- use
CALL name_question_max();
SELECT *;

-- Q6
DROP PROCEDURE IF EXISTS str_group_or_name;
DELIMITER //
CREATE PROCEDURE str_group_or_name(IN str VARCHAR(45))
BEGIN 
	SELECT g.GroupName
    FROM `group` g
    WHERE g.GroupName LIKE concat('%', str, '%')
    UNION
    SELECT a.Fullname
    FROM `account` a
    WHERE a.Fullname LIKE concat('%', str, '%');
END//
DELIMITER ;
-- use
CALL str_group_or_name('sa');
SELECT *;

-- Q7
DROP PROCEDURE IF EXISTS create_acct;
DELIMITER //
CREATE PROCEDURE create_acct(INOUT fullname VARCHAR(45), 
							 INOUT email VARCHAR(45), 
                             OUT username VARCHAR(45),
                             OUT pos_id INT,
                             OUT dept_id INT)
BEGIN
	SET username = (SELECT SUBSTRING_INDEX(email, '@', 1));
	SET	pos_id = (
		SELECT p.PositionID 
        FROM `position` p 
        WHERE p.PositionName = 'Dev'
	);
	SET dept_id = (
		SELECT d.DepartmentID 
        FROM `department` d 
        WHERE d.DepartmentName = 'default'
	);
END//
DELIMITER ;
-- use
SET @fullname = 'Pham Van Tuan';
SET @email = 'tuanpv2406@gmail.com';
SET @username = '', @pos_id = '', @dept_id = '';
CALL create_acct(@fullname, @email, @username, @pos_id, @dept_id);
SELECT @username, @pos_id, @dept_id;

-- Q8
DROP PROCEDURE IF EXISTS longgest_content;
DELIMITER //
CREATE PROCEDURE longgest_content(IN type_name VARCHAR(45))
BEGIN
	SELECT fil.Content 
    FROM (
		SELECT q.*
		FROM `question` q
		INNER JOIN `typequestion` tq ON q.TypeID = tq.TypeID
		WHERE tq.TypeName = type_name
	) as fil
    ORDER BY length(fil.Content) DESC
    LIMIT 1;
END//
DELIMITER ;
-- use
SET @type_name = 'Multiple-Choice';
CALL longgest_content(@type_name);
SELECT *;

-- Q9
DROP PROCEDURE IF EXISTS delete_exam_by_id;
DELIMITER //
CREATE PROCEDURE delete_exam_by_id(IN exam_id INT)
BEGIN
	DECLARE exam_table_row INT DEFAULT 0;
	DECLARE exam_question_table_row INT DEFAULT 0;
	DELETE
	FROM	`examquestion` eq
	WHERE 	eq.ExamID = exam_id;    
	SET exam_question_table_row = (SELECT ROW_COUNT());
	DELETE
	FROM	`exam` e
	WHERE 	e.ExamID = exam_id;
	SET exam_table_row = (SELECT ROW_COUNT());
END//
DELIMITER ;
-- use
SET @exam_id = 1;
CALL delete_exam_by_id(@exam_id);

-- Q10
DROP PROCEDURE IF EXISTS delete_exam_follow_year;
DELIMITER //
CREATE PROCEDURE delete_exam_follow_year(IN year_exam VARCHAR(45), OUT exam_id INT)
	BEGIN
		SELECT e.ExamID INTO exam_id
        FROM `exam` e
        WHERE e.CreateDate like CONCAT(year_exam,'%')
        LIMIT 1;
	END//
DELIMITER ;
-- use
SET 	@exam_id = '';
CALL 	delete_exam_follow_year('2020',@exam_id);
CALL	delete_exam_by_id(@exam_id);
SELECT ROW_COUNT() as 'SL record bi xoa';

-- Q11
DROP PROCEDURE IF EXISTS delete_department;
DELIMITER //
CREATE PROCEDURE delete_department(IN dept_name VARCHAR(45))
	BEGIN
		DECLARE dept_id INT DEFAULT (
			SELECT d.DepartmentID 
            FROM `department` d 
            WHERE d.DepartmentName = dept_name
		);
        DECLARE dept_id_default INT DEFAULT (
			SELECT d.DepartmentID 
            FROM `department` d 
            WHERE d.DepartmentName = 'default'
		);
        
		UPDATE `account` a
        SET	a.DepartmentID = dept_id_default
        WHERE a.DepartmentID = dept_id;
        
        DELETE 	
        FROM `department` d
        WHERE d.DepartmentID = dept_id;
	END//
DELIMITER ;
-- use
CALL delete_department("Marketing");

-- Q12
DROP PROCEDURE IF EXISTS question_created_per_month;
DELIMITER //
CREATE PROCEDURE question_created_per_month()
	BEGIN
		SELECT MONTH(q.CreateDate) 'Thang', count(q.QuestionID) 'So luong'
		FROM `question` q
		WHERE YEAR(q.CreateDate) = YEAR(CURDATE())
		GROUP BY MONTH(q.CreateDate)
        ORDER BY MONTH(q.CreateDate);
	END//
DELIMITER ;
-- use
CALL question_created_per_month();
SELECT *;

-- Q13
DROP PROCEDURE IF EXISTS count_question_by_6_month;
DELIMITER //
CREATE PROCEDURE count_question_by_6_month()
	BEGIN	
		SELECT MONTH(q.CreateDate) 'Thang', count(q.QuestionID) 'So luong'
		FROM `question` q
        WHERE q.CreateDate >= DATE_SUB(CURDATE(),INTERVAL 6 MONTH)
		GROUP BY MONTH(q.CreateDate)
        ORDER BY MONTH(q.CreateDate);
	END//
DELIMITER ;
-- use
CALL count_question_by_6_month();
SELECT *;