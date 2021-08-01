CREATE DATABASE qldiem;
USE qldiem;
CREATE TABLE IF NOT EXISTS lop(
	ID_Lop INT NOT NULL AUTO_INCREMENT,
    TenLop VARCHAR(45) NOT NULL UNIQUE,
    NienKhoa VARCHAR(45) NOT NULL,
    PRIMARY KEY (ID_Lop)
);

CREATE TABLE IF NOT EXISTS sinhvien(
	ID_SV INT NOT NULL AUTO_INCREMENT,
    HoLot VARCHAR(45) NOT NULL,
    Ten VARCHAR(45) NOT NULL,
    GioiTinh BOOLEAN NOT NULL,
    NgaySinh DATE NOT NULL,
    DienThoai VARCHAR(45) NOT NULL UNIQUE,
    Email VARCHAR(45) NOT NULL UNIQUE,
    ID_Lop INT NOT NULL,
    PRIMARY KEY (ID_SV),
    FOREIGN KEY (ID_Lop) REFERENCES lop(ID_Lop)
);

CREATE TABLE IF NOT EXISTS monhoc(
	ID_MonHoc INT NOT NULL AUTO_INCREMENT,
    TenMonHoc VARCHAR(45) NOT NULL UNIQUE,
    SoTinChi INT NOT NULL,
    PRIMARY KEY (ID_MonHoc)
);

CREATE TABLE IF NOT EXISTS bangdiem(
	ID_SV INT NOT NULL,
	ID_MonHoc INT NOT NULL,
    Diem FLOAT NOT NULL,
    PRIMARY KEY (ID_SV,ID_MonHoc),
    FOREIGN KEY (ID_SV) REFERENCES sinhvien(ID_SV),
    FOREIGN KEY (ID_MonHoc) REFERENCES monhoc(ID_MonHoc)
);

INSERT INTO lop VALUES
(NULL,'Lop 1','2017'),
(NULL,'Lop 2','2017'),
(NULL,'Lop 3','2017'),
(NULL,'Lop 4','2018'),
(NULL,'Lop 5','2018'),
(NULL,'Lop 6','2019');

INSERT INTO monhoc VALUES
(NULL,'Mon hoc 1','3'),
(NULL,'Mon hoc 2','3'),
(NULL,'Mon hoc 3','4'),
(NULL,'Mon hoc 4','4'),
(NULL,'Mon hoc 5','4'),
(NULL,'Mon hoc 6','2'),
(NULL,'Mon hoc 7','2'),
(NULL,'Mon hoc 8','1');

INSERT INTO sinhvien VALUES
(NULL,'Ngo Quoc','An',1,'1999-10-12','0143426772','ngooquocca@gmail.com',1),
(NULL,'Ngoo Quoc','Annn',1,'1999-10-12','0143426772','ngoquoccann@gmail.com',1),
(NULL,'Ngoo Quocc','An',1,'1999-10-12','0177426772','ngoquoccann@gmail.com',2),
(NULL,'Ngoo Qucc','Ann',1,'1999-10-12','0143446772','ngooquocann@gmail.com',2),
(NULL,'Noo Quocc','Ann',1,'1999-10-12','0144526772','ngooquocann@gmail.com',2),
(NULL,'Ngoo Qucc','Annn',1,'1999-10-12','0143478772','ngooquocnn@gmail.com',1);

INSERT INTO bangdiem VALUES
(1,1,9.5),(1,2,9.8),(1,3,9.7),(1,4,9.6),(2,1,5.8),(2,2,9.4),
(2,3,3.8),(3,1,4.8),(3,2,6.8),(3,4,5.3),(4,1,3.8),(5,1,4.8);

-- function q3
DROP FUNCTION IF EXISTS count_by_gender;
DELIMITER $$
CREATE FUNCTION count_by_gender(lop_id INT ,gender_id BOOLEAN) RETURNS INT
DETERMINISTIC
	BEGIN
		DECLARE soluong INT DEFAULT 0;
		SET soluong = (	SELECT COUNT(*)
						FROM sinhvien
                        WHERE sinhvien.GioiTinh = gender_id AND sinhvien.ID_Lop = lop_id
                        );
		RETURN soluong;
	END$$
DELIMITER ;

-- stored Q7
DROP PROCEDURE IF EXISTS list_sinh_vien_with_score_by_mon_hoc;
DELIMITER $$
CREATE PROCEDURE list_sinh_vien_with_score_by_mon_hoc(IN id_monhoc INT)
	BEGIN 
		SELECT *
        FROM bangdiem bd JOIN sinhvien sv ON bd.ID_SV = sv.ID_SV 
        JOIN (SELECT bd.Diem FROM bangdiem bd WHERE bd.ID_MonHoc = id_monhoc GROUP BY bd.Diem LIMIT 5)
        AS diem ON bd.Diem = diem.Diem
        WHERE bd.ID_MonHoc = id_monhoc 							
        ;
	END$$
DELIMITER ;

-- stored Q8
DROP PROCEDURE IF EXISTS avg_score_by_student;
DELIMITER $$
CREATE PROCEDURE avg_score_by_student(IN id_sv INT)
	BEGIN 
		SELECT ROUND(AVG(bd.Diem),2) AS `AVG`
        FROM bangdiem bd
        WHERE bd.ID_SV = id_sv; 							
	END$$
DELIMITER ;

-- function Q9
DROP FUNCTION IF EXISTS hoc_phi_by_student;
DELIMITER $$
CREATE FUNCTION hoc_phi_by_student(sv_id INT) RETURNS DOUBLE
DETERMINISTIC
	BEGIN
		DECLARE hocphi DOUBLE DEFAULT 0.0;
		SET hocphi = (  SELECT SUM(tblHocPhiMon.HocPhiMon)
						FROM (SELECT mh.SoTinChi*500000 AS HocPhiMon
							  FROM bangdiem bd JOIN monhoc mh ON bd.ID_MonHoc = mh.ID_MonHoc
							  WHERE bd.ID_SV = sv_id) AS tblHocPhiMon
						);
        RETURN hocphi;
	END$$
DELIMITER ;