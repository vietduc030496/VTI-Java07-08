-- Q1 tạo view chứa danh sách nhân viên thuộc phòng ban sale
-- use cte
with tbldepartmentcte as(
	select d.DepartmentID
    from tbldepartment d
    where d.DepartmentName = 'department2'
)
select * from tblaccount a join tbldepartmentcte dc on a.DepartmentID = dc.DepartmentID;
-- use subquery
select * 
from tblaccount a
where a.DepartmentID = (select d.DepartmentID from tbldepartment d where d.DepartmentName = 'department2');

-- Q2 tạo view chứa thông tin account tham gia vào nhiều group nhất
-- use cte
with tblcountgroup as(
	select ga.AccountID, count(*) as 'soluong'
    from tblgroupaccount ga
    group by ga.AccountID
), maxcountgroup as (
	select min(soluong) as 'soluong'
    from tblcountgroup cg
)
select a.AccountID,a.Email,a.Username,a.FullName,cg.soluong
from tblaccount a join tblcountgroup cg on a.AccountID = cg.AccountID
join maxcountgroup mcg on cg.soluong = mcg.soluong;
-- use subquery
select a.AccountID,a.Username,a.FullName,count(ga.AccountID) as 'soluong'
from tblgroupaccount ga join tblaccount a on a.AccountID = ga.AccountID
group by ga.AccountID
having soluong = (select max(c) from( select count(*) as c from tblgroupaccount ga group by ga.AccountID) as cs);

-- Q3
-- use cte
with tblquestionlong as(
	select *
    from tblquestion q
    where length(q.Content) > 30
)
delete q from tblquestion q join tblquestionlong ql on q.QuestionID = ql.QuestionID;
-- use subquery
delete from tblquestion q
where length(q.Content) > 15;

-- Q4
-- use cte
with tblcountacc as(
	select a.DepartmentID, count(*) as 'soluong'
    from tblaccount a
    group by a.DepartmentID
), maxcountacc as (
	select ca.DepartmentID,max(soluong) as 'soluong'
    from tblcountacc ca
)
select d.DepartmentID,d.DepartmentName,ca.soluong
from tbldepartment d join tblcountacc ca on d.DepartmentID = ca.DepartmentID
join maxcountacc mca on ca.soluong = mca.soluong;
-- use subquery
select d.DepartmentID,d.DepartmentName,count(*) as soluong
from tbldepartment d join tblaccount a on d.DepartmentID = a.DepartmentID
group by a.DepartmentID
having soluong = (select max(c) from (select count(*) as c from tblaccount a group by a.DepartmentID) as cs);

-- Q5
-- use cte
with tblaccbyname as(
	select *
    from tblaccount a
    where a.FullName like 'Ng%'
)
select *
from tblquestion q join tblaccbyname abn on q.CreatorID = abn.AccountID;
-- use subquery
select * from tblquestion q
where q.CreatorID in (select a.AccountID from tblaccount a where a.FullName like 'Ng%');
