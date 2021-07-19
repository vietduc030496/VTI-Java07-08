-- create database assignment1_question2 ;
use assignment1_question2;

create table if not exists Department(
	Department_Number int(10) auto_increment primary key,
    Department_Name varchar(225) 
);
create table if not exists  employee_table(
	 Employee_Number int(10) auto_increment primary key,
     Employee_Name varchar(225) ,
     Department_Number INT (10),
     foreign key (Department_Number) references Department(Department_Number)
);
create table if not exists Skill(
	Skill_code int(10) primary key auto_increment ,
    Skill_name varchar(225)
);
create table if not exists Employee_Skill_Table(
	Employee_Number Int,
    Skill_code int ,
    Date_registered date,
    primary key ( employee_number,Skill_code) ,
    foreign key(employee_number) references employee_table(employee_Number) ,
    foreign key(Skill_code) references Skill(Skill_code)
);
-- insert into  Department(Department_name)  values ('IT');
-- insert into  Department(Department_name)  values ('Human Resources');
-- insert into  Department(Department_name)  values (' Accounting and Finance');
-- insert into  Department(Department_name)  values (' Marketing');
-- insert into  Department(Department_name)  values (' Research and Development (R&D)');


-- insert into skill(Skill_name) values ('java');
-- insert into skill(Skill_name) values ('c++');
-- insert into skill(Skill_name) values ('git');
-- insert into skill(Skill_name) values ('cli');
-- insert into skill(Skill_name) values ('python');

-- insert into employee_table(employee_name ,Department_Number) values ('Nguyen van hieu','1');
-- insert into employee_table(employee_name ,Department_Number) values ('Nguyen van an','2');
-- insert into employee_table(employee_name ,Department_Number) values ('Nguyen van quan','3');
-- insert into employee_table(employee_name ,Department_Number) values ('Nguyen van hoa','4');
-- insert into employee_table(employee_name ,Department_Number) values ('Nguyen van nam','1');
-- insert into employee_table(employee_name ,Department_Number) values ('Nguyen Trai','1');
-- insert into employee_table(employee_name ,Department_Number) values ('Nguyen Van loc ','2');
-- insert into employee_table(employee_name ,Department_Number) values ('Ngo Dai Thang ','3');
-- insert into employee_table(employee_name ,Department_Number) values ('Nguyen Duy Phuong','4');
-- insert into employee_table(employee_name ,Department_Number) values ('Tran Ha Nam ','1');

-- insert into Employee_Skill_Table( Employee_Number,Skill_code,Date_registered) values ('1','1','2010-12-01');
-- insert into Employee_Skill_Table( Employee_Number,Skill_code,Date_registered) values ('1','2','2010-11-04');
-- insert into Employee_Skill_Table( Employee_Number,Skill_code,Date_registered) values ('2','3','2010-10-04');
-- insert into Employee_Skill_Table( Employee_Number,Skill_code,Date_registered) values ('2','1','2010-09-04');
-- insert into Employee_Skill_Table( Employee_Number,Skill_code,Date_registered) values ('3','4','2010-05-03');

-- use join 
-- select employee_name 
-- from employee_table as em
-- inner join  Employee_Skill_Table on Employee_Skill_Table.Employee_Number =em.employee_Number 
-- inner join skill on Employee_Skill_Table.skill_code= skill.skill_code 
-- where skill.skill_name = 'java';

-- subquery

-- select employee_name 
-- from employee_table as em
-- where employee_number in (
-- 	select employee_number
--     from Employee_Skill_Table
--     where Employee_Skill_Table.skill_code in(
-- 		select skill_code 
--         from skill 
--         where  skill_name ='java'
--     )
-- )
select dem.counta
from (
Select department.department_Number,department_name, count(department.department_Number) as counta
from department 
inner join employee_table on department.department_Number = employee_table.department_Number
group by department.department_number
) as dem
where dem.counta >= 3

-- Select *
-- from department 
-- inner join employee_table on department.department_Number = employee_table.department_Number