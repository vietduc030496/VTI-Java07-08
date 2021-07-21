package com.vti.assignment2.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.vti.assignment2.config.Config;
import com.vti.assignment2.entity.Department;
import com.vti.assignment2.entity.Employee;
import com.vti.assignment2.entity.HourlyEmployee;
import com.vti.assignment2.entity.SalariedEmployee;

public class DepartmentManage implements Config {
	static int dem = 0;
	private ArrayList<Department> listDepartment;
	private List<Employee> listEmployee;

	public boolean checkBirthFormat(String date) {
		// String str= "/d/d[-/.]/d/d[-/.]/d{4}";
		String str = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$";
		if (Pattern.compile(str).matcher(date).matches()) {
			// System.out.println("yes");
			return true;
		} else {
			System.out.println("please enter right format of date like 12/10/1999 :");
		}

		return false;
	}

	public boolean checkPhone(String phone) {
		String str = "(84|0[3|5|7|8|9])+([0-9]{8})\\b";

		if (Pattern.compile(str).matcher(phone).matches()) {
			// System.out.println("yes");
			return true;
		} else {
			System.out.println("please enter right fomat of phone like 0985845025 :");
		}
		return false;
	}

	public boolean checkEmail(String mail) {
		String str = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";

		if (Pattern.compile(str).matcher(mail).matches()) {
//		        System.out.println("yes");
			return true;
		} else {
			System.out.println("please enter  right fomat of email  like hieu@gmail.com");
		}
		return false;

	}

	public void createEmployee() {
		Scanner scanf = new Scanner(System.in);
		System.out.print("\n Enter first Name : ");
		String firstName = scanf.nextLine();
		System.out.print("\n Enter last Name : ");
		String lastName = scanf.nextLine();
		// System.out.print("\n Enter ssn of employee : ");
		// String ssn = scanf.nextLine();
		dem++;
		String ssn = "" + dem;
		System.out.print("\n Enter birth day : ");
		String birthDate = scanf.nextLine();
		while (!checkBirthFormat(birthDate)) {
			birthDate = scanf.nextLine();
		}
		System.out.print("\n Enter phone : ");
		String phone = scanf.nextLine();
		while (!checkPhone(phone)) {
			phone = scanf.nextLine();
		}
		System.out.print("\n Enter type mail : ");
		String mail = scanf.nextLine();
		while (!checkEmail(mail)) {
			mail = scanf.nextLine();
		}
		System.out.print("\n Enter type of employee : ");
		System.out.println("\n 1 - HoursEmployee");
		System.out.println("\n 2- Salaried employee . \n");
		Employee term = null;
		int typeOfEmployee = scanf.nextInt();
		if (typeOfEmployee == HOURLYEMPLOYEE) {
			System.out.print("\n Enter wage : ");
			double wage = scanf.nextDouble();
			System.out.print("\n Enter work hour: ");
			double workHours = scanf.nextDouble();
			term = new HourlyEmployee(wage, workHours);

		} else {

			System.out.print("\n Enter commission rate : ");
			double commitssionRate = scanf.nextDouble();
			System.out.print("\n Enter grossSales : ");
			double grossSales = scanf.nextDouble();
			System.out.print("\n Enter bassicSalary : ");
			double bassicSalary = scanf.nextDouble();
			term = new SalariedEmployee(commitssionRate, grossSales, bassicSalary);

		}
		int departmentNumber = 1;
		printDepartment();
//		System.err.println("your choice:");
		if (listDepartment.size() == 0) {
			createDepartment();
			printDepartment();

		} else {
			departmentNumber = scanf.nextInt();
		}

		while (departmentNumber > listDepartment.size()) {
			System.out.print("there are not department  :" + departmentNumber);
			departmentNumber = scanf.nextInt();
		}
		term.setFirstName(firstName);
		term.setLastName(lastName);
		term.setSsn(ssn);
		term.setBirthDate(birthDate);
		term.setEmail(mail);
		term.setPhone(phone);
		listDepartment.get(departmentNumber).getListOfEmployee().add(term);
		listEmployee.add(term);
		Collections.sort(listEmployee);

	}

	private void createDepartment() {
		Scanner scanner = new Scanner(System.in);
		String name = null;
		System.out.println("Enter deparment name :");
		name = scanner.nextLine();
		Department department = new Department();
		department.setDepartmentName(name);
		listDepartment.add(department);

	}

	void printDepartment() {
		if (listDepartment.size() == 0) {
			System.out.print("there are no department ,pleasa create department first");

		} else {
			System.out.print("this below is list of department choose one: \n");
			for (int i = 0; i < listDepartment.size(); i++) {
				System.out.print(i + "-" + listDepartment.get(i).getDepartmentName() + "\n");
			}

		}
	}

