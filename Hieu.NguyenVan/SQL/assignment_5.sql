
-- question 1 : danh sach nhan vien sale
with saleMember as( 
select Fullname ,DepartmentName
from account 
inner join department on department.DepartmentID=account.DepartmentID
where department.DepartmentName = 'sale'
) 
select * from saleMember;

-- question 2 : account vao nhieu group nhat 
with counttble as (
select account.AccountID ,count( groupaccount.GroupID) as counter
from account
inner join groupaccount on groupaccount.AccountID = account.AccountID
group by groupaccount.GroupID
)
,maxofgroup as(
select max(counter) as maxer
from counttble
) 
select *
from account 
join counttble on counttble.AccountID =account.AccountID
join maxofgroup on counttble.counter = maxofgroup.maxer;

-- question 3 : xoa question co content > 300 ky tu 
delete from question
where length(content) >300;

-- question 4 : danh sach phong ban co nhieu nhan vien nhat and
with countmember as(
	 select * ,count(DepartmentID) as counter from account
     group by DepartmentID
), findmax as (
 select  max(counter) as maxer
 from countmember
)
-- select * from findmax
select department.DepartmentName ,maxer,counter from department
inner join countmember on  countmember.DepartmentID = department.DepartmentID
join findmax  
where maxer = counter ;

-- question 5 : cau hoi do ho nguyen tao 

with  findNguyen as (
select QuestionID,Fullname from question 
inner join account on account.AccountID = question.CreatorID
where account.Fullname like "nguyen%"
)
select * ,Fullname from question 
inner join  findNguyen on findNguyen.QuestionID= question.QuestionID




