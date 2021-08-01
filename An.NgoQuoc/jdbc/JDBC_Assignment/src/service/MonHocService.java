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
import entity.MonHoc;
import utils.DBConnection;

public class MonHocService {
	private Scanner sc;
	private Connection conn;
	private Statement sta;
	private PreparedStatement ps;
	private ArrayList<MonHoc> listMonHoc;
	
	public MonHocService() {
		sc = new Scanner(System.in);
		listMonHoc = new ArrayList<>();
	}
	public ArrayList<MonHoc> danhsachMonhoc() throws SQLException {
		conn = DBConnection.getInstance().getConnection();
		sta = null;
		ResultSet rs = null;		
		try {
			sta = conn.createStatement();
			rs = sta.executeQuery(SqlConstant.DANH_SACH_MON_HOC);
			while(rs.next()) {
				MonHoc monhoc = new MonHoc();
				monhoc.setID_MonHoc(rs.getInt("ID_MonHoc"));
				monhoc.setTenMonHoc(rs.getString("TenMonHoc"));
				monhoc.setSoTinChi(rs.getInt("SoTinChi"));
				
				listMonHoc.add(monhoc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(sta);
			DBConnection.closeConnection(conn);
		}
		return listMonHoc;
	}
}

