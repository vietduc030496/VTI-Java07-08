package constant;

public class SqlConstant {

	private SqlConstant() {
	}

	public static final String SAVE_SINH_VIEN = "INSERT INTO sinhvien VALUES"
											  + "(NULL,?,?,?,?,?,?,?)";

	public static final String SHOW_SINH_VIEN = "SELECT * FROM sinhvien JOIN lop ON sinhvien.ID_Lop = lop.ID_Lop";
	
	public static final String COUNT_NAM_NU_BY_LOP =  "SELECT sinhvien.ID_Lop,count_by_gender(sinhvien.ID_Lop,1) as Nam,count_by_gender(sinhvien.ID_Lop,0) as Nu "
													+ "FROM sinhvien "
													+ "GROUP BY sinhvien.ID_Lop;";

	public static final String SHOW_DIEM_BY_ID_SV =   "SELECT bangdiem.ID_SV,lop.TenLop,monhoc.TenMonHoc,bangdiem.Diem "
													+ "FROM bangdiem "
													+ "JOIN monhoc ON bangdiem.ID_MonHoc = monhoc.ID_MonHoc "
													+ "JOIN sinhvien ON bangdiem.ID_SV = sinhvien.ID_SV "
													+ "JOIN lop ON sinhvien.ID_Lop = lop.ID_Lop "
													+ "WHERE sinhvien.ID_SV = ?";
	
	public static final String DANH_SACH_LOP = "SELECT * FROM lop";
	
	public static final String DANH_SACH_MON_HOC = "SELECT * FROM monhoc";
	
	public static final String SHOW_SINH_VIEN_BY_LOP = 	  "SELECT ID_SV,HoLot,Ten,GioiTinh,NgaySinh "
														+ "FROM sinhvien "
														+ "WHERE ID_Lop = ?;";
	
	public static final String SHOW_SINH_VIEN_WITH_MIN_SCORE_BY_MON_HOC = "SELECT * "
																		+ "FROM bangdiem bd "
																		+ "LEFT JOIN sinhvien sv ON bd.ID_SV = sv.ID_SV "
																		+ "WHERE bd.ID_MonHoc = ? "
																		+ "HAVING bd.Diem = ("
																							+ "SELECT MIN(bd.Diem) "
																							+ "FROM bangdiem bd "
																							+ "WHERE bd.ID_MonHoc = ?);";
	
	public static final String SHOW_SINH_VIEN_TOP_BY_MON_HOC = "CALL list_sinh_vien_with_score_by_mon_hoc(?);";
	
	public static final String AVG_SCORE_BY_STUDENT = "CALL avg_score_by_student(?);";
	
	public static final String HOC_PHI_BY_STUDENT = "SELECT hoc_phi_by_student(?) AS HocPhi;";
}
