package ToolJDBC.DemoJDBCAssignment;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import ToolJDBC.entity.Lop;
import ToolJDBC.entity.MonHoc;
import ToolJDBC.entity.SinhVien;
import ToolJDBC.service.LopService;
import ToolJDBC.service.MonHocService;
import ToolJDBC.service.SinhVienService;
import ToolJDBC.service.StoreProcedurers;
import ToolJDBC.utils.MailUtils;
import ToolJDBC.utils.Validate;

public class ControlMenu {
	
	public void menu1() throws SQLException {
		Validate validate = new Validate();
		Scanner sc =new Scanner(System.in);
		SinhVien sv = null;
		
		
		System.out.print("Enter ho lot: ");
		String hoLot = sc.next();
		
		System.out.print("Enter ten: ");
		String ten = sc.next();
		
		System.out.print("Enter gioi tinh: ");
		String gioiTinh = sc.next();
		
		System.out.print("Enter NgaySinh: ");
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
		String iD_Lop = sc.next();
		
		sv = new SinhVien(hoLot, ten, gioiTinh, ngaySinh, diaChi, dienThoai, email, iD_Lop);


		MailUtils mail =new  MailUtils(sv.getEmail());
		SinhVienService sinhvienservice= new SinhVienService();
		int temp = sinhvienservice.createSinhVien(sv);
		System.out.println(temp);
	}
	
	public void menu2() throws SQLException {
		SinhVienService sinhvienservice= new SinhVienService();
		List <SinhVien> listsv= sinhvienservice.getSinhVien();
		for(SinhVien sv : listsv) {
			System.out.println(sv);
		}
	}
	public void menu3() throws SQLException {
		SinhVienService sinhvienservice= new SinhVienService();
		sinhvienservice.countByGenger();
		
	}
	public void menu4() throws SQLException {
		Scanner sc =new Scanner(System.in);
		SinhVienService sinhvienservice= new SinhVienService();
		System.out.println("Enter the id of student you want to view mark  : ");
		int id =sc.nextInt();
		sinhvienservice.getMarkStudentByID(id);
	}
	public void menu5() throws SQLException {
		LopService lopser = new LopService();
		SinhVienService sinhvienservice= new SinhVienService();
		List<Lop> listLop=lopser.getLop();
		for(Lop lop :listLop) {
			System.out.println("Lop "+lop.getTenLop() +"have :");
			lopser.countStudentById(lop.getID_Lop());
			sinhvienservice.getSinhVienbylop(lop.getID_Lop());
		}
		
	}
	public void menu6() throws SQLException {
		MonHocService monser = new MonHocService();
		SinhVienService sinhvienservice= new SinhVienService();
		List<MonHoc> listMon=monser.getMonHoc();
		for(MonHoc mon :listMon) {
			System.out.println("Mon "+mon.getTenMonHoc() +"have :");

			sinhvienservice.getMinMarkSinhVienbymonhoc(mon.getID_MonHoc());
		}
		
	}
	public void menu7() throws SQLException {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter ID MonHoc : ");
		int id = sc.nextInt();
		StoreProcedurers store= new StoreProcedurers();
		store.topSV(id);
	}
	public void menu8() throws SQLException {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter ID sinhvien : ");
		int id = sc.nextInt();
		StoreProcedurers store= new StoreProcedurers();
		int result =store.avgScore(id);
		System.out.println("AVG mark : "+result);
		
	}
	public void menu9() throws SQLException {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter ID sinhvien : ");
		int id = sc.nextInt();
		StoreProcedurers store= new StoreProcedurers();
		int result =store.tuitionFee(id);
		System.out.println("Tuition fee : "+result);
	}

}
