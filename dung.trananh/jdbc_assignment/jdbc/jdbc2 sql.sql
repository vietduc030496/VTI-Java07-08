#Q1
insert into sinhvien values (null,?,?,?,?,?,?,?,?);

#Q2
select sv.id_sv, sv.holot, sv.ten,sv.ngaysinh, sv.gioitinh, l.tenlop from sinhvien as sv
natural join lop as l;

#Q3
select sv.gioitinh, l.tenlop, count(*) from  sinhvien as sv
natural join lop as l 
group by sv.gioitinh, sv.id_lop;

#Q4
select bd.id_sv, l.tenlop, mh.tenmonhoc, bd.diem
from bangdiem as bd 
natural join monhoc as mh 
natural join sinhvien as sv 
natural join lop as l
where bd.id_sv = ?;

#Q5
select sv.id_lop, count(*) from sinhvien as sv
group by sv.id_lop;

#Q6
select bd.id_sv, sv.ten, mh.tenmonhoc, bd.diem from bangdiem as bd 
natural join sinhvien as sv
natural join monhoc as mh
where bd.diem = (select min(bd2.diem) from bangdiem as bd2
				 where bd2.id_monhoc = bd.id_monhoc)
group by bd.id_monhoc;

#Q7
DROP PROCEDURE IF EXISTS getTop5Grade;
DELIMITER $$
CREATE PROCEDURE getTop5Grade(IN idmonhoc int)
	BEGIN
		SELECT sv.id_sv,sv.ten,bd.id_monhoc,bd.diem FROM bangdiem AS bd
        NATURAL JOIN sinhvien AS sv
        WHERE bd.id_monhoc = idmonhoc
        GROUP BY bd.diem
        ORDER BY bd.diem DESC
        LIMIT 5;
	END$$
DELIMITER ;

CALL getTop5Grade(2);

#Q8
DROP PROCEDURE IF EXISTS calcAverageGrade;
DELIMITER $$
CREATE PROCEDURE calcAverageGrade(IN idsv int)
	BEGIN
		SELECT avg(diem) FROM bangdiem
        WHERE id_sv = idsv;
	END$$
DELIMITER ;
CALL calcAverageGrade(1);

#Q9
DELIMITER $$

CREATE FUNCTION calcTotalFee(
	idsv int
) 
RETURNS FLOAT
DETERMINISTIC
BEGIN
    DECLARE totalfee FLOAT;
	DECLARE sotinchi INT;
    
    SET sotinchi = (SELECT SUM(mh.sotinchi) FROM monhoc as mh 
					NATURAL JOIN bangdiem as bd
                    WHERE bd.id_sv= idsv);
    SET totalfee = sotinchi * 500000;
	-- return the total fee
	RETURN (totalfee);
END$$
DELIMITER ;

select calcTotalFee(1);
