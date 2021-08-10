create database jdbc_vti;

use jdbc_vti;

drop table if exists lop;
create table lop(
	ID_Lop int auto_increment primary key,
    tenLop varchar(255),
    nienKhoa int
);

drop table if exists sinhVien;
create table sinhVien(
	ID_SV int auto_increment primary key,
    hoLot varchar(255),
    ten varchar(255),
    gioiTinh varchar(255),
    ngaySinh date,
    diaChi varchar(255),
    dienThoai varchar(255),
    email varchar(255),
    ID_Lop int,
    foreign key (ID_Lop) references lop(ID_Lop)
);

drop table if exists monHoc;
create table monHoc(
	ID_MonHoc int auto_increment primary key,
    tenMonHoc varchar(255),
    soTinChi int
);

drop table if exists bangDiem;
create table bangDiem(
	ID_SV int,
    ID_MonHoc int,
    diem int,
    primary key(ID_SV, ID_MonHoc)
);

--------------------------- INSERT ---------------------------
INSERT INTO `jdbc_vti`.`lop` (`tenLop`, `nienKhoa`) VALUES ('cn8', '2017');
INSERT INTO `jdbc_vti`.`lop` (`tenLop`, `nienKhoa`) VALUES ('cn2', '2016');
INSERT INTO `jdbc_vti`.`lop` (`tenLop`, `nienKhoa`) VALUES ('cn9', '2018');
INSERT INTO `jdbc_vti`.`lop` (`tenLop`, `nienKhoa`) VALUES ('cn10', '2015');
INSERT INTO `jdbc_vti`.`lop` (`tenLop`, `nienKhoa`) VALUES ('cn11', '2019');

INSERT INTO `jdbc_vti`.`sinhvien` (`hoLot`, `ten`, `gioiTinh`, `ngaySinh`, `diaChi`, `dienThoai`, `email`, `ID_Lop`) VALUES ('a', 'a', 'nam', '1999-04-20', 'ha noi ', '0123456789', 'abc@gmail.com', '1');
INSERT INTO `jdbc_vti`.`sinhvien` (`hoLot`, `ten`, `gioiTinh`, `ngaySinh`, `diaChi`, `dienThoai`, `email`, `ID_Lop`) VALUES ('b', 'b', 'nu', '1999-05-28', 'ha noi ', '0123456789', 'abc@gmail.com', '2');
INSERT INTO `jdbc_vti`.`sinhvien` (`hoLot`, `ten`, `gioiTinh`, `ngaySinh`, `diaChi`, `dienThoai`, `email`, `ID_Lop`) VALUES ('c', 'c', 'nam', '1999-06-27', 'ha noi ', '0123456789', 'abc@gmail.com', '3');
INSERT INTO `jdbc_vti`.`sinhvien` (`hoLot`, `ten`, `gioiTinh`, `ngaySinh`, `diaChi`, `dienThoai`, `email`, `ID_Lop`) VALUES ('d', 'd', 'nu', '1999-08-21', 'ha noi ', '0123456789', 'abc@gmail.com', '4');
INSERT INTO `jdbc_vti`.`sinhvien` (`hoLot`, `ten`, `gioiTinh`, `ngaySinh`, `diaChi`, `dienThoai`, `email`, `ID_Lop`) VALUES ('e', 'e', 'nu', '1999-09-22', 'ha noi ', '0123456789', 'abc@gmail.com', '5');
INSERT INTO `jdbc_vti`.`sinhvien` (`hoLot`, `ten`, `gioiTinh`, `ngaySinh`, `diaChi`, `dienThoai`, `email`, `ID_Lop`) VALUES ('f', 'f', 'nam', '1999-10-25', 'ha noi ', '0123456789', 'abc@gmail.com', '2');

INSERT INTO `jdbc_vti`.`monhoc` (`tenMonHoc`, `soTinChi`) VALUES ('lap trinh web', '3');
INSERT INTO `jdbc_vti`.`monhoc` (`tenMonHoc`, `soTinChi`) VALUES ('lap trinh mang', '3');
INSERT INTO `jdbc_vti`.`monhoc` (`tenMonHoc`, `soTinChi`) VALUES ('csdl', '3');
INSERT INTO `jdbc_vti`.`monhoc` (`tenMonHoc`, `soTinChi`) VALUES ('dai so', '2');
INSERT INTO `jdbc_vti`.`monhoc` (`tenMonHoc`, `soTinChi`) VALUES ('giai tich', '2');

