package app;

import java.sql.SQLException;
import java.util.Scanner;

import javax.mail.MessagingException;

import service.*;

public class main {
	public static void main(String[] args) throws SQLException, MessagingException{
		int choiceNumber = 10;
		Scanner scanner = new Scanner(System.in);

		while (choiceNumber != 0) {
			System.out.println("1. Them thong tin Sinh Vien");
			System.out.println("2. Hien thi danh sach Sinh Vien");
			System.out.println("3. Hien thi so luong hs nam/nu moi lop");
			System.out.println("4. Hien thi bang diem cua Sinh Vien theo ID");
			System.out.println("5. Dem so luong Sinh Vien moi lop");
			System.out.println("6. Thong tin Sinh Vien co diem thap nhat moi mon hoc");
			System.out.println("7. Lay thong tin Sinh Vien co diem thuoc top 5 theo ID mon hoc");
			System.out.println("8. Tinh diem trung binh cua Sinh Vien theo ID_SV");
			System.out.println("9. Tinh tien hoc cua sinh vien theo ID_SV");
			System.out.println("0. Exit");
			System.out.println("Please choose: ");
			choiceNumber = Integer.parseInt(scanner.nextLine());

			switch (choiceNumber) {
			case 1:
				insertSinhVien.insertSV();
				break;
			case 2:
				displaySinhVien.getSinhVien();
				break;
			case 3:
				displayGenderSV.getGenderSV();
				break;
			case 4:
				displayBangDiem.getBangDiemByID();
				break;
			case 5:
				countSinhVien.countSVEachClass();
				break;
			case 6:
				displayMinGrade.getMinGradeEachSubject();
				break;
			case 7:
				getTop5GradeSV.getTop5Grade();
				break;
			case 8:
				calcAvgGrade.calcAvgGradeByIDSV();
				break;
			case 9:
				calcTotalFee.calcTotalFeeByIDSV();
				break;
			case 0:
				System.exit(0);
				break;

			}
		}
	}
}
