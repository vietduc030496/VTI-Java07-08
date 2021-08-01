package ToolJDBC.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ToolJDBC.constant.SqlConstant;
import ToolJDBC.entity.Lop;
import ToolJDBC.entity.MonHoc;
import ToolJDBC.utils.DBConnection;

public class MonHocService {

	private Connection con;

	private Statement sta;
	public List<MonHoc> getMonHoc() throws SQLException {
		con = DBConnection.getInstance().getConnection();
		sta = null;
		ResultSet rs = null;
		List<MonHoc> monhoclist = new ArrayList<>();

		try {
			sta = con.createStatement();
			rs = sta.executeQuery(SqlConstant.SELECT_MonHoc);

			while (rs.next()) {
				MonHoc monhoc =new MonHoc();
				monhoc.setID_MonHoc(rs.getInt("ID_MonHoc"));
				monhoc.setTenMonHoc(rs.getString("TenMonHoc"));
				monhoc.setSoTinChi(rs.getInt("SoTinChi"));
				monhoclist.add(monhoc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(sta);
			DBConnection.closeConnection(con);
		}
		return monhoclist;
	}
}
