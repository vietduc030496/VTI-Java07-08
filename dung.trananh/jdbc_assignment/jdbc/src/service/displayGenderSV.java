package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import constant.sqlconstant;
import utils.DBconnection;

public class displayGenderSV {
	private static Connection con;
	private static Statement sta;

	public static void getGenderSV() throws SQLException {
		con = DBconnection.getInstance().getConnection();
		sta = null;
		ResultSet rs = null;

		try {
			sta = con.createStatement();
			rs = sta.executeQuery(sqlconstant.GET_COUNTERS_BY_GENDER);

			while (rs.next()) {
				System.out.println("gioitinh: " + rs.getString(1) + ", tenlop: "+ rs.getString(2) + 
						", soluong: " + rs.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBconnection.closeResultSet(rs);
			DBconnection.closeStatement(sta);
			DBconnection.closeConnection(con);
		}
	}
}