	public DepartmentManage() {
		listEmployee = new ArrayList<Employee>();
		listDepartment = new ArrayList<Department>();
		Department department1 = new Department();
		department1.setDepartmentName("hr");
		listDepartment.add(department1);
		Department department2 = new Department();
		department2.setDepartmentName("it");
		listDepartment.add(department2);
		Department department3 = new Department();
		department3.setDepartmentName("orther");
		listDepartment.add(department3);
		Scanner scanf = new Scanner(System.in);
		int pick = 1;
		while (pick != EXIT) {
			System.out.print("Enter number follow menu below:  \n");
			System.out.print("1 - Create employee   \n");
			System.out.print("2 - View all employee  \n");
			System.out.print("3 - Classify employee  \n");
			System.out.print("4 - Search  \n");
			System.out.print("5 - Report  \n");
			System.out.print("6 - Create department  \n");
			System.out.print("7 - Delete Employee \n");
			System.out.print("0 - exit  \n");
			System.out.print("Pick one :  ");
			pick = scanf.nextInt();

			switch (pick) {
			case CREATEEMPLOYEE: {
				createEmployee();

				break;
			}

			case VIEWEMPLOYEE: {
				viewAllEmployee();
				break;
			}

			case CLASSIFYEMPLOYEE: {
				classify();
//				classifyEmployee();
				break;
			}
			case SEARCH: {
				search();
				break;
			}
			case REPORT: {
				report();
				break;
			}
			case CREATEDEPARTMENT: {
				createDepartment();
				break;
			}
			case DELETEEMPLOYEE: {
				deleteSameSsn();
			}
			}
		}

	}

	private void deleteSameSsn() {
		System.out.println("enter the the ssn of employee you want to delete :");
		String ssnDe=null;
		Scanner scanner =new Scanner(System.in);
		ssnDe=scanner.nextLine();
		for(Department department : listDepartment) {
			for(int i=0;i<department.getListOfEmployee().size();i++ ) {
				if(ssnDe.equals( department.getListOfEmployee().get(i).getSsn() )) {
					department.getListOfEmployee().remove(i);
				}
			}
		}
		
	}

	private void classify() {
		System.out.print("list hourly employee: \n");
		for (Object employe : listEmployee) {
			if (employe instanceof HourlyEmployee) {
				((HourlyEmployee) employe).Display();
			}
		}
		System.out.print("list salaried employee: \n");
		for (Object employe : listEmployee) {
			if (employe instanceof SalariedEmployee) {
				((SalariedEmployee) employe).Display();
			}
		}

	}

	private void report() {
		for (Department department : listDepartment) {
			System.out.print("Department " + department.getDepartmentName() + " have "
					+ department.getListOfEmployee().size() + " employee \n");
		}

	}

	public void search() {
		Scanner scanf = new Scanner(System.in);
		System.out.print("\n 1. Find employee by department \n" + "2. Find employee by name :  ");
		int typeFind = scanf.nextInt();
		if (typeFind == FINDBYDEPARTMENT) {
			searchDepartment();
		} else
			searchEmployee();
	}

	private void searchDepartment() {

		Scanner scanf = new Scanner(System.in);
		System.out.print("\n Enter Department(1:it:hr,2:other): ");
		int typeofDepartment = scanf.nextInt();
		String nameofdepartment = "orther";

		if (typeofDepartment == HR) {
			nameofdepartment = "hr";
		} else if ((typeofDepartment == IT)) {
			nameofdepartment = "it";
		}
		for (Department department : listDepartment) {
			if (nameofdepartment.equalsIgnoreCase(department.getDepartmentName())) {
				System.out.print("employee belong to " + nameofdepartment + "\n");

				for (Employee employee : department.getListOfEmployee()) {
					employee.Display();
				}
			}
		}

	}

	public void searchEmployee() {
		Scanner scanf = new Scanner(System.in);
		System.out.print("\n Enter employee name  ");
		String employeeName = scanf.nextLine();
		for (Department department : listDepartment) {
			for (Employee employee : department.getListOfEmployee()) {
				if (employee.getFirstName().equalsIgnoreCase(employeeName)) {
					System.out.print("found the employee name " + employeeName + "\n");
					employee.Display();
				}
			}
		}

	}

	private void classifyEmployee() {
		System.out.print("Hour Employee:  \n");
		for (Department department : listDepartment) {
			for (Object employee : department.getListOfEmployee()) {
				if (employee instanceof HourlyEmployee) {
					((HourlyEmployee) employee).Display();
				}
			}
		}
		System.out.print("Salaried Employee:  \n");
		for (Department department : listDepartment) {
			for (Object employee : department.getListOfEmployee()) {
				if (employee instanceof SalariedEmployee) {
					((SalariedEmployee) employee).Display();
				}
			}
		}
		// TODO Auto-generated method stub

	}

	private void viewAllEmployee() {
		for (Department department : listDepartment) {
			for (Employee employee : department.getListOfEmployee()) {
				employee.Display();
			}
		}

	}
}
