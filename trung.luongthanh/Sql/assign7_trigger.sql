use assign12;

-- q1
drop trigger if exists group_create_time

DELIMITER $$	
	CREATE TRIGGER group_create_time
	BEFORE INSERT ON groupp
    FOR EACH ROW
	BEGIN
		IF year(NEW.createDate) < year(current_date())-1 THEN
			SIGNAL SQLSTATE '12345' 
			SET MESSAGE_TEXT = 'field createDate must be more than 1 year ago from now';
		END IF;
    END$$
DELIMITER ;

-- q2
drop trigger if exists disallow_add_user

DELIMITER $$	
	CREATE TRIGGER disallow_add_user
	BEFORE INSERT ON accounts
    FOR EACH ROW
	BEGIN
		IF NEW.departmentID=1 THEN
			SIGNAL SQLSTATE '12345' 
			SET MESSAGE_TEXT = 'Department "sale" cannot add more user';
		END IF;
    END$$
DELIMITER ;

-- q3 
drop trigger if exists config_group

DELIMITER $$	
	CREATE TRIGGER config_group
	BEFORE INSERT ON groupaccount
    FOR EACH ROW
	BEGIN
		declare account_per_group int;
        
        set @account_per_group = (select count(ga.groupID) 
									from groupaccount ga
									where ga.groupID = new.groupID
									group by ga.groupID);
        
		IF @account_per_group >= 5 THEN
			SIGNAL SQLSTATE '12345' 
			SET MESSAGE_TEXT = '1 group has maximum 5 users ';
		END IF;
    END$$
DELIMITER ;

-- q4 
drop trigger if exists config_exam

DELIMITER $$	
	CREATE TRIGGER config_exam
	BEFORE INSERT ON examquestion
    FOR EACH ROW
	BEGIN
		declare question_per_exam int;
        
        set @question_per_exam = (select count(eq.examID) 
									from examquestion eq
									where eq.examID = new.examID
									group by eq.examID);
        
		IF @question_per_exam >= 10 THEN
			SIGNAL SQLSTATE '12345' 
			SET MESSAGE_TEXT = '1 exam has maximum 10 questions ';
		END IF;
    END$$
DELIMITER ;

-- q5

drop trigger if exists delete_account_relate

DELIMITER $$	
	CREATE TRIGGER delete_account_relate
	BEFORE DELETE ON accounts
    FOR EACH ROW
	BEGIN
		IF OLD.email='admin@gmail.com' THEN
			SIGNAL SQLSTATE '12345' 
			SET MESSAGE_TEXT = 'cannot delete admin account';
		END IF;
        
        -- delete eq with examID or questionID has creatorID = accountID
        SET sql_safe_updates = 0;
        DELETE eq
		FROM examquestion eq 
		JOIN exam e
		ON eq.examID = e.examID
		JOIN question q
		ON q.questionID = eq.questionID 
		WHERE e.creatorID = old.accountID OR q.creatorID = old.accountID;
        SET sql_safe_updates = 1;
        
        -- delete exam has accountID
        SET sql_safe_updates = 0;
        DELETE FROM exam e
        WHERE e.creatorID = old.accountID;
        SET sql_safe_updates = 1;
	    
        -- delete question has accountID
		SET sql_safe_updates = 0;
		DELETE FROM question q
        WHERE q.creatorID = old.accountID;
        SET sql_safe_updates = 1;
    END$$
DELIMITER ;

-- q6
drop trigger if exists config_account

DELIMITER $$	
	CREATE TRIGGER config_account
	BEFORE INSERT ON accounts
    FOR EACH ROW
	BEGIN
		IF NEW.departmentID is null THEN
			set NEW.departmentID = 6;
		END IF;
    END$$
DELIMITER ;

-- q7
drop trigger if exists config_exam

DELIMITER $$	
	CREATE TRIGGER config_exam
	BEFORE INSERT ON answer
    FOR EACH ROW
	BEGIN
		declare count_ans int;
        declare correct_ans int;
        
        set @count_ans = (select count(a.questionID)
							from answer a
                            where a.questionID = NEW.questionID
							group by a.questionID );
                            
        set @correct_ans = (select count(a.isCorrect)
							from answer a
							where a.questionID = NEW.questionID
							and a.isCorrect = 1
							group by a.isCorrect);       
                            
		IF @count_ans >= 4 or @correct_ans >=2 THEN
			SIGNAL SQLSTATE '12345' 
			SET MESSAGE_TEXT = 'max limit is 4 answer and 2 correct answer per question';
		END IF;
    END$$
DELIMITER ;

-- q8 ?

-- q9
drop trigger if exists disallow_delete_exam_inLast2Days

