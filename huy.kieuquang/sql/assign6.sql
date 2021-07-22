use assign12;

-- q1
drop procedure if exists acc_of_dept

DELIMITER $$	
CREATE PROCEDURE acc_of_dept(IN dept_name varchar(255))
	BEGIN
		SELECT *
        FROM accounts acc
        left JOIN department dept
        ON acc.departmentID = dept.departmentID
        WHERE dept.DepartmentName = dept_name;
    END$$
DELIMITER ;

call acc_of_dept ('sale');	

-- q2
drop procedure if exists get_quantity_acc

DELIMITER $$	
CREATE PROCEDURE get_quantity_acc()
	BEGIN
		SELECT ga.groupID ,count(ga.accountID)
        FROM groupaccount ga
        group by ga.groupID;
    END$$
DELIMITER ;

call get_quantity_acc();

-- q3
drop procedure if exists statistic_typeQuest

DELIMITER $$	
CREATE PROCEDURE statistic_typeQuest()
	BEGIN
		SELECT  tq.typeName, count(q.typeID) 
        FROM question q
        RIGHT JOIN typequestion tq
		ON tq.typeID = q.typeID
        AND MONTH(q.createDate) = MONTH(now())
        GROUP BY tq.typeID;
    END$$
DELIMITER ;

call statistic_typeQuest();

-- q4
drop procedure if exists get_typeQuestion

DELIMITER $$	
CREATE PROCEDURE get_typeQuestion(OUT out_id_typeQ int)
	BEGIN
		select tq.typeID into out_id_typeQ
		from typequestion tq
		join question q 
		on tq.typeID = q.typeID
		group by tq.typeID
		having count(q.typeID) = (	select max(countTypeID) from
									(select count(q.typeID) as countTypeID
										from typequestion tq
										join question q 
										on tq.typeID = q.typeID
										group by tq.typeID	) as MaxContent );
    END$$
DELIMITER ;

set @typeID = '';
call get_typeQuestion(@typeID);
select @typeID;

-- q5
select tq.typeName
from typequestion tq
where tq.typeID = @typeID;

-- q6
drop procedure if exists get_group

DELIMITER $$	
CREATE PROCEDURE get_group(IN gr_name varchar(255))
	BEGIN
		SELECT  *
        FROM groupp g
        WHERE g.groupName = gr_name;
    END$$
DELIMITER ;

call get_group('gr1');

-- q7
drop procedure if exists create_acc

DELIMITER $$	
CREATE PROCEDURE create_acc(IN full_name varchar(255), IN email varchar(255))
	BEGIN
		INSERT INTO `assign12`.`accounts` (`email`, `username`, `fullname`, `departmentID`, `positionID`, `createDate`) 
        VALUES (email, trim('@gmail.com' from email), full_name, 6, 1, current_date());
        SELECT 'CREATE SUCESS' as Message;
    END$$
DELIMITER ;

call create_acc('test','test123@gmail.com');

-- q8
drop procedure if exists statistic_longest_content

DELIMITER $$	
CREATE PROCEDURE statistic_longest_content(IN type_name varchar(255))
	BEGIN
		SELECT tq.typeName, q.questionID, q.content , char_length(q.content) as length_content
        FROM typequestion tq
        JOIN question q
        ON tq.typeID = q.typeID
        WHERE tq.typeName = type_name
        GROUP BY q.questionID
        ORDER BY length_content desc
        limit 1;
    END$$
DELIMITER ;

call statistic_longest_content('Multiple-Choice');
-- Multiple-Choice
-- Essay

-- q9
drop procedure if exists delete_exam_byID

DELIMITER $$	
CREATE PROCEDURE delete_exam_byID(IN exam_id int)
	BEGIN
		DELETE FROM exam e
        WHERE e.examID = exam_id;
    END$$
DELIMITER ;

call delete_exam_byID(11);

-- q10
drop procedure if exists delete_exam_3yearsAgo

