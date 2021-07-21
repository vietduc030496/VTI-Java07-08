
-- question 1
select * 
from account 
inner join department on account.DepartmentID=department.DepartmentID;

-- question 2
select * 
from account 
where CreateDate <'2010-12-20';

-- question 3
select *
from account
inner join position on  account.PositionID=position.PositionID
where PositionName= "Dev";
-- question 4
select DepartmentName
from account
inner join department on account.DepartmentID = department.DepartmentID
group by account.DepartmentID
having count(account.DepartmentID) > 2;

-- question 5

select  * , count(question.QuestionID) as cou
from  question
inner join examquestion on examquestion.QuestionID=question.QuestionID
-- where cou = max(cou)
group by question.QuestionID
order by cou  desc limit 10;
-- question 6
select categoryquestion.CategoryName ,count(categoryquestion.CategoryID) as numberUse
from categoryquestion 
inner join question on question.CategoryID=categoryquestion.CategoryID
group by question.CategoryID;

-- question 7
select * ,count(examquestion.QuestionID)
from question
inner join examquestion on question.QuestionID = examquestion.QuestionID
group by  examquestion.QuestionID;

-- question 8 
select * 
from question
where QuestionID=(
	select max(counter)
    from (
		select count(question.QuestionID) as counter
        from question
        inner join answer on answer.QuestionID=question.QuestionID
        group by question.QuestionID
    ) as intable
) ;

-- question 9 
select *,count(GroupID) as numbermember
from groupaccount
inner join account on account.AccountID =groupaccount.AccountID
group by groupaccount.GroupID ;

-- question 10 

-- select * 
-- from position 
-- where PositionID in (
-- 	select positionID 
--     from 
--     where counter = (
--     
--     )
-- )

select PositionName ,count(position.PositionID) as counter
from position
inner join account on account.PositionID=position.PositionID
group by position.PositionID
order by counter limit 1;

-- question 11

select PositionName ,count(position.PositionID) as counter
from position
inner join account on account.PositionID=position.PositionID
group by position.PositionID
order by counter ;

-- question 12
select question.Content as question_content,answer.Content answer_content,account.Fullname as creator ,TypeName
from question
inner join answer on answer.QuestionID= question.QuestionID
inner join account on account.AccountID=question.CreatorID
inner join typequestion on typequestion.TypeID=question.TypeID ;

-- question 13
select TypeName,count(question.TypeID) as number_question
from question 
inner join typequestion on typequestion.typeID = question.TypeID
group by question.TypeID;

-- question 14
select  GroupName 
from account 
inner join groupaccount on groupaccount.AccountID=account.AccountID
right   join group_table on group_table.GroupID = groupaccount.GroupID
where groupaccount.GroupID is null
group by GroupName;
-- having count(GroupName) = 1

-- question 15
select *
from question
left join answer on  question.QuestionID=answer.QuestionID
where answer.QuestionID is null;

-- question 17
select * 
from account 
inner join groupaccount on groupaccount.AccountID=account.AccountID
where GroupID=1
union
select * 
from account 
inner join groupaccount on groupaccount.AccountID=account.AccountID
where GroupID=2;

-- question 18 
select * 
from account 
inner join groupaccount on groupaccount.AccountID=account.AccountID
inner join group_table on group_table.GroupID=groupaccount.GroupID
group by group_table.GroupID
having count(group_table.CreatorID) > 1 
union 
select * 
from account 
inner join groupaccount on groupaccount.AccountID=account.AccountID
inner join group_table on group_table.GroupID=groupaccount.GroupID
group by group_table.GroupID
having count(group_table.CreatorID) > 7