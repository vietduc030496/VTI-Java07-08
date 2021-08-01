package service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import utils.DBconnection;

public class getTop5GradeSV {
	static Scanner in = new Scanner(System.in);
	private static Connection con;
	
	public static void getTop5Grade() throws SQLException{
		System.out.println("Nhap id cua monhoc: ");
		int id = Integer.parseInt(in.nextLine());
		
		con = DBconnection.getInstance().getConnection();
		CallableStatement cs = null;
		ResultSet rs = null;

		try {
			cs = con.prepareCall("{call getTop5Grade(?)}");
			cs.setInt(1, id);
			rs = cs.executeQuery();

			while (rs.next()) {
				System.out.println("idsv: " + rs.getInt(1) + ", tensv: "+ rs.getString(2) + ", idmonhoc: " + id + ", diem:" + rs.getFloat(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBconnection.closeCallableStatement(cs);
			DBconnection.closeConnection(con);
		}
	}
}
