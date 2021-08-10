package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


import constant.sqlconstant;
import utils.DBconnection;

public class displayBangDiem {
	static Scanner in = new Scanner(System.in);
	private static Connection con;
	
	public static void getBangDiemByID() throws SQLException{
		System.out.println("Nhap id cua sinh vien: ");
		int id = Integer.parseInt(in.nextLine());
		
		con = DBconnection.getInstance().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(sqlconstant.GET_GRADE_BY_ID);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("idsv: " + rs.getInt(1) + ", tenlop: "+ rs.getString(2) + 
						", tenmonhoc: " + rs.getString(3) + ", diem: "+ rs.getFloat(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBconnection.closePreparedStatement(ps);
			DBconnection.closeConnection(con);
		}
	}
}
