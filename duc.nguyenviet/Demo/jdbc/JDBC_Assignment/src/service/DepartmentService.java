package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import constant.SqlConstant;
import entity.Department;
import utils.DBConnection;

public class DepartmentService {

	private Connection con;

	private Statement sta;

	public List<Department> getDepartments() throws SQLException {
		con = DBConnection.getInstance().getConnection();
		sta = null;
		ResultSet rs = null;
		List<Department> depts = new ArrayList<>();

		try {
			sta = con.createStatement();
			rs = sta.executeQuery(SqlConstant.SELECT_ALL_DEPT);

			while (rs.next()) {
				Department dept = new Department();
				dept.setId(rs.getInt("DepartmentId"));
				dept.setName(rs.getString("DepartmentName"));

				depts.add(dept);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(sta);
			DBConnection.closeConnection(con);
		}
		return depts;
	}

	public Department getDetpById(int id) throws SQLException {
		con = DBConnection.getInstance().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Department department = null;

		try {
			ps = con.prepareStatement(SqlConstant.SELECT_DEPT_BY_ID);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				department = new Department();
				department.setId(rs.getInt("DepartmentId"));
				department.setName(rs.getString("DepartmentName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closePreparedStatement(ps);
			DBConnection.closeConnection(con);
		}

		return department;
	}

}
