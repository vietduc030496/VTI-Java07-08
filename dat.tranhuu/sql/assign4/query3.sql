use vti1;
-- quest 1 --
select * from tbl_account where department_id =(select id from tbl_department where name like "sale" limit 1);    
-- quest 2 --
select * from( select account_id,so_group  from( select account_id, count(account_id) as so_group from tbl_group_account group by account_id 
 order by so_group desc) as x where x.so_group=
 (select max(so_group) as max from( select account_id, count(account_id) as so_group from tbl_group_account group by account_id)as tbl1 )) as x
 inner join tbl_account a on a.id = x.account_id;
 -- quest 3 --
 SET SQL_SAFE_UPDATES = 0;
(select tbl_question.id from tbl_question where length(content) >300);
delete from tbl_question   where length(content) >300;

 -- quest 4 --
 select * from( select department_id,so_tv  from( select department_id, count(department_id) as so_tv from tbl_account group by department_id) as x where x.so_tv=
 (select max(so_tv) as max from( select department_id, count(department_id) as so_tv from tbl_account group by department_id)as tbl1 )) as x
 inner join tbl_department a on a.id = x.department_id;
  -- quest 5 --
select * from tbl_question where tbl_question.account_id in 
(select id from tbl_account where fullname like "%Nguyễn%");
 