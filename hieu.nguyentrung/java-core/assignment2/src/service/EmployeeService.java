package service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

import entity.Department;
import entity.Employee;
import entity.HourlyEmployee;
import entity.SalariedEmployee;
import constant.*;

public class EmployeeService {
	Scanner scanner = new Scanner(System.in);

	public HourlyEmployee HourlyEmployeeInPut(String id) {
		System.out.println("Enter first name : ");
		String fName = scanner.nextLine();
		System.out.println("Enter last name : ");
		String lName = scanner.nextLine();
		System.out.println("Enter birth date : ");
		String bDate;
		while (true) {
			bDate = scanner.nextLine();
			if (Check.isValidDate(bDate)) {
				break;
			} else {
				System.out.println("Invalid format, please re-fill !!");
			}
		}
		System.out.println("Enter phone : ");
		String phone;
		while (true) {
			phone = scanner.nextLine();
			if (Check.isValidPhone(phone)) {
				break;
			} else {
				System.out.println("Invalid format, please re-fill !!");
			}
		}
		System.out.println("Enter email : ");
		String email;
		while (true) {
			email = scanner.nextLine();
			if (Check.isValidEmail(email)) {
				break;
			} else {
				System.out.println("Invalid format, please re-fill !!");
			}
		}
		System.out.println("Enter wage: ");
		double wage = Double.parseDouble(scanner.nextLine());
		System.out.println("Enter working hours: ");
		double wHours = Double.parseDouble(scanner.nextLine());
		HourlyEmployee hE = new HourlyEmployee(id, fName, lName, bDate, phone, email, wage, wHours);
		return hE;
	}

	public SalariedEmployee SalariedEmployeeInPut(String id) {
		System.out.println("Enter first name : ");
		String fName = scanner.nextLine();
		System.out.println("Enter last name : ");
		String lName = scanner.nextLine();
		System.out.println("Enter birth date : ");
		String bDate;
		while (true) {
			bDate = scanner.nextLine();
			if (Check.isValidDate(bDate)) {
				break;
			} else {
				System.out.println("Invalid format, please re-fill !!");
			}
		}
		System.out.println("Enter phone : ");
		String phone;
		while (true) {
			phone = scanner.nextLine();
			if (Check.isValidPhone(phone)) {
				break;
			} else {
				System.out.println("Invalid format, please re-fill !!");
			}
		}
		System.out.println("Enter email : ");
		String email;
		while (true) {
			email = scanner.nextLine();
			if (Check.isValidEmail(email)) {
				break;
			} else {
				System.out.println("Invalid format, please re-fill !!");
			}
		}
		System.out.println("Nhap commissionRate: ");
		double cRate = Double.parseDouble(scanner.nextLine());
		System.out.println("Nhap grossSales: ");
		double gSales = Double.parseDouble(scanner.nextLine());
		System.out.println("Nhap basicSalary: ");
		double bSalary = Double.parseDouble(scanner.nextLine());
		SalariedEmployee sE = new SalariedEmployee(id, fName, lName, bDate, phone, email, cRate, gSales, bSalary);
		return sE;
	}

	public void addEmployee(Department dep, int ssn) {
		int choice = 10000;
		while (choice != 0) {
			System.out.println("<< Select type of employee >>");
			System.out.println("1. SalariedEmployee");
			System.out.println("2. HourlyEmployee");
			System.out.println("0.Exit");
			choice = Integer.parseInt(scanner.nextLine());
			switch (choice) {
			case 0:
				break;
			case 1:
				SalariedEmployee sE = SalariedEmployeeInPut(String.valueOf(ssn));
				dep.addSalariedEmployee(sE);
				ssn += 1;
				break;
			case 2:
				HourlyEmployee hE = HourlyEmployeeInPut(String.valueOf(ssn));
				dep.addHourlyEmployee(hE);
				ssn += 1;
				break;
			}
		}

	}

	public void EmployeeDisplay(List<Department> dep) {
		for (Department d : dep) {
			d.Display();
		}
	}

	public void DeleteEmployee(List<Department> dep) {
		System.out.println("Enter ssn : ");
		String ssn = scanner.nextLine();
//		List<Employee> list = new ArrayList<>();
		for (Department d : dep) {
			List<Employee> list = new ArrayList<>(d.getListOfEmployee());
			for (int i =0; i<list.size(); i++) {
				if (list.get(i).getSsn().equalsIgnoreCase(ssn)) {
					list.remove(i);
					d.setListOfEmployee(list);
				}
			}
		}
	}

	public void SortHE(List<Department> dep, List<HourlyEmployee> hE) {

		Collections.sort(hE, new Comparator<HourlyEmployee>() {

			@Override
			public int compare(HourlyEmployee e1, HourlyEmployee e2) {
				// TODO Auto-generated method stub
				return e1.getFirstName().compareToIgnoreCase(e2.getFirstName());
			}
		});
	}

