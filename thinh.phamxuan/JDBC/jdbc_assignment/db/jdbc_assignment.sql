DROP DATABASE IF EXISTS jdbs_assignment;
CREATE DATABASE jdbs_assignment;
USE jdbs_assignment;
DROP TABLE IF EXISTS lop;
CREATE TABLE lop (
	ID_Lop TINYINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    TenLop VARCHAR(50) NOT NULL UNIQUE KEY,
    NienKhoa VARCHAR(50) NOT NULL
    );
    
DROP TABLE IF EXISTS sinhvien;
CREATE TABLE sinhvien (
	ID_SV TINYINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    HoLot VARCHAR(50) NOT NULL,
    Ten VARCHAR(50) NOT NULL,
	GioiTinh VARCHAR(50) NOT NULL,
	NgaySinh DATE NOT NULL,
	DiaChi VARCHAR(100) NOT NULL,
	DienThoai VARCHAR(50) NOT NULL UNIQUE KEY,
	Email VARCHAR(50) NOT NULL UNIQUE KEY,
    ID_Lop TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY(ID_Lop) REFERENCES `Lop`(ID_Lop)                  
    );
 
DROP TABLE IF EXISTS monhoc;
CREATE TABLE monhoc (
	ID_MonHoc TINYINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    TenMonHoc VARCHAR(50) NOT NULL UNIQUE KEY,
    SoTinChi INT NOT NULL
    );   
    
DROP TABLE IF EXISTS bangdiem;
CREATE TABLE bangdiem (
    ID_SV TINYINT UNSIGNED NOT NULL,
    ID_MonHoc TINYINT UNSIGNED NOT NULL,
	Diem FLOAT NOT NULL,
    FOREIGN KEY (ID_SV) REFERENCES `SinhVien`(ID_SV),
	FOREIGN KEY (ID_MonHoc) REFERENCES `MonHoc`(ID_MonHoc),
    PRIMARY KEY(ID_SV,ID_MonHoc)
    );
    

    
INSERT INTO lop (TenLop,NienKhoa) VALUES ("CNTT1","2017"),
("CNTT2","2017"),
("CNTT3","2018"),
("CNTT4","2019"),
("CNTT5","2020");
INSERT INTO sinhvien (HoLot,Ten,GioiTinh,NgaySinh,DiaChi,DienThoai,Email,ID_Lop) VALUES ("Pham","Thinh","Nam","1999-06-05","HaiPhong","0988418412","a@gmail.com",1),
("Vu","Long","Nam","2000-12-11","HaiPhong","0955482695","b@gmail.com",3),
("Vu","Duc","Nam","2000-01-15","HaiPhong","0985896425","c@gmail.com",3),
("Pham","Duong","Nu","2001-12-08","HaNoi","0976556845","d@gmail.com",4),
("Nguyen","Linh","Nu","2002-01-01","HaiPhong","0973622595","e@gmail.com",5);
INSERT INTO monhoc (TenMonHoc,SoTinChi) VALUES ("DaiSo",3),
("GiaiTich",3),
("Triet",3),
("TheDuc",1),
("QuanTri",2);
INSERT INTO bangdiem (ID_SV,ID_MonHoc,Diem) VALUES (1,1,7),
(1,2,6),
(1,3,5),
(1,4,8),
(1,5,9),
(2,1,6),
(2,2,7),
(2,3,2),
(2,4,9),
(2,5,10),
(3,2,9),
(3,4,5),
(4,5,3),
(4,1,4),
(5,1,10),
(5,2,2),
(5,3,4);

DROP PROCEDURE IF EXISTS hienThiSinhVienDiemTop5;
DELIMITER $$
CREATE PROCEDURE hienThiSinhVienDiemTop5(IN in_id_monhoc INT)
	BEGIN
        SELECT monhoc.TenMonHoc,sinhvien.ID_SV,sinhvien.Ten,bangdiem.Diem
        FROM bangdiem
        INNER JOIN sinhvien 
        ON bangdiem.ID_SV=sinhvien.ID_SV
        INNER JOIN monhoc
        ON bangdiem.ID_MonHoc=monhoc.ID_MonHoc
        WHERE bangdiem.ID_MonHoc=in_id_monhoc
        GROUP BY bangdiem.Diem
        ORDER BY bangdiem.Diem DESC
        LIMIT 5;
        
	END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS tinhDiemTBSV;
DELIMITER $$
CREATE PROCEDURE tinhDiemTBSV(IN in_id_sinhvien INT)
	BEGIN
		SELECT AVG(Diem) AS DiemTB 
        FROM bangdiem
        WHERE ID_SV = in_id_sinhvien;
	END$$
DELIMITER ;

DROP FUNCTION IF EXISTS tinhTienHocSV;
DELIMITER $$
CREATE FUNCTION tinhTienHocSV(in_id_sinhvien INT) 
RETURNS FLOAT
DETERMINISTIC
BEGIN
    DECLARE hocphi FLOAT;
    SET hocphi = (SELECT SUM(monhoc.SoTinChi) 
					FROM monhoc
					INNER JOIN bangdiem
                    ON monhoc.ID_MonHoc=bangdiem.ID_MonHoc
                    WHERE bangdiem.ID_SV=in_id_sinhvien)* 500000;
	RETURN hocphi;
END$$
DELIMITER ;




