-- Q1
insert into tbldepartment values (null,"Sale"),
(null,"Dev"),
(null,"Tester"),
(null,"HR"),
(null,"BA");

insert into tblposition values (null,"position1"),
(null,"position2"),
(null,"position3"),
(null,"position4"),
(null,"position5");

insert into tblgroup values (null,"group1",1,"2021-07-19"),
(null,"group2",2,"2021-07-05"),
(null,"group3",3,"2021-07-01"),
(null,"group4",4,"2019-07-19"),
(null,"group5",5,"2020-07-19"),
(null,"group6",6,"2020-06-25"),
(null,"group7",7,"2018-01-15");


insert into tblaccount values (null,"ngoquocan@gmail.com","ngoquocan","Ngo Quoc An",2,4,"2021-11-11"),
(null,"ddddd@gmail.com","dddd","ddddddd",5,3,"2021-11-11"),
(null,"abcd@gmail.com","abcd","abcd",3,4,"2021-11-11"),
(null,"a@gmail.com","a","aaaaaaa",1,2,"2021-11-11"),
(null,"b@gmail.com","b","nguyenvanb",4,1,"2021-11-11"),
(null,"asasdad@gmail.com","asdadaas","Dao Dao Dao",2,4,"2021-11-11");

insert into tblgroupaccount values (1,1,"2021-11-11"),
(2,2,"2021-11-11"),
(3,3,"2021-11-11"),
(1,4,"2021-11-11"),
(2,5,"2021-11-11");

insert into tbltypequestion values (null,"Essay"),
(null,"Multi-Choice"),
(null,"typequestion1"),
(null,"typequestion2"),
(null,"typequestion3");

insert into tblcategoryquestion values (null,"Java"),
(null,"HTML"),
(null,"Css"),
(null,"Python"),
(null,"PhP");


insert into tblquestion values (null,"question1",1,1,1,"2021-11-11"),
(null,"question2",2,2,1,"2021-11-11"),
(null,"question3",3,3,1,"2021-11-11"),
(null,"câu hỏi thứ 1",4,3,1,"2021-11-11"),
(null,"câu hỏi thứ 2",3,2,1,"2021-11-11");

insert into tblanswer values (null,"answer1",1,true),
(null,"answer2",2,true),
(null,"answer3",3,false),
(null,"answer4",1,false),
(null,"answer5",1,true),
(null,"answer6",1,false);

insert into tblexam values (null,1,"exam1",1,90,1,"2021-11-11"),
(null,2,"exam2",2,90,2,"2021-11-11"),
(null,3,"exam3",3,90,3,"2021-11-11"),
(null,4,"exam4",3,90,3,"2018-11-11"),
(null,5,"exam5",3,90,3,"2018-11-11");

insert into tblexamquestion values (1,1),
(2,2),
(3,3),
(1,2),
(3,2);
-- Q2
select * from tbldepartment;
-- Q3
select tbldepartment.DepartmentID from tbldepartment
where tbldepartment.DepartmentName ='sale';
-- Q4
select *
from tblaccount
where length(tblaccount.FullName) = 
	(
		select max(length(tblaccount.FullName))
        from tblaccount
        where length(tblaccount.FullName)
    )
order by tblaccount.FullName desc;
-- Q5
select *
from tblaccount
where length(tblaccount.FullName) = 
	(
		select max(length(tblaccount.FullName))
        from tblaccount
        where length(tblaccount.FullName)
    )
	and tblaccount.DepartmentID = '3';
-- Q6
select * from tblgroup where tblgroup.CreateDate < '2019-12-20';
-- Q7
select tblanswer.QuestionID
from tblanswer
group by tblanswer.QuestionID
having count(tblanswer.QuestionID) >= 4; 
-- Q8
select tblexam.ExamID
from tblexam
where tblexam.Duration > '60' and tblexam.CreateDate < '2019-12-20';
-- Q9
select *
from tblgroup
order by tblgroup.CreateDate desc
limit 5;
-- Q10
select count(*)
from tblaccount
where tblaccount.DepartmentID = '2';
-- Q11
select *
from tblaccount
where tblaccount.FullName like "D%o";
-- Q12
delete from tblexam
where tblexam.CreateDate < '2019-12-20';
-- Q13
delete from tblquestion
where tblquestion.Content like 'câu hỏi%';
-- Q14
update tblaccount
set tblaccount.FullName = 'Nguyễn Bá Lộc', tblaccount.Email = 'loc.nguyenba@vti.com.vn'
where tblaccount.AccountID = '5';
-- Q15
update tblgroupaccount
set tblgroupaccount.GroupID = '4'
where tblgroupaccount.AccountID = '5';