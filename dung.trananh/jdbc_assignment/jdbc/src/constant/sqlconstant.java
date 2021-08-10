package constant;

public class sqlconstant {
	
	private sqlconstant() {
	}
	public static final String INSERT_STUDENT = "insert into sinhvien values (null,?,?,?,?,?,?,?,?);";
	
	public static final String GET_ALL_STUDENT = "select sv.id_sv, sv.holot, sv.ten,sv.ngaysinh, sv.gioitinh, l.tenlop from sinhvien as sv\r\n"
			+ "natural join lop as l;";
	
	public static final String GET_COUNTERS_BY_GENDER = "select sv.gioitinh, l.tenlop, count(*) from  sinhvien as sv\r\n"
			+ "natural join lop as l \r\n"
			+ "group by sv.gioitinh, sv.id_lop;";
	
	public static final String GET_GRADE_BY_ID = "select bd.id_sv, l.tenlop, mh.tenmonhoc, bd.diem\r\n"
			+ "from bangdiem as bd \r\n"
			+ "natural join monhoc as mh \r\n"
			+ "natural join sinhvien as sv \r\n"
			+ "natural join lop as l\r\n"
			+ "where bd.id_sv = ?;";
	
	public static final String GET_COUNTERS_EACH_CLASS = "select sv.id_lop, count(*) from sinhvien as sv\r\n"
			+ "group by sv.id_lop;";
	
	public static final String GET_MIN_EACH_SUBJECT = "select bd.id_sv, sv.ten, mh.tenmonhoc, bd.diem from bangdiem as bd \r\n"
			+ "natural join sinhvien as sv\r\n"
			+ "natural join monhoc as mh\r\n"
			+ "where bd.diem = (select min(bd2.diem) from bangdiem as bd2\r\n"
			+ "				 where bd2.id_monhoc = bd.id_monhoc)\r\n"
			+ "group by bd.id_monhoc;";
}
