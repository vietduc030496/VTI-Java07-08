package vti.exercise1.app;

import vti.exercise1.service.*;
import java.util.*;
import vti.exercise1.entity.*;

public class Controller {
	List<Employee> listEmployee;
	List<Department> listDepartment;
	DisplayList displayService;
	int ssn;

	public Controller(List<Employee> employee, List<Department> department) {
		listEmployee = employee;
		listDepartment = department;
		displayService = new DisplayList();
		ssn = employee.size();
		menu();
	}

	void menu() {
		Scanner input = new Scanner(System.in);
		System.out.println("************** MENU **************");
		System.out.println("1 - Quan ly phong ban.");
		System.out.println("2 - Them nhan vien.");
		System.out.println("3 - Hien thi nhan vien.");
		System.out.println("4 - Hien thi nhan vien lam chinh.");
		System.out.println("5 - Hien thi nhan vien lam theo gio.");
		System.out.println("6 - Tim kiem nhan vien.");
		try {
			int type = input.nextInt();
			input.nextLine();
			switch (type) {
			case 1:
				inputDepartment();
				break;
			case 2:
				inputEmployee();
				break;
			case 3:
				displayService.displayEmployee(listEmployee);
				menu();
				break;
			case 4:
				displayService.displaySalariedEmployee(listEmployee);
				menu();
				break;
			case 5:
				displayService.displayHourlyEmployee(listEmployee);
				menu();
				break;
			case 6:
				employeeSearch();
				break;
			default:
				System.out.println("Moi ban chon lai!");
				menu();
				break;
			}
		} catch (InputMismatchException e) {
			System.out.println("Moi ban chon lai!");
			menu();
		}

		input.close();
	}

	void inputDepartment() {
		Scanner input = new Scanner(System.in);
		System.out.println("********** INPUT DEPARTMENT ***********");
		System.out.println("0 - Thoat ra menu.");
		System.out.println("1 - Hien thi danh sach cac phong ban.");
		System.out.println("2 - Them phong ban.");
		System.out.println("3 - Tim kiem phong ban.");
		try {
			int type = input.nextInt();
			switch (type) {
			case 0:
				menu();
				break;
			case 1:
				displayListDepartment();
				break;
			case 2:
				addDepartment();
				break;
			case 3:
				departmentSearch();
				break;
			default:
				System.out.println("Moi ban chon lai!");
				inputDepartment();
				break;
			}
		} catch (InputMismatchException e) {
			System.out.println("Moi ban chon lai!");
			inputDepartment();
		}
		input.close();
	}

	void addDepartment() {
		System.out.println("******** ADD DEPARTMENT ********");
		System.out.print("Ten phong ban: ");
		Scanner input = new Scanner(System.in);
		String name = input.nextLine();
		Department department = new Department(name);
		boolean isDublicate = false;
		for (Department d : this.listDepartment) {
			if (name.equals(d.getDepartmentName())) {
				System.out.println("Ten phong ban bi trung!!! Them that bai!!");
				isDublicate = true;
				break;
			}
		}
		if (!isDublicate) {
			System.out.println("Them phong ban thanh cong");
			this.listDepartment.add(department);
		}
		inputDepartment();
		input.close();
	}

	void displayListDepartment() {
		Scanner input = new Scanner(System.in);
		System.out.println("********** LIST DEPARTMENT **********");
		if (!this.listDepartment.isEmpty()) {
			int index = 0;
			for (Department d : this.listDepartment) {
				System.out.println(
						"Stt: " + ++index + " | Ten: " + d.getDepartmentName() + " | So nv: " + d.getAmountEmployee());
			}
			System.out.println("Chon nut theo stt de xem chi tiet phong ban!");
			System.out.println("Chon 0 de thoat!");
		}
		int type = input.nextInt();
		input.nextLine();
		if (type == 0) {
			inputDepartment();
		} else {
			try {
				if (this.listDepartment.get(type - 1) != null) {
					this.displayService.displayEmployee(this.listDepartment.get(type - 1).getListOfEmployee());
					displayListDepartment();
				}
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Khong ton tai phong ban stt " + type);
				displayListDepartment();
			}
		}

		input.close();
	}

