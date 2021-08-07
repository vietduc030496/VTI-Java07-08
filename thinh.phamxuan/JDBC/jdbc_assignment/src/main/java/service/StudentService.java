package service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import constant.SQLConstant;
import entity.SinhVien;
import utils.DateUtils;
import utils.RegexUtils;
import utils.DBConnection;

public class StudentService {
	private Scanner sc;
	private Connection conn;
	private Statement sta;
	private PreparedStatement ps;
	private CallableStatement cs;
	public StudentService() {
		super();
		sc=new Scanner(System.in);
	}
	public void themSV() throws AddressException, SQLException, MessagingException, ParseException {
		System.out.println("Nhap ho lot");
		String firstName = sc.nextLine();

		System.out.println("Nhap ten");
		String lastName = sc.nextLine();
		System.out.println("Nhap gioi tinh");
		String gender = sc.nextLine();
		System.out.println("Nhap ngay sinh theo format yyyy-mm-dd");
		String birthDay = sc.nextLine();

		while (!DateUtils.checkValidDate(birthDay)) {
			System.out.println("Nhap sai, hay nhap theo format yyyy-mm-dd");
			birthDay = sc.nextLine();

		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate=format.parse(birthDay);
		java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime()); 
		System.out.println("Nhap dia chi");
		String address = sc.nextLine();
		System.out.println("Nhap so dien thoai");
		String phone = sc.nextLine();
		while (!RegexUtils.checkValidPhone(phone)) {
			System.out.println("Nhap sai, hay nhap lai theo format 10 chu so");
			phone = sc.nextLine();
		}

		System.out.println("Nhap email");
		String email = sc.nextLine();
		while (!RegexUtils.checkValidEmail(email)) {
			System.out.println("Nhap sai hay nhap lai");
			email = sc.nextLine();
		}
		System.out.println("Nhap id lop");
		int id_lop = sc.nextInt();
		SinhVien sv=new SinhVien(firstName,lastName,gender,sqlDate,address,phone,email,id_lop);

		chenSV(sv);
	}
	public void chenSV(SinhVien sv) throws SQLException, AddressException, MessagingException {
		conn = DBConnection.getInstance().getConnection();
		ps = null;
		try {
			ps = conn.prepareStatement(SQLConstant.CHEN_SINH_VIEN);
			ps.setString(1, sv.getHoLot());
			ps.setString(2, sv.getTen());
			ps.setString(3, sv.getGioiTinh());
			ps.setDate(4,(java.sql.Date) sv.getNgaySinh());
			ps.setString(5, sv.getDiaChi());
			ps.setString(6, sv.getDienThoai());
			ps.setString(7, sv.getEmail());
			ps.setInt(8, sv.getID_Lop());

			ps.execute();
			System.out.println("a");	
//			MailService mailService = new MailService();
//			mailService.sendMail(sv.getEmail());
			System.out.println("c");
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			DBConnection.closePreparedStatement(ps);
			DBConnection.closeConnection(conn);
		}	
	}
	public void hienThiDSSV() throws SQLException {
		conn = DBConnection.getInstance().getConnection();
		sta = null;
		ResultSet rs = null;
		try {
			sta = conn.createStatement();
			rs = sta.executeQuery(SQLConstant.HIEN_THI_SINH_VIEN);
			while(rs.next()) {
				SinhVien sv = new SinhVien();
				sv.setID_SV(rs.getInt(1));
				sv.setHoLot(rs.getString(2));
				sv.setTen(rs.getString(3));
				sv.setGioiTinh(rs.getString(4));
				sv.setNgaySinh(rs.getDate(5));
				sv.setDiaChi(rs.getString(6));
				sv.setDienThoai(rs.getString(7));
				sv.setEmail(rs.getString(8));
				sv.setID_Lop(rs.getInt(9));
				String tenLop = rs.getString(10);
				
				System.out.println(sv.toString() + "\t" +"TenLop "+ tenLop);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(sta);
			DBConnection.closeConnection(conn);
		}
	}
	public void hienThiBangDiem()  throws SQLException {
		System.out.print("Nhap ID cua sinh vien: ");
		int ID_SV = sc.nextInt();
		conn = DBConnection.getInstance().getConnection();
		ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(SQLConstant.HIEN_THI_BANG_DIEM);
			ps.setInt(1, ID_SV);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("ID_SV " + rs.getInt(1) + " TenLop "+ rs.getString(2) + 
						" TenMonHoc " + rs.getString(3) + " Diem "+ rs.getFloat(4));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closePreparedStatement(ps);
			DBConnection.closeConnection(conn);
		}
	}
	public void hienThiSVCoDiemThapNhat() throws SQLException{
		conn = DBConnection.getInstance().getConnection();
		sta = null;
		ResultSet rs = null;

		try {
			sta = conn.createStatement();
			rs = sta.executeQuery(SQLConstant.HIEN_THI_SINH_VIEN_DIEM_THAP_NHAT);

			while (rs.next()) {
				
				System.out.println("TenMonHoc " + rs.getString(1)+" ID_SV " + rs.getInt(2) + " TenSV "+ rs.getString(3) + 
						  " Diem "+ rs.getFloat(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(sta);
			DBConnection.closeConnection(conn);
		}
	}
	public void hienThiSVCoDiemTop5() throws SQLException{
		System.out.print("Nhap ID cua mon hoc: ");
		int ID_MonHoc = sc.nextInt();
		conn = DBConnection.getInstance().getConnection();
		cs = null;
		ResultSet rs = null;
		try {
			cs = (CallableStatement) conn.prepareStatement(SQLConstant.HIEN_THI_SINH_VIEN_DIEM_TOP_5);
			ps.setInt(1, ID_MonHoc);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("TenMonHoc " + rs.getString(1)+" ID_SV " + rs.getInt(2) + " TenSV "+ rs.getString(3) + 
						  " Diem "+ rs.getFloat(4));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeCallableStatement(cs);
			DBConnection.closeConnection(conn);
		}
	}
	public void tinhDiemTBSV() throws SQLException{
		System.out.print("Nhap ID cua sinh vien: ");
		int ID_SV = sc.nextInt();
		conn = DBConnection.getInstance().getConnection();
		cs = null;
		ResultSet rs = null;
		try {
			cs = (CallableStatement) conn.prepareStatement(SQLConstant.TINH_DIEM_TB_SINH_VIEN);
			ps.setInt(1,ID_SV);
			rs = ps.executeQuery();
			
			while(rs.next()) {

				System.out.println("ID_SV: "+rs.getInt(1)+" Ten "+rs.getString(2)+" TenLop: "+ rs.getString(3) +
					  " DiemTB: "+ rs.getFloat(4));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeCallableStatement(cs);
			DBConnection.closeConnection(conn);
		}
	}
	public void tinhTienHocSV() throws SQLException{
		System.out.print("Nhap ID cua sinh vien: ");
		int ID_SV = sc.nextInt();
		conn = DBConnection.getInstance().getConnection();
		ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(SQLConstant.TINH_TIEN_HOC_SINH_VIEN);
			ps.setInt(1, ID_SV);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("ID_SV: "+rs.getInt(1)+" Ten "+rs.getString(2)+" TenLop: "+ rs.getString(3) +
						  " HocPhi: "+ rs.getFloat(4));


			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closePreparedStatement(ps);
			DBConnection.closeConnection(conn);
		
	}
	}
}

	

