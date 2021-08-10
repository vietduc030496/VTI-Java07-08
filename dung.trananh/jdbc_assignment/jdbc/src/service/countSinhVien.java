package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import constant.sqlconstant;
import utils.DBconnection;

public class countSinhVien {
	private static Connection con;
	private static Statement sta;

	public static void countSVEachClass() throws SQLException {
		con = DBconnection.getInstance().getConnection();
		sta = null;
		ResultSet rs = null;

		try {
			sta = con.createStatement();
			rs = sta.executeQuery(sqlconstant.GET_COUNTERS_EACH_CLASS);

			while (rs.next()) {
				System.out.println("idlop: " + rs.getInt(1) + ", soluongsinhvien: "+ rs.getInt(2));
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
