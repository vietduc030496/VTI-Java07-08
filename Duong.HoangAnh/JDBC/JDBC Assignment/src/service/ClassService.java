package service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import constant.SQLconstant;
import entity.ClassSchool;
import entity.Student;
import utils.DBConnection;
import service.StudentService;

public class ClassService {
	private Connection con;
	private Statement sta;

	public void showAmountMaleAndFemaleInClass() throws SQLException {
		con = DBConnection.getInstance().getConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(SQLconstant.SELECT_MALE_FEMALE_IN_CLASS);
			rs = ps.executeQuery();
			System.out.println("---------------- Class -----------------");
			while (rs.next()) {
				System.out.println("Class name: " + rs.getString("Class name"));
				System.out.println("Male: " + rs.getString("Male"));
				System.out.println("Female: " + rs.getString("Female") + "\n");
			}
			System.out.println("----------------------------------------");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closePreparedStatement(ps);
			DBConnection.closeConnection(con);
		}
	}

	public void displayStudentAllClass() throws SQLException {
		List<ClassSchool> listClass = selectAllClass();
		System.out.println("------------------ Class ------------------");
		for (ClassSchool cla : listClass) {
			int amount = countStudentInClass(cla.getClassID());
			System.out.println("--- " + cla.getClassID() + " || " + cla.getClassName() + " || " + amount + "HS ---");
			if (amount > 0) {
				StudentService studentService = new StudentService();
				List<Student> listStudent = studentService.selectStudentInClass(cla.getClassID());
				for (Student stu : listStudent) {
					System.out.println("First name: " + stu.getFirstName());
					System.out.println("Last name: " + stu.getLastName());
					System.out.println("Gender: " + stu.getGender());
					System.out.println("BirthDay: " + stu.getBirthDay() + "\n");
				}
			} else {
				System.out.println("List empty!" + "\n");
			}
		}
		System.out.println("-------------------------------------------");
	}

	public int countStudentInClass(int classID) throws SQLException {
		con = DBConnection.getInstance().getConnection();
		ResultSet rs = null;
		CallableStatement cs = null;
		int amount = 0;
		try {
			cs = con.prepareCall(SQLconstant.COUNT_STUDENT_IN_CLASS);
			cs.setInt(1, classID);
			cs.registerOutParameter(2, java.sql.Types.INTEGER);
			cs.execute();
			amount = cs.getInt("amount");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeCallableStatement(cs);
			DBConnection.closeConnection(con);
		}
		return amount;
	}

	public List<ClassSchool> selectAllClass() throws SQLException {
		con = DBConnection.getInstance().getConnection();
		ResultSet rs = null;
		sta = null;
		List<ClassSchool> result = new ArrayList<ClassSchool>();
		try {
			sta = con.createStatement();
			rs = sta.executeQuery(SQLconstant.SELECT_ALL_CLASS);
			while (rs.next()) {
				ClassSchool newClass = new ClassSchool(rs.getInt("classID"), rs.getString("className"),
						rs.getString("schoolYear"));
				result.add(newClass);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(sta);
			DBConnection.closeConnection(con);
		}
		return result;
	}
}
