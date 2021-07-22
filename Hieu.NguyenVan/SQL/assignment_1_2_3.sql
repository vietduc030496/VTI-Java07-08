-- insert into department(departmentName) values ('sale');
-- insert into department(departmentName) values ('maketing');
-- insert into department(departmentName) values ('Human Resources');
-- insert into department(departmentName) values ('IT');
-- insert into department(departmentName) values ('Accounting and Finance');
-- insert into department(departmentName) values (' Research and Development (R&D)');
-- insert into department(departmentName) values ('Production');

-- insert into position (PositionName) values ('Dev') ;
-- insert into position (PositionName) values ('Test') ;
-- insert into position (PositionName) values ('Scrum Master') ;
-- insert into position (PositionName) values ('PM') ;

-- insert into account (Email,Username,FullName,DepartmentID,PositionID,CreateDate) values("account1@gmail.com", "account1","nguyen van acount 1",1,4,"2021-07-12");
-- insert into account (Email,Username,FullName,DepartmentID,PositionID,CreateDate) values("account2@gmail.com", "account2","nguyen van acount 2",2,3,"2021-07-12");
-- insert into account (Email,Username,FullName,DepartmentID,PositionID,CreateDate) values("account3@gmail.com", "account3","nguyen van acount 3",3,2,"2021-07-12");
-- insert into account (Email,Username,FullName,DepartmentID,PositionID,CreateDate) values("account4@gmail.com", "account4","nguyen van acount 4",4,1,"2021-07-12");
-- insert into account (Email,Username,FullName,DepartmentID,PositionID,CreateDate) values("account5@gmail.com", "account5","nguyen van acount 5",5,4,"2021-07-12");
-- insert into account (Email,Username,FullName,DepartmentID,PositionID,CreateDate) values("account6@gmail.com", "account6","nguyen van acount 6",6,3,"2021-07-12");
-- insert into account (Email,Username,FullName,DepartmentID,PositionID,CreateDate) values("account7@gmail.com", "account7","nguyen van acount 7",2,2,"2021-07-12");
-- insert into account (Email,Username,FullName,DepartmentID,PositionID,CreateDate) values("account8@gmail.com", "account8","nguyen van acount 8",4,1,"2021-07-12");
-- insert into account (Email,Username,FullName,DepartmentID,PositionID,CreateDate) values("account9@gmail.com", "account9","nguyen van acount 9",3,4,"2021-07-12");
-- insert into account (Email,Username,FullName,DepartmentID,PositionID,CreateDate) values("account10@gmail.com", "account10","nguyen van acount 10",2,3,"2021-07-12");
-- insert into account (Email,Username,FullName,DepartmentID,PositionID,CreateDate) values("account11@gmail.com", "account11","nguyen van acount 11",1,1,"2021-07-12");

-- insert into group_table(GroupName,CreatorID,CreateDate) values("group1", 4,"2010-12-24");
-- insert into group_table(GroupName,CreatorID,CreateDate) values("group2", 3,"2010-12-24");
-- insert into group_table(GroupName,CreatorID,CreateDate) values("group3", 2,"2010-12-24");
-- insert into group_table(GroupName,CreatorID,CreateDate) values("group4", 1,"2010-12-24");
-- insert into group_table(GroupName,CreatorID,CreateDate) values("group5", 4,"2010-12-24");
-- insert into group_table(GroupName,CreatorID,CreateDate) values("group6", 3,"2010-12-24");

-- insert into groupaccount(GroupID,AccountID,JoinDate) values(4, 5,"2010-10-01");
-- insert into groupaccount(GroupID,AccountID,JoinDate) values(3, 4,"2020-10-02");
-- insert into groupaccount(GroupID,AccountID,JoinDate) values(2, 3,"2010-10-03");
-- insert into groupaccount(GroupID,AccountID,JoinDate) values(1, 2,"2010-10-05");
-- insert into groupaccount(GroupID,AccountID,JoinDate) values(1, 1,"2010-10-09");

-- insert into typequestion(TypeName) values("Essay");
-- insert into typequestion(TypeName) values("Multiple-Choice");

-- insert into categoryquestion(CategoryName) values("Java");
-- insert into categoryquestion(CategoryName) values("DotNet");
-- insert into categoryquestion(CategoryName) values("SQL");
-- insert into categoryquestion(CategoryName) values("API");
-- insert into categoryquestion(CategoryName) values("HTML/CSS");
-- insert into categoryquestion(CategoryName) values("Vim");
-- insert into categoryquestion(CategoryName) values("Thread");
-- insert into categoryquestion(CategoryName) values("Cloud");

