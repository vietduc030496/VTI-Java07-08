package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import constant.sqlconstant;
import utils.DBconnection;

public class displayMinGrade {
	private static Connection con;
	private static Statement sta;

	public static void getMinGradeEachSubject() throws SQLException {
		con = DBconnection.getInstance().getConnection();
		sta = null;
		ResultSet rs = null;

		try {
			sta = con.createStatement();
			rs = sta.executeQuery(sqlconstant.GET_MIN_EACH_SUBJECT);

			while (rs.next()) {
				System.out.println("idsv: " + rs.getInt(1) + ", tensv: "+ rs.getString(2) + 
						", tenmonhoc: " + rs.getString(3) + ", diem: "+ rs.getFloat(4));
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
