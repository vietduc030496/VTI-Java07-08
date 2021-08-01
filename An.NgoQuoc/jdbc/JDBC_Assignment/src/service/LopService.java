package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import constant.SqlConstant;
import entity.Lop;
import utils.DBConnection;

public class LopService {
	private Scanner sc;
	private Connection conn;
	private Statement sta;
	private PreparedStatement ps;
	private ArrayList<Lop> listLop;
	
	public LopService() {
		sc = new Scanner(System.in);
		listLop = new ArrayList<>();
	}
	public ArrayList<Lop> danhSachLop() throws SQLException {
		conn = DBConnection.getInstance().getConnection();
		sta = null;
		ResultSet rs = null;		
		try {
			sta = conn.createStatement();
			rs = sta.executeQuery(SqlConstant.DANH_SACH_LOP);
			while(rs.next()) {
				Lop lop = new Lop();
				lop.setId_lop(rs.getInt("ID_Lop"));
				lop.setTenlop(rs.getString("TenLop"));
				lop.setNienkhoa(rs.getString("NienKhoa"));
				
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
}