	public void SortSE(List<Department> dep, List<SalariedEmployee> sE) {

		Collections.sort(sE, new Comparator<SalariedEmployee>() {

			@Override
			public int compare(SalariedEmployee e1, SalariedEmployee e2) {
				// TODO Auto-generated method stub
				return e1.getFirstName().compareToIgnoreCase(e2.getFirstName());
			}
		});
	}

	public void ClassifyEmployee(List<Department> dep) {
		List<SalariedEmployee> sE = new ArrayList<>();
		List<HourlyEmployee> hE = new ArrayList<>();
		for (Department d : dep) {
			for (int i = 0; i < d.getListOfEmployee().size(); i++) {
				if (d.getListOfEmployee().get(i) instanceof SalariedEmployee) {
					sE.add((SalariedEmployee) d.getListOfEmployee().get(i));
				} else {
					hE.add((HourlyEmployee) d.getListOfEmployee().get(i));
				}
			}
		}
		SortHE(dep, hE);
		System.out.println("List of HourlyEmployee: ");
		for (HourlyEmployee h : hE) {
			System.out.println(h.toString());
		}
		System.out.println("*************");
		SortSE(dep, sE);
		System.out.println("List of SalariedEmployee: ");
		for (SalariedEmployee s : sE) {
			System.out.println(s.toString());

		}
	}

	public void searchEmp(List<Department> d) {
		int choice = 9999;
		while (choice != 0) {
			System.out.println("Select type of search: ");
			System.out.println("**********************");
			System.out.println("1. Search by dept name:  ");
			System.out.println("2. Search by emp name:  ");
			System.out.println("0. Exit");
			choice = Integer.parseInt(scanner.nextLine());
			switch (choice) {
			case 1:
				searchByDepartment(d);
				break;
			case 2:
				searchByEmp(d);
				break;
			case 0:
				break;

			}
		}
	}

	public void searchByDepartment(List<Department> d) {
		System.out.println("Enter department: ");
		String dName = scanner.nextLine();
		for (Department de : d) {
			if (de.getDepartmentName().equalsIgnoreCase(dName)) {
				System.out.println(de.getListOfEmployee());
			}
		}

	}

	public void searchByEmp(List<Department> d) {
		System.out.println("Enter first name of employee : ");
		String emp = scanner.nextLine();
		for (Department de : d) {
			List<Employee> list = new ArrayList<>(de.getListOfEmployee());
			for (Employee e : list) {
				if (e.getFirstName().equalsIgnoreCase(emp)) {
					System.out.println("Result : ");
					System.out.println(e.toString());
				}
			}
		}
	}

//	public void updateEmp(List<Department> d) {
//		int choice = 9999;
//		while (choice != 0) {
//			System.out.println("Select type of employee to update: ");
//			System.out.println("**********************");
//			System.out.println("1. Update HourlyEmployee:  ");
//			System.out.println("2. Update SalariedEmployee:  ");
//			System.out.println("0. Exit");
//			choice = Integer.parseInt(scanner.nextLine());
//			switch (choice) {
//			case 1:
//				searchByDepartment(d);
//				break;
//			case 2:
//				searchByEmp(d);
//				break;
//			case 0:
//				break;
//
//			}
//		}
//	}


//	public void updateEmp(List<Department> d) {
//		System.out.println("Enter snn: ");
//		String emp = scanner.nextLine();
//		for (Department de : d) {
//			List<Employee> list = new ArrayList<>(de.getListOfEmployee());
//			for (Employee e : list) {
//				if (e instanceof SalariedEmployee) {
//					if (e.getSsn().equalsIgnoreCase(emp)) {
//						System.out.println("Update first name:");
//						String firstName = scanner.nextLine();
//						e.setFirstName(firstName);
//						System.out.println("Update last name:");
//						String lastName = scanner.nextLine();
//						e.setLastName(lastName);
//						System.out.println("Update birth date:");
//						String bDate = scanner.nextLine();
//						e.setBirthDate(bDate);
//						System.out.println("Update phone:");
//						String phone = scanner.nextLine();
//						e.setPhone(phone);
//						System.out.println("Update email:");
//						String email = scanner.nextLine();
//						e.setEmail(email);
//						System.out.println("Update commissionRate:");
//						Double cR =Double.parseDouble(scanner.nextLine());
//						((SalariedEmployee) e).setCommissionRate(cR);
//						System.out.println("Update grossSales:");
//						Double gS =Double.parseDouble(scanner.nextLine());
//						((SalariedEmployee) e).setGrossSales(gS);
//						System.out.println("Update basicSalary:");
//						Double bS =Double.parseDouble(scanner.nextLine());
//						((SalariedEmployee) e).setBasicSalary(bS);
//						System.out.println("Update SalariedEmployee successfull");
//					}
//				}
//			}
//		}
//	}
}
