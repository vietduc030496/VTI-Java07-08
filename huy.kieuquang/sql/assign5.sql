use assign12;

-- q1
create view showEm as
select a.accountiD, a.fullname, d.departmentName
from accounts a, department d
where a.departmentID = d.departmentID
and d.DepartmentName = 'sale';

select * from showEm;

-- q2
create view mostJoinGroup as
select ga.accountID, count(ga.accountID) as joined
from groupaccount ga, accounts a
where a.accountID = ga.accountID
group by ga.accountID
order by joined desc
limit 1;

select * from mostJoinGroup;

-- q3
set sql_safe_updates = 0;
delete from question q
where char_length(q.content) > 300;
set sql_safe_updates = 1;

-- q4
create view depart_most_member as
select d.departmentID, d.DepartmentName, count(a.departmentID) as SoNhanvien
from accounts a, department d
where a.departmentID = d.departmentID
group by a.departmentID 
order by SoNhanvien desc
limit 5;

select * from depart_most_member;

-- q5
create view nguyen_creator as
select q.questionID, a.fullname
from question q, accounts a
where q.creatorID = a.accountID 
and a.fullname like 'Nguyen%';

select * from nguyen_creator;