-- insert into question(Content,CategoryID,TypeID,CreatorID,CreateDate) values("content 1:x", 1,1, 4,"2021-03-10");
-- insert into question(Content,CategoryID,TypeID,CreatorID,CreateDate) values("content 2:", 2, 2, 2,"2021-09-22");
-- insert into question(Content,CategoryID,TypeID,CreatorID,CreateDate) values("content 3:", 3, 1, 3,"2021-08-14");
-- insert into question(Content,CategoryID,TypeID,CreatorID,CreateDate) values("content 4:", 4, 2, 4,"2021-07-16");
-- insert into question(Content,CategoryID,TypeID,CreatorID,CreateDate) values("content 5:", 5, 1, 5,"2021-06-18");
-- insert into question(Content,CategoryID,TypeID,CreatorID,CreateDate) values("content 6:", 6, 2, 1,"2021-05-10");
-- insert into question(Content,CategoryID,TypeID,CreatorID,CreateDate) values("content 7:", 7, 1, 2,"2021-04-12");
-- insert into question(Content,CategoryID,TypeID,CreatorID,CreateDate) values("content 8:", 8, 2, 3,"2021-03-14");
-- insert into question(Content,CategoryID,TypeID,CreatorID,CreateDate) values("content 9:", 7, 2, 4,"2021-02-16");
-- insert into question(Content,CategoryID,TypeID,CreatorID,CreateDate) values("content 10:",7, 1, 5,"2020-01-18");
-- insert into answer(Content,QuestionID,isCorrect) values ('answer 1',1,true);
-- insert into answer(Content,QuestionID,isCorrect) values ('answer 2',2,true);
-- insert into answer(Content,QuestionID,isCorrect) values ('answer 3',3,true);
-- insert into answer(Content,QuestionID,isCorrect) values ('answer 4',4,true);
-- insert into answer(Content,QuestionID,isCorrect) values ('answer 5',5,true);
-- insert into answer(Content,QuestionID,isCorrect) values ('answer 6',6,true);
-- insert into answer(Content,QuestionID,isCorrect) values ('answer 7',7,true);
-- insert into answer(Content,QuestionID,isCorrect) values ('answer 8',8,true);
-- insert into answer(Content,QuestionID,isCorrect) values ('answer 9',9,true);
-- insert into answer(Content,QuestionID,isCorrect) values ('answer 10',10,true);
-- insert into answer(Content,QuestionID,isCorrect) values ('answer 11',1,false);
-- insert into answer(Content,QuestionID,isCorrect) values ('answer 12',2,false);

-- insert into exam(`Code`,Title,CategoryID,Duration,CreatorID,CreateDate) values("code-01", "Kiểm tra lần 1 ", 1, 90, 1,"2020-07-03");
-- insert into exam(`Code`,Title,CategoryID,Duration,CreatorID,CreateDate) values("code-02", "Kiểm tra lần 1 ", 1, 90, 1,"2020-07-03");
-- insert into exam(`Code`,Title,CategoryID,Duration,CreatorID,CreateDate) values("code-03", "Kiểm tra lần 1 ", 1, 90, 1,"2020-07-03");
-- insert into exam(`Code`,Title,CategoryID,Duration,CreatorID,CreateDate) values("code-04", "Kiểm tra lần 1 ", 1, 90, 1,"2020-07-03");
-- insert into exam(`Code`,Title,CategoryID,Duration,CreatorID,CreateDate) values("code-05", "Kiểm tra lần 1 ", 1, 90, 1,"2020-07-03");
-- insert into exam(`Code`,Title,CategoryID,Duration,CreatorID,CreateDate) values("code-06", "Kiểm tra lần 1 ", 1, 90, 1,"2020-07-03");
-- insert into exam(`Code`,Title,CategoryID,Duration,CreatorID,CreateDate) values("code-07", "Kiểm tra lần 1 ", 1, 90, 1,"2020-07-03");
-- insert into exam(`Code`,Title,CategoryID,Duration,CreatorID,CreateDate) values("code-08", "Kiểm tra lần 1 ", 1, 90, 1,"2020-07-03");
-- insert into exam(`Code`,Title,CategoryID,Duration,CreatorID,CreateDate) values("code-09", "Kiểm tra lần 1 ", 1, 90, 1,"2020-07-03");
-- insert into exam(`Code`,Title,CategoryID,Duration,CreatorID,CreateDate) values("code-10", "Kiểm tra lần 1 ", 1, 90, 1,"2020-07-03");

-- insert into examquestion(ExamID,QuestionID) values(1, 1);
-- insert into examquestion(ExamID,QuestionID) values(1, 2);
-- insert into examquestion(ExamID,QuestionID) values(1, 3);
-- insert into examquestion(ExamID,QuestionID) values(1, 4);
-- insert into examquestion(ExamID,QuestionID) values(1, 5);
-- insert into examquestion(ExamID,QuestionID) values(1, 6);
-- insert into examquestion(ExamID,QuestionID) values(1, 7);
-- insert into examquestion(ExamID,QuestionID) values(1, 8);
-- insert into examquestion(ExamID,QuestionID) values(2, 4);
-- insert into examquestion(ExamID,QuestionID) values(3, 1);
-- insert into examquestion(ExamID,QuestionID) values(3, 2);

select * 
from department ;

select DepartmentID 
from department 
where DepartmentName ='sale';

select * 
from account 
order by length(Fullname) DESC;

select * 
from account 
where DepartmentID=3
order by length(Fullname) DESC;

select *
from group_table
where CreateDate <'2019-12-20';

select * ,count(questionID) 
from answer
-- where k > 1
group by QuestionID
having count(QuestionID)>=4;

-- q8
select *
from  exam 
where Duration >= 60 AND CreateDate <'2022-12-20';

-- question 9
select  * 
from group_table 
order by CreateDate DESC limit 0 , 5;

-- question 10 
select * ,count(DepartmentID)
from account
where DepartmentID = 2
group by DepartmentID ;

-- question 11
select * 
from account 
where Fullname like 'N%1';

-- question 12

delete from exam where CreateDate <'2019-12-20';

-- question 13
delete from question where Content like 'câu hỏi %';

-- question 14 

update account 
set Fullname ='Nguyen Ba Loc ',Email ='loc.nguyenba@vti.com.vn'
where AccountID=5;

-- question 15
update groupaccount
set groupID =4
where AccountID=5 ;