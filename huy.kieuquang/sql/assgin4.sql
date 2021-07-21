use assign12;

-- q1
select * 
from accounts a
join department d
on a.departmentID = d.departmentID;

-- q2
select * 
from accounts a 
where cast(a.createDate as date) > '2010-12-20';

-- q3
select *
from accounts a
join positions p
on  a.PositionID = p.PositionID
where p.positionName= "dev";

-- q4
select d.departmentID, d.DepartmentName, count(a.departmentID) as SoNhanvien
from accounts a, department d
where a.departmentID = d.departmentID
group by a.departmentID 
having SoNhanvien > 2;

-- q5
select  * , count(q.questionID) as counted
from  question q
join examquestion eq
on eq.questionID = q.questionID
group by q.questionID
order by counted  desc limit 5;

-- q6
select cq.categoryID ,cq.CategoryName ,count(cq.CategoryID) as used
from categoryquestion cq
join question q
on q.CategoryID = cq.CategoryID
group by q.CategoryID;

-- q7
select q.QuestionID ,count(eq.QuestionID) as used
from question q
join examquestion eq
on q.QuestionID = eq.QuestionID
group by  q.QuestionID;

-- q8
select x.QuestionID, max(counted)
from(
	select q.QuestionID, count(q.QuestionID) as counted
    from question q
    join answer a
    on a.QuestionID = q.QuestionID
    group by q.QuestionID ) as x;
    
-- q9
select ga.GroupID, count(ga.GroupID) as SoLuongAccount
from groupaccount ga
join accounts a 
on a.AccountID = ga.AccountID
group by ga.GroupID ;

-- q10
select p.PositionName , count(p.PositionID) as counter
from positions p
join accounts a
on a.PositionID = p.PositionID
group by p.PositionID
order by counter 
limit 1;

-- q11
select p.PositionName , count(p.PositionID) as counter
from positions p
join accounts a
on a.PositionID = p.PositionID
group by p.PositionID
order by counter ;

-- q12
select q.Content as Question,a.Content as Answer,acc.Fullname as Creator, t.TypeName
from question q
join answer a
on a.QuestionID = q.QuestionID
join accounts acc 
on acc.AccountID=q.CreatorID
join typequestion t
on t.TypeID=q.TypeID ;

-- q13
select tq.TypeName, count(q.TypeID) as quantity
from question q
join typequestion tq
on tq.typeID = q.TypeID
group by q.TypeID;

-- q14 q15
select g.GroupName 
from accounts a 
join groupaccount ga
on ga.AccountID = a.AccountID
right join groupp g 
on g.GroupID = ga.GroupID
where ga.GroupID is null
group by g.GroupName;

-- q16
select *
from question q
left join answer a
on q.QuestionID = a.QuestionID
where a.QuestionID is null;

-- q17
select * 
from accounts a 
join groupaccount ga
on ga.AccountID = a.AccountID
where ga.GroupID = 1
union
select * 
from accounts a 
join groupaccount ga 
on ga.AccountID = a.AccountID
where ga.GroupID = 2;

-- q18
select g.groupID, count(ga.AccountID) as quantity_member
from groupaccount ga
join groupp g 
on g.GroupID=ga.GroupID
group by g.GroupID
having count(ga.AccountID) > 5
union 
select g.groupID, count(ga.AccountID) as quantity_member
from groupaccount ga
join groupp g 
on g.GroupID=ga.GroupID
group by g.GroupID
having count(ga.AccountID) < 7