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

public class ControlMenu {
	
	public void menu1() throws SQLException {
		SinhVien hieu= new SinhVien();
		hieu.setTen("hieu");
		hieu.setEmail("nvhieu.dev@gmail.com");
		MailUtils mail =new  MailUtils(hieu.getEmail());
		SinhVienService sinhvienservice= new SinhVienService();
		int temp = sinhvienservice.createSinhVien(hieu);
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