	int chooseDepartment() {
		Scanner input = new Scanner(System.in);
		System.out.println("************ CHOOSE DEPARTMENT ************");
		int index = 0;
		for (Department d : this.listDepartment) {
			System.out.println(++index + " - " + d.getDepartmentName());
		}
		System.out.println("*Tao phong ban nhan 0 de tro lai, sau do nhan 1!");
		try {
			int type = input.nextInt();

			if (type >= 1 && type <= this.listDepartment.size()) {
				return type;
			} else if (type == 0) {
				return 0;
			} else {
				System.out.println("Moi ban chon lai!");
				chooseDepartment();
			}
		} catch (InputMismatchException e) {
			System.out.println("Moi ban chon lai!");
			chooseDepartment();
		}
		input.close();
		return 0;
	}

	void inputEmployee() {
		Scanner input = new Scanner(System.in);
		System.out.println("************ INPUT EMPLOYEE ************");
		System.out.println("0 - Thoat ra menu.");
		System.out.println("1 - Them nhan vien lam chinh.");
		System.out.println("2 - Them nhan vien lam theo gio.");
		try {
			int type = input.nextInt();
			input.nextLine();
			if (type == 1) {
				int department = this.chooseDepartment() - 1;
				if (department == -1) {
					menu();
				}
				SalariedEmployee sE = inputSalariedEmployee(input);
				listEmployee.add(sE);
				Collections.sort(listEmployee);
				listDepartment.get(department).getListOfEmployee().add(sE);
				Collections.sort(listDepartment.get(department).getListOfEmployee());
			} else if (type == 2) {
				int department = this.chooseDepartment() - 1;
				if (department == -1) {
					menu();
				}
				HourlyEmployee hE = inputHourlyEmployee(input);
				listEmployee.add(hE);
				Collections.sort(listEmployee);
				listDepartment.get(department).getListOfEmployee().add(hE);
				Collections.sort(listDepartment.get(department).getListOfEmployee());
			} else if (type == 0) {
				menu();
			} else {
				System.out.println("Moi ban chon lai!");
			}
		} catch (InputMismatchException e) {
			System.out.println("Moi ban chon lai!");
			inputEmployee();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			inputEmployee();
		}
		inputEmployee();
		input.close();
	}

	SalariedEmployee inputSalariedEmployee(Scanner input) {
		System.out.print("Nhap ho: ");
		String firstName = input.nextLine();
		System.out.print("Nhap ten: ");
		String lastName = input.nextLine();
		System.out.print("Nhap ti le hoa hong: ");
		double commissionRate = input.nextDouble();
		System.out.print("Nhap tong doanh thu: ");
		double grossSales = input.nextDouble();
		System.out.print("Nhap luong co ban: ");
		double basicSalary = input.nextDouble();
		input.nextLine();
		System.out.print("Nhap email: ");
		String email = input.nextLine();
		System.out.print("Nhap sdt: ");
		String phone = input.nextLine();
		System.out.print("Nhap ns (dd/mm/yy): ");
		String birth = input.nextLine();
		SalariedEmployee sE = new SalariedEmployee(Integer.toString(ssn++), firstName, lastName, commissionRate,
				grossSales, basicSalary);
		sE.setEmail(email);
		sE.setPhone(phone);
		sE.setBirthDate(birth);
		return sE;
	}

	HourlyEmployee inputHourlyEmployee(Scanner input) {
		System.out.print("Nhap ho: ");
		String firstName = input.nextLine();
		System.out.print("Nhap ten: ");
		String lastName = input.nextLine();
		System.out.print("Nhap tien cong: ");
		double wage = input.nextDouble();
		System.out.print("Nhap so gio lam: ");
		double workingHous = input.nextDouble();
		input.nextLine();
		System.out.print("Nhap email: ");
		String email = input.nextLine();
		System.out.print("Nhap sdt: ");
		String phone = input.nextLine();
		System.out.print("Nhap ns (dd/mm/yy): ");
		String birth = input.nextLine();
		HourlyEmployee hE = new HourlyEmployee(Integer.toString(ssn++), firstName, lastName, wage, workingHous);
		hE.setEmail(email);
		hE.setPhone(phone);
		hE.setBirthDate(birth);
		return hE;
	}

