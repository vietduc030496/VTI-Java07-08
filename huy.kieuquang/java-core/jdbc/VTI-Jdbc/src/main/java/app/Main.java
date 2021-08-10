package app;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import javax.mail.MessagingException;

import entity.Lop;
import entity.SinhVien;
import services.LopService;
import services.SinhVienService;
import utils.EmailUtil;
import utils.Validate;

public class Main {
	public static void main(String[] args) throws SQLException, MessagingException, UnsupportedEncodingException, ParseException{
		Main main = new Main();
		main.run();
	}

	public void run() throws SQLException, MessagingException, UnsupportedEncodingException, ParseException{
		SinhVienService svService = new SinhVienService();
		LopService lopService = new LopService();
		Validate validate = new Validate();
		EmailUtil emailUtil = new EmailUtil();

		List<SinhVien> listSV = null;

		Scanner sc = new Scanner(System.in);

		boolean exit = false;
		while (exit == false) {
			System.out.println("----------Menu-----------");
			System.out.println("0.Exit");
			System.out.println("1.Them sinh vien");
			System.out.println("2.Hien thi ds sinh vien");
			System.out.println("3.Hien thi so nam/nu cac lop");
			System.out.println("4.Hien thi bang diem sinhvien");
			System.out.println("5.Dem so luong sinhvien tung lop ");
			System.out.println("6.Sinhvien co diem thap nhat moi mon hoc ");
			System.out.println("7.Info sv co diem top 5 cao nhat");
			System.out.println("8.Diem trung binh ");
			System.out.println("9.Tinh hoc phi theo so tin chi ");
			System.out.println("-------------------------");
			System.out.print("Choose your option: ");

			int option = sc.nextInt();
			switch (option) {
			case 0:
				exit = true;
				break;
			case 1:
				SinhVien sv = null;
				System.out.print("Nhap ho lot: ");
				String hoLot = sc.next();
				System.out.print("Nhap ten: ");
				String ten = sc.next();
				System.out.print("Nhap gioi tinh: ");
				String gioiTinh = sc.next();
				System.out.print("Nhap ngay sinh: ");
				String ngaySinh = "";
				while (validate.validateBrithday(ngaySinh) == false) {
					ngaySinh = sc.next();
				}
				System.out.print("Nhap dia chi: ");
				String diaChi = sc.next();
				System.out.print("Nhap dien thoai: ");
				String dienThoai = "";
				while (validate.validatePhone(dienThoai) == false) {
					dienThoai = sc.next();
					if (validate.validatePhone(dienThoai) == false)
						System.out.println("Phone is not valid");
				}
				System.out.print("Nhap email: ");
				String email = "";
				while (validate.validateEmail(email) == false) {
					email = sc.next();
					if (validate.validateEmail(email) == false)
						System.out.println("Email is not valid");
				}
				System.out.print("Nhap ID_Lop: ");
				int iD_Lop = sc.nextInt();
				
				sv = new SinhVien(hoLot, ten, gioiTinh, ngaySinh, diaChi, dienThoai, email, iD_Lop);

				// change email, password
				if(svService.insertSinhvien(sv)) {
					emailUtil.sendMail(email);
				}
				
				break;
			case 2:
				listSV = svService.getAllSinhVien();

				for (SinhVien sinhVien : listSV) {
					System.out.println(sinhVien);
				}
				break;
			case 3:
				svService.getGender();
				break;
			case 4:
				System.out.print("Nhap id sinh vien: ");
				int id_sv = sc.nextInt();
				svService.getInfoByID(id_sv);
				break;
			case 5:
				List<Lop> listLop = lopService.getAllLop();
				listSV = svService.getAllSinhVien();
				svService.getQuantityPerClass();

				for (Lop lop : listLop) {
					System.out.println("Lop " + lop.getTenLop());
					for (SinhVien sinhvien : listSV) {
						if (sinhvien.getID_Lop() == lop.getID_Lop()) {
							System.out.println(sinhvien.toString());
						}
					}
				}
				break;
			case 6:
				svService.getInfoHasMinMarkPerSubject();
				break;
			case 7:
				List<Integer> listMark = svService.getTop5Mark();

				for (Integer mark : listMark) {
					System.out.println("Diem " + mark);
					svService.getInfoByMark(mark);
				}

				break;
			case 8:
				System.out.print("Nhap id sv: ");
				int id_sv2 = sc.nextInt();
				svService.getAvarageMarkById(id_sv2);
				break;
			case 9:
				System.out.print("Nhap id sv: ");
				int id_sv3 = sc.nextInt();
				svService.getTuitionFeeByID(id_sv3);
				break;
			default:
				break;
			}
		}
	}

}
