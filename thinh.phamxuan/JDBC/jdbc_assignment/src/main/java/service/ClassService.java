package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import utils.DBConnection;

import constant.SQLConstant;
import entity.Lop;

public class ClassService {
	private Scanner sc;
	private Connection conn;
	private Statement sta;
	private PreparedStatement ps;
	private ArrayList<Lop> listLop;
	public ClassService() throws SQLException {
		super();
		sc=new Scanner(System.in);
		listLop=new ArrayList<>();
		listLop=layDanhSachLop();

	}
	public ArrayList<Lop> layDanhSachLop() throws SQLException{
		conn = DBConnection.getInstance().getConnection();
		ResultSet rs = null;
		sta = null;
		try {
			sta = conn.createStatement();
			rs = sta.executeQuery(SQLConstant.LAY_DANH_SACH_LOP);
			while(rs.next()) {
				Lop lop = new Lop();
				lop.setID_Lop(rs.getInt("ID_Lop"));
				lop.setTenLop(rs.getString("TenLop"));
				lop.setNienKhoa(rs.getString("NienKhoa"));
				
				listLop.add(lop);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(sta);
			DBConnection.closeConnection(conn);
		}
		return listLop;
	}

	
	public void hienThiSoLuongNamNu() throws SQLException {
		conn = DBConnection.getInstance().getConnection();
		ResultSet rs = null;
		sta = null;
		try {
			sta = conn.createStatement();
			rs = sta.executeQuery(SQLConstant.HIEN_THI_SO_LUONG_NAM_NU);

			while (rs.next()) {

				System.out.println("TenLop " + rs.getString(1) + " GioiTinh "+ rs.getString(2) + 
						 " SoLuong "+ rs.getInt(3));
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closePreparedStatement(ps);
			DBConnection.closeConnection(conn);
		}
	}
	public void hienThiSVTrongLop() throws SQLException{
		conn = DBConnection.getInstance().getConnection();
		ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(SQLConstant.HIEN_THI_SINH_VIEN_TRONG_LOP);
			for (Lop lop : listLop) {
				System.out.print("Lop " + lop.getTenLop());	

				ps.setInt(1, lop.getID_Lop());
				rs = ps.executeQuery();
				int rowcount = 0;
				if (rs.last()) {
				  rowcount = rs.getRow();
				  rs.beforeFirst(); 
				  
				  if(rowcount>0) {
					  System.out.println(" co "+rowcount+" sinh vien");
				  }
				 

				}
				 else {
					  System.out.println(" co 0 sinh vien");
				  }
					while(rs.next()) {
						int ID_SV = rs.getInt("ID_SV");
						String HoLot = rs.getString("HoLot");
						String Ten = rs.getString("Ten");
						String GioiTinh = rs.getString("GioiTinh");
						Date NgaySinh = rs.getDate("NgaySinh");
						
						System.out.println("SinhVien [ID_SV=" + ID_SV + ", HoLot=" + HoLot + ", Ten=" + Ten + ", GioiTinh=" + GioiTinh
								+ ", NgaySinh=" + NgaySinh + "]");
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

}
