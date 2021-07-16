package app;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import entity.Department;
import entity.Employee;
import entity.HourlyEmployee;
import entity.SalariedEmployee;

public class DepartmentManage {
	List<Employee> listEmployees = new ArrayList<Employee>();
	List<Department> lisDepartments = new ArrayList<Department>();
	public void creatEmployee() {
		Employee ee = null;	
		boolean ck;
		
		Scanner sc = new Scanner(System.in);
		//System.out.print("Nhap ssn:");
		//String ssn = sc.nextLine();
		System.out.print("Nhap firstName:");
		String firstName = sc.nextLine();
		System.out.print("Nhap lastName:");
		String lastName = sc.nextLine();
		
		//xu ly date
		ck = true;
		String birthDate = "";
		System.out.print("Nhap birthDate:");
		while(ck) {
			birthDate = sc.nextLine();
			String str = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";
			if(Pattern.compile(str).matcher(birthDate).matches()) {
				ck = false;
			}
			else {
				System.out.print("Ngày sinh không đúng, nhập lại:");
			}
		}
		
		//xu ly phone
		ck=true;
		String phone = "";
		System.out.print("Nhap phone:");
		while(ck) {
			phone = sc.nextLine();
			String str = "([0-9]{7,15})\\b";
			if(Pattern.compile(str).matcher(phone).matches()) {
				ck = false;
			}
			else {
				System.out.print("Số điện thoại không đúng, nhập lại:");
			}
		}
		
		//chek email
		ck = true;
		String email = "";
		System.out.print("Nhap email:");
		while(ck) {
			email = sc.nextLine();
			String str = "^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$";
			if(Pattern.compile(str).matcher(email).matches()) {
				ck = false;
			}
			else {
				System.out.print("Email không đúng, nhập lại:");
			}
		}
		Department dp = new Department();
		
		//nhập phòng ban đến khi đúng
		ck = true;
		String departmentName ="";
		while(ck) {
			System.out.print("Nhap departmentName(HR,IT,XX):");
			departmentName = sc.nextLine();
			if(departmentName.equals("HR") == true || departmentName.equals("IT") | departmentName.equals("XX")) {
				ck = false;
			}
		}
				
		//nhap kieu nhan vien
		System.out.print("Nhập loại nhân viên(SalariedEmployee = 1 || HourlyEmployee = 2): ");
		int typeE = sc.nextInt();
		if(typeE == 1) {
			System.out.print("Nhap commissionRate:");
			double commissionRate = sc.nextDouble();
			System.out.print("Nhap grossSales:");
			double grossSales = sc.nextDouble();
			System.out.print("Nhap basicSalary:");
			double basicSalary = sc.nextDouble();
			ee = new SalariedEmployee(firstName, lastName, birthDate, phone, email, commissionRate, grossSales, basicSalary);
			listEmployees.add(ee);
		}
		else if(typeE == 2) {
			System.out.print("Nhap wage:");
			double wage = sc.nextDouble();
			System.out.print("Nhap workingHours:");
			double workingHours = sc.nextDouble();
			ee = new HourlyEmployee(firstName, lastName, birthDate, phone, email, wage, workingHours);
			listEmployees.add(ee);
		}
		
		//add nhan vien vao phòng ban
		for (Department department : lisDepartments) {
			if(departmentName.equals(department.getDepartmentName())){
				List<Employee> list = department.getListOfEmployee();
				list.add(ee);
			}
		}

	}
	public void displayEmployees() {
		if(listEmployees.size() != 0) {
			Collections.sort(listEmployees);
			for (Employee employee : listEmployees) {
				employee.display();
			}
		}
		else {
			System.out.println("Không có nhân viên nào");
		}
	}
	public int displayEmployeesByDptName() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập tên phòng ban:");
		String dptName = sc.nextLine();
		for (Department department : lisDepartments) {
			if(department.getDepartmentName().equals(dptName)){
				List<Employee> list = department.getListOfEmployee();
				if(list.size() !=0) {
					for (Employee employee : list) {
						employee.display();
					}
				}
				else {
					System.out.println("Không có Employee nào ");
				}
				return 0;
			}
		}
		System.out.println("Không tồn tại phòng ban");
		return 1;
	}
	public void displayEmployeesByName() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập tên nhân viên:");
		String name = sc.nextLine();
		int ck = 1;
		Collections.sort(listEmployees);
		for ( Employee ee : listEmployees) {
			if(ee.getFirstName().equals(name)) {
				ee.display();
				ck = 0;
			}
		}
		if(ck == 1) {
			System.out.println("Không tồn tại Employee");
		}
	}
	public void displayDptAndNum() {
		for (Department department : lisDepartments) {
			department.display();
		}

	}
	public void classifyEmployee() {
		System.out.println("Danh sách SalariedEmployee:");
		Collections.sort(listEmployees);
		for (Object ee : listEmployees) {
			if(ee instanceof SalariedEmployee ) {
				((SalariedEmployee) ee).display();
			}
		}
		System.out.println("Danh sách HourlyEmployee");
		for (Object ee : listEmployees) {
			if(ee instanceof HourlyEmployee ) {
				((HourlyEmployee) ee).display();
			}
		}
	}
	public void run(String [] arg) {
		//khởi tạo phòng ban
		Department dp1 = new Department("HR", new ArrayList<Employee>());
		Department dp2 = new Department("IT", new ArrayList<Employee>());
		Department dp3 = new Department("ORTHER", new ArrayList<Employee>());
		lisDepartments.add(dp1);
		lisDepartments.add(dp2);
		lisDepartments.add(dp3);		
		
		Scanner sc = new Scanner(System.in);		
		boolean ck = true;
		while(ck == true) {
			System.out.println("-----------------------------------------------");
			System.out.println("1. Tạo mới nhân viên");
			System.out.println("2. Hiển thị danh sách nhân viên");
			System.out.println("3. Phân loại nhân viên");
			System.out.println("4. Hiển thị danh sách nhân viên theo phòng ban");
			System.out.println("5. Hiển thị nhân viên theo tên");
			System.out.println("6. Hiển thị danh sách phòng ban và số lượng nhân viên");
			System.out.println("0. Thoát");
			System.out.print("Lựa chọn chức năng:");
			int luachon = sc.nextInt();
			switch (luachon) {
			case 1:
				creatEmployee();
				break;
			case 2:
				displayEmployees();
				break;
			case 3:
				classifyEmployee();
				break;
			case 4:
				displayEmployeesByDptName();
				break;
			case 5:
				displayEmployeesByName();
				break;
			case 6:
				displayDptAndNum();
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
	public static void main(String [] arg) {
		DepartmentManage dm =new DepartmentManage();
		dm.run(arg);
	}
}