INSERT INTO `jdbc_vti`.`bangdiem` (`ID_SV`, `ID_MonHoc`, `diem`) VALUES ('1', '1', '10');
INSERT INTO `jdbc_vti`.`bangdiem` (`ID_SV`, `ID_MonHoc`, `diem`) VALUES ('2', '2', '9');
INSERT INTO `jdbc_vti`.`bangdiem` (`ID_SV`, `ID_MonHoc`, `diem`) VALUES ('3', '3', '8');
INSERT INTO `jdbc_vti`.`bangdiem` (`ID_SV`, `ID_MonHoc`, `diem`) VALUES ('4', '4', '7');
INSERT INTO `jdbc_vti`.`bangdiem` (`ID_SV`, `ID_MonHoc`, `diem`) VALUES ('1', '5', '6');
INSERT INTO `jdbc_vti`.`bangdiem` (`ID_SV`, `ID_MonHoc`, `diem`) VALUES ('6', '2', '5');
INSERT INTO `jdbc_vti`.`bangdiem` (`ID_SV`, `ID_MonHoc`, `diem`) VALUES ('1', '3', '4');
INSERT INTO `jdbc_vti`.`bangdiem` (`ID_SV`, `ID_MonHoc`, `diem`) VALUES ('2', '4', '3');
INSERT INTO `jdbc_vti`.`bangdiem` (`ID_SV`, `ID_MonHoc`, `diem`) VALUES ('3', '2', '2');
INSERT INTO `jdbc_vti`.`bangdiem` (`ID_SV`, `ID_MonHoc`, `diem`) VALUES ('4', '3', '1');
INSERT INTO `jdbc_vti`.`bangdiem` (`ID_SV`, `ID_MonHoc`, `diem`) VALUES ('5', '4', '6');
INSERT INTO `jdbc_vti`.`bangdiem` (`ID_SV`, `ID_MonHoc`, `diem`) VALUES ('6', '5', '5');

----------------------------------------------------
/* 
		Dem so nam/nu moi lop
select ID_Lop, gioiTinh, count(gioiTinh) as counted
from jdbc_vti.sinhvien sv
where gioiTinh = 'nu'
group by ID_Lop
union
select ID_Lop, gioiTinh, count(gioiTinh) as counted
from jdbc_vti.sinhvien sv
where gioiTinh = 'nam'
group by ID_Lop
*/
-- q4
drop procedure if exists get_sv_byID

DELIMITER $$	
CREATE PROCEDURE get_sv_byID(IN id_sv int)
	BEGIN
		select sv.ID_SV, lop.tenLop, mh.tenMonHoc, bd.diem
		from sinhvien sv, bangdiem bd, lop, monhoc mh 
		where bd.ID_SV = sv.ID_SV
		and bd.ID_MonHoc = mh.ID_MonHoc
		and sv.ID_Lop = lop.ID_Lop
		and sv.ID_SV = id_sv;
    END$$
DELIMITER ;

call get_sv_byID(1);

-- q8
drop procedure if exists get_avarage_mark_byID

DELIMITER $$	
CREATE PROCEDURE get_avarage_mark_byID(IN id_sv int)
	BEGIN
		select avg(bd.diem) avg_mark
		from bangdiem bd
		where bd.ID_SV = id_sv;
    END$$
DELIMITER ;

call get_avarage_mark_byID(1);

-- q9
drop procedure if exists get_tuition_fee_byID

DELIMITER $$	
CREATE PROCEDURE get_tuition_fee_byID(IN id_sv int)
	BEGIN
		declare sotinchi int;
        declare hocphi int;
        
        set @sotinchi = (select sum(mh.soTinChi) 
						from bangdiem bd
						join monhoc mh
						on bd.ID_MonHoc = mh.ID_MonHoc
						where bd.ID_SV = id_sv);
		set @hocphi = @sotinchi * 500000;
                        
		select round(@hocphi, -1) as hocphi;
    END$$
DELIMITER ;

call get_tuition_fee_byID(1);

