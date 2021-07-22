# Question 1: them 5 ban ghi
insert into department values (null,"Sale"),
(null,"Dev"),
(null,"Tester"),
(null,"HR"),
(null,"BA");

insert into position values (null,"position1"),
(null,"position2"),
(null,"position3"),
(null,"position4"),
(null,"position5");
insert into position values (null, "developer");

insert into `group` values (null,"group1",1,"2021-07-19"),
(null,"group2",2,"2021-07-05"),
(null,"group3",3,"2021-07-01"),
(null,"group4",4,"2019-07-19"),
(null,"group5",5,"2020-07-19"),
(null,"group6",6,"2020-06-25"),
(null,"group7",7,"2018-01-15");


insert into `account` values (null,"vantruong@gmail.com","vantruong","truongvantruong",2,4,"2021-11-11"),
(null,"ddddd@gmail.com","dddd","ddddddd",5,3,"2021-11-11"),
(null,"hieunguyen@gmail.com","hieunguyen","nguyentrunghieu",3,4,"2021-11-11"),
(null,"a@gmail.com","a","aaaaaaa",1,2,"2021-11-11"),
(null,"b@gmail.com","b","nguyenvanb",4,1,"2021-11-11"),
(null,"DavidRobertFilo@gmail.com","DavidRobertFilooooooo","DavidRobertFilo",2,4,"2021-11-11"),
(null,"cccccccccc","cccccccccccc","DavidRobertFilocccc",2,6,"2021-11-11"),
(null,"hhhhhh@gmail","hhhhhhh","Davidhhhhhh",2,6,"2021-11-11");

insert into groupaccount values (1,1,"2021-11-11"),
(2,2,"2021-11-11"),
(3,3,"2021-11-11"),
(1,4,"2021-11-11"),
(2,5,"2021-11-11");

insert into typequestion values (null,"Essay"),
(null,"Multi-Choice"),
(null,"typequestion1"),
(null,"typequestion2"),
(null,"typequestion3");

insert into categoryquestion values (null,"Java"),
(null,"HTML"),
(null,"Css"),
(null,"Python"),
(null,"PhP");


insert into question values (null,"question1",1,1,1,"2021-11-11"),
(null,"question2",2,2,1,"2021-11-11"),
(null,"question3",3,3,1,"2021-11-11"),
(null,"câu hỏi thứ 1",4,3,1,"2021-11-11"),
(null,"câu hỏi thứ 2",3,2,1,"2021-11-11");

insert into answer values (null,"answer1",1,true),
(null,"answer2",2,true),
(null,"answer3",3,false),
(null,"answer4",1,false),
(null,"answer5",1,true),
(null,"answer6",1,false);
insert into answer values (null,"A",1,true),
(null,"B",2,true),
(null,"C",3,false);
insert into answer values (null,"D",1,true),(null,"E",1,true),(null,"F",1,true);

insert into exam values (null,1,"exam1",1,2.5,1,"2021-11-11"),
(null,2,"exam2",2,1.5,2,"2021-11-11"),
(null,3,"exam3",3,1.5,3,"2021-11-11"),
(null,4,"exam4",3,3.0,3,"2018-11-11"),
(null,5,"exam5",3,1.0,3,"2018-11-11");

insert into examquestion values (1,1),
(2,2),
(3,3),
(1,2),
(3,2);

# Question 2: Lay ra tat ca cac phong ban
select * from department;

# Question 3:lay ra id cua " Sale"
select departmentID from department
where departmentName ="Sale";

# Question 4: Lay account co full name dai nhat
select * from `account` as acc
where (select length(acc.fullname))= (select max(length(acc1.fullname)) from `account` as acc1 );

# Question 4 : sap xep giam dan
select * from `account`
order by length(fullname) desc;

# Question 5: acc co fullname dai nhat && departmentID = 3
select * from `account` as acc
where length(acc.fullname) = ( select max(length(acc1.fullname)) from `account` as acc1 ) 
and acc.departmentID = 3;

# Question 6: lay group truoc 20/12/2019
select groupName from `group`
where createDate < "2019-12-20";

# Question 7: lay id cua question >=4 cau tra loi
select questionID from answer
group by questionID
having count(questionID) >=4;

# Question 8: Lay ma de thi time >=60phut(1.0 gio)  && truoc 20/12/2019
select `code` from exam 
where duration >= 1.0 and createDate < "2019-12-20";

# Question 9: Lay ra 5 group duoc tao gan nhat
select * from `group`
order by createDate desc
limit 5;

# Question 10: dem so nhan vien department2 co id =2
select count(*) as amount_of_emp from `account`
where departmentID = 2;

# Question 11: Lay nhan vien bat dau bang D va ket thuc bang o
select * from `account`
where fullname like "D%o";

# Question 12: Xoa exam truoc 20/12/2019
delete from exam 
where createDate < "2019-12-20";

# Question 13 xoa question co noi dung bat dau " cau hoi"
select * from question;
delete from question 
where content like "câu hỏi%";

# Question 14: Update thong tin
select * from `account`;
update `account` 
set fullname ="Nguyễn Bá Lộc",email = "loc.nguyenba@vti.com.vn"
where accountID =5;

# Question 15: update acc co id-5 se thuoc group co id=4
select * from groupaccount;
update groupaccount
set groupID = 4
where accountID = 5;