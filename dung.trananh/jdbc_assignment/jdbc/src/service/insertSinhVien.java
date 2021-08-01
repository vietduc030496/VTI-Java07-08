package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import javax.mail.MessagingException;

import constant.*;
import entity.*;
import utils.DBconnection;
import utils.sendMail;

public class insertSinhVien {
	static Scanner in = new Scanner(System.in);
	private static Connection con;
	
	public static void insertSV() throws SQLException, MessagingException {
		System.out.println("Nhap Holot: ");
		String holot = in.nextLine();
		System.out.println("Nhap Ten: ");
		String ten = in.nextLine();
		System.out.println("Nhap gioitinh: ");
		String gt = in.nextLine();
		System.out.println("Nhap ngay sinh");
		String bid;
		while (true) {
			bid = in.nextLine();
			if (checkdata.checkInputDateData(bid)) {
				break;
			} else {
				System.out.print("Invalid birthdate. Please reenter: ");
			}
		}
		System.out.println("Nhap dia chi: ");
		String diachi = in.nextLine();
		System.out.println("Nhap dien thoai: ");
		String phone;
		while (true) {
			phone = in.nextLine();
			if (checkdata.checkInputPhoneData(phone)) {
				break;
			} else {
				System.out.print("Invalid phone. Please reenter: ");
			}
		}
		System.out.println("Nhap email: ");
		String email;
		while (true) {
			email = in.nextLine();
			if (checkdata.checkInputEmailData(email)) {
				break;
			} else {
				System.out.print("Invalid email. Please reenter: ");
			}
		}
		System.out.println("Nhap id_lop: ");
		int id_lop = Integer.parseInt(in.nextLine());
		
		con = DBconnection.getInstance().getConnection();
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sqlconstant.INSERT_STUDENT);
			ps.setString(1, holot);
			ps.setString(2, ten);
			ps.setString(3, gt);
			ps.setString(4, bid);
			ps.setString(5, diachi);
			ps.setString(6, phone);
			ps.setString(7, email);
			ps.setInt(8, id_lop);
			int i = ps.executeUpdate();

			if (i>0) {
				System.out.println("Insert Student Successfully");
				sendMail.sendText(email);
			}
			else {
				System.out.println("Failed To Insert");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBconnection.closePreparedStatement(ps);
			DBconnection.closeConnection(con);
		}
	}
}
