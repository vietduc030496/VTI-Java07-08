package constant;

public class SQLConstant {
	public static final String SELECT_ALL_SinhVien = "SELECT * FROM sinhvien;";
	
	public static final String SELECT_ALL_LOP = "SELECT * FROM lop;";
	
	public static final String SELECT_GENDER = "select ID_Lop, gioiTinh, count(gioiTinh) counted "
											+ "from jdbc_vti.sinhvien sv "
											+ "where gioiTinh = 'nam' "
											+ "group by ID_Lop "
											+ "union "
											+ "select ID_Lop, gioiTinh, count(gioiTinh) counted "
											+ "from jdbc_vti.sinhvien sv "
											+ "where gioiTinh = 'nu' "
											+ "group by ID_Lop ";

	public static final String SELECT_QUANTITY_PER_CLASS = "select sv.ID_Lop ,count(sv.ID_Lop) quantity "
															+ "from sinhvien sv "
															+ "group by sv.ID_Lop";
	
	public static final String SELECT_SINHVIEN_BY_ID = "select sv.ID_SV, sv.hoLot, sv.ten, sv.gioiTinh, sv.ngaySinh "
													+ "from sinhvien sv "
													+ "where sv.ID_Lop = ?";
	
	public static final String SELECT_MIN_MARK_PER_SUBJECT = "select bd.ID_SV, sv.hoLot, sv.ten, sv.gioiTinh,sv.ngaySinh, mh.tenMonHoc, min(diem) diemMin "
															+ "from bangdiem bd "
															+ "join monhoc mh "
															+ "on mh.ID_MonHoc = bd.ID_MonHoc "
															+ "join sinhvien sv "
															+ "on sv.ID_SV = bd.ID_SV "
															+ "group by bd.ID_MonHoc";
	
	public static final String SELECT_TOP5MARK = "select distinct bd.diem "
												+ "from bangdiem bd "
												+ "order by bd.diem desc "
												+ "limit 5";
	
	public static final String SELECT_SINHVIEN_BY_MARK = "select bd.ID_SV, bd.diem, sv.hoLot, sv.ten, sv.gioiTinh, sv.ngaySinh "
														+ "from bangdiem bd "
														+ "join sinhvien sv "
														+ "on bd.ID_SV = sv.ID_SV "
														+ "where bd.diem = ?";
	
	public static final String INSERT_SINHVIEN = "INSERT INTO sinhvien(`hoLot`, `ten`, `gioiTinh`, `ngaySinh`, `diaChi`, `dienThoai`, `email`, `ID_Lop`) "
												+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
}
