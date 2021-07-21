#Question 1
select * from `account`
where departmentID = ( select departmentID from department
						where departmentName ="Sale");
                        
#Question 2
select * from `account`
where accountID in ( select accountID from groupaccount
					 group by accountID
                     having count(*) = ( select max(counts.acc_count) from 
											(select count(*) as acc_count from groupaccount
													group by accountID) as counts)
					);

#Question 3
with cte3 as (
	select questionID,
			content,
            categoryID,
            typeID,
            creatorID,
            createDate
	from question
    where length(content) > 300)
delete from cte3;

#Question 4
select * from department
where departmentID in ( select departmentID from `account`
					 group by departmentID
                     having count(*) = ( select max(counts.acc_count) from 
											(select count(*) as acc_count from `account`
													group by departmentID) as counts)
					);

#Question 5
with cte5 as (
	select q.questionID,
			q.content,
            q.categoryID,
            q.typeID,
            q.creatorID,
            q.createDate,
            acc.fullname
	from question as q inner join `account` as acc
    on q.creatorID = acc.accountID
    where acc.fullname like "nguyen%")
select * from cte5;
	

