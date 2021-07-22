-- quest 1
use vti1;
delimiter $$
CREATE procedure get_account_in_department(in department_name varchar(255))	
begin 
	select * from tbl_account where department_id in 
	(select id from tbl_department where name like  department_name);
end $$
delimiter ;
call get_account_in_department("sale");
-- quest 2
drop procedure if exists get_account_in_group;
delimiter $$
CREATE procedure get_account_in_group()	
begin 
	select group_id, count(group_id) as so_tv from tbl_group_account group by  group_id;
end $$
delimiter ;
call get_account_in_group();

-- quest 3
drop procedure if exists get_type_in_question;
delimiter $$
CREATE procedure get_type_in_question()	
begin 
	select type_id, count(type_id) as so_luong_quest from tbl_question group by  type_id;
end $$
delimiter ;
call get_type_in_question();
-- quest 4
drop procedure if exists get_type_in_question1;
delimiter $$
CREATE procedure get_type_in_question1(out typea bigint)	
begin 
	select x.type_id into typea from (select type_id, count(type_id) as so_luong_quest from tbl_question group by  type_id) as x
    where x.so_luong_quest = (select max(so_luong_quest) from (select type_id, count(type_id) as so_luong_quest from tbl_question group by  type_id) as y) ;
end $$
delimiter ;
set @type_id=0;
call get_type_in_question1(@type_id);
select @type_id;

-- quest 5
set @type_id=0;
call get_type_in_question1(@type_id);
select @type_id;
select name from tbl_type_question where id in (select @type_id);
-- quest 6
drop procedure if exists get_group_or_account;
delimiter $$
CREATE procedure get_group_or_account(in name varchar(255))	
begin 
	select *  from tbl_group  join tbl_account where tbl_account.fullname = name or  tbl_group.name = name;
end $$
delimiter ;

call get_group_or_account("fullname1");
-- quest 7
drop procedure if exists insert_acc;
delimiter $$
CREATE procedure insert_acc(in fullname varchar(255), in email varchar(255))	
begin 
	insert into tbl_account(email,username,fullname,created_date,department_id,position_id) 
	values (email,substring_index(email,"@",1),fullname,(SELECT CURRENT_DATE()),5,(select id from tbl_position where name = "developer" limit 1));
    select * from tbl_account where tbl_account.email=email;
end $$
delimiter ;

call insert_acc("fullname20","email22@gmail.com");
-- quest 9
drop procedure if exists delete_exam;
delimiter $$
CREATE procedure delete_exam(in id bigint)	
begin 
	delete from tbl_exam_question where tbl_exam_question.exam_id =id;
	delete from tbl_exam where tbl_exam.id =id;
end $$
delimiter ;
call delete_exam(1);
-- quest 10