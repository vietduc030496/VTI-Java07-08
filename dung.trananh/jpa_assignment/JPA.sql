create table Employee(
	id int primary key auto_increment,
    firstname varchar(100),
    lastname varchar(100),
    email varchar(50),
    phone varchar(50));
    
select * from employee;

insert into Employee values (null, "Dung", "Tran", "dungtran240799@gmail.com","0932264199");