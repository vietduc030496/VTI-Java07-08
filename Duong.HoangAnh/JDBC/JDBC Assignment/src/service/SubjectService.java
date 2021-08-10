package service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import constant.SQLconstant;
import entity.*;
import utils.DBConnection;

public class SubjectService {
	private Connection con;
	private Statement sta;

	public void displayStudentMinMarkInSubject() throws SQLException {
		List<Subject> listSubject = selectAllSubject();
		System.out.println("---------------- Subject ----------------");
		for (Subject sub : listSubject) {
			System.out.println("--- ID: " + sub.getSubjectID() + " || Subject name: " + sub.getSubjectName() + " ---");
			StudentService studentService = new StudentService();
			studentService.findStudentsMinMark(sub.getSubjectID());
		}
		System.out.println("-----------------------------------------");
	}

	public void showStudentInThreeTop(Scanner input) throws SQLException {
		System.out.print("Enter ID of subjet: ");
		int subjectID = input.nextInt();
		System.out.println("----- Three top of subject *" + getSubjectName(subjectID) + "* -----");
		List<Integer> listMark = findThreeTopMark(subjectID);
		selectStudentInThreeTop(subjectID, listMark);
		System.out.println("------------------------------------------");
	}

	private String getSubjectName(int subjectID) throws SQLException {
		con = DBConnection.getInstance().getConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
		sta = null;
		String subjectName = null;
		try {
			ps = con.prepareStatement(SQLconstant.GET_SUBJECT_NAME);
			ps.setInt(1, subjectID);
			rs = ps.executeQuery();
			rs.next();
			subjectName = rs.getString("subjectName");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(sta);
			DBConnection.closePreparedStatement(ps);
			DBConnection.closeConnection(con);
		}
		return subjectName;
	}

	private void selectStudentInThreeTop(int subjectID, List<Integer> listMark) throws SQLException {
		con = DBConnection.getInstance().getConnection();
		ResultSet rs = null;
		sta = null;
		PreparedStatement ps = null;
		int index = 1;
		try {
			for (int mark : listMark) {
				System.out.println("Top " + index++ + ": " + mark);
				ps = con.prepareCall(SQLconstant.SELECT_STUDENT_IN_THREE_TOP);
				ps.setInt(1, subjectID);
				ps.setInt(2, mark);
				rs = ps.executeQuery();
				while (rs.next()) {
					System.out.println("First name: " + rs.getString("First name"));
					System.out.println("Last name: " + rs.getString("Last name"));
					System.out.println("BirthDay: " + rs.getString("BirthDay"));
					System.out.println("Gender: " + rs.getString("Gender"));
					System.out.println("Class name: " + rs.getString("Class name") + "\n");
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(sta);
			DBConnection.closePreparedStatement(ps);
			DBConnection.closeConnection(con);
		}
	}

	public List<Integer> findThreeTopMark(int subjectID) throws SQLException {
		con = DBConnection.getInstance().getConnection();
		ResultSet rs = null;
		sta = null;
		PreparedStatement ps = null;
		List<Integer> result = new ArrayList<Integer>();
		try {
			ps = con.prepareCall(SQLconstant.FIND_THREE_TOP_MARK);
			ps.setInt(1, subjectID);
			rs = ps.executeQuery();
			while (rs.next()) {
				result.add(rs.getInt("mark"));
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

	public List<Subject> selectAllSubject() throws SQLException {
		con = DBConnection.getInstance().getConnection();
		ResultSet rs = null;
		sta = null;
		List<Subject> result = new ArrayList<Subject>();
		try {
			sta = con.createStatement();
			rs = sta.executeQuery(SQLconstant.SELECT_ALL_SUBJECT);
			while (rs.next()) {
				Subject newSubject = new Subject(rs.getInt("subjectID"), rs.getString("subjectName"));
				result.add(newSubject);
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
