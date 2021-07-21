package app;
import java.util.Scanner;

import service.DepartmentManage;

public class Run {
	public static void main(String [] arg) {
		DepartmentManage dpm = new DepartmentManage();
		Scanner sc = new Scanner(System.in);		
		boolean ck = true;
		while(ck == true) {
			System.out.println("-----------------------------------------------");
			System.out.println("1. Tạo mới phòng ban");
			System.out.println("2. Tạo mới nhân viên");
			System.out.println("3. Hiển thị danh sách nhân viên");
			System.out.println("4. Phân loại nhân viên");
			System.out.println("5. Hiển thị danh sách nhân viên theo phòng ban");
			System.out.println("6. Hiển thị nhân viên theo tên");
			System.out.println("7. Hiển thị danh sách phòng ban và số lượng nhân viên");
			System.out.println("8. Xóa nhân viên");
			System.out.println("9. Sửa thông tin nhân viên");
			System.out.println("0. Thoát");
			System.out.print("Lựa chọn chức năng:");
			int luachon = sc.nextInt();
			switch (luachon) {
			case 1:
				dpm.creatDpm();
				break;
			case 2:
				dpm.creatEmployee();
				break;
			case 3:
				dpm.displayEmployees();
				break;
			case 4:
				dpm.classifyEmployee();
				break;
			case 5:
				dpm.displayEmployeesByDptName();
				break;
			case 6:
				dpm.displayEmployeesByName();
				break;
			case 7:
				dpm.displayDptAndNum();
				break;
			case 8:
				dpm.deleteEmployeeByName();
				break;
			case 9:
				dpm.updateEmployee();
				break;
			case 0:
				System.out.print("Bạn có muốn thoát?(Yes/No):");
				String x = sc.next();
				if(x.equalsIgnoreCase("Yes")) {
					ck = false;
				}
				break;
			default:
				System.out.println("Nhập sai");
				break;
			}
		}
	}
}

