package service;

import java.sql.*;
import java.util.*;

import utils.DBConnection;
import constant.NotificationConstant;
import constant.SQLconstant;
import entity.*;
import service.ValidateService;

public class StudentService {
	private Connection con;
	private Statement sta;

	public void inputStudent(Scanner input) throws SQLException {
		ValidateService validate = new ValidateService();
		try {
			System.out.println("----------- Input student -----------");

			System.out.print("Nhap ho: ");
			String firstName = input.nextLine();
			validate.name(firstName);

			System.out.print("Nhap ten: ");
			String lastName = input.nextLine();
			validate.name(lastName);

			System.out.print("Nhap gioi tinh(1-nam, 2-nu, 3-khong xac dinh): ");
			int gender = Integer.parseInt(input.nextLine());
			validate.gender(gender);

			System.out.print("Nhap ngay sinh(yyyy/mm/dd): ");
			String birthDay = input.nextLine();
			validate.date(birthDay);

			System.out.print("Nhap dia chi: ");
			String address = input.nextLine();

			System.out.print("Nhap sdt: ");
			String phone = input.nextLine();
			validate.phone(phone);

			System.out.print("Nhap email: ");
			String email = input.nextLine();
			validate.email(email);

			insertStudent(firstName, lastName, gender, birthDay, address, phone, email);

		} catch (IllegalArgumentException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.println(NotificationConstant.DATA_NOT_VALID);
		}
	}

	public void insertStudent(String firstName, String lastName, int gender, String birthDay, String address,
			String phone, String email) throws SQLException {
		con = DBConnection.getInstance().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(SQLconstant.INSERT_STUDENT);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setInt(3, gender);
			ps.setString(4, birthDay);
			ps.setString(5, address);
			ps.setString(6, phone);
			ps.setString(7, email);
			ps.executeUpdate();
			System.out.println("Them thanh cong!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closePreparedStatement(ps);
			DBConnection.closeConnection(con);
		}
	}

	public void showAllStudent() throws SQLException {
		con = DBConnection.getInstance().getConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(SQLconstant.SHOW_ALL_STUDENT);
			rs = ps.executeQuery();
			System.out.println("---------------- All student -----------------");
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("ID"));
				System.out.println("Full name: " + rs.getString("Full name"));
				System.out.println("BirthDay: " + rs.getString("BirthDay"));
				System.out.println("Gender: " + rs.getString("Gender"));
				System.out.println("Class name: " + rs.getString("Class name") + "\n");
			}
			System.out.println("---------------------------------------------");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closePreparedStatement(ps);
			DBConnection.closeConnection(con);
		}
	}

	public List<Student> selectStudentInClass(int classID) throws SQLException {
		con = DBConnection.getInstance().getConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<Student> listStudent = new ArrayList<Student>();
		try {
			ps = con.prepareStatement(SQLconstant.SELECT_STUDENT_IN_CLASS);
			ps.setInt(1, classID);
			rs = ps.executeQuery();
			while (rs.next()) {
				Student newStudent = new Student();
				newStudent.setFirstName(rs.getString("First name"));
				newStudent.setLastName(rs.getString("Last name"));
				newStudent.setGender(rs.getString("Gender"));
				newStudent.setBirthDay(rs.getString("BirthDay"));
				listStudent.add(newStudent);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closePreparedStatement(ps);
			DBConnection.closeConnection(con);
		}
		return listStudent;
	}

	public void showMarkBoardStudent(Scanner input) {
		System.out.print("Enter student Id to find out: ");
		int studentID = input.nextInt();
		try {
			showMarkBoardStudent(studentID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void showMarkBoardStudent(int studentID) throws SQLException {
		con = DBConnection.getInstance().getConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(SQLconstant.SHOW_MARK_BOARD_STUDENT);
			ps.setInt(1, studentID);
			rs = ps.executeQuery();
			System.out.println("---------------- Mark -----------------");
			if (rs.next()) {
				System.out.print("ID: " + rs.getInt("ID") + " --- ");
				System.out.println("Class name: " + rs.getString("Class name"));
				System.out.println("Subject      ||" + "      Mark" + "\n");
				System.out.println(rs.getString("Subject") + "      ||      " + rs.getInt("Mark") + "\n");
			}
			while (rs.next()) {
				System.out.println(rs.getString("Subject") + "      ||      " + rs.getInt("Mark") + "\n");
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

	public void findStudentsMinMark(int subjectID) throws SQLException {
		con = DBConnection.getInstance().getConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(SQLconstant.FIND_STUDENT_MIN_MARK);
			ps.setInt(1, subjectID);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("ID"));
				System.out.println("First name: " + rs.getString("First name"));
				System.out.println("Last name: " + rs.getString("Last name"));
				System.out.println("BirthDay: " + rs.getString("BirthDay"));
				System.out.println("Gender: " + rs.getString("Gender"));
				System.out.println("Class name: " + rs.getString("Class name"));
				System.out.println("Mark: " + rs.getString("Mark") + "\n");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closePreparedStatement(ps);
			DBConnection.closeConnection(con);
		}
	}

	public void find_average_mark_student(Scanner input) throws SQLException {
		System.out.print("Enter ID of student: ");
		int studentID = input.nextInt();
		System.out.println("Average:" + average_mark_student(studentID));
	}

	private double average_mark_student(int studentID) throws SQLException {
		con = DBConnection.getInstance().getConnection();
		ResultSet rs = null;
		CallableStatement cs = null;
		sta = null;
		double average = 0;
		try {
			cs = con.prepareCall(SQLconstant.AVERAGE_MARK_STUDENT);
			cs.setInt(1, studentID);
			cs.registerOutParameter(2, java.sql.Types.DOUBLE);
			cs.execute();
			average = cs.getDouble("average");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(sta);
			DBConnection.closeCallableStatement(cs);
			DBConnection.closeConnection(con);
		}
		return average;
	}

	public void show_monney_credits_student(Scanner input, int monneyPerCredit) throws SQLException {
		System.out.print("Enter ID of student: ");
		int studentID = input.nextInt();
		System.out.println("Amount monney:" + amount_credits_student(studentID) * monneyPerCredit);
	}

	private double amount_credits_student(int studentID) throws SQLException {
		con = DBConnection.getInstance().getConnection();
		ResultSet rs = null;
		CallableStatement cs = null;
		sta = null;
		int amount = 0;
		try {
			cs = con.prepareCall(SQLconstant.SUM_CREDITS_STUDENT);
			cs.setInt(1, studentID);
			cs.registerOutParameter(2, java.sql.Types.INTEGER);
			cs.execute();
			amount = cs.getInt("amount");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(sta);
			DBConnection.closeCallableStatement(cs);
			DBConnection.closeConnection(con);
		}
		return amount;
	}
}