DELIMITER $$	
	CREATE TRIGGER disallow_delete_exam_inLast2Days
	BEFORE DELETE ON exam
    FOR EACH ROW
	BEGIN
		declare time_distance int;
        
        set @time_distance = day(current_date())-day(old.createDate);
		IF @time_distance <=2 THEN
			SIGNAL SQLSTATE '12345' 
			SET MESSAGE_TEXT = 'cannot delete exam in last 2 days';
		END IF;
    END$$
DELIMITER ;

-- q10
drop trigger if exists update_question
drop trigger if exists delete_question

DELIMITER $$	
	CREATE TRIGGER delete_question
	BEFORE DELETE ON question
    FOR EACH ROW
	BEGIN
		declare exist_questionID int;
        
        set @exist_questionID= (select distinct eq.questionID
								from examquestion eq
								where eq.questionID = old.questionID);
		IF @exist_questionID is not null THEN
			SIGNAL SQLSTATE '12345' 
			SET MESSAGE_TEXT = 'question is in exam';
		END IF;
    END$$
    
    CREATE TRIGGER update_question
	BEFORE UPDATE ON question
    FOR EACH ROW
	BEGIN
		declare exist_questionID int;
        
        set @exist_questionID= (select distinct eq.questionID
								from examquestion eq
								where eq.questionID = old.questionID);
		IF @exist_questionID is not null THEN
			SIGNAL SQLSTATE '12345' 
			SET MESSAGE_TEXT = 'question is in exam';
		END IF;
    END$$
    
DELIMITER ;

-- q12
drop trigger if exists get_exam_info

DELIMITER $$	
	CREATE TRIGGER get_exam_info
	BEFORE UPDATE ON exam
    FOR EACH ROW
	BEGIN	
		IF old.duration <=30 THEN
			SET sql_safe_updates = 0;
			UPDATE exam e
            set e.duration = "Short time"
            WHERE e.examID = old.examID;
            SET sql_safe_updates = 1;
		ELSEIF old.duration > 30 AND old.duration >= 60 THEN
			SET sql_safe_updates = 0;
			UPDATE exam e
            set e.duration = "Medium time"
            WHERE e.examID = old.examID;
            SET sql_safe_updates = 1;
		ELSE 
			SET sql_safe_updates = 0;
			UPDATE exam e
            set e.duration = "Long time"
            WHERE e.examID = old.examID;
            SET sql_safe_updates = 1;
		END IF;
    END$$
DELIMITER ;

-- q13
drop PROCEDURE if exists statistic_account_per_group

DELIMITER $$	
	CREATE PROCEDURE statistic_account_per_group()

	BEGIN
		declare account_per_group int;
        declare the_number_user_amount varchar(255);
        declare quantity_group int;
        declare i int;
        
        drop temporary table if exists temp_group;
        create temporary table temp_group(groupID int, quantity_account int, the_number_user_amount varchar(255));
        
        set @quantity_group = (select count(distinct ga.groupID) 
								from groupaccount ga );
        
		set @i = 1;
		WHILE(@quantity_group > 0) do
			set @account_per_group = (select count(ga.groupID) 
							from groupaccount ga
							where ga.groupID = @i
							group by ga.groupID);
            
			IF @account_per_group  <=5 THEN
			SET @the_number_user_amount = 'few';
			ELSEIF @account_per_group > 5 AND @account_per_group <=20 THEN
				SET @the_number_user_amount = 'normal';
			ELSE
				SET @the_number_user_amount = 'higher';
			END IF;
            
			insert into temp_group values (@i, @account_per_group, @the_number_user_amount);
			set @quantity_group = @quantity_group -1;
            set @i = @i + 1;
        END WHILE;
                                    
		select * from temp_group;
    END$$
DELIMITER ;

call statistic_account_per_group();

-- q14
drop procedure if exists statistic_user_per_dept

DELIMITER $$	
CREATE PROCEDURE statistic_user_per_dept()
	BEGIN
		declare i int;
        declare quantity_dept int;
        declare user_per_dept int;
        declare user_per_dept_converted varchar(255);
        
		drop temporary table if exists temp_dept;
        create temporary table temp_dept(departmentID int, quantity_user varchar(255));
        
        set @quantity_dept = (select count(dept.departmentID)
								from department dept);
		set @i = 1;
		while(@quantity_dept > 0) do
			set @user_per_dept = (select count(acc.departmentID)
									from accounts acc
									where acc.departmentID = @i
									group by acc.departmentID);
			
            IF @user_per_dept is not null THEN
				set @user_per_dept_converted = convert(@user_per_dept, char);
            ELSE
				set @user_per_dept_converted = 'Khong co user';
			END IF;
            
            insert into temp_dept values(@i, @user_per_dept_converted);
			
            set @i = @i + 1;
			set @quantity_dept = @quantity_dept -1;
        end while;
        
        select * from temp_dept;
    END$$
DELIMITER ;

call statistic_user_per_dept();


