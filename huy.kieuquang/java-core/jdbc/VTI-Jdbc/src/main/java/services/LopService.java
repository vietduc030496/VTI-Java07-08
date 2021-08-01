package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import constant.SQLConstant;
import entity.Lop;
import utils.DBConnection;

public class LopService {
	private Connection con;
	private Statement sta;
	
	public List<Lop> getAllLop() throws SQLException{
		List<Lop> listLop = new ArrayList<>();
		con = DBConnection.getInstance().getConnection();
		sta = null;
		ResultSet rs = null;

		try {
			sta = con.createStatement();
			rs = sta.executeQuery(SQLConstant.SELECT_ALL_LOP);

			while (rs.next()) {
				Lop lop = new Lop();
				lop.setID_Lop(rs.getInt("ID_Lop"));
				lop.setTenLop(rs.getString("tenLop"));
				lop.setNienKhoa(rs.getInt("nienKhoa"));

				listLop.add(lop);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con);
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(sta);
		}
		return listLop;
	}
}
