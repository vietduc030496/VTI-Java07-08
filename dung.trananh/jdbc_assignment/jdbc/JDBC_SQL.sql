create table lop(
	id_lop int primary key auto_increment,
    tenlop varchar(50),
    nienkhoa varchar(50));

create table sinhvien(
	id_sv int primary key auto_increment,
    holot varchar(50),
    ten varchar(50),
    gioitinh varchar(10),
    ngaysinh date,
    diachi varchar(100),
    dienthoai varchar(50),
    email varchar(50),
    id_lop int);

create table bangdiem(
	id_sv int,
    id_monhoc int,
    diem float);

create table monhoc(
	id_monhoc int primary key auto_increment,
    tenmonhoc varchar(50),
    sotinchi int);
    
alter table sinhvien add foreign key (id_lop) references lop(id_lop);
alter table bangdiem add foreign key (id_sv) references sinhvien(id_sv);
alter table bangdiem add foreign key (id_monhoc) references monhoc(id_monhoc);
alter table bangdiem add primary key (id_sv,id_monhoc);

insert into lop values (null,"L1","2017-2022");
insert into lop values (null,"L2","2016-2021");
insert into lop values (null,"L3","2018-2023");
insert into lop values (null,"G1","2017-2022");
insert into lop values (null,"G2","2016-2021");

insert into monhoc values (null,"Ly",3);
insert into monhoc values (null,"Hoa",3);
insert into monhoc values (null,"Sinh",3);
insert into monhoc values (null,"Toan",4);
insert into monhoc values (null,"Van",4);

insert into sinhvien values (null,"Tran","Dung","Nam","1999-07-24","HN","0932264199","dungtran240799@gmail.com",1);
insert into sinhvien values (null,"Ngo","Hoang","Nam","1999-08-24","HN","0927889127","ngohoangb2@gmail.com",1);
insert into sinhvien values (null,"Nguyen","Hieu","Nam","1999-09-24","HN","0931237812","nguyenhieu@gmail.com",2);
insert into sinhvien values (null,"Nguyen","Lan","Nu","1999-10-24","HN","0931237812","nguyenlan@gmail.com",2);

insert into bangdiem values (1,1,9.0);
insert into bangdiem values (1,2,8.5);
insert into bangdiem values (2,2,9.0);
insert into bangdiem values (2,4,9.0);
insert into bangdiem values (3,5,8.0);
insert into bangdiem values (3,3,9.0);