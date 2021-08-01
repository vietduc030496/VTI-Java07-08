package ToolJDBC.constant;

public class SqlConstant {

	private SqlConstant() {
	}

	public static final String SELECT_ALL_DEPT = "SELECT * FROM Department;";

	public static final String SELECT_DEPT_BY_ID = "SELECT * FROM Department WHERE DepartmentID = ?;";
	public static final String INSERT_STUDENT = "INSERT INTO SinhVien(HoLot,Ten,GioiTinh,NgaySinh,DiaChi,DienThoai,Email,ID_Lop) values (?,?,?,?,?,?,?,?) ";
	public static final String SELECT_ALL_STUDENT = "SELECT * FROM sinhvien JOIN lop ON sinhvien.ID_Lop = lop.ID_Lop";
	public static final String COUNT_BY_GENGER = "SELECT *,count(ID_Lop and GioiTinh) as counter \r\n"
			+ "from sinhvien\r\n" + "GROUP BY ID_Lop and GioiTinh";

	public static final String SELECT_MARK_BY_ID_SV = "SELECT sinhvien.ID_SV,TenLop,TenMonHoc,Diem  FROM sinhvien\r\n"
			+ "INNER JOIN bangdiem ON bangdiem.ID_SV = sinhvien.ID_SV\r\n"
			+ "INNER JOIN monhoc on monhoc.ID_MonHoc = bangdiem.ID_MonHoc\r\n"
			+ "INNER JOIN lop on lop.ID_lop = sinhvien.ID_Lop\r\n" 
			+ "where sinhvien.ID_SV = ?";

	public static final String SELECT_SINH_VIEN_BY_LOP = "SELECT ID_SV,HoLot,Ten,GioiTinh,NgaySinh " + "FROM sinhvien "
			+ "WHERE ID_Lop = ?;";
	
	
	public static final String SELECT_LOP ="SELECT * FROM Lop  ";
	public static final String COUNT_SINHVIEN_BY_ID ="SELECT *,count(ID_Lop) as counter \r\n"
			+ "from sinhvien\r\n" 
					+ "WHERE ID_Lop = ? " + " GROUP BY ID_Lop ";

	
	public static final String SELECT_SINH_VIEN_WITH_MIN_SCORE_BY_MON_HOC = "SELECT * \r\n"
			+ "from sinhvien \r\n"
			+ "inner join bangdiem on bangdiem.ID_SV = sinhvien.ID_SV\r\n"
			+ "WHERE  ID_MONHOC = ? \r\n"
			+ "ORDER BY Diem ASC limit 1 ;";
	
	public static final String SELECT_TOP_SINH_VIEN = "CALL top_sv_by_mon_hoc(?);";

	public static final String AVG_SCORE = "{CALL Average_Score(? , ? )}";

	public static final String TUITION_FEE = "{? = call Tuition_Fee(?)} ";

	public static final String SELECT_ALL_STUDENT_BY_ID =  "SELECT * FROM sinhvien where ID_Lop = ? ";

	public static final String SELECT_MonHoc = "SELECT * from Monhoc ";

}