	void employeeSearch() {
		Scanner input = new Scanner(System.in);
		System.out.print("Nhap ten nhan vien: ");
		String textSearch = input.nextLine();
		boolean isFind = false;
		Employee employee = null;
		for (Employee e : this.listEmployee) {
			if (textSearch.equals(e.getFirstName())) {
				System.out.println("******** " + e.getFirstName() + " ********");
				e.display();
				employee = e;
				isFind = true;
				break;
			}
		}
		if (!isFind) {
			System.out.println("Khong tim duoc nv hop le!!");
			menu();
		} else {
			changeInfoEmployee(employee);
		}
		input.close();
	}

	void changeInfoEmployee(Employee employee) {
		System.out.println("0 - Thoat ra!");
		System.out.println("1 - Them, sua thong tin nhan vien.");
		System.out.println("2 - Xoa nhan vien.");
		Scanner input = new Scanner(System.in);
		try {
			int type = input.nextInt();
			input.nextLine();
			if (type == 0) {
				menu();
			} else if (type == 1) {
				if (employee instanceof SalariedEmployee) {
					System.out.println("*Nhan vien chinh thuc* * " + employee.getFullName() + " *");
					SalariedEmployee e = (SalariedEmployee) employee;
					SalariedEmployee sE = inputSalariedEmployee(input);
					e.setFirstName(sE.getFirstName());
					e.setLastName(sE.getLastName());
					e.setCommissionRate(sE.getCommissionRate());
					e.setBasicSalary(sE.getBasicSalary());
					e.setGrossSales(sE.getGrossSales());
					e.setEmail(sE.getEmail());
					e.setPhone(sE.getPhone());
					e.setBirthDate(sE.getBirthDate());
					menu();
				} else if (employee instanceof HourlyEmployee) {
					System.out.println("*Nhan vien lam theo gio* * " + employee.getFullName() + " *");
					HourlyEmployee e = (HourlyEmployee) employee;
					HourlyEmployee hE = inputHourlyEmployee(input);
					e.setFirstName(hE.getFirstName());
					e.setLastName(hE.getLastName());
					e.setWage(hE.getWage());
					e.setWorkingHous(hE.getWorkingHous());
					e.setEmail(hE.getEmail());
					e.setPhone(hE.getPhone());
					e.setBirthDate(hE.getBirthDate());
					menu();
				}
			} else if (type == 2) {
				deleteEmployee(employee);
			}
		} catch (InputMismatchException e) {
			System.out.println("Moi ban chon lai!");
			changeInfoEmployee(employee);
		}

		input.close();
	}

	void departmentSearch() {
		Scanner input = new Scanner(System.in);
		System.out.print("Nhap ten phong ban: ");
		String textSearch = input.nextLine();
		boolean isFind = false;
		for (Department d : this.listDepartment) {
			if (textSearch.equals(d.getDepartmentName())) {
				System.out.println("******** " + d.getDepartmentName() + " ********");
				if (d.getAmountEmployee() > 0) {
					displayService.displayEmployee(d.getListOfEmployee());
				} else {
					System.out.println("Danh sach trong !!");
				}
				isFind = true;
				break;
			}
		}
		if (!isFind) {
			System.out.println("Khong tim duoc phong ban hop le!!");
		}
		inputDepartment();
		input.close();
	}

	void deleteEmployee(Employee employee) {
		listEmployee.remove(employee);
		for (Department d : listDepartment) {
			if (d.getListOfEmployee().contains(employee)) {
				listEmployee.remove(employee);
			}
		}
		System.out.println("Xoa nhan vien *" + employee.getFullName() + "* thanh cong!");
		menu();
	}
}