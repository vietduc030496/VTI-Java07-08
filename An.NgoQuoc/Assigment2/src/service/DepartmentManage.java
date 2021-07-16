package service;
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
	public int validate(String s, String type) {
		if(type == "date") {
			String str = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";
			if(Pattern.compile(str).matcher(s).matches()) {
				return 1;
			}
		}
		else if(type == "phone") {
			String str = "([0-9]{7,15})\\b";
			if(Pattern.compile(str).matcher(s).matches()) {
				return 1;
			}
		}
		else{
			String str = "^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$";
			if(Pattern.compile(str).matcher(s).matches()) {
				return 1;
			}
		}
		return 0;
	}
	public void creatDpm() {
		Department dpm = new Department();
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập tên phòng ban:");
		dpm.setDepartmentName(sc.nextLine());
		dpm.setListOfEmployee(new ArrayList<Employee>());
		lisDepartments.add(dpm);
	}
	public int creatEmployee() {
		if(lisDepartments.size()==0) {
			System.err.println("Không có phòng ban nào hãy nhập tạo phòng ban trước");
			return 0;
		}
		Employee ee = null;	
		boolean ck;
		
		Scanner sc = new Scanner(System.in);
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
			if(validate(birthDate, "date")==1) {
				ck = false;
			}
			else {
				System.err.print("Ngày sinh không đúng, nhập lại:");
			}
		}
		
		//xu ly phone
		ck=true;
		String phone = "";
		System.out.print("Nhap phone:");
		while(ck) {
			phone = sc.nextLine();
			if(validate(phone, "phone")==1) {
				ck = false;
			}
			else {
				System.err.print("Số điện thoại không đúng, nhập lại:");
			}
		}
		
		//chek email
		ck = true;
		String email = "";
		System.out.print("Nhập email:");
		while(ck) {
			email = sc.nextLine();
			if(validate(email, "email")==1) {
				ck = false;
			}
			else {
				System.err.print("Email không đúng, nhập lại:");
			}
		}
		Department dp = new Department();
		
		//nhập phòng ban đến khi đúng
		ck = true;
		String departmentName ="";
		System.out.print("Nhập 1 trong các phòng ban ( ");
		for (Department department : lisDepartments) {
			System.out.print(department.getDepartmentName() + " ");
		}
		while(ck) {
			System.out.print("): ");
			departmentName = sc.nextLine();
			for (Department department : lisDepartments) {
				if(department.getDepartmentName().equals(departmentName)) {
					ck = false;
				}				
			}
			if(ck == true) {
				System.err.print("Phòng ban không tồn tại, nhập lại:");
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
		return 1;

	}
	public void displayEmployees() {
		if(listEmployees.size() != 0) {
			Collections.sort(listEmployees);
			for (Employee employee : listEmployees) {
				employee.display();
			}
		}
		else {
			System.err.println("Không có nhân viên nào");
		}
	}
	public int displayEmployeesByDptName() {
		if(lisDepartments.size()==0) {
			System.err.println("Không có phòng ban nào hãy nhập tạo phòng ban trước");
			return 0;
		}
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
					System.err.println("Không có Employee nào ");
				}
				return 0;
			}
		}
		System.err.println("Không tồn tại phòng ban");
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
			System.err.println("Không tồn tại Employee");
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
	public int deleteEmployeeByName() {
		if(listEmployees.size()==0) {
			System.err.println("Không có nhân viên nào");
			return 1;
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập ssn của nhân viên:");
		long ssn = sc.nextLong();
		for (Employee e : listEmployees) {
			if(e.getSsn() == ssn) {
				lisDepartments.remove(e);
				System.out.println("Xóa thành công");
				return 2;
			}
		}
		System.err.println("Không tồn tại nhân viên có ssn = " + ssn);
		return 0;
	}
	public int updateEmployee(){
		if(listEmployees.size()==0) {
			System.err.println("Không có nhân viên nào");
			return 1;
		}
		System.out.print("Nhập ssn của nhân viên:");
		Scanner sc = new Scanner(System.in);
		long ssn = sc.nextLong();
		//sc.nextLine();
		for (Employee e : listEmployees) {
			if(e.getSsn() == ssn) {
				System.out.println("1. update firstname");
				System.out.println("2. update lastname");
				System.out.println("3. update datebirth");
				System.out.println("4. update phone");
				System.out.println("5. update email");
				System.out.println("Chọn 1 chức năng: ");
				int key = sc.nextInt();
				sc.nextLine();
				switch (key) {
				case 1:
					System.out.println("Nhập lại firstname");
					e.setFirstName(sc.nextLine());
					break;
				case 2:
					System.out.println("Nhập lại lastname");
					e.setLastName(sc.nextLine());
					break;
				case 3:
					boolean ck = true;
					String birthDate = "";
					System.out.print("Nhập lại birthDate:");
					while(ck) {
						birthDate = sc.nextLine();				
						if(validate(birthDate, "date")==1) {
							ck = false;
						}
						else {
							System.err.print("Ngày sinh không đúng, nhập lại:");
						}
					}
					e.setBirthDate(birthDate);
					break;
				case 4:
					ck=true;
					String phone = "";
					System.out.println("Nhập lại phone");
					while(ck) {
						phone = sc.nextLine();
						if(validate(phone, "phone")==1) {
							ck = false;
						}
						else {
							System.err.print("Số điện thoại không đúng, nhập lại:");
						}
					}
					e.setPhone(phone);
					break;
				case 5:
					System.out.println("Nhập lại email");
					ck = true;
					String email = "";
					while(ck) {
						email = sc.nextLine();
						if(validate(email, "email")==1) {
							ck = false;
						}
						else {
							System.err.print("Email không đúng, nhập lại:");
						}
					}
					e.setEmail(email);
					break;
				default:
					System.err.println("Chức năng không hợp lệ");
					break;
				}
			}
			return 2;
		}
		System.err.println("Không tồn tại nhân viên có ssn = " + ssn);
		return 0;
	}
}

