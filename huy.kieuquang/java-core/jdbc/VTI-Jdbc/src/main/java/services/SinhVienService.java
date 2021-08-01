package services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import constant.SQLConstant;
import entity.SinhVien;
import utils.ConvertStringToDate;
import utils.DBConnection;

public class SinhVienService {
	private Connection con;
	private Statement sta;
	private CallableStatement callSt;
	private PreparedStatement ps;

	public List<SinhVien> getAllSinhVien() throws SQLException {
		List<SinhVien> listSV = new ArrayList<>();
		con = DBConnection.getInstance().getConnection();
		sta = null;
		ResultSet rs = null;

		try {
			sta = con.createStatement();
			rs = sta.executeQuery(SQLConstant.SELECT_ALL_SinhVien);

			while (rs.next()) {
				SinhVien sv = new SinhVien();
				sv.setID_SV(rs.getInt("ID_SV"));
				sv.setHoLot(rs.getString("hoLot"));
				sv.setTen(rs.getString("ten"));
				sv.setGioiTinh(rs.getString("gioiTinh"));
				sv.setNgaySinh(new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("ngaySinh")));
				sv.setDiaChi(rs.getString("diaChi"));
				sv.setDienThoai(rs.getString("dienThoai"));
				sv.setEmail(rs.getString("email"));
				sv.setID_Lop(rs.getInt("ID_Lop"));

				listSV.add(sv);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con);
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(sta);
		}
		return listSV;
	}

	public void getGender() throws SQLException {
		con = DBConnection.getInstance().getConnection();
		sta = null;
		ResultSet rs = null;

		try {
			sta = con.createStatement();
			rs = sta.executeQuery(SQLConstant.SELECT_GENDER);

			while (rs.next()) {
				System.out.println(
						"Lop " + rs.getInt("ID_Lop") + " - " + rs.getInt("counted") + " " + rs.getString("gioiTinh"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con);
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(sta);
		}
	}

	public void getInfoByID(int id_sv) throws SQLException {
		con = DBConnection.getInstance().getConnection();
		sta = null;
		callSt = null;
		ResultSet rs = null;

		try {
			callSt = con.prepareCall("{call get_sv_byID(?)}");
			callSt.setInt(1, id_sv);
			rs = callSt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt("ID_SV") + " - " + rs.getString("tenLop") + " - "
						+ rs.getString("tenMonHoc") + " - " + rs.getInt("diem"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con);
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(sta);
		}
	}

	public void getQuantityPerClass() throws SQLException {
		con = DBConnection.getInstance().getConnection();
		sta = null;
		ResultSet rs = null;

		try {
			sta = con.createStatement();
			rs = sta.executeQuery(SQLConstant.SELECT_QUANTITY_PER_CLASS);

			while (rs.next()) {
				System.out.println("Lop " + rs.getInt("ID_Lop") + " - " + rs.getInt("quantity") + " sinhvien");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con);
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(sta);
		}
	}

	public void getInfoHasMinMarkPerSubject() throws SQLException {
		con = DBConnection.getInstance().getConnection();
		sta = null;
		ResultSet rs = null;

		try {
			sta = con.createStatement();
			rs = sta.executeQuery(SQLConstant.SELECT_MIN_MARK_PER_SUBJECT);

			while (rs.next()) {
				System.out.println(rs.getString("tenMonHoc"));
				System.out.println("ID_SV: " + rs.getInt("ID_SV") + " - " + "HoLot: " + rs.getString("hoLot") + " - "
						+ "Ten: " + rs.getString("ten") + " - " + "Gioitinh: " + rs.getString("gioiTinh") + " - "
						+ "Ngaysinh: " + new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("ngaySinh")) + " - "
						+ "Diem: " + rs.getInt("diemMin"));
				System.out.println();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con);
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(sta);
		}
	}

	public List<Integer> getTop5Mark() throws SQLException {
		con = DBConnection.getInstance().getConnection();
		sta = null;
		ResultSet rs = null;
		List<Integer> listMark = new ArrayList<>();

		try {
			sta = con.createStatement();
			rs = sta.executeQuery(SQLConstant.SELECT_TOP5MARK);

			while (rs.next()) {
				listMark.add(rs.getInt("diem"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con);
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(sta);
		}
		return listMark;
	}

	public void getInfoByMark(int mark) throws SQLException {
		con = DBConnection.getInstance().getConnection();
		ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(SQLConstant.SELECT_SINHVIEN_BY_MARK);
			ps.setInt(1, mark);
			rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("ID_SV: " + rs.getInt("ID_SV") + " - " + "HoLot: " + rs.getString("hoLot") + " - "
						+ "Ten: " + rs.getString("ten") + " - " + "Gioitinh: " + rs.getString("gioiTinh") + " - "
						+ "Ngaysinh: " + new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("ngaySinh")));
				System.out.println();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con);
			DBConnection.closeResultSet(rs);
			DBConnection.closePreparedStatement(ps);
		}
	}
	
	public void getAvarageMarkById(int id_sv) throws SQLException{
		con = DBConnection.getInstance().getConnection();
		callSt = null;
		ResultSet rs = null;

		try {
			callSt = con.prepareCall("{call get_avarage_mark_byID(?)}");
			callSt.setInt(1, id_sv);
			rs = callSt.executeQuery();

			while (rs.next()) {
				System.out.println("Diem trung binh " + Double.parseDouble(String.format("%.2f", rs.getDouble("avg_mark"))));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con);
			DBConnection.closeResultSet(rs);
			DBConnection.closeCallableStatement(callSt);
		}
	}
	
	public void getTuitionFeeByID(int id_sv) throws SQLException{
		con = DBConnection.getInstance().getConnection();
		callSt = null;
		ResultSet rs = null;

		try {
			callSt = con.prepareCall("{call get_tuition_fee_byID(?)}");
			callSt.setInt(1, id_sv);
			rs = callSt.executeQuery();

			while (rs.next()) {
				System.out.println("Hoc phi: " + rs.getInt("hocphi") + " VND");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con);
			DBConnection.closeResultSet(rs);
			DBConnection.closeCallableStatement(callSt);
		}
	}
	
	public boolean insertSinhvien(SinhVien sv) throws SQLException, ParseException{
		con = DBConnection.getInstance().getConnection();
		ps = null;
		ResultSet rs = null;
		boolean check = false;

		try {
			ps = con.prepareStatement(SQLConstant.INSERT_SINHVIEN);
			ps.setString(1, sv.getHoLot());
			ps.setString(2, sv.getTen());
			ps.setString(3, sv.getGioiTinh());
			ps.setDate(4, ConvertStringToDate.toDate(sv.getNgaySinh()));
			ps.setString(5, sv.getDiaChi());
			ps.setString(6, sv.getDienThoai());
			ps.setString(7, sv.getEmail());
			ps.setInt(8, sv.getID_Lop());
			
			ps.execute();
			check = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con);
			DBConnection.closeResultSet(rs);
			DBConnection.closePreparedStatement(ps);
		}
		return check;
	}
}
