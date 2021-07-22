use learsql;
Create database if not exists learnsql;
create  table  if not exists San_Pham (
	Ma_Sp INT(10) auto_increment primary key,
	Ten_SP varchar(225) ,
    Don_gia int(10)
)ENGINE = InnoDB ;

create table  if not exists Khach_hang(
	Ma_KH int (10) auto_increment primary key,
	Ten_KH varchar(225) ,
    Phone varchar(10),
	Ghi_chu varchar(225)
)Engine  =InnoDB ;
create table  if not exists Don_hang (
	Ma_DH int(10) auto_increment primary key ,
    Ngay_DH Date ,
     Ma_SP int(10),
	foreign key (Ma_SP) references  San_Pham (Ma_Sp),
    So_Luong int(100) ,
    Ma_KH int(10),
    foreign key (Ma_KH) references  Khach_Hang (Ma_KH)
);
-- insert into San_pham(Ten_SP ,Don_gia ) values('Nguyen Van Hieu','19') ;
-- insert into San_pham(Ten_SP ,Don_gia ) values('Nguyen Van Nam','19') ;
-- insert into San_pham(Ten_SP ,Don_gia ) values('Nguyen Van HAi','19') ;
-- insert into Khach_hang(Ten_KH,Phone,Ghi_chu) values('ngo quoc an','098343433','khong co gi');
-- insert into Khach_hang(Ten_KH,Phone,Ghi_chu) values('Nguyen Van An ','098343433','khong co gi');
-- insert into Khach_hang(Ten_KH,Phone,Ghi_chu) values('Nguyen Van Cuong ','098343433','khong co gi');
-- insert into Khach_hang(Ten_KH,Phone,Ghi_chu) values('Ngo Huy Hoang','098343433','khong co gi');
-- insert into Khach_hang(Ten_KH,Phone,Ghi_chu) values('Ba Van Kien ','098343433','khong co gi');
-- insert into Don_hang(Ngay_DH,Ma_SP,So_luong,Ma_KH) values ('1999-12-10','1','12','1');
-- insert into Don_hang(Ngay_DH,Ma_SP,So_luong,Ma_KH) values ('1999-12-10','2','12','4');
-- insert into Don_hang(Ngay_DH,Ma_SP,So_luong,Ma_KH) values ('1999-12-10','3','12','3');
-- insert into Don_hang(Ngay_DH,Ma_SP,So_luong,Ma_KH) values ('1999-12-10','1','12','2');
-- insert into Don_hang(Ngay_DH,Ma_SP,So_luong,Ma_KH) values ('1999-12-10','2','12','7');


create view  viewdonhang2 as 
select
Ten_KH,
Ngay_DH,
Ten_SP,
So_Luong,
don_hang.So_Luong*san_pham.don_gia as Thanh_tien
from don_hang
inner join san_pham on don_hang.Ma_SP = san_pham.Ma_Sp
inner join khach_hang on don_hang.ma_KH = khach_hang.Ma_KH;

select * from viewdonhang2 ;
