-- question 1 : khong cho phep them nguoi dung co ngay tao truoc nam ngoai
drop trigger if exists checkCreateDateAccount ;
DELIMITER $$
	create trigger checkCreateDateAccount
	before insert on account 
	for each row
    begin 
		if new.CreateDate < DATE_SUB(CURDATE(),INTERVAL 12 MONTH) then 
			Signal sqlstate '12345'
            SET message_text='Ngay tao tu mot nam truoc khong  duoc phep ';
        end if ;
    end $$
DELIMITER ;
-- Question 2 :khong cho phep add them vao departmet sale
drop trigger if exists checkAccountOnSaleDepartment ;
DELIMITER $$    
	create trigger  checkAccountOnSaleDepartment
    before insert  on account
    for each row 
    begin 
		if new.departmentID = 1 then 
			signal sqlstate '12345'
            set message_text ='Department "Sale" cannot add more user' ;
        end if ;
    end $$
DELIMITER ;    


-- question 3 : cau hinh 1 group co nhieu nhat 5 user 

drop trigger if exists checkGroupNumber;
DELIMITER $$
	create trigger checkGroupNumber
    before insert on groupaccount
    for each row 
    begin 
		if (
			select count(*) 
			from groupaccount
			where GroupID= new.GroupID
			group by GroupID
        ) > 5 then 
			signal sqlstate '12345'
            set message_text ='group da cos hon 5 nguoi' ;
       end if ;     
	end $$
DELIMITER ;

-- 4 : cau hinh mot bai thi co nhieu nhat 10 question

drop trigger if exists limitExamQuestionNumber ;
DELIMITER $$
	create trigger limitExamQuestionNumber
	before insert on examquestion
	for each row 
    BEGIN 
		if(select count(*)
			from groupaccount
            where new.examID=examID
            group by examID
            ) > 10 then 
			signal sqlstate '12345'
            set message_text ='exam da co du 10 question0';
        end if ;
    end $$
DELIMITER ;
-- question 5 : khong cho phep xoa email admin@gmail.com

drop trigger if exists limitdeleteAdminAccount ;
DELIMITER $$
	create trigger limitdeleteAdminAccount
	before delete on account 
	for each row 
	begin
		if old.Email = 'admin@gmail.com' then 
			signal sqlstate  '12345'
            set message_text ='khong duoc xoa tai khoan admin' ;
        end if ;
    end $$
DELIMITER ;

-- question 6 : trigger mac dinh account vaof waiting departmnet alter

drop trigger if exists addDefaultDepartmnet ;
DELIMITER $$
	create trigger addDefaultDepartmnet 
	before insert on account 
    for each row  
	begin 
		if new.DepartmentID=null then
			set new.DepartmentID =1;
        end if ;
    end $$     
DELIMITER ;            
            
-- question 7 : toa 4 answer ,voi nhieu nhat 2 dap an dung 

drop trigger if exists limitAnswer;
DELIMITER $$
	create trigger limitAnswer 
    before insert on answer 
    for each row 
	begin
		if (
				select count(*)
				from answer
				where questionID = new.questionID 
				group by questionID ) >= 4 then 
			signal sqlstate '12345'
            set message_text ='1 cau hoi chi co the co 4 dap an ';
        elseif (
				select count(*)
				from answer
				where questionID = new.questionID And isCorrect =true
				group by questionID ) >= 2 and new.isCorrect =true then 
			signal sqlstate '12345'
            set message_text ='1 cau hoi chi co the co 2 dap an dung ';
		end if ;	
    end $$
DELIMITER ;

-- question 8 : fix sex to M,F,U
drop trigger if exists changeFomatSex ;
DELIMITER $$
	create trigger changeFomatSex
	before insert on account  
    for each row
	begin 
		if new.Gender ='nam'  then set new.Gender = 'N' ;
        elseif new.Gender = 'nu' then set new.Gender='F' ;
        elseif new.Gender is  NULL then set new.Gender = 'U';
        end if ;
        end $$
DELIMITER ;

-- question 9 : Khong cho phep xoa bai thi moi tao duoc 2 ngay 
drop trigger if exists checkExamDate ;
DELIMITER $$
	create trigger checkExamDate 
    before delete on exam
    for each row 
    begin 
		if old.CreateDate > Date_sub(now ,interval 2 day ) then 
			signal sqlstate '12345'
            set message_text = 'khong the xoa bai thi moi tao duoc 2 ngay ';
         end if ;   
	end $$
DELIMITER ;

-- question 10 : chi duoc xoa ,update question chua nam trong exam 

drop trigger if exists checkQuestionOnExam ;
DELIMITER $$
	create trigger checkQuestionOnExam 
    before delete on question 
    for each row 
    begin 
		if old.questionID in (select questionID  from examquestion ) then 
			signal sqlstate '12345'
            set message_text = 'khong the xoa bai thi moi tao duoc 2 ngay ';
         end if ;   
	end $$
DELIMITER ;
-- question 11 : chi duoc xoa ,update question chua nam trong exam 

drop trigger if exists checkQuestionOnExam ;
DELIMITER $$
	create trigger checkQuestionOnExam 
    before update on question 
    for each row 
    begin 
		if old.questionID in (select questionID  from examquestion ) then 
			signal sqlstate '12345'
            set message_text = 'khong the xoa bai thi moi tao duoc 2 ngay ';
         end if ;   
	end $$
DELIMITER ;

-- question 12 : xem exam 
SELECT examID, title,
	CASE 
		WHEN Duration <= 0.5 
			THEN "Short Time"
		WHEN Duration > 0.5 AND duration <= 1.0
			THEN "Medium Time"
		WHEN Duration > 1.0
			THEN "Long Time"
	END time_description
FROM exam;

-- question 13 : thong ke account moi group them cot the_number_user_amount 
select * , case 
	when count(GroupID) <6 then 'few'
    when count(GroupID) >5 and count(GroupID) <21 then 'normal'
    when count(GroupID) >21 then 'higher'
    end the_number_user_amount
from account 
inner join groupaccount on groupaccount.AccountID=account.AccountID
group by GroupID;

-- question 14 
select department.DepartmentID,DepartmentName,case
 when counter >0 then counter
 WHEN counter is NULL then 'khong co user '
 end soUser
from department 
left join (
select AccountID ,DepartmentID,count(departmentID) as counter
from account 
group by departmentID  )  countbyde  on countbyde.DepartmentID=department.DepartmentID
