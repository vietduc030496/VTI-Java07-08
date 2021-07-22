-- Q1 tạo view chứa danh sách nhân viên thuộc phòng ban sale
-- use cte
with tbldepartmentcte as(
	select d.DepartmentID
    from tbldepartment d
    where d.DepartmentName = 'department2'
)
select * from tblaccount a join tbldepartmentcte dc on a.DepartmentID = dc.DepartmentID;
-- use subquery
SELECT 
    *
FROM
    tblaccount a
WHERE
    a.DepartmentID = (SELECT 
            d.DepartmentID
        FROM
            tbldepartment d
        WHERE
            d.DepartmentName = 'department2');

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
SELECT 
    a.AccountID,
    a.Username,
    a.FullName,
    COUNT(ga.AccountID) AS 'soluong'
FROM
    tblgroupaccount ga
        JOIN
    tblaccount a ON a.AccountID = ga.AccountID
GROUP BY ga.AccountID
HAVING soluong = (SELECT 
        MAX(c)
    FROM
        (SELECT 
            COUNT(*) AS c
        FROM
            tblgroupaccount ga
        GROUP BY ga.AccountID) AS cs);

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
SELECT 
    d.DepartmentID, d.DepartmentName, COUNT(*) AS soluong
FROM
    tbldepartment d
        JOIN
    tblaccount a ON d.DepartmentID = a.DepartmentID
GROUP BY a.DepartmentID
HAVING soluong = (SELECT 
        MAX(c)
    FROM
        (SELECT 
            COUNT(*) AS c
        FROM
            tblaccount a
        GROUP BY a.DepartmentID) AS cs);

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
SELECT 
    *
FROM
    tblquestion q
WHERE
    q.CreatorID IN (SELECT 
            a.AccountID
        FROM
            tblaccount a
        WHERE
            a.FullName LIKE 'Ng%');
