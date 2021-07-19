create database if not exists qlnhanvien;
use qlnhanvien;
create table if not exists Department 
(
Department_Number int not null, 
Department_Name varchar(45) not null,
primary key(Department_Number)
);
create table if not exists Skill(
Skill_Code int not null,
Skill_Name varchar(45),
primary key(Skill_Code)
);
create table if not exists Employee_Table 
(
Employee_Number int not null, 
Employee_Name varchar(45) not null,  
Department_Number int not null,
primary key(Employee_Number),
foreign key (Department_Number) references Department(Department_Number)
);
create table if not exists Employee_Skill_Table
(
Employee_Number int not null, 
Skill_Code int not null, 
Registration_Date date not null,
constraint Employee_Skill primary key(Employee_Number,Skill_Code)
);

-- insert into department value(1,'IT1');
-- insert into department value(2,'IT2');
-- insert into department value(3,'IT3');

-- insert into skill value(1,'JAVA');
-- insert into skill value(2,'PYTHON');
-- insert into skill value(3,'PHP');

-- insert into employee_table value(1,'Ngô Quốc Ân 1', 1);
-- insert into employee_table value(2,'Ngô Quốc Ân 2', 2);
-- insert into employee_table value(3,'Ngô Quốc Ân 3', 3);
-- insert into employee_table value(4,'Ngô Quốc Ân 4', 1);

-- insert into employee_skill_table value(1,1,'2021-07-19');
-- insert into employee_skill_table value(1,3,'2021-07-19');
-- insert into employee_skill_table value(2,1,'2021-07-19');
-- insert into employee_skill_table value(2,2,'2021-07-19');
-- insert into employee_skill_table value(2,3,'2021-07-19');
-- insert into employee_skill_table value(3,1,'2021-07-19');
-- insert into employee_skill_table value(4,2,'2021-07-19'); 

-- create view employeeBySkillUseJOIN as
-- select employee_table.Employee_Name
-- from ((employee_skill_table 
-- join employee_table on employee_skill_table.Employee_Number = employee_table.Employee_Number)
-- join skill on employee_skill_table.Skill_Code = Skill.Skill_Code)
-- where Skill.Skill_Name = 'JAVA';

create view employeeBySkillUseSUB as
select employee_table.Employee_Name
from employee_table
where Employee_Number in
	(select employee_skill_table.Employee_Number 
    from employee_skill_table 
    where employee_skill_table.Skill_Code in
		(select skill.Skill_Code
        from skill
        where skill.Skill_Name = "JAVA")
    );

-- select department.Department_Name,count(employee_table.Department_Number) as Count
-- from department join employee_table on(employee_table.Department_Number = department.Department_Number)
-- where Count > 3
-- group by department.Department_Number;