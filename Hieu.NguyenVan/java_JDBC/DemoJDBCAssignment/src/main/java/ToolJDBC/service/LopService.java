package ToolJDBC.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ToolJDBC.constant.SqlConstant;
import ToolJDBC.entity.Lop;
import ToolJDBC.entity.SinhVien;
import ToolJDBC.utils.DBConnection;

public class LopService {
	private Connection con;

	private Statement sta;
	public void countStudentById(int id) throws SQLException {
		con = DBConnection.getInstance().getConnection();
		sta = null;
		ResultSet rs = null;
		PreparedStatement pre =null;

		try {
			pre = con.prepareStatement(SqlConstant.COUNT_SINHVIEN_BY_ID);
			pre.setInt(1, id);
			rs = pre.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("counter"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(sta);
			DBConnection.closeConnection(con);
		}
		
	}
	public List<Lop> getLop() throws SQLException {
		con = DBConnection.getInstance().getConnection();
		sta = null;
		ResultSet rs = null;
		List<Lop> loplist = new ArrayList<>();

		try {
			sta = con.createStatement();
			rs = sta.executeQuery(SqlConstant.SELECT_LOP);

			while (rs.next()) {
				Lop lop =new Lop();
				lop.setID_Lop(rs.getInt("ID_Lop"));
				lop.setNienkhoa(rs.getString("NienKhoa"));
				lop.setTenLop(rs.getString("TenLop"));
				loplist.add(lop);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(sta);
			DBConnection.closeConnection(con);
		}
		return loplist;
	}
}
