-- 1)
drop view if exists employee_sale_view;
create view employee_sale_view as
select a.* from `Account` a
where a.DepartmentID = 
(select d.DepartmentID from `Department` d
where d.DepartmentName like "sale");

select * from employee_sale_view;

-- 2)
drop view if exists max_group_account;
create view max_group_account as
with cte_list_account_group(AccountID, AmountGroupTakePartIn) as (
	select ga.AccountID, count(ga.GroupID) from `GroupAccount` ga
    group by ga.AccountID
) 
select a.AccountID, a.FullName, c.AmountGroupTakePartIn  from `Account` a
join cte_list_account_group c on a.AccountID = c.AccountID
where c.AmountGroupTakePartIn = (select max(AmountGroupTakePartIn) from cte_list_account_group);

select * from max_group_account;

-- 3)
drop view if exists long_content_question;
create view long_content_question as
select *, length(q.Content) from `Question` q
where length(q.Content) > 300;
delete from `Question`
where length(Content) > 300;
select * from long_content_question;
select * from `Question`;

-- 4)
drop view if exists max_employee_each_department_view;
create view max_employee_each_department_view as
with employee_of_department(departmentID, departmentName , amountEmployee) as (
	select d.DepartmentID, d.DepartmentName, count(a.AccountID) from `Department` d
    left join `Account` a on d.DepartmentID = a.DepartmentID
    group by d.DepartmentID
)
select * from employee_of_department e
where e.amountEmployee = (select max(amountEmployee) from employee_of_department);
select * from max_employee_each_department_view;
-- 5)

with creator_nguyen_question(questionID, creatorName) as (
	select q.QuestionID, a.FullName from `Question` q
    left join `Account` a on q.CreatorID = a.AccountID
    where substring_index(a.FullName, ' ', 1) like "nguyen"
)
select questionID, creatorName from creator_nguyen_question;
