package com.vti.jdbc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.mysql.cj.jdbc.CallableStatement;
//import com.sun.mail.imap.protocol.MailboxInfo;
import com.vti.jdbc.constant.SqlConstant;
import com.vti.jdbc.entities.Student;
import com.vti.jdbc.utils.DBConnection;
import com.vti.jdbc.utils.MailUtils;
import com.vti.jdbc.utils.RegexUtils;

public class StudentService {
	Scanner scanner = new Scanner(System.in);

	private Connection con;

	private PreparedStatement ps = null;
	private CallableStatement cs = null;

	public Student studentInput() {
		System.out.println("Enter ClassID : ");
		int classID = Integer.parseInt(scanner.nextLine());

		System.out.println("Enter firstName : ");
		String firstName = scanner.nextLine();

		System.out.println("Enter name : ");
		String name = scanner.nextLine();

		System.out.println("Enter gender : ");
		String gender = scanner.nextLine();

		System.out.println("Enter birthDate : ");
		String birthDate;
		while (true) {
			birthDate = scanner.nextLine();
			if (RegexUtils.checkBirthDate(birthDate)) {
				break;
			} else {
				System.out.println("Invalid format, please re-fill !!\nExample: YYYY-MM-dd");
			}
		}

		System.out.println("Enter address : ");
		String address = scanner.nextLine();

		System.out.println("Enter phoneNumber : ");
		String phoneNumber;
		while (true) {
			phoneNumber = scanner.nextLine();
			if (RegexUtils.checkValidPhone(phoneNumber)) {
				break;
			} else {
				System.out.println("Invalid format,phone number must have 10 digits. Please re-fill !!");
			}
		}

		System.out.println("Enter email : ");
		String email;
		while (true) {
			email = scanner.nextLine();
			if (RegexUtils.checkValidEmail(email)) {
				break;
			} else {
				System.out.println("Invalid format, please re-fill !!\nExample: trunghieunguyen@gmail.com");
			}
		}

		Student stu = new Student(classID, firstName, name, gender, birthDate, address, phoneNumber, email);
		return stu;
	}

