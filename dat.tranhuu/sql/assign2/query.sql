-- quest2--
select * from tbl_department; 
-- quest3--
select id from tbl_department where tbl_department.name="sale"; 
-- quest4--
select *, length(tbl_account.fullname) as legth_fullname from tbl_account order by legth_fullname desc;
-- quest5--
select *, length(tbl_account.fullname) as legth_fullname 
from tbl_account where tbl_account.department_id=3 order by legth_fullname desc limit 1;
-- quest6--
select name from tbl_group where tbl_group.created_date <"2019-12-20";
-- quest7--
select question_id from (select  tbl_answer.question_id,count(tbl_answer.question_id) 
as number_quest from tbl_answer group by tbl_answer.question_id) as tb1 where tb1.number_quest>=4 ;
-- quest8--
select code from tbl_exam where created_date <"2019-12-20" and durantion >=60;
-- quest9--
select * from tbl_group order by created_date desc limit 5;
-- quest10--
select count(id) from tbl_account where department_id=2;
-- quest11--
select * from tbl_account where fullname like "D%o";
-- quest12--
SET SQL_SAFE_UPDATES = 0;
delete from tbl_exam where tbl_exam.created_date < "2019-12-20";
-- quest13--
SET SQL_SAFE_UPDATES = 0;
delete from tbl_question where content like "câu hỏi %";
-- quest14--
update tbl_account set fullname = "Nguyễn Bá Lộc", email="loc.nguyenba@vti.com.vn" where id=5;
-- quest15--
update tbl_group_account set account_id= 4 where group_id=5;