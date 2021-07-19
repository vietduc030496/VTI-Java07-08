create database if not exists qlDonHang;
use qlDonHang;
create table if not exists `san_pham`(
Ma_SP int not null,
Ten_SP varchar(45) not null,
Don_Gia double,
primary key(Ma_SP)
);
create table if not exists `khach_hang`(
Ma_KH int not null,
Ten_KH varchar(45) not null,
Phone_No varchar(45),
Ghi_Chu varchar(45) not null,
primary key(Ma_KH)
);
create table if not exists `don_hang`(
Ma_DH int not null,
Ngay_DH date not null,
Ma_SP int not null,
So_Luong int not null,
Ma_KH int not null,
primary key(Ma_DH),
foreign key(Ma_SP) references san_pham(Ma_SP),
foreign key(Ma_KH) references khach_hang(Ma_KH)
)engine = InnoDB;

insert into san_pham value(1,"Mì Tôm",5000.0);
insert into san_pham value(2,"coca cola",10000.0);
insert into san_pham value(3,"pepsi",10000.0);

insert into khach_hang value(1,"Ngô Quốc Ân 1","0123456789","abcxyz");
insert into khach_hang value(2,"Ngô Quốc Ân 2","0111111111","qwerty");
insert into khach_hang value(3,"Ngô Quốc Ân 3","0999999999","zxcvbn");

insert into don_hang value(1,'2021-07-19',1,1,1);
insert into don_hang value(2,'2021-07-19',1,1,1);
insert into don_hang value(3,'2021-07-19',2,2,2);
insert into don_hang value(4,'2021-07-19',3,5,1);
insert into don_hang value(5,'2021-07-19',1,4,3);

create view don_hang_view as
select khach_hang.Ma_KH, don_hang.Ngay_DH, san_pham.Ten_SP, don_hang.So_Luong,don_hang.So_Luong * san_pham.Don_Gia as Thanh_tien
from don_hang,khach_hang,san_pham
where don_hang.Ma_KH = khach_hang.Ma_KH and don_hang.Ma_SP = san_pham.Ma_SP;