	public void insertStudent() throws SQLException, AddressException, MessagingException {
		con = DBConnection.getInstance().getConnection();
		ps = null;
		List<Student> listStudent = new ArrayList<>();
		listStudent.add(studentInput());
		MailUtils mailUtils = new MailUtils();
		try {
			for (Student s : listStudent) {
				ps = con.prepareStatement(SqlConstant.INSERT_STUDENT);
				ps.setInt(1, s.getClassID());
				ps.setString(2, s.getFirstName());
				ps.setString(3, s.getName());
				ps.setString(4, s.getGender());
				ps.setString(5, s.getBirthDate());
				ps.setString(6, s.getAddress());
				ps.setString(7, s.getPhoneNumber());
				ps.setString(8, s.getEmail());
				ps.execute();
				mailUtils.sendMail(s.getEmail());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeStatement(ps);
			DBConnection.closeConnection(con);
		}
		System.out.println("Inserted");
	}

	public void displayStudent() throws SQLException {
		con = DBConnection.getInstance().getConnection();
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(SqlConstant.SELECT_STUDENT);
			rs = ps.executeQuery();
			while (rs.next())
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getDate(3) + "\t" + rs.getString(4)
						+ "\t" + rs.getString(5));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closePreparedStatement(ps);
			DBConnection.closeConnection(con);
		}
	}

	public void displayNumberStudent() throws SQLException {
		con = DBConnection.getInstance().getConnection();
		ResultSet rs = null;
		System.out.println("ClassID" + "\t" + "\t" + "ClassName"+ "\t" + "Num_of_male" + "\t" + "Num_of_female");
		try {
			ps = con.prepareStatement(SqlConstant.SELECT_NUM_OF_STUDENT);
			rs = ps.executeQuery();
			while (rs.next())
				System.out.println(rs.getInt(1) + "\t" + "\t" + rs.getString(2) + "\t" + "\t" 
									+ rs.getInt(3) + "\t" + "\t" + rs.getInt(4));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closePreparedStatement(ps);
			DBConnection.closeConnection(con);
		}
	}

	public void displayStudentTranscript() throws SQLException {
		System.out.println("Please choose number of studentID:  ");
		int input = Integer.parseInt(scanner.nextLine());
		con = DBConnection.getInstance().getConnection();
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(SqlConstant.SELECT_TRANSCRIPT);
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) == input) {
					System.out.println(
							rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getFloat(4));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closePreparedStatement(ps);
			DBConnection.closeConnection(con);
		}
	}

	public void displayCountStudentEachClass() throws SQLException {
		con = DBConnection.getInstance().getConnection();
		ResultSet rs = null;
		System.out.println("Number of students in each class");
		System.out.println("ClassID" + "\t" + "\t" + "ClassName"+ "\t" + "Number of students");
		try {
			ps = con.prepareStatement(SqlConstant.SELECT_COUNT_EACH_CLASS);
			rs = ps.executeQuery();
			while (rs.next())
				System.out.println(
						rs.getInt(1) + "\t" + "\t" + rs.getString(2) + "\t" + "\t" + rs.getInt(3));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closePreparedStatement(ps);
			DBConnection.closeConnection(con);
		}
	}
	
	public void displayStudentEachClass() throws SQLException {
		con = DBConnection.getInstance().getConnection();
		ResultSet rs = null;
		System.out.println("Information of students in each class");
		System.out.println("ClassID" + "\t" + "\t" + "ClassName"+ "\t" + "StudentID"
							+ "\t"+"FirstName"+ "\t"+"Name"+ "\t"+ "\t"+"gender"+ "\t"+ "\t"+"birthDate");
		try {
			ps = con.prepareStatement(SqlConstant.SELECT_STUDENT_EACH_CLASS);
			rs = ps.executeQuery();
			while (rs.next())
				System.out.println(
						rs.getInt(1) + "\t" + "\t" + rs.getString(2) + "\t" + "\t" + rs.getInt(3)+ "\t"+ "\t"+rs.getString(4)
						+ "\t"+ "\t"+rs.getString(5)+ "\t"+ "\t"+ rs.getString(6)+ "\t"+ "\t"+rs.getDate(7));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closePreparedStatement(ps);
			DBConnection.closeConnection(con);
		}
	}
	
	public void displayMinScore() throws SQLException {
		con = DBConnection.getInstance().getConnection();
		ResultSet rs = null;
		System.out.println("SubjectID" + "\t"  + "SubjectName"+ "\t" + "StudentID"
							+ "\t"+"FirstName"+ "\t"+ "Name"+ "\t"+ "\t"+"Gender"+ "\t"+ "\t"+"MinScore");
		try {
			ps = con.prepareStatement(SqlConstant.SELECT_MIN_SCORE_OF_STUDENT);
			rs = ps.executeQuery();
			while (rs.next())
				System.out.println(
						rs.getInt(1) + "\t" + "\t" + rs.getString(2) + "\t" + "\t" + rs.getInt(3)+ "\t"+ "\t"+rs.getString(4)
						+ "\t"+ "\t"+rs.getString(5)+ "\t"+ "\t"+ rs.getString(6)+ "\t"+ "\t"+rs.getFloat(7));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closePreparedStatement(ps);
			DBConnection.closeConnection(con);
		}
	}
	
	public void displayFiveMaxScore() throws SQLException {
		System.out.println("Please choose number of subjectID:  ");
		int subjectID = Integer.parseInt(scanner.nextLine());
		con = DBConnection.getInstance().getConnection();
		ResultSet rs = null;
		System.out.println("SubjectID" + "\t"  + "StudentID"+ "\t" + "ClassID"+ "\t"
							+ "\t"+"FirstName"+ "\t"+"Name"+ "\t"+ "\t"+"Gender"+ "\t"+ "\t"+"Score");
		try {
			cs = (CallableStatement) con.prepareCall(SqlConstant.CALL_PROCEDURE_FIVE_SCORE);
			cs.setInt(1, subjectID);
			rs = cs.executeQuery();
			while (rs.next())
				System.out.println(
						rs.getInt(1) + "\t" + "\t" + rs.getInt(2) + "\t" + "\t" + rs.getInt(3)+ "\t"+ "\t"+rs.getString(4)
						+ "\t"+ "\t"+rs.getString(5)+ "\t"+ "\t"+ rs.getString(6)+ "\t"+ "\t"+rs.getFloat(7));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closePreparedStatement(cs);
			DBConnection.closeConnection(con);
		}
	}
	
	public void displayAvgScore() throws SQLException {
		System.out.println("Please choose number of studentID:  ");
		int studentID = Integer.parseInt(scanner.nextLine());
		con = DBConnection.getInstance().getConnection();
		ResultSet rs = null;
		System.out.println("StudentID" + "\t"  + "FirstName"+ "\t" 
							+ "Name"+ "\t" + "\t"+"Score");
		try {
			cs = (CallableStatement) con.prepareCall(SqlConstant.CALL_PROCEDURE_AVG_SCORE);
			cs.setInt(1, studentID);
			rs = cs.executeQuery();
			while (rs.next())
				System.out.println(
						rs.getInt(1) + "\t" + "\t" + rs.getString(2) + "\t" + "\t" + rs.getString(3)+ "\t"+ "\t"+rs.getFloat(4));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closePreparedStatement(cs);
			DBConnection.closeConnection(con);
		}
	}
	
	public void calcTuision() throws SQLException {
		System.out.println("Please enter studentID: ");
		int studentID = Integer.parseInt(scanner.nextLine());
		con = DBConnection.getInstance().getConnection();
		try {
			cs = (CallableStatement) con.prepareCall(SqlConstant.FUNC_CALC_TUISION);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setInt(2, studentID);
			cs.execute();
				System.out.println("StudentID: " + studentID + "\t" +  "Tuision:  " + cs.getInt(1) );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closePreparedStatement(cs);
			DBConnection.closeConnection(con);
		}
	}
}
