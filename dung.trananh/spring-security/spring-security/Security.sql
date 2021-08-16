create table Employee(
	id int primary key auto_increment,
    role_id int,
    username varchar(50),
    `password` varchar(50),
    firstname varchar(100),
    lastname varchar(100),
    email varchar(50),
    phone varchar(50));
    
create table `Role`(
	id int primary key auto_increment,
    role_name varchar(50));

alter table Employee add foreign key (role_id) references `Role`(id);