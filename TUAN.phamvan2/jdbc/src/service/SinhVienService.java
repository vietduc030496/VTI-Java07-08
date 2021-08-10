package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import constant.SQLConstant;
import entity.SinhVien;
import utils.DBConnection;
import utils.Validation;
import java.util.Scanner;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;


public class SinhVienService {
	private Connection con;

	private Statement sta;

	private PreparedStatement ps;
	
	private Scanner input = new Scanner(System.in);
	
	public void inputSV() throws AddressException, SQLException, MessagingException {
		SinhVien sv = new SinhVien();
		System.out.print("Nhập Họ lót: ");
		sv.setHoLot(input.nextLine());
		System.out.print("Nhập Tên: ");
		sv.setTen(input.nextLine());
		System.out.print("Nhập Giới tính: ");
		sv.setGioiTinh(input.nextLine());
		String ns, phone, email;
		while (true) {
			System.out.print("Nhập ngày sinh (yyyy-MM-dd): ");
			ns = input.nextLine();
			if (Validation.isValidDate(ns)) {
				break;
			} else {
				System.err.println("Nhập lại!");
			}
		}
		sv.setNgaySinh(ns);
		System.out.print("Nhập địa chỉ: ");
		sv.setDiaChi(input.nextLine());
		while (true) {
			System.out.print("Nhập số điện thoại: ");
			phone = input.nextLine();
			if (Validation.isValidPhone(phone)) {
				break;
			} else {
				System.err.println("Nhập lại!");
			}
		}
		sv.setDienThoai(phone);
		while (true) {
			System.out.print("Nhập email: ");
			email = input.nextLine();
			if (Validation.isValidEmail(email)) {
				break;
			} else {
				System.err.println("Nhập lại!");
			}
		}
		sv.setEmail(email);
		System.out.print("Nhập ID Lớp:");
		sv.setLopID(input.nextInt());
		
		luuSV(sv);
	}
	
	public void luuSV(SinhVien sv) throws SQLException, AddressException, MessagingException {
		con = DBConnection.getInstance().getConnection();
		ps = null;
		try {
			ps = con.prepareStatement(SQLConstant.INSERT_STU);
			ps.setString(1, sv.getHoLot());
			ps.setString(2, sv.getTen());
			ps.setString(3, sv.getGioiTinh());
			ps.setString(4, sv.getNgaySinh());
			ps.setNString(5, sv.getDiaChi());
			ps.setString(6, sv.getDienThoai());
			ps.setString(7, sv.getEmail());
			ps.setInt(8, sv.getLopID());
			
			ps.execute();
			
			//gửi mail
			SendMailService sendmail = new SendMailService();
			sendmail.send(sv.getEmail());
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			DBConnection.closePreparedStatement(ps);
			DBConnection.closeConnection(con);
		}		
	}

	public List<SinhVien> getListSinhVien() throws SQLException {
		con = DBConnection.getInstance().getConnection();
		sta = null;
		ResultSet rs = null;
		List<SinhVien> svList = new ArrayList<>();

		try {
			sta = con.createStatement();
			rs = sta.executeQuery(SQLConstant.SHOW_ALL_STU);
			while (rs.next()) {
				SinhVien sv = new SinhVien();
				sv.setSvID(rs.getInt("ID_SV"));
				sv.setHoLot(rs.getString("HoLot"));
				sv.setTen(rs.getString("Ten"));
				sv.setGioiTinh(rs.getString("GioiTinh"));
				sv.setNgaySinh(rs.getString("NgaySinh"));
				String tenLop = rs.getString("TenLop");

				svList.add(sv);
				System.out.println(sv.toString() + ", Tên lớp: " + tenLop);
			}
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(sta);
			DBConnection.closeConnection(con);
		}
		return svList;
	}
	
	public void countStuByGender() throws SQLException {
		con = DBConnection.getInstance().getConnection();
		sta = null;
		ResultSet rs = null;
		try {
			sta = con.createStatement();
			rs = sta.executeQuery(SQLConstant.COUNT_STU_BY_GENDER);
			int lopID, nam, nu;
			while (rs.next()) {
				lopID = rs.getInt("ID_Lop");
				nam = rs.getInt("Nam");
				nu = rs.getInt("Nu");
				System.out.println("Lớp ID: " + lopID + ", Nam: " + nam + ", Nữ:" + nu);
			}
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(sta);
			DBConnection.closeConnection(con);
		}
	}

