/*============================== CREATE DATABASE =======================================*/
/*======================================================================================*/
DROP DATABASE IF EXISTS JDBCAssignment;
CREATE DATABASE JDBCAssignment;
USE JDBCAssignment;

/*============================== CREATE TABLE=== =======================================*/
/*======================================================================================*/

-- create table 1: Lop
DROP TABLE IF EXISTS `Lop`;
CREATE TABLE `Lop`(
	ID_Lop 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    TenLop 			NVARCHAR(30) NOT NULL UNIQUE KEY,
    NienKhoa 		NVARCHAR(30) NOT NULL
);

-- create table 2: SinhVien
DROP TABLE IF EXISTS `SinhVien`;
CREATE TABLE `SinhVien`(
	ID_SV				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    HoLot				VARCHAR(50) NOT NULL,
    Ten					NVARCHAR(50) NOT NULL,
    GioiTinh			NVARCHAR(50) NOT NULL,
    NgaySinh			DATE NOT NULL,
    DiaChi	 			NVARCHAR(50) NOT NULL,
    DienThoai			NVARCHAR(50) NOT NULL,
    Email				VARCHAR(50) NOT NULL UNIQUE KEY,
    ID_Lop				TINYINT UNSIGNED NOT NULL,
    
    FOREIGN KEY(ID_Lop) REFERENCES `Lop`(ID_Lop)
);

-- create table 3: MonHoc
DROP TABLE IF EXISTS `MonHoc`;
CREATE TABLE `MonHoc`(
	ID_MonHoc				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    TenMonHoc				NVARCHAR(50) NOT NULL UNIQUE KEY,
    SoTinChi				INT UNSIGNED NOT NULL
);

-- create table 4: BangDiem
DROP TABLE IF EXISTS `BangDiem`;
CREATE TABLE `BangDiem` (
	ID_SV				TINYINT UNSIGNED NOT NULL,
    ID_MonHoc			TINYINT UNSIGNED NOT NULL,
    Diem				FLOAT,
    
    FOREIGN KEY(ID_SV) REFERENCES `SinhVien`(ID_SV),
    FOREIGN KEY(ID_MonHoc) REFERENCES `MonHoc`(ID_MonHoc)
);

/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data Lop
INSERT INTO Lop (TenLop, NienKhoa) 
VALUES			(N'CN01', 2017	),
				(N'CN12', 2017	),
				(N'CN08', 2016	),
				(N'AT11', 2015  ),
				(N'MR09', 2020	);

-- Add data SinhVien
INSERT INTO `SinhVien`	(	HoLot    ,	Ten	  , GioiTinh,   NgaySinh  ,  DiaChi , 	DienThoai	, 			Email			, ID_Lop)
VALUES 					('Nguyen Hai', 'Dang' , 'Nam'	, '1989-06-11', 'Ha Noi', '0987453241'	, 'haidang29@gmail.com'		, 	1	),
						('Tong Quang', 'Anh'  , 'Nam'	, '1996-12-12', 'Ha Nam', '0392357912'	, 'hoahaiduong@gmail.com'	,   5	),
                        ('Nguyen Van', 'Chien', 'Nam'	, '1999-03-09', 'Son La', '0989359233'	, 'chienng@gmail.com'		, 	3	),
                        ('Do'		 , 'Duong', 'Nu'	, '1998-08-14', 'Lao Cai','0974973493'	, 'doduong@gmail.com'		, 	3	),
                        ('Pham Ngoc' , 'Thinh', 'Nam'	, '1990-06-01', 'Ha Noi', '0972947975'	, 'thinhpham12@gmail.com'	,   2	);				 

-- Add data MonHoc
INSERT INTO `MonHoc`(  TenMonHoc			, SoTinChi	)
VALUES 				('Vat ly dai cuong' 	, 	4		),
					('Toan cao cap 1' 		, 	3		),
                    ('Tin hoc co so 1' 		, 	2		),
                    ('Nhap mon CNPM' 		,	3		),
                    ('Tu tuong HCM' 		, 	2		);
                    
-- Add data BangDiem
INSERT INTO `BangDiem`	(ID_SV, ID_MonHoc,  Diem ) 
VALUES 					(	1 , 	2	 ,  9.5	 ),
						(	4 , 	4	 ,  9	 ),
                        (	5 , 	1	 ,  10	 ),
                        (	2 , 	2	 ,  9.5	 ),
                        (	3 , 	5	 ,  8.5	 ),
                        (	3 , 	3	 ,  6	 );
	
-- Q2
SELECT sv.ID_SV, CONCAT(sv.HoLot, ' ', sv.Ten) 'Ho ten', sv.NgaySinh, sv.GioiTinh, l.TenLop 
FROM `SinhVien` sv
INNER JOIN `Lop` l ON sv.ID_Lop = l.ID_Lop;

