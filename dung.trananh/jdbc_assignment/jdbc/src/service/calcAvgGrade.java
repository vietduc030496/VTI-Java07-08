package service;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import utils.DBconnection;

public class calcAvgGrade {
	static Scanner in = new Scanner(System.in);
	private static Connection con;
	
	public static void calcAvgGradeByIDSV() throws SQLException{
		System.out.println("Nhap id cua sinh vien: ");
		int id = Integer.parseInt(in.nextLine());
		
		con = DBconnection.getInstance().getConnection();
		CallableStatement cs = null;
		ResultSet rs = null;

		try {
			cs = con.prepareCall("{call calcAverageGrade(?)}");
			cs.setInt(1, id);
			rs = cs.executeQuery();

			if (rs.next()) {
				System.out.println("idsv: " + id + ", diemtrungbinh: "+ rs.getFloat(1));
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
