package app;
import service.StudentService;
import service.ClassService;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class Main {

	public static void main(String[] args) throws AddressException, SQLException, MessagingException, ParseException {
		
		// TODO Auto-generated method stub
		StudentService studentService=new StudentService();
		ClassService classService=new ClassService();
		Scanner sc =new Scanner(System.in);
        String choose = null;
        boolean exit = false;
        showMenu();
        while (true) {
            choose = sc.nextLine();
            switch (choose) {
            case "1":
            	studentService.themSV();
                break;
            case "2":
            	studentService.hienThiDSSV();
            	break;
            case "3":
            	classService.hienThiSoLuongNamNu();
                break;
            case "4":
            	studentService.hienThiBangDiem();
                break;
            case "5":
            	classService.hienThiSVTrongLop();
                break;
            case "6":
            	studentService.hienThiSVCoDiemThapNhat();
                break;
            case "7":
            	studentService.hienThiSVCoDiemTop5();
                break;
            case "8":
            	 studentService.tinhDiemTBSV();
                break;
            case "9":
            	 studentService.tinhTienHocSV();
                break;
            case "0":
                System.out.println("Thoat!");
                exit = true;
                break;
            default:
                System.out.println("Xin vui long chon lai:");
                break;
            }
            if (exit) {
                break;
            }
            showMenu();
        }
	}
    public static void showMenu() {
        System.out.println("-----------menu------------");
        System.out.println("1. Them thong tin sinh vien");
        System.out.println("2. Hien thi danh sach sinh vien");
        System.out.println("3. Hien thi so luong sinh vien nam/nu o cac lop");
        System.out.println("4. Hien thi bang diem cua sinh vien");
        System.out.println("5. Dem so luong sinh vien va thong tin sinh vien cua tung lop");
        System.out.println("6. Xem thong tin sinh vien co diem thap nhat cua moi mon hoc");
        System.out.println("7. Xem thong tin sinh vien co diem thuoc top 5 cao nhat");
        System.out.println("8. Tinh diem trung binh cua sinh vien");
        System.out.println("9. Tinh tien hoc theo so tin chi cua sinh vien");
        System.out.println("0. Thoat");
        System.out.println("---------------------------");
        System.out.print("Vui long chon: ");
    }
}