-- Q3
DROP FUNCTION IF EXISTS count_by_gender;
DELIMITER $$
CREATE FUNCTION count_by_gender(lop_id INT ,gender_id VARCHAR(45)) RETURNS INT
DETERMINISTIC
	BEGIN
		DECLARE soluong INT DEFAULT 0;
		SET soluong = (	SELECT COUNT(*)
						FROM `SinhVien` sv
                        WHERE sv.GioiTinh = gender_id AND sv.ID_Lop = lop_id
                        );
		RETURN soluong;
	END$$
DELIMITER ;
SELECT sv.ID_Lop, count_by_gender(sv.ID_Lop, 'Nam') Nam, count_by_gender(sv.ID_Lop, 'Nu') as Nu 
FROM `SinhVien` sv
GROUP BY sv.ID_Lop;

-- Q4
SELECT DISTINCT sv.ID_SV, l.TenLop, mh.TenMonHoc, bd.Diem
FROM `BangDiem` bd 
INNER JOIN `MonHoc` mh ON bd.ID_MonHoc = mh.ID_MonHoc
INNER JOIN `SinhVien` sv ON sv.ID_SV = bd.ID_SV
INNER JOIN `Lop` l ON sv.ID_Lop = l.ID_Lop		
WHERE sv.ID_SV = 2;
-- Q5
SELECT sv.ID_SV, sv.HoLot, sv.Ten, sv.GioiTinh, sv.NgaySinh, tb2.*
FROM `SinhVien` sv
INNER JOIN (
	SELECT * 
	FROM (
		SELECT l.ID_Lop, l.TenLop, COUNT(l.ID_Lop) 'So luong'
		FROM `SinhVien` sv
		INNER JOIN `Lop` l ON sv.ID_Lop = l.ID_Lop 
		GROUP BY l.ID_Lop, l.TenLop
	) AS tb1
) AS tb2 ON tb2.ID_Lop = sv.ID_Lop;

-- Q6
SELECT ID_SV, TenMonHoc, Diem
FROM (
	SELECT (ROW_NUMBER() OVER (PARTITION BY bd.ID_MonHoc ORDER BY bd.Diem DESC)) AS RowNumber, 
	bd.ID_MonHoc, bd.Diem, mh.TenMonHoc, CONCAT(sv.HoLot, ' ', sv.Ten) 'Ho ten', bd.ID_SV, l.TenLop
FROM `BangDiem` bd 
INNER JOIN `MonHoc` mh ON mh.ID_MonHoc = bd.ID_MonHoc 
INNER JOIN `SinhVien` sv ON sv.ID_SV = bd.ID_SV
INNER JOIN `Lop` l ON l.ID_Lop = sv.ID_Lop) AS tbl 
WHERE tbl.RowNumber = 1;

-- Q7
DROP PROCEDURE IF EXISTS top_student;
DELIMITER //
CREATE PROCEDURE top_student(IN id_monhoc INT) 
BEGIN 
	SELECT sv.*, bd.Diem
    FROM `SinhVien` sv
    INNER JOIN `BangDiem` bd ON bd.ID_SV = sv.ID_SV
    WHERE bd.Diem >= 6 AND bd.ID_MonHoc = id_monhoc;
END//
DELIMITER ;
CALL top_student(1);

-- Q8
DROP PROCEDURE IF EXISTS point_average;
DELIMITER //
CREATE PROCEDURE point_average(IN id_sv INT)
BEGIN
	SELECT CONCAT(sv.HoLot, ' ', sv.Ten) 'Ho ten', AVG(bd.Diem) 'Diem TB'
    FROM `SinhVien` sv
    INNER JOIN `BangDiem` bd ON sv.ID_SV = bd.ID_SV
    WHERE sv.ID_SV = id_sv;
END//
DELIMITER ;
CALL point_average(3);

-- Q9
DROP FUNCTION IF EXISTS calc_the_fee;
DELIMITER //
CREATE FUNCTION calc_the_fee(id_sv INT) RETURNS INT 
DETERMINISTIC
BEGIN 
	DECLARE  tong_tin_chi INTEGER;
    DECLARE hoc_phi INTEGER;
	SELECT SUM(mh.SoTinChi) INTO tong_tin_chi FROM `BangDiem` bd
	INNER JOIN `MonHoc` mh on bd.ID_MonHoc = mh.ID_MonHoc 
    WHERE bd.ID_SV = id_sv;
	SET hoc_phi = 500 * tong_tin_chi;
    RETURN hoc_phi;
END//
DELIMITER ;

SELECT calc_the_fee(3) 'Hoc phi';