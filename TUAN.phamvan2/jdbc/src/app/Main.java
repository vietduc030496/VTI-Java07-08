package app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import entity.SinhVien;
import service.SinhVienService;

public class Main {
	private static Scanner sc;

	public static void main(String[] args) throws SQLException, AddressException, MessagingException {
		sc = new Scanner(System.in);
		SinhVienService svService = new SinhVienService();
		boolean choice = true;
		while(choice) {
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
			String chon = sc.nextLine();
			
			switch (chon) {
			case "1":
				svService.inputSV();
				break;
			case "2":
				svService.getListSinhVien();
				break;
			case "3":
				svService.countStuByGender();
				break;
			case "4":
				int id1;
				System.out.print("Mời nhập SV ID: ");
				id1 = Integer.parseInt(sc.nextLine());
				svService.showScoreById(id1);
				break;
			case "5":
				svService.showStuByClass();;
				break;
			case "6":
				svService.showStuWithMinScore();
				break;
			case "7":
				int id2;
				System.out.print("Mời nhập Môn Học ID: ");
				id2 = Integer.parseInt(sc.nextLine());
				svService.callTopSV(id2);
				break;
			case "8":
				int id3;
				System.out.print("Mời nhập SV ID: ");
				id3 = Integer.parseInt(sc.nextLine());
				svService.pointAverage(id3);;
				break;
			case "9":
				int id4;
				System.out.print("Mời nhập SV ID: ");
				id4 = Integer.parseInt(sc.nextLine());
				svService.calcTheFee(id4);;
				break;
			case "0":
				System.out.print("Bạn có muốn thoát (Yes/No): ");
				String x = sc.next();
				if(x.equals("Yes")) {
					choice = false;
				}
				break;
			default:
				System.err.println("Nhập số hợp lệ !!!");
				break;
			}
		}
		
	}
}
