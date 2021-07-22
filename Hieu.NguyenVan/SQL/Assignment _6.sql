
-- question 1 :lay ra account theo phong ban 
drop procedure if exists getAccountbyDeparment ;
DELIMITER $$

create procedure  getAccountbyDeparment(in departmentName varCHAR(4) )
	BEGIN 	
		SELECT * 
        FROM Account 
		INNER JOIN  department on department.departmentID = account.departmentID
        WHERE department.departmentName = departmentName ;
    End $$
DELIMITER ;

SET @_TEMP ='SALE';
CALL getAccountbyDeparment( @_TEMP);


-- question 2 : So luong account moi group 

drop procedure if exists  getcountAcountByGroup ;
DELIMITER $$
CREATE procedure getcountAcountByGroup() 
	begin 
		select GroupName , COUNT(group_table.GroupName)  as counter
        FROM ACCOUNT 
        INNER JOIN groupaccount on groupaccount.AccountID =account.AccountID
        inner join group_table on group_table.GroupID=groupaccount.GroupID
        group by group_table.GroupName;
	end $$
DELIMITER ;    

CALL getcountAcountByGroup();
-- question 3: luu so question duoc tao theo type trong thang 
drop procedure if exists  newQuestionthisMonth ;
DELIMITER $$
create procedure newQuestionthisMonth()
	begin
		select * ,count(TypeName)
        from question 
        inner join typequestion on typequestion.TypeID=question.TypeID 
        where month(CreateDate)  = MONTH(CURRENT_DATE()) 
        group by TypeName;
   end $$
DELIMITER ;
CALL newQuestionthisMonth();

-- question 4 : id type question co nhieu cau hoi nhat 	
drop procedure if exists getTypeMax;
DELIMITER $$
create procedure getTypeMax(out Id int(10))
	begin
		select  TypeID into id 
        from question 
        group by TypeID
        order by count(TypeID) desc limit 1;
	end $$ 
DELIMITER ;
set @Id='';
call getTypeMax(@Id);
        
-- question 5 :  su dung store question 4 de lay ten type
drop procedure if exists getTypeName;
DELIMITER $$ 
create procedure getTypeName(in id int(10))
	begin 
		select * 
        from typequestion
        where TypeID= id;
	end $$
DELIMITER ;
call getTypeName(@Id);

-- question 6 : find groupname or user name 
drop procedure if exists findGrouporUserName;
DELIMITER $$ 
create procedure findGrouporUserName(in namefind varchar(10))
	begin 
		select groupName
        from group_table
        where GroupName like namefind
        union 
        select Username
        from account
        where Username like namefind;
	end $$
DELIMITER ;
set @namestring= concat('group','%');
call findGrouporUserName(@nameString);

-- question 7 :tao account voi username va email

drop procedure if exists createAccount;
DELIMITER $$ 
create procedure createAccount(in fullnames varchar(225),in emails varchar(225) )
	begin 
		insert into account (Fullname,userName,email,DepartmentID,positionID,Createdate)
        values (fullnames,substring_index(fullname,'@',1),emails,1,1,CURDATE());
	end $$
DELIMITER ;
set @namestring= 'nguyen van a';
set @email ='abc@gmail.com';
call createAccount(@nameString , @email);


-- question 8 :find question have longest content by type question

drop procedure if exists longestquestion;
DELIMITER $$ 
create procedure longestquestion(in typenames varchar(225) )
	begin 
		select TypeName,Content,length(content) as len
        from question 
        inner join typequestion on typequestion.TypeID=question.TypeID
        where TypeName =typenames 
        order by len desc limit 1;
	end $$
DELIMITER ;
set @typesname= 'Essay';
call longestquestion(@typesname);

-- question 9 :delete exam by id 

drop procedure if exists deleteExamById;
DELIMITER $$ 
create procedure deleteExamById(in ids int(10) )-- , out result int (10))
	begin 
		declare child int;
        declare exam1 int;
		delete from examquestion
		where examquestion.ExamID =ids;
		select row_count() into child;
		delete from exam
		where exam.ExamID =ids ;
        select row_count() into exam1;
        
        set @results =child+exam1;
        select @results;
	end $$
DELIMITER ;
set @id= '7';
set @resutl=0;
call deleteExamById(@id) ;-- ,@result);
-- select  @result ;

-- question 10 :delete exam create 3 year ago 

drop procedure if exists deleteExam3YearAgo;
DELIMITER $$ 
create procedure deleteExam3YearAgo(in years int(10) ,out results varchar (225))
	begin 
		select  exam.ExamID into results
        from exam
        where year( CreateDate) =years
        limit 1;
	end $$
DELIMITER ;
set @years= '2017';
set @results='';
call deleteExam3YearAgo(@years,@results);
call deleteExamById(@results) ;

-- question 11 :delete department  

drop procedure if exists deleteDepartment;
DELIMITER $$ 
create procedure deleteDepartment(in denames varchar(10) )
	begin 
		update account 
        set account.departmentID=1
        where  account.departmentID=(
			select departmentID
            from department 
            where departmentName=denames
        );
		delete from department 
        where department.departmentName=denames;
	end $$
DELIMITER ;
set @denames= 'cho';
set @results='';
call deleteDepartment(@denames);

-- question 12 :number question is created in this year 

drop procedure if exists numberQuesInMonth;
DELIMITER $$ 
create procedure numberQuesInMonth( )
	begin 
		select * ,count(month(createDate)) as couter
        from question
        where year( createDate) = year(curdate())
        group by month(createDate);
	end $$
DELIMITER ;
set @denames= 'cho';
set @results='';
call numberQuesInMonth();

-- question 13 :number question is created for 6 month

drop procedure if exists numberQuesIn6Month;
DELIMITER $$ 
create procedure numberQuesIn6Month( )
	begin 
		select * ,count(month(createDate)) as couter
        from question
        where CreateDate>DATE_SUB(CURDATE(),INTERVAL 6 MONTH)
        group by month(createDate);
	end $$
DELIMITER ;
set @denames= 'cho';
set @results='';
call numberQuesIn6Month()