package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import constant.*;
import entity.*;
import utils.*;

public class displaySinhVien {
	private static Connection con;
	private static Statement sta;

	public static void getSinhVien() throws SQLException {
		con = DBconnection.getInstance().getConnection();
		sta = null;
		ResultSet rs = null;

		try {
			sta = con.createStatement();
			rs = sta.executeQuery(sqlconstant.GET_ALL_STUDENT);

			while (rs.next()) {
				System.out.println("id: " + rs.getInt(1) + ", holot: "+ rs.getString(2) + 
						", ten: " + rs.getString(3) + ", ngaysinh: "+ rs.getString(4) +
						", gioitinh: " + rs.getString(5) + ", tenlop: " + rs.getString(6));
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
