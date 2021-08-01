Create database if not exists JDBC_Assignment;
USE JDBC_Assignment;
create table if not exists lop(
	ID_Lop int auto_increment primary key ,
	TenLop varchar (225),
    NienKhoa varchar (225)
) ;


CREATE table if not exists sinhvien(
	ID_SV int AUTO_INCREMENT PRIMARY KEY,
    HoLot VARCHAR (225) ,
    Ten VARCHAR (225),
    GioiTinh VARCHAR (2225),
    NgaySinh DATE ,
    DiaChi VARCHAR(225) ,
    DienThoai VARCHAR (225) ,
    Email VARCHAR(225) ,
    ID_Lop int,
    FOREIGN KEY (ID_Lop) REFERENCES lop(ID_Lop)
    
);
CREATE TABLE IF NOT EXISTS MonHoc(
	ID_MonHoc INT AUTO_INCREMENT PRIMARY KEY,
    TenMonHoc  VARCHAR(225),
    SoTinChi INT
);
CREATE TABLE IF NOT EXISTS BangDiem (
	ID_SV INT,
    FOREIGN KEY (ID_SV) REFERENCES sinhvien (ID_SV),
    ID_MonHoc int ,
    FOREIGN KEY(ID_MonHoc) REFERENCES monhoc (ID_MonHoc),
    Diem int
    
);
CREATE TABLE IF NOT EXISTS Department (
    DepartmentID INT AUTO_INCREMENT,
    DepartmentName VARCHAR(250),
    PRIMARY KEY (DepartmentID)
);

INSERT INTO Department(DepartmentName) VALUES ('Division 1'), ('Division 2'), ('Project 2');
SELECT * FROM department;
-- INSERT INTO lop(TenLop,NienKhoa) values ('CN1','10');
-- INSERT INTO lop(TenLop,NienKhoa) values ('CN2','10');
-- INSERT INTO lop(TenLop,NienKhoa) values ('CN3','10');
-- INSERT INTO lop(TenLop,NienKhoa) values ('CN4','10');
-- INSERT INTO lop(TenLop,NienKhoa) values ('CN5','10');
-- INSERT INTO lop(TenLop,NienKhoa) values ('CN6','10');

-- INSERT INTO monhoc(TenMonHoc , SoTinChi ) VALUES ('Giai Tich',4);
-- INSERT INTO monhoc(TenMonHoc , SoTinChi ) VALUES ('Giai Thuat',4);
-- INSERT INTO monhoc(TenMonHoc , SoTinChi ) VALUES ('C++',4);
-- INSERT INTO monhoc(TenMonHoc , SoTinChi ) VALUES ('Huong Doi tuong',4);
-- INSERT INTO monhoc(TenMonHoc , SoTinChi ) VALUES ('Tin hoc',4);
-- INSERT INTO monhoc(TenMonHoc , SoTinChi ) VALUES ('Triet hoc ',4);




-- INSERT INTO sinhvien (HoLot,Ten,GioiTinh,NgaySinh,DiaChi,DienThoai,Email,ID_Lop)
-- VALUES ('Nguyen van','hieu',1,'1999-02-01','Ha dong','037373737','hieu@gmail.com',1);
-- INSERT INTO sinhvien (HoLot,Ten,GioiTinh,NgaySinh,DiaChi,DienThoai,Email,ID_Lop)
-- VALUES ('Nguyen van','hieu1',1,'1999-02-01','Ha dong','037373737','hieu@gmail.com',2);
-- INSERT INTO sinhvien (HoLot,Ten,GioiTinh,NgaySinh,DiaChi,DienThoai,Email,ID_Lop)
-- VALUES ('Nguyen van','hieu2',1,'1999-02-01','Ha dong','037373737','hieu@gmail.com',3);
-- INSERT INTO sinhvien (HoLot,Ten,GioiTinh,NgaySinh,DiaChi,DienThoai,Email,ID_Lop)
-- VALUES ('Nguyen van','hieu3',1,'1999-02-01','Ha dong','037373737','hieu@gmail.com',2);
-- INSERT INTO sinhvien (HoLot,Ten,GioiTinh,NgaySinh,DiaChi,DienThoai,Email,ID_Lop)
-- VALUES ('Nguyen van','hieu4',1,'1999-02-01','Ha dong','037373737','hieu@gmail.com',3);
-- INSERT INTO sinhvien (HoLot,Ten,GioiTinh,NgaySinh,DiaChi,DienThoai,Email,ID_Lop)
-- VALUES ('Nguyen van','hieu5',1,'1999-02-01','Ha dong','037373737','hieu@gmail.com',2);
-- INSERT INTO sinhvien (HoLot,Ten,GioiTinh,NgaySinh,DiaChi,DienThoai,Email,ID_Lop)
-- VALUES ('Nguyen van','hieu6',1,'1999-02-01','Ha dong','037373737','hieu@gmail.com',1);
-- INSERT INTO sinhvien (HoLot,Ten,GioiTinh,NgaySinh,DiaChi,DienThoai,Email,ID_Lop)
-- VALUES ('Nguyen van','hieu7',1,'1999-02-01','Ha dong','037373737','hieu@gmail.com',1);


SELECT *,count(ID_Lop and GioiTinh) 
from sinhvien
GROUP BY ID_Lop and GioiTinh;

SELECT sinhvien.ID_SV,TenLop,TenMonHoc,Diem  FROM sinhvien
INNER JOIN bangdiem ON bangdiem.ID_SV = sinhvien.ID_SV
INNER JOIN monhoc on monhoc.ID_MonHoc = bangdiem.ID_MonHoc
INNER JOIN lop on lop.ID_lop = sinhvien.ID_Lop
where sinhvien.ID_SV = 1;

SELECT * 
from sinhvien 
inner join bangdiem on bangdiem.ID_SV = sinhvien.ID_SV
WHERE  ID_MONHOC =1
ORDER BY Diem ASC limit 1 ;


DROP PROCEDURE IF EXISTS top_sv_by_mon_hoc;
DELIMITER $$
CREATE PROCEDURE top_sv_by_mon_hoc(IN id_monhoc INT)
	BEGIN 
		SELECT *
        FROM bangdiem 
		INNER JOIN sinhvien  ON bangdiem.ID_SV = sinhvien.ID_SV 
        WHERE bangdiem.ID_MonHoc = id_MonHoc 
        GROUP BY Diem 
        ORDER BY Diem DESC limit 5;
	END$$
DELIMITER ;

-- stored Q8
DROP PROCEDURE IF EXISTS Average_Score;
DELIMITER $$
CREATE PROCEDURE Average_Score(IN ID_SVS INT ,out avgs int)
	BEGIN 
		SELECT ROUND(AVG(bangdiem.Diem)) AS avgstu into avgs
        FROM bangdiem 
        WHERE bangdiem.ID_SV = ID_SVS ; 							
	END$$
DELIMITER ;

-- function Q9
DROP FUNCTION IF EXISTS Tuition_Fee ;
DELIMITER $$
CREATE FUNCTION Tuition_Fee(SV_IDS INT) RETURNS DOUBLE
DETERMINISTIC
	BEGIN
		DECLARE hocphi DOUBLE DEFAULT 0.0;
		SET hocphi = (  SELECT SUM(sotinchi) * 500000
						from sinhvien 
                        inner join bangdiem on bangdiem.ID_SV = sinhvien.ID_SV
                        inner join monhoc on monhoc.ID_MonHoc = bangdiem.ID_MonHoc
						);
        RETURN hocphi;
	END$$
DELIMITER ;
select Tuition_Fee(1);