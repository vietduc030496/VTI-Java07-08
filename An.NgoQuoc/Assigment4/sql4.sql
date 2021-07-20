-- Q1
select * from tblaccount a join tbldepartment d on a.DepartmentID = d.DepartmentID;

-- Q2
select * from tblaccount a where a.CreateDate > '2010-12-20';

-- Q3
select * from tblaccount a join tblposition p on a.PositionID = p.PositionID
where p.PositionName = 'developer';

-- Q4
select d.DepartmentID,d.DepartmentName ,count(a.DepartmentID)as 'soluong'
from tblaccount a right join tbldepartment d on a.DepartmentID = d.DepartmentID
group by d.DepartmentID
having count(*)>3;

-- Q5
select q.QuestionID,q.Content,q.CategoryID,q.TypeID,count(*) as 'so luong'
from tblquestion q join tblexamquestion eq on q.QuestionID = eq.QuestionID
group by eq.QuestionID 
having count(*) = (
	select count(*) 
	from tblexamquestion eq 
	group by eq.QuestionID 
	order by count(*) desc
	limit 1
    );
    
-- Q6
select cq.CategoryID,cq.CategoryName,count(q.CategoryID) as 'so luong'
from tblcategoryquestion cq left join tblquestion q on cq.CategoryID = q.CategoryID
group by cq.CategoryID;

-- Q7
select q.QuestionID,q.Content,q.CategoryID,q.TypeID, count(eq.QuestionID) as 'so luong'
from tblquestion q left join tblexamquestion eq on q.QuestionID = eq.QuestionID
group by q.QuestionID;

-- Q8
select q.QuestionID,q.Content,q.CategoryID,q.TypeID, count(*) as 'so luong'
from tblanswer a join tblquestion q on a.QuestionID = q.QuestionID
group by a.QuestionID
having count(*) = (select count(*) from tblanswer a group by a.QuestionID order by count(*) desc limit 1);

-- Q9
select g.GroupID,g.GroupName,count(ga.GroupID) as 'so luong'
from tblgroup g left join tblgroupaccount ga on g.GroupID = ga.GroupID
group by g.GroupID;

-- Q10
select p.PositionID,p.PositionName,count(*) as 'soluong'
from tblaccount a join tblposition p on a.PositionID = p.PositionID
group by a.PositionID
having soluong = (select count(*) from tblaccount a group by a.PositionID order by count(*) asc limit 1);

-- Q11
select d.DepartmentID,d.DepartmentName,p.PositionName,count(a.PositionID) as 'soluong'
from tblaccount a,tbldepartment d,tblposition p
where a.DepartmentID = d.DepartmentID and a.PositionID = p.PositionID
group by p.PositionID,a.DepartmentID;

-- Q12
select *
from tblquestion q join tbltypequestion tq on q.TypeID = tq.TypeID
join tblcategoryquestion cq on q.CategoryID = cq.CategoryID
join tblanswer an on q.QuestionID =an.QuestionID
where isCorrect = 1;

-- Q13
select tq.TypeID,tq.TypeName,count(q.TypeID) as 'soluong'
from tbltypequestion tq left join tblquestion q on q.TypeID = tq.TypeID
group by tq.TypeID;

-- Q14
select g.GroupID,g.GroupName,count(ga.GroupID) as 'soluong'
from tblgroup g left join tblgroupaccount ga on g.GroupID = ga.GroupID
group by g.GroupID
having soluong = '0';

-- Q15
select g.GroupID,g.GroupName,count(ga.GroupID) as 'soluong'
from tblgroup g left join tblgroupaccount ga on g.GroupID = ga.GroupID
group by g.GroupID
having soluong = '0';

-- Q16
select q.QuestionID,q.Content,q.CategoryID,q.TypeID, count(a.QuestionID) as 'soluong'
from tblquestion q left join tblanswer a on a.QuestionID = q.QuestionID
group by q.QuestionID
having soluong = '0';

-- Q17a
select * from tblaccount a where a.DepartmentID = '1';
-- Q17b
select * from tblaccount a where a.DepartmentID = '2';
-- Q17c
select * from tblaccount a where a.DepartmentID = '1'
union distinct
select * from tblaccount a where a.DepartmentID = '2';

-- Q18a
select g.GroupID,g.GroupName,count(ga.GroupID) as 'soluong'
from tblgroup g left join tblgroupaccount ga on g.GroupID = ga.GroupID
group by g.GroupID having soluong > 7;
-- Q18b
select g.GroupID,g.GroupName,count(ga.GroupID) as 'soluong'
from tblgroup g left join tblgroupaccount ga on g.GroupID = ga.GroupID
group by g.GroupID having soluong < 5;
-- Q18c
select g.GroupID,g.GroupName,count(ga.GroupID) as 'soluong'
from tblgroup g left join tblgroupaccount ga on g.GroupID = ga.GroupID
group by g.GroupID having soluong > 7
union distinct
select g.GroupID,g.GroupName,count(ga.GroupID) as 'soluong'
from tblgroup g left join tblgroupaccount ga on g.GroupID = ga.GroupID
group by g.GroupID having soluong < 5;





