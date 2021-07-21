# Question 1
insert into department values (null,"Sale");
insert into department values (null,"Marketing");
insert into department values (null,"HR");
insert into department values (null,"Cloud");
insert into department values (null,"Network");

insert into position values (null,"Sys Admin");
insert into position values (null,"Test");
insert into position values (null,"Net Admin");
insert into position values (null,"Dev");

insert into `group` values (null,"G1",1,"2021-07-19"),
(null,"G2",2,"2021-07-05"),
(null,"G3",3,"2021-07-01");
insert into `group` values (null,"G4",4,"2019-07-19");
insert into `group` values (null,"G5",5,"2020-07-19");
insert into `group` values (null,"G6",6,"2020-06-25");
insert into `group` values (null,"G7",7,"2018-01-15");


insert into `account` values (null,"hieunguyen@gmail.com","hieunguyen","nguyentronghien",2,4,"2021-07-19");
insert into `account` values (null,"dungtran240799@gmail.com","dungtran","trananhdung",5,3,"2021-07-19"),
(null,"hieunguyen@gmail.com","hieunguyen","nguyentrunghieu",3,4,"2021-07-19"),
(null,"ngohoang@gmail.com","ngohoang","ngohuyhoang",1,2,"2021-07-19"),
(null,"nguyenducnam@gmail.com","ducnam","nguyenducnam",3,4,"2021-07-19"),
(null,"nguyenchiduc@gmail.com","chiduc","nguyenchiduc",4,1,"2021-07-19");
insert into `account` values (null,"hieunguyen123@gmail.com","hieunguyen123","Duongducho",2,4,"2021-07-19");
insert into `account` values (null,"nguyenhuyhoang123@gmail.com","hoangnguyen123","nguyenhuyhoang",2,3,"2021-07-19");

insert into groupaccount values (1,1,"2021-07-19"),
(2,2,"2021-07-10"),
(3,3,"2021-07-06"),
(1,4,"2021-07-22"),
(2,5,"2021-07-11"),
(1,6,"2021-07-01"),
(1,7,"2021-07-11"),
(1,8,"2021-07-19"),
(1,2,"2021-07-18"),
(3,2,"2021-07-18")
;

insert into typequestion values (null,"Essay"),
(null,"Multi-Choice"),
(null,"Drag and Drop");

insert into categoryquestion values (null,"Java"),
(null,"Net"),
(null,"SQL"),
(null,"Postman");

insert into question values (null,"A",1,1,1,"2021-07-01"),
(null,"B",2,2,1,"2021-06-15"),
(null,"C",3,3,1,"2021-06-25");
insert into question values (null,"câu hỏi thứ 1",4,3,1,"2021-06-25");
insert into question values (null,"câu hỏi thứ 2",1,3,1,"2021-06-25");
insert into question values (null,"câu hỏi thứ 3",3,1,2,"2021-06-24");

insert into answer values (null,"A",1,true),
(null,"B",2,true),
(null,"C",3,false);
insert into answer values (null,"D",1,true),(null,"E",1,true),(null,"F",1,true);

insert into exam values (null,111,"Hello",1,1.5,1,"2021-06-15"),
(null,222,"Network",2,2.0,2,"2021-06-11"),
(null,333,"SQL",3,3.5,3,"2021-05-20");

insert into exam values (null,444,"SQL",3,3.5,3,"2019-05-20");

insert into examquestion values (1,1),
(2,2),
(3,3),
(1,2);

# Question 2
select * from department;

# Question 3
select departmentID from department
where departmentName ="Sale";

# Question 4.1
select * from `account` as acc
where length(acc.fullname) = (select max(length(acc2.fullname))
from `account` as acc2 );

# Question 4.2
select * from `account` as acc 
order by length(acc.fullname) desc;

# Question 5
select * from `account` as acc
where length(acc.fullname) = ( select max(length(acc2.fullname))
from `account` as acc2 ) and acc.departmentID = 3;

# Question 6
select groupName from `group`
where createDate < "2019-12-20";

# Question 7
select questionID from answer
group by questionID
having count(questionID) >=4;

# Question 8
select `code` from exam 
where duration >= 1.0 and createDate < "2019-12-20";

# Question 9
select * from `group`
order by createDate desc
limit 5;

# Question 10
select count(*) as num_of_emp from `account`
where departmentID = 2;

# Question 11
select * from `account`
where fullname like "D%o";

# Question 12
delete from exam 
where createDate < "2019-12-20";

# Question 13
select * from question;
delete from question 
where content like "câu hỏi%";

# Question 14
select * from `account`;
update `account`
set fullname ="Nguyễn Bá Lộc",email = "loc.nguyenba@vti.com.vn"
where accountID =5;

# Question 15
select * from groupaccount;
update groupaccount
set groupID = 4
where accountID = 5;