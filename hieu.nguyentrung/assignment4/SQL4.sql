#Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
select accountID, username, fullname, department.departmentID
from `account` as acc
inner join department
on acc.departmentID = department.departmentID;

#Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010 
select *
from `account` as acc
where createDate > 2010-12-20;

#Question 3: Viết lệnh để lấy ra tất cả các developer
select * from position;
select accountID, username, fullname, departmentID, position.positionID, positionName
from `account` as acc
inner join position
on acc.positionID = position.positionID
where  positionName = "developer";

#Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên 
select  department.departmentID, departmentName
from `account` as acc
inner join department
on acc.departmentID = department.departmentID
group by acc.departmentID
having count(acc.departmentID) >3;

#Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất 
select questionID, count(*) as max_num 
from examquestion 
group by questionID
having count(*) = (select max(counts.count) from (select count(*) as count from examquestion group by questionID) as counts );

#Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
select categoryID , count(*) as number_of_question
from question
group by categoryID;

#Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
select questionID, count(*) as num_of_exam 
from examquestion
group by questionID;
#Question 8: Lấy ra Question có nhiều câu trả lời nhất 
select questionID, count(*) as max_num_of_answer from answer
group by questionID
having count(*) = (select max(counts.count) from (select count(*) as count from answer group by questionID) as counts );

#Question 9: Thống kê số lượng account trong mỗi group 
select g.groupID, g.groupName ,count(*) as num_of_acccount from groupaccount
inner join `group` as g
on groupaccount.groupID = g.groupID
group by groupID;

#Question 10: Tìm chức vụ có ít người nhất 
select acc.positionID, position.positionName, count(*) as min_of_position from `account` as acc
inner join position 
on acc.positionID = position.positionID
group by positionID
having count(*) = (select min(counts.count) from (select count(*) as count from `account` group by positionID) as counts );

#Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM 
select acc.departmentID , acc.positionID , p.positionName , count(p.positionID) as num_of_employee from `account` as acc
inner join position as p
on acc.positionID = p.positionID
group by departmentID , positionID
order by departmentID;

#Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, loại câu hỏi, ai là 
#người tạo ra câu hỏi, câu trả lời là gì, … 
select * from question 
natural join typequestion 
left join answer
on question.questionID = answer.questionID;

#Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm 
select *,count(question.TypeID) as num_of_question
from typequestion 
left join question 
on question.TypeID = typequestion.TypeID
group by typequestion.TypeID;

#Question 14: Lấy ra group không có account nào
select distinct groupID, groupName 
from `group` as g 
where not exists (select *from groupaccount as ga where ga.groupID = g.groupID );

#Question 15: Lấy ra group có account 
select distinct groupID, groupName 
from `group` as g 
where exists (select *from groupaccount as ga where ga.groupID = g.groupID );

#Question 16: Lấy ra question không có answer nào 
select distinct questionID, content
from question 
where not exists (select *
				   from answer
                   where answer.questionID = question.questionID );
#Question 17:
#a
select accountID from groupaccount
where groupID=1;
#b
select accountID from groupaccount
where groupID=2;
#c
select accountID from groupaccount
where groupID=1
union distinct
select accountID from groupaccount
where groupID=2;

#Question 18:
select g.GroupID,g.GroupName,count(ga.GroupID) as num_of_employee_in_group
from `group` as g left join groupaccount as ga 
on g.GroupID = ga.GroupID
group by g.GroupID 
having num_of_employee_in_group > 7
union distinct
select g.GroupID,g.GroupName,count(ga.GroupID) as num_of_employee_in_group
from `group`as g left join groupaccount as ga 
on g.GroupID = ga.GroupID
group by g.GroupID 
having num_of_employee_in_group < 5;