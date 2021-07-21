#Question 1
select * from 
`account` as acc inner join department as dept
on acc.departmentID = dept.departmentID;

#Question 2
select * from `account`
where createDate > "2010-12-20";

#Question 3
select * from `account` as acc 
inner join position as p
on acc.positionID = p.positionID
where p.positionName = "Dev";

#Question 4
select departmentID, departmentName from department
where departmentID in ( select departmentID from `account`
					group by departmentID
					having count(departmentID) >3);

#Question 5
select questionID, count(*) as max_frequency from examquestion 
group by questionID
having count(*) = (select max(counts.count) from 
						(select count(*) as count from examquestion
							group by questionID) as counts );

#Question 6
select categoryID , count(*) as num_of_question 
from question
group by categoryID;

#Question 7
select questionID, count(*) as frequency_in_exam from examquestion
group by questionID;

#Question 8
select questionID, count(*) as max_num_of_answer from answer
group by questionID
having count(*) = (select max(counts.count) from 
						(select count(*) as count from answer
							group by questionID) as counts );
															
#Question 9
select g.groupID, g.groupName ,count(*) as num_of_acc_each_group from groupaccount
inner join `group` as g
on groupaccount.groupID = g.groupID
group by groupID;

#Question 10
select acc.positionID, p.positionName, count(*) as min_num_of_position from `account` as acc
natural join position as p 
group by positionID
having count(*) = (select min(counts.count) from 
						(select count(*) as count from `account`
							group by positionID) as counts );

#Question 11
select * from `account` natural join department natural join position;

select departmentID , positionID , p.positionName , count(positionID) as num_of_position_in_each_dept from `account`
natural join position as p
group by departmentID , positionID
order by departmentID;

#Question 12
select * from question natural join typequestion left join answer
on question.questionID = answer.questionID;

#Question 13
select typeID,typeName,count(*) as num_of_question_each_type from question as q 
natural join typequestion as tq
group by typeID;

#Question 14
select distinct groupID, groupName 
from `group` as g 
where not exists (select *
				   from groupaccount as ga
                   where ga.groupID = g.groupID );
#Question 15 (bi trung voi Question 14)
#Question 16
select distinct questionID, content
from question as q 
where not exists (select *
				   from answer as a
                   where a.questionID = q.questionID );
#Question 17
select accountID from groupaccount
where groupID=1
union
select accountID from groupaccount
where groupID=2;

#Question 18
select groupID from groupaccount
group by groupID
having count(*) > 5
union all
select groupID from groupaccount
group by groupID
having count(*) < 7;