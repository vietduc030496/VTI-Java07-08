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

	private int ExistHE(List<Department> dep, String ssn, List<HourlyEmployee> hE) {
		int i;
		for (Department d : dep) {
			for (i = 0; i < d.getListOfEmployee().size(); i++) {
				if ((d.getListOfEmployee().get(i) instanceof HourlyEmployee)) {
					for (int j = 0; j < hE.size(); j++) {
						hE.get(j).getSsn().equalsIgnoreCase(ssn);
					}
				}
				return i;
			}
		}
		return -1;

	}

	private int ExistSE(List<SalariedEmployee> sE, String ssn) {
		for (int i = 0; i < sE.size(); i++) {
			if (sE.get(i).getSsn().equalsIgnoreCase(ssn))
				return i;
		}
		return -1;
	}

	public void DeleteEmployeeHE(List<Department> dep, String ssn, List<HourlyEmployee> hE) {
		int position = ExistHE(dep, ssn, hE);
		if (position == -1) {
			System.out.println("Delete operation failed. Please try again!");
		} else {
			hE.remove(position);
//			for (Department d : dep) {
//				for (int i = 0; i < d.getListOfEmployee().size(); i++) {
//					d.getListOfEmployee().remove(position);
//				}
//			}

			System.out.println("Successful delete!");
		}
	}

	public void DeleteEmployeeSE(List<SalariedEmployee> sE, String ssn) {
		int position = ExistSE(sE, ssn);
		if (position == -1) {
			System.out.println("Delete operation failed. Please try again!");
		} else {
			sE.remove(position);
			System.out.println("Successful delete!");
		}
	}

	public void SortEmployee(List<Department> dep, List<HourlyEmployee> hE) {
//		for (int i = 0; i < dep.size(); i++) {
//			if (dep.get(i).getDepartmentName().equalsIgnoreCase(DepartmentName)) {
				Collections.sort(hE, new Comparator<HourlyEmployee>() {

					@Override
					public int compare(HourlyEmployee e1, HourlyEmployee e2) {
						// TODO Auto-generated method stub
						return e1.getLastName().compareToIgnoreCase(e2.getLastName());
					}
				});
//			}
//		}
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
		System.out.println("List of HourlyEmployee: ");
		for (HourlyEmployee h : hE) {
			h.toString();
			SortEmployee(dep, hE);
		}
		System.out.println("-----------------------");
		System.out.println("List of SalariedEmployee: ");
		for (SalariedEmployee s : sE) {
			s.toString();
		}
	}
}