DELIMITER $$	
CREATE PROCEDURE delete_exam_3yearsAgo()
	BEGIN
		-- count record in examquestion equalwith exam by ID
		select count(eq.examID) as Record_deleted
		from exam e
		join examquestion eq
		on e.examID = eq.examID
		where e.examID in (select e.examID
		from exam e
		where year(e.createDate) = year(current_date()) - 3);
        
		-- delete list examID in 3 years ago of examquestion
		SET sql_safe_updates = 0;
		delete from examquestion eq
		where eq.examID in (select listID.examID
							from (
								select distinct eq.examID
								from exam e
								join examquestion eq
								on e.examID = eq.examID
								where e.examID in (select e.examID
													from exam e
													where year(e.createDate) = year(current_date()) - 3) )as listID);
		SET sql_safe_updates = 1;
		
        -- delete exam 3 years ago
        SET sql_safe_updates = 0;
		DELETE FROM exam e
        where year(e.createDate) = year(current_date()) -3;
        SET sql_safe_updates = 1;
    END$$
DELIMITER ;

-- INSERT INTO `assign12`.`exam` (`code`, `title`, `categoryID`, `duration`, `creatorID`, `createDate`) VALUES ('c11', 'aa', '8', '120', '5', '2018-12-20');
-- INSERT INTO `assign12`.`exam` (`code`, `title`, `categoryID`, `duration`, `creatorID`, `createDate`) VALUES ('c12', 'aa', '8', '120', '5', '2018-12-10');
call delete_exam_3yearsAgo();

-- q11
drop procedure if exists delete_depart_byName

DELIMITER $$	
CREATE PROCEDURE delete_depart_byName(IN dept_name varchar(255))
	BEGIN
		UPDATE accounts acc
        SET acc.departmentID = 6
        WHERE acc.departmentID = (SELECT getID.departmentID
								FROM(
									SELECT DISTINCT dept.departmentID
									FROM accounts acc
									LEFT JOIN department dept
									ON dept.departmentID = acc.departmentID
									WHERE dept.departmentName = dept_name ) AS getID);
                                    
		SET sql_safe_updates = 0;
		DELETE FROM department d
        WHERE d.departmentName = dept_name;
        SET sql_safe_updates = 1;
    END$$
DELIMITER ;

-- create test depart with test account 
call delete_depart_byName('test');

-- q12
drop procedure if exists statistic_question_per_month

DELIMITER $$	
CREATE PROCEDURE statistic_question_per_month()
	BEGIN
		SELECT distinct month(q.createDate) as `Month`, count(q.questionID) as Question_Quantity
        FROM question q
        WHERE year(q.createDate) = year(current_date())
        group by month(q.createDate);
    END$$
DELIMITER ;

call statistic_question_per_month();

-- q13
drop procedure if exists question_last6Months;

DELIMITER $$	
CREATE PROCEDURE question_last6Months()
	BEGIN 
        declare n int;
        declare current_month int;
        
        set n = 6;
        set current_month = month(current_date());
        
        while(n>0) do
            insert into temp values (current_month, null);
            SET current_month = current_month - 1;
			SET  n = n - 1; 
        end while;
        
        set n = 6;
        set current_month = month(current_date());
        while(n>0) do
			SET SQL_SAFE_UPDATES = 0;
            update temp
            set quantity_created = (select Counted.Question_Quantity
									from(
									select q.questionID, month(q.createDate) as `Month`, count(q.questionID) as Question_Quantity
									from question q
									where month(q.createDate) = current_month
									group by month(q.createDate) ) as Counted)
			where temp.month = current_month;
            SET SQL_SAFE_UPDATES = 1;
                                    
			SET current_month = current_month -1;
			SET  n = n - 1; 
        end while;
        
		set n = 6;
        set current_month = month(current_date());
        while(n>0) do
			SET SQL_SAFE_UPDATES = 0;
            update temp
            set quantity_created = 'Khong co cau hoi nao trong thang'
			where temp.quantity_created is null;
            SET SQL_SAFE_UPDATES = 1;
                                    
			SET  n = n - 1; 
        end while;
    END$$
DELIMITER ;

drop temporary table if exists temp;
create temporary table temp(`month` int, quantity_created varchar(255));
call question_last6Months();
select * from temp;





	