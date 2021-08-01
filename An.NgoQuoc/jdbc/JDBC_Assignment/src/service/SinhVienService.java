package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.mysql.cj.xdevapi.PreparableStatement;

import constant.RegexConstant;
import constant.SqlConstant;
import entity.Lop;
import entity.MonHoc;
import entity.SinhVien;
import utils.DBConnection;

public class SinhVienService {
	private Scanner sc;
	private Connection conn;
	private Statement sta;
	private PreparedStatement ps;
	private LopService lopService;
	private MonHocService monhocService;
	private ArrayList<Lop> listLop;
	private ArrayList<MonHoc> listMonHoc;
	private ArrayList<SinhVien> listSV;
	
	public SinhVienService() throws SQLException {
		sc = new Scanner(System.in);
		lopService = new LopService();
		listLop = lopService.danhSachLop();
		monhocService = new MonHocService();
		listMonHoc = monhocService.danhsachMonhoc();
	}
	
	public void nhapSinhVien() throws ParseException, SQLException, AddressException, MessagingException {
		SinhVien sv = new SinhVien();
		System.out.print("Nhập Họ lót: ");
		sv.setHolot(sc.nextLine());
		System.out.print("Nhập Tên: ");
		sv.setTen(sc.nextLine());
		System.out.print("Nhập Giới tính (Nam - 1 / Nu - 0): ");
		sv.setGioitinh(sc.nextInt());
		sc.nextLine();
		
		// validate date
		System.out.print("Nhập Ngày sinh: ");
		String strDate = "";
		while(true) {
			strDate = sc.nextLine();
			if(Pattern.compile(RegexConstant.REGEX_DATE).matcher(strDate).matches()) {
				sv.setNgaysinh(convertToDate(strDate));
				break;
			}
			System.err.print("Ngày sinh không đúng định dạng dd-mm-yyyy nhập lại: ");
		}
		
		//validate phone
		System.out.print("Nhập Điện thoại: ");
		String phone = "";
		while(true) {
			phone = sc.nextLine();
			if(Pattern.compile(RegexConstant.REGEX_PHONE).matcher(phone).matches()) {
				sv.setDienthoai(phone);
				break;
			}
			System.err.print("Điện thoại không đúng định dạng nhập lại: ");
		}
		
		//validate emali
		System.out.print("Nhập Email: ");
		String email = "";
		while(true) {
			email = sc.nextLine();
			if(Pattern.compile(RegexConstant.REGEX_MAIL).matcher(email).matches()) {
				sv.setEmail(email);
				break;
			}
			System.err.print("Email không đúng định dạng nhập lại: ");
		}
		
		System.out.print("Nhập ID Lớp:");
		sv.setID_Lop(sc.nextInt());
		
		luuSinhVien(sv);
		
	}
	public Date convertToDate(String str) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		java.util.Date date = sdf.parse(str);
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		return sqlDate;
	}
	
	public void luuSinhVien(SinhVien sv) throws SQLException, AddressException, MessagingException {
		conn = DBConnection.getInstance().getConnection();
		ps = null;
		try {
			ps = conn.prepareStatement(SqlConstant.SAVE_SINH_VIEN);
			ps.setString(1, sv.getHolot());
			ps.setString(2, sv.getTen());
			ps.setInt(3, sv.getGioitinh());
			ps.setDate(4, sv.getNgaysinh());
			ps.setString(5, sv.getDienthoai());
			ps.setString(6, sv.getEmail());
			ps.setInt(7, sv.getID_Lop());
			
			ps.execute();
			
			//gửi mail
			SendMailService sendmail = new SendMailService();
			sendmail.sendtext(sv.getEmail());
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			DBConnection.closePreparedStatement(ps);
			DBConnection.closeConnection(conn);
		}		
	}
	
	public void showSinhVien() throws SQLException {
		conn = DBConnection.getInstance().getConnection();
		sta = null;
		ResultSet rs = null;
		try {
			sta = conn.createStatement();
			rs = sta.executeQuery(SqlConstant.SHOW_SINH_VIEN);
			while(rs.next()) {
				SinhVien sv = new SinhVien();
				sv.setID_SV(rs.getInt("ID_SV"));
				sv.setHolot(rs.getString("HoLot"));
				sv.setTen(rs.getString("Ten"));
				sv.setGioitinh(rs.getInt("GioiTinh"));
				sv.setNgaysinh(rs.getDate("NgaySinh"));
				sv.setDienthoai(rs.getString("DienThoai"));
				sv.setEmail(rs.getString("Email"));
				sv.setID_Lop(rs.getInt("ID_Lop"));
				String tenlop = rs.getString("TenLop");
				
				System.out.println(sv.toString() + "\t" + tenlop);
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
	
	public void countNamNuByLop() throws SQLException{
		conn = DBConnection.getInstance().getConnection();
		sta = null;
		ResultSet rs = null;		
		try {
			sta = conn.createStatement();
			rs = sta.executeQuery(SqlConstant.COUNT_NAM_NU_BY_LOP);
			System.out.println("\tID Lop\tNam\tNu");
			while(rs.next()) {
				int id_lop = rs.getInt("ID_Lop");
				int sl_nam = rs.getInt("Nam");
				int sl_nu = rs.getInt("Nu");
				
				System.out.println("\t" + id_lop + "\t" + sl_nam + "\t" + sl_nu);
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
	
	public void hienThiBangDiemBySinhVien() throws SQLException {
		System.out.print("Nhập ID_SV: ");
		int ID_SV = sc.nextInt();
		conn = DBConnection.getInstance().getConnection();
		ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(SqlConstant.SHOW_DIEM_BY_ID_SV);
			ps.setInt(1, ID_SV);
			rs = ps.executeQuery();
			System.out.println("\tID SV\tTenLop\tTenMonHoc\tDiem");
			while(rs.next()) {
				String tenlop = rs.getString("TenLop");
				String tenmonhoc = rs.getString("TenMonHoc");
				float diem = rs.getFloat("Diem");
				
				System.out.println("\t" + ID_SV + "\t" + tenlop + "\t" + tenmonhoc + "\t" + diem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(ps);
			DBConnection.closeConnection(conn);
		}
	}
	public void showSinhVienByLop() throws SQLException {
		conn = DBConnection.getInstance().getConnection();
		ps = null;
		ResultSet rs = null;		
		try {
			ps = conn.prepareStatement(SqlConstant.SHOW_SINH_VIEN_BY_LOP);
			for (Lop lop : listLop) {
				System.out.println("Danh sách sinh viên " + lop.getTenlop());
				ps.setInt(1, lop.getId_lop());
				rs = ps.executeQuery();
				int count = rs.last() ? rs.getRow() : 0;
				rs.absolute(0);
				System.out.println("Số lượng: " + count);
				if(count != 0) {
					System.out.println("\tID_DV\tHoLot\t\tTen\tGioiTinh\tNgaySinh");
					while(rs.next()) {
						int ID_SV = rs.getInt("ID_SV");
						String HoLot = rs.getString("HoLot");
						String Ten = rs.getString("Ten");
						int GioiTinh = rs.getInt("GioiTinh");
						Date NgaySinh = rs.getDate("NgaySinh");
						
						System.out.println("\t" + ID_SV + "\t" + HoLot + "\t" + Ten + "\t" + GioiTinh + "\t\t" + NgaySinh);
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(ps);
			DBConnection.closeConnection(conn);
		}
	}
	
	public void studentWithMinScoreBySubject() throws SQLException {
		conn = DBConnection.getInstance().getConnection();
		ps = null;
		ResultSet rs = null;		
		try {
			ps = conn.prepareStatement(SqlConstant.SHOW_SINH_VIEN_WITH_MIN_SCORE_BY_MON_HOC);
			for (MonHoc monhoc : listMonHoc) {
				ps.setInt(1, monhoc.getID_MonHoc());
				ps.setInt(2, monhoc.getID_MonHoc());
				rs = ps.executeQuery();
				while(rs.next()) {
					float Diem = rs.getFloat("Diem");
					SinhVien sv = new SinhVien();
					sv.setID_SV(rs.getInt("ID_SV"));
					sv.setHolot(rs.getString("HoLot"));
					sv.setTen(rs.getString("Ten"));
					sv.setGioitinh(rs.getInt("GioiTinh"));
					sv.setNgaysinh(rs.getDate("NgaySinh"));
					sv.setDienthoai(rs.getString("DienThoai"));
					sv.setEmail(rs.getString("Email"));
					sv.setID_Lop(rs.getInt("ID_Lop"));
					
					System.out.println(monhoc.getTenMonHoc() + " - điểm " + Diem + ":");
					System.out.println(sv.toString());
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(ps);
			DBConnection.closeConnection(conn);
		}
	}
	
	public void showStudentTopBySubject() throws SQLException {
		System.out.print("Nhập ID_MonHoc: ");
		int ID_MonHoc = sc.nextInt();
		conn = DBConnection.getInstance().getConnection();
		ps = null;
		ResultSet rs = null;		
		try {
			ps = conn.prepareStatement(SqlConstant.SHOW_SINH_VIEN_TOP_BY_MON_HOC);
			ps.setInt(1, ID_MonHoc);
			rs = ps.executeQuery();
			System.out.println("\tID_DV\tHoLot\t\tTen\tGioiTinh\tNgaySinh\tDiem");
			while(rs.next()) {
				int ID_SV = rs.getInt("ID_SV");
				String HoLot = rs.getString("HoLot");
				String Ten = rs.getString("Ten");
				int GioiTinh = rs.getInt("GioiTinh");
				Date NgaySinh = rs.getDate("NgaySinh");
				float Diem = rs.getFloat("Diem");
				
				System.out.println("\t" + ID_SV + "\t" + HoLot + "\t" + Ten + "\t" + GioiTinh + "\t\t" + NgaySinh + "\t" + Diem);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(ps);
			DBConnection.closeConnection(conn);
		}
	}
	
	public void agvScoreByStudent() throws SQLException {
		System.out.print("Nhập ID_SV: ");
		int ID_SV = sc.nextInt();
		conn = DBConnection.getInstance().getConnection();
		ps = null;
		ResultSet rs = null;		
		try {
			ps = conn.prepareStatement(SqlConstant.AVG_SCORE_BY_STUDENT);
			ps.setInt(1, ID_SV);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("Điểm trung bình: " + rs.getFloat("AVG"));				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(ps);
			DBConnection.closeConnection(conn);
		}
	}
	
	public void hocPhiBySinhVien() throws SQLException {
		System.out.print("Nhập ID_SV: ");
		int ID_SV = sc.nextInt();
		conn = DBConnection.getInstance().getConnection();
		ps = null;
		ResultSet rs = null;		
		try {
			ps = conn.prepareStatement(SqlConstant.HOC_PHI_BY_STUDENT);
			ps.setInt(1, ID_SV);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("Hoc Phí: " + rs.getFloat("HocPhi") + " VNĐ");				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(ps);
			DBConnection.closeConnection(conn);
		}
	}
}
