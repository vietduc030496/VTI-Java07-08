package constant;

public class SQLConstant {
	public static final String SHOW_ALL_LOP = "SELECT * FROM `Lop`;";
	
	public static final String INSERT_STU = "INSERT INTO `SinhVien`(HoLot, Ten, GioiTinh, NgaySinh, DiaChi, DienThoai, Email, ID_Lop) "
											+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
	
	public static final String FIND_STUDENT_BY_ID = "SELECT * FROM `SinhVien` WHERE ID_SV = ?;";
	
	public static final String SHOW_ALL_STU =  "SELECT sv.ID_SV, sv.HoLot, sv.Ten, sv.NgaySinh, sv.GioiTinh, l.TenLop\r\n"
											+ "FROM `SinhVien` sv\r\n"
											+ "INNER JOIN `Lop` l ON sv.ID_Lop = l.ID_Lop;";
	
	public static final String COUNT_STU_BY_GENDER =  "SELECT sv.ID_Lop, count_by_gender(sv.ID_Lop, 'Nam') Nam, count_by_gender(sv.ID_Lop, 'Nu') as Nu \r\n"
													+ "FROM `SinhVien` sv\r\n"
													+ "GROUP BY sv.ID_Lop;";
	
	public static final String SHOW_SCORE =   "SELECT DISTINCT sv.ID_SV, l.TenLop, mh.TenMonHoc, bd.Diem\r\n"
											+ "FROM `BangDiem` bd \r\n"
											+ "INNER JOIN `MonHoc` mh ON bd.ID_MonHoc = mh.ID_MonHoc\r\n"
											+ "INNER JOIN `SinhVien` sv ON sv.ID_SV = bd.ID_SV\r\n"
											+ "INNER JOIN `Lop` l ON sv.ID_Lop = l.ID_Lop		\r\n"
											+ "WHERE sv.ID_SV = ?;";
	
	public static final String COUNT_STU_BY_CLASS =   "SELECT sv.ID_SV, sv.HoLot, sv.Ten, sv.GioiTinh, sv.NgaySinh, tb2.*\r\n"
													+ "FROM `SinhVien` sv\r\n"
													+ "INNER JOIN (\r\n"
													+ "	SELECT * \r\n"
													+ "	FROM (\r\n"
													+ "		SELECT l.ID_Lop, l.TenLop, COUNT(l.ID_Lop) 'So luong'\r\n"
													+ "		FROM `SinhVien` sv\r\n"
													+ "		INNER JOIN `Lop` l ON sv.ID_Lop = l.ID_Lop \r\n"
													+ "		GROUP BY l.ID_Lop, l.TenLop\r\n"
													+ "	) AS tb1\r\n"
													+ ") AS tb2 ON tb2.ID_Lop = sv.ID_Lop;";
	
	public static final String SHOW_STU_WITH_MIN_SCORE =  "SELECT ID_SV, TenMonHoc, Diem\r\n"
														+ "FROM (\r\n"
														+ "	SELECT (ROW_NUMBER() OVER (PARTITION BY bd.ID_MonHoc ORDER BY bd.Diem DESC)) AS RowNumber, \r\n"
														+ "	bd.ID_MonHoc, bd.Diem, mh.TenMonHoc, CONCAT(sv.HoLot, ' ', sv.Ten) 'Ho ten', bd.ID_SV, l.TenLop\r\n"
														+ "FROM `BangDiem` bd \r\n"
														+ "INNER JOIN `MonHoc` mh ON mh.ID_MonHoc = bd.ID_MonHoc \r\n"
														+ "INNER JOIN `SinhVien` sv ON sv.ID_SV = bd.ID_SV\r\n"
														+ "INNER JOIN `Lop` l ON l.ID_Lop = sv.ID_Lop) AS tbl \r\n"
														+ "WHERE tbl.RowNumber = 1;";
	
	public static final String CALL_STORED_TOP_STU_BY_SUB = "CALL top_student(?);";
	
	public static final String CALL_STORE_POINT_AVERAGE = "CALL point_average(?);";
	
	public static final String CALL_FUNCTION_CALC_THE_FEE = "SELECT calc_the_fee(?) 'Hoc phi';";
}
