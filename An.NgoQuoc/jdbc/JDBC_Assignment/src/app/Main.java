package app;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import service.SendMailService;
import service.SinhVienService;


public class Main {
	public static void main(String[] args) throws SQLException, ParseException, AddressException, MessagingException {
		Scanner sc = new Scanner(System.in);
		SinhVienService svService = new SinhVienService();
		boolean ck = true;
		while(ck) {
			System.out.println("+----------------------------------------------------+");
			System.out.println("1. Thêm sinh viên");
			System.out.println("2. Hiển thị danh sách sinh viên");
			System.out.println("3. Hiển thị số lượng nam nữ cửa mỗi lớp");
			System.out.println("4. Hiển thị bảng điểm của 1 sinh viên");
			System.out.println("5. Hiển thị số lượng sinh viên và hiển thị sinh viên của từng lớp");
			System.out.println("6. Hiển thị sinh viên có điểm thấp nhấp của mỗi môn học");
			System.out.println("7. Hiển thị sinh viên có điểm thuộc top 5 điểm của môn học");
			System.out.println("8. Hiển thị điểm trung bình của sinh viên");
			System.out.println("9. Hiển thị học phí của sinh viên");
			System.out.println("0. Thoát");
			System.out.print("Chức năng bạn chọn: ");
			int chon = sc.nextInt();
			switch (chon) {
			case 1:
				svService.nhapSinhVien();
				break;
			case 2:
				svService.showSinhVien();
				break;
			case 3:
				svService.countNamNuByLop();
				break;
			case 4:
				svService.hienThiBangDiemBySinhVien();
				break;
			case 5:
				svService.showSinhVienByLop();
				break;
			case 6:
				svService.studentWithMinScoreBySubject();
				break;
			case 7:
				svService.showStudentTopBySubject();
				break;
			case 8:
				svService.agvScoreByStudent();
				break;
			case 9:
				svService.hocPhiBySinhVien();
				break;
			case 0:
				System.out.print("Bạn có muốn thoát (Yes/No): ");
				String x = sc.next();
				if(x.equals("Yes")) {
					ck = false;
				}
				break;
			default:
				System.err.println("Nhập số hợp lệ !!!");
				break;
			}
		}
		
	}

}
