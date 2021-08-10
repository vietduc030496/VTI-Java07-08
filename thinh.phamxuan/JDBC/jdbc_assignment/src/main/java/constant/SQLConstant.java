package constant;

public class SQLConstant {
	public static final String CHEN_SINH_VIEN = "INSERT INTO sinhvien VALUES (?,?,?,?,?,?,?,?);";
	
	public static final String HIEN_THI_SINH_VIEN = "SELECT sv.ID_SV, sv.HoLot, sv.Ten, sv.GioiTinh,sv.NgaySinh,sv.DiaChi,sv.DienThoai,sv.Email,sv.ID_Lop, l.TenLop\r\n"
			+ "FROM sinhvien AS sv\r\n"
			+ "INNER JOIN lop AS l\r\n"
			+ "ON sinhvien.ID_Lop=lop.ID_LOP;";
	
	public static final String HIEN_THI_SO_LUONG_NAM_NU = "SELECT l.TenLop, sv.GioiTinh, COUNT(*)\r\n"
			+ "FROM sinhvien AS sv\r\n"
			+ "INNER JOIN lop AS l \r\n"
			+ "ON sinhvien.ID_Lop=lop.ID_LOP\r\n"
			+ "GROUP BY sv.GioiTinh, sv.ID_Lop;";
	
	public static final String HIEN_THI_BANG_DIEM = "SELECT bd.ID_SV, l.TenLop, mh.TenMonHoc, bd.Diem\r\n"
			+ "FROM bangdiem AS bd \r\n"
			+ "INNER JOIN monhoc AS mh \r\n"
			+ "ON bangdiem.ID_MonHoc=monhoc.ID_MonHoc\r\n"
			+ "INNER JOIN sinhvien AS sv \r\n"
			+ "ON bangdiem.ID_SV=sinhvien.ID_SV\r\n"
			+ "INNER JOIN lop AS l\r\n"
			+ "ON sinhvien.ID_Lop=lop.ID_Lop\r\n"
			+ "WHERE sinhvien.ID_SV = ?;";
	public static final String LAY_DANH_SACH_LOP = "SELECT * from lop;";
	public static final String HIEN_THI_SINH_VIEN_TRONG_LOP = "SELECT sv.ID_SV, sv.HoLot, sv.Ten, sv.GioiTinh,sv.NgaySinh\r\n"
			+ "FROM sinhvien AS sv\r\n"
			+ "WHERE ID_Lop = ?;";
	public static final String HIEN_THI_SINH_VIEN_DIEM_THAP_NHAT = "SELECT mh.TenMonHoc, bd.ID_SV, sv.Ten, bd.Diem\r\n"
			+ "FROM bangdiem AS bd \r\n"
			+ "INNER JOIN sinhvien AS sv\r\n"
			+ "ON bangdiem.ID_SV=sinhvien.ID_SV\r\n"
			+ "INNER JOIN monhoc AS mh\r\n"
			+ "ON bangdiem.ID_MonHoc=monhoc.ID_MonHoc\r\n"
			+ "WHERE bd.Diem = \r\n"
			+ "(SELECT MIN(bd2.Diem)\r\n"
			+ " FROM bangdiem AS bd2\r\n"
			+ "	WHERE bd2.ID_MonHoc = bd.ID_MonHoc)\r\n"
			+ "GROUP BY bd.ID_MonHoc;";
	public static final String HIEN_THI_SINH_VIEN_DIEM_TOP_5="CALL hienThiSinhVienDiemTop5(?);";
	public static final String TINH_DIEM_TB_SINH_VIEN="CALL tinhDiemTBSV(?);";
	public static final String TINH_TIEN_HOC_SINH_VIEN="SELECT tinhTienHocSV(?);";
}