	public void showScoreById(int svID) throws SQLException {
		con = DBConnection.getInstance().getConnection();
		sta = null;
		ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(SQLConstant.SHOW_SCORE);
			ps.setInt(1, svID);
			rs = ps.executeQuery();
			while (rs.next()) {
				String tenLop = rs.getString("TenLop");
				String tenMonHon = rs.getString("TenMonHoc");
				double diem = rs.getDouble("Diem");
				
				System.out.println("SV ID: " + svID + ", Tên lớp: " + tenLop + ", Tên môn học: " + tenMonHon + ", Điểm: " + diem);
			}
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(sta);
			DBConnection.closeConnection(con);
		}
	}
	
	public void showStuByClass() throws SQLException {
		con = DBConnection.getInstance().getConnection();
		sta = null;
		ps = null;
		ResultSet rs = null;

		try {
			sta = con.createStatement();
			rs = sta.executeQuery(SQLConstant.COUNT_STU_BY_CLASS);
			while (rs.next()) {
				int svID = rs.getInt("ID_SV");
				String hoLot = rs.getString("HoLot");
				String ten = rs.getString("Ten");
				String gioiTinh = rs.getString("GioiTinh");
				String ns = rs.getString("NgaySinh");
				int lopID = rs.getInt("ID_Lop");
				String tenLop = rs.getString("TenLop");
				int soLuong = rs.getInt("So luong");
				
				System.out.println("SV ID: " + svID + ", Họ lót: " + hoLot + ", Tên: " + ten + ", Giới tính: " + gioiTinh 
						+ ", Ngày sinh: " + ns + ", Lớp ID: " + lopID + ", Tên lớp: " + tenLop + ", Số lượng: " + soLuong);
			}
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(sta);
			DBConnection.closeConnection(con);
		}
	}
	
	public void showStuWithMinScore() throws SQLException {
		con = DBConnection.getInstance().getConnection();
		sta = null;
		ps = null;
		ResultSet rs = null;

		try {
			sta = con.createStatement();
			rs = sta.executeQuery(SQLConstant.SHOW_STU_WITH_MIN_SCORE);
			while (rs.next()) {
				int svID = rs.getInt("ID_SV");
				String tenMonHoc = rs.getString("TenMonHoc");
				double diem = rs.getDouble("Diem");
				
				System.out.println("SV ID: " + svID + ", Tên môn học: " + tenMonHoc + ", Điểm: " + diem);
			}
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(sta);
			DBConnection.closeConnection(con);
		}
	}

	public List<SinhVien> callTopSV(int monHocID) throws SQLException {
		con = DBConnection.getInstance().getConnection();
		sta = null;
		ResultSet rs = null;
		ps = null;
		List<SinhVien> svList = new ArrayList<>();

		try {
			ps = con.prepareStatement(SQLConstant.CALL_STORED_TOP_STU_BY_SUB);
			ps.setInt(1, monHocID);
			rs = ps.executeQuery();
			while (rs.next()) {
				SinhVien sv = new SinhVien();
				sv.setSvID(rs.getInt("ID_SV"));
				sv.setHoLot(rs.getString("HoLot"));
				sv.setTen(rs.getString("Ten"));
				sv.setGioiTinh(rs.getString("GioiTinh"));
				sv.setNgaySinh(rs.getString("NgaySinh"));
				sv.setDiaChi(rs.getString("DiaChi"));
				sv.setDienThoai(rs.getString("DienThoai"));
				sv.setEmail(rs.getString("Email"));
				sv.setLopID(rs.getInt("ID_Lop"));
				double diem = rs.getDouble("Diem");
				svList.add(sv);
				System.out.println(sv.toString() + ", Điểm: " + diem);
			}
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(sta);
			DBConnection.closeConnection(con);
		}
		return svList;

	}
	
	public void pointAverage(int svID) throws SQLException {
		con = DBConnection.getInstance().getConnection();
		sta = null;
		ResultSet rs = null;
		ps = null;

		try {
			ps = con.prepareStatement(SQLConstant.CALL_STORE_POINT_AVERAGE);
			ps.setInt(1, svID);
			rs = ps.executeQuery();
			while (rs.next()) {
				String hoTen = rs.getString("Ho ten");
				double diemTB = rs.getDouble("Diem TB");
				System.out.println("Họ tên: " + hoTen + ", Điểm TB: " + diemTB);
			}
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(sta);
			DBConnection.closeConnection(con);
		}
	}
	
	public void calcTheFee(int svID) throws SQLException {
		con = DBConnection.getInstance().getConnection();
		sta = null;
		ResultSet rs = null;
		ps = null;

		try {
			ps = con.prepareStatement(SQLConstant.CALL_FUNCTION_CALC_THE_FEE);
			ps.setInt(1, svID);
			rs = ps.executeQuery();
			while (rs.next()) {
				double hocPhi = rs.getDouble("Hoc phi");
				System.out.println("Học phí: " + hocPhi);
			}
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(sta);
			DBConnection.closeConnection(con);
		}
	}
}
