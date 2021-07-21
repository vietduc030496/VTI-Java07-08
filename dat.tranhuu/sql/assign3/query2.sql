use vti1;
-- quest1 -- 
select * from tbl_account join tbl_department  on  tbl_account.department_id=tbl_department.id;
-- quest2 -- 
select * from tbl_account where created_date > "2010-12-20";
-- quest3 -- 
select * from tbl_account where position_id = (select id from tbl_position where name = "developer" limit 1) ;
-- quest4 -- 
select depa.id,depa.name from tbl_department depa inner join 
(select * from (select department_id, count(department_id) 
as n from tbl_account group by department_id) as a where a.n >3 ) x on x.department_id = depa.id;
-- quest5 -- 
select * from tbl_question 
inner join  (select question_id, count(question_id) as ma from tbl_exam_question group by question_id  order by ma desc limit 1)  x
on x.question_id = tbl_question.id;
-- quest6 -- 
select category_id, count(category_id) as number_of_question from tbl_question group by category_id;
-- quest7 -- 
select question_id, count(question_id) as ma from tbl_exam_question group by question_id;
-- quest8 -- 
select question_id, count(question_id) as ma from tbl_answer group by question_id  order by ma desc limit 1;
-- quest9 -- 
select group_id, count(account_id) as so_luong_acc from tbl_group_account group by group_id;
-- quest10 -- 
select position_id, count(id) as so_ng from tbl_account group by position_id  order by so_ng  limit 1;
-- quest12 -- 
select q.id,q.content as noi_dung_question,q.created_date,tq.name as kieu_question, cq.name as the_loai, a.username as nguoi_tao,ta.content as dap_an from tbl_question q inner join 
tbl_type_question tq on tq.id = q.type_id
inner join  tbl_category_question cq on cq.id = q.category_id
inner join tbl_account a on a.id = q.account_id
inner join tbl_answer ta on ta.question_id = q.id; 
-- quest13 -- 
select q.number_of_question,tq.name,tq.id from (select type_id, count(type_id) as number_of_question from tbl_question group by type_id) q
inner join ( select * from tbl_type_question  where name like "trắc nghiệm" or name like "tự luận") tq on tq.id=q.type_id;
-- quest14 -- 

select name from (select name,ga.account_id from tbl_group 
left join tbl_group_account ga on ga.group_id= tbl_group.id) as a where a.account_id is null;

-- quest16 -- 
select id,content from (select tbl_question.id,tbl_question.content,a.content as content_a from tbl_question 
left join tbl_answer a on a.question_id= tbl_question.id) as x where x.content_a is null;
-- quest17 -- 
-- 1 --
select * from tbl_group_account  inner join tbl_account a on a.id =   tbl_group_account.account_id
where tbl_group_account.group_id =1;

-- 2 --
select * from tbl_group_account  inner join tbl_account a on a.id =   tbl_group_account.account_id
where tbl_group_account.group_id =2;

-- 3 --
select * from tbl_account  inner join tbl_group_account a on a.account_id =  tbl_account.id 
where a.group_id =2 or a.group_id =1;

-- quest18 -- 
-- 1 --
select * from tbl_group inner join
 (select group_id, count(group_id) as so_luong_tv from tbl_group_account group by group_id ) as x
 on x.group_id = tbl_group.id where so_luong_tv >5;
 -- 2 --
select * from tbl_group inner join
 (select group_id, count(group_id) as so_luong_tv from tbl_group_account group by group_id ) as x
 on x.group_id = tbl_group.id where so_luong_tv <7;
 -- 3 --
select * from tbl_group inner join
 (select group_id, count(group_id) as so_luong_tv from tbl_group_account group by group_id ) as x
 on x.group_id = tbl_group.id where so_luong_tv >5 and so_luong_tv <7;