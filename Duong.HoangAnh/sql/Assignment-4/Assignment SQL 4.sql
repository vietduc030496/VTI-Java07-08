use Exam;

select a.*,d.* from `Account` a
join `Department` d on a.DepartmentID = d.DepartmentID;

select a.* from `Account` a
where a.CreateDate >"20101220";

select a.* from `Account` a
join `Position` p on a.PositionID = p.PositionID
where p.PositionName like "dev";

select a.* from `Account` a
group by a.DepartmentID
having count(a.DepartmentID) > 3;

select eq.* ,count(eq.QuestionID) as amount from `ExamQuestion` eq
group by eq.QuestionID
order by count(eq.QuestionID) desc
limit 1;

select c.*, count(q.CategoryID) from `CategoryQuestion` c
left join `Question` q on c.CategoryID = q.CategoryID
group by c.CategoryID;

select q.QuestionID, count(eq.ExamID) as `amountUse` from `Question` q
left join `ExamQuestion` eq on q.QuestionID = eq.QuestionID
group by q.QuestionID;

select q.*, count(a.QuestionID) as amountAnswer from `Question` q
left join `Answer` a on q.QuestionID = a.QuestionID
group by q.QuestionID
order by count(a.QuestionID) desc
limit 1;

select  g.GroupID, g.GroupName, count(ga.AccountID) from `Group` g
left join `GroupAccount` ga on g.GroupID = ga.GroupID
group by g.GroupID;

select p.PositionName, count(a.AccountID) from `Position` p
left join `Account` a on p.PositionID = a.PositionID
group by p.PositionID
order by count(a.AccountID) asc
limit 1;

select d.*, count(a.AccountID) from `Department` d
left join `Account` a on d.DepartmentID = a.DepartmentID
left join `Position` p on a.PositionID = p.PositionID
where p.PositionName like "dev" or p.PositionName like "test" or p.PositionName like "PM" or p.PositionName like "scrum master"
group by d.DepartmentID;

select 	q.*, a.FullName as `Creator`, tq.TypeName as `Type`, an.Content as ContentAnswer from `Question` q
left join `Account` a on q.CreatorID = a.AccountID
left join `TypeQuestion` tq on q.TypeID = tq.TypeID
left join `Answer` an on q.QuestionID = an.QuestionID;

select tq.*, count(q.TypeID) as `Amount` from `TypeQuestion` tq
left join `Question` q on tq.TypeID = q.TypeID
where tq.TypeName like "tu luan" or tq.TypeName like "trac nhiem"
group by tq.TypeID;

select  g.GroupID, g.GroupName from `Group` g
left join `GroupAccount` ga on g.GroupID = ga.GroupID
group by g.GroupID
having count(ga.AccountID) = 0;

select q.*, count(a.QuestionID) as amountAnswer from `Question` q
left join `Answer` a on q.QuestionID = a.QuestionID
group by q.QuestionID
having count(a.QuestionID) = 0;

-- Exercise 2: Union

select a.* from `Account` a
left join `GroupAccount` ga on a.AccountID = ga.AccountID
where ga.GroupID = 1;

select a.* from `Account` a
join `GroupAccount` ga on a.AccountID = ga.AccountID
where ga.GroupID = 2;

select a.* from `Account` a
left join `GroupAccount` ga on a.AccountID = ga.AccountID
where ga.GroupID = 1
union
select a.* from `Account` a
join `GroupAccount` ga on a.AccountID = ga.AccountID
where ga.GroupID = 2;

select  g.GroupID, g.GroupName from `Group` g
left join `GroupAccount` ga on g.GroupID = ga.GroupID
group by g.GroupID
having count(ga.AccountID) > 5;

select  g.GroupID, g.GroupName from `Group` g
left join `GroupAccount` ga on g.GroupID = ga.GroupID
group by g.GroupID
having count(ga.AccountID) < 7;

select  g.GroupID, g.GroupName from `Group` g
left join `GroupAccount` ga on g.GroupID = ga.GroupID
group by g.GroupID
having count(ga.AccountID) > 5
union
select  g.GroupID, g.GroupName from `Group` g
left join `GroupAccount` ga on g.GroupID = ga.GroupID
group by g.GroupID
having count(ga.AccountID) < 7;