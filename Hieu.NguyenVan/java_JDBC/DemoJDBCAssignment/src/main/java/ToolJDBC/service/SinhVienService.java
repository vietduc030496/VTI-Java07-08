package ToolJDBC.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ToolJDBC.constant.SqlConstant;
import ToolJDBC.entity.Department;
import ToolJDBC.entity.SinhVien;
import ToolJDBC.utils.DBConnection;

public class SinhVienService {

	private Connection con;

	private Statement sta;
	
	
	public int createSinhVien(SinhVien sinhvien) throws SQLException {
		int result = 0;
		con=DBConnection.getInstance().getConnection();
		sta=null;
		ResultSet rs =null;
		PreparedStatement sta1 =con.prepareStatement(SqlConstant.INSERT_STUDENT);
		sta1.setString(1, sinhvien.getHoLot());
		sta1.setString(2, sinhvien.getTen());
		sta1.setString(3, sinhvien.getGioiTinh());
		sta1.setString(4, sinhvien.getNgaySinh());
		sta1.setString(5, sinhvien.getDiaChi());
		sta1.setString(6, sinhvien.getDienThoai());
		sta1.setString(7, sinhvien.getEmail());
		sta1.setString(8, sinhvien.getID_Lop());
				
		result=sta1.executeUpdate();
				
		return result;		
	}
	public List<SinhVien> getSinhVien() throws SQLException {
		con = DBConnection.getInstance().getConnection();
		sta = null;
		ResultSet rs = null;
		List<SinhVien> svlist = new ArrayList<>();

		try {
			sta = con.createStatement();
			rs = sta.executeQuery(SqlConstant.SELECT_ALL_STUDENT);

			while (rs.next()) {
				SinhVien sv = new SinhVien();
				sv.setID_SV(rs.getInt("ID_SV"));
				sv.setHoLot(rs.getString("HoLot"));
				sv.setTen(rs.getString("Ten"));
				sv.setGioiTinh(rs.getString("GioiTinh"));
				sv.setNgaySinh(rs.getDate("NgaySinh"));
				sv.setDienThoai(rs.getString("DienThoai"));
				sv.setEmail(rs.getString("Email"));
				sv.setID_Lop(rs.getString("ID_Lop"));
				String tenlop = rs.getString("TenLop");
				svlist.add(sv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(sta);
			DBConnection.closeConnection(con);
		}
		return svlist;
	}
	public List<SinhVien> getSinhVienbylop(int id) throws SQLException {
		con = DBConnection.getInstance().getConnection();
		sta = null;
		ResultSet rs = null;
		PreparedStatement pre=null;
		List<SinhVien> svlist = new ArrayList<>();

		try {
			pre = con.prepareStatement(SqlConstant.SELECT_ALL_STUDENT_BY_ID);
			pre.setInt(1, id);
			rs =pre.executeQuery();

			while (rs.next()) {
				SinhVien sv = new SinhVien();
				sv.setID_SV(rs.getInt("ID_SV"));
				sv.setHoLot(rs.getString("HoLot"));
				sv.setTen(rs.getString("Ten"));
				sv.setGioiTinh(rs.getString("GioiTinh"));
				sv.setNgaySinh(rs.getDate("NgaySinh"));
				sv.setDienThoai(rs.getString("DienThoai"));
				sv.setEmail(rs.getString("Email"));
				sv.setID_Lop(rs.getString("ID_Lop"));
				
				svlist.add(sv);
				System.out.println(sv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(sta);
			DBConnection.closeConnection(con);
		}
		return svlist;
	}
	public void  getMinMarkSinhVienbymonhoc(int id) throws SQLException {
		con = DBConnection.getInstance().getConnection();
		sta = null;
		ResultSet rs = null;
		PreparedStatement pre=null;
		List<SinhVien> svlist = new ArrayList<>();

		try {
			pre = con.prepareStatement(SqlConstant.SELECT_SINH_VIEN_WITH_MIN_SCORE_BY_MON_HOC);
			pre.setInt(1, id);
			rs =pre.executeQuery();

			while (rs.next()) {
				SinhVien sv = new SinhVien();
				sv.setID_SV(rs.getInt("ID_SV"));
				sv.setHoLot(rs.getString("HoLot"));
				sv.setTen(rs.getString("Ten"));
				sv.setGioiTinh(rs.getString("GioiTinh"));
				sv.setNgaySinh(rs.getDate("NgaySinh"));
				sv.setDienThoai(rs.getString("DienThoai"));
				sv.setEmail(rs.getString("Email"));
				sv.setID_Lop(rs.getString("ID_Lop"));
				int diem = rs.getInt("Diem") ;
				
				svlist.add(sv);
				System.out.println(sv +"have : " +diem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(sta);
			DBConnection.closeConnection(con);
		}
		
	}
	public void countByGenger() throws SQLException {
		con = DBConnection.getInstance().getConnection();
		sta = null;
		ResultSet rs = null;

		try {
			sta = con.createStatement();
			rs = sta.executeQuery(SqlConstant.COUNT_BY_GENGER );
			while (rs.next()) {
				String name = rs.getString("ID_LOP");
				int count =rs.getInt("counter");
				System.err.println("Class "+name+" have :"+count+" student .");
		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(sta);
			DBConnection.closeConnection(con);
		}
		
	}

	public void getMarkStudentByID(int id) throws SQLException {
		
		con = DBConnection.getInstance().getConnection();
		PreparedStatement pre = null;
		ResultSet rs = null;

		try {
			pre = con.prepareStatement(SqlConstant.SELECT_MARK_BY_ID_SV );
			pre.setInt(1, id);
			rs = pre.executeQuery();
			while (rs.next()) {
				int id_sv = rs.getInt("ID_SV");
				String tenLop = rs.getString("TenLop");
				String tenMonHoc = rs.getString("TenMonHoc");
				String diem = rs.getString("Diem");
				
				System.err.println("Student "+id_sv + "--"+tenLop+"--" +"---" +tenMonHoc +"--"+ diem);
		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(pre);
			DBConnection.closeConnection(con);
		}

		// TODO Auto-generated method stub
		
	}
	
}
