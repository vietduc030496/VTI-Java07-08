package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import entity.Department;
import entity.Employee;
import entity.HourlyEmployee;
import entity.SalariedEmployee;

import utils.Validation;

public class Execute implements IDepartment {

	private Scanner s;

	public List<Employee> emps = new ArrayList<>();
	public Employee emp = new Employee();

	public Department dpm = new Department();
	public List<Department> dpms = new ArrayList<>();

	public List<Employee> emps1 = new ArrayList<>();
	public List<Employee> emps2 = new ArrayList<>();

	public Execute() {
		super();
		// TODO Auto-generated constructor stub
		s = new Scanner(System.in);
		emps1.add(new SalariedEmployee("0001", "pham", "a", "24/06/1999", "0921847812", "a@gmail.com", 10, 20, 1000));
		emps2.add(new SalariedEmployee("0003", "pham", "b", "24/06/1999", "0921847812", "b@gmail.com", 10, 20, 1000));
		emps2.add(new HourlyEmployee("0008", "pham", "c", "24/06/1999", "0921847812", "c@gmail.com", 10, 20));
		emps2.add(new HourlyEmployee("0002", "pham", "d", "24/06/1999", "0921847812", "d@gmail.com", 10, 20));
		emps1.add(new HourlyEmployee("0010", "pham", "e", "24/06/1999", "0921847812", "e@gmail.com", 10, 20));
		emps.addAll(emps1);
		emps.addAll(emps2);
		dpms.add(new Department("it", emps1));
		dpms.add(new Department("mkt", emps2));
	}

	private int isExist(String ssn) {
		for (int i = 0; i < emps.size(); i++) {
			if (emps.get(i).getSsn().equalsIgnoreCase(ssn))
				return i;
		}
		return -1;
	}

	@Override
	public Department inputD() {
		// TODO Auto-generated method stub
		String departmentName = "";
		List<Employee> listOfEmployee = new ArrayList<>();
		System.out.print("Enter department name: ");
		departmentName = s.nextLine();
		boolean isExistD = false;
		for (Department dpm : dpms) {
			if (departmentName.equalsIgnoreCase(dpm.getDepartmentName())) {
				isExistD = true;
			}
		}
		if (isExistD == false) {
			Department dpm = new Department();
			dpm.setDepartmentName(departmentName);
			System.out.println("Added successfully!");
		}

		return new Department(departmentName, listOfEmployee);
	}

	@Override
	public Employee inputE() {
		// TODO Auto-generated method stub

		String ssn, firstName, lastName, birthDate, phone, email;
		while (true) {
			System.out.print("Enter ssn: ");
			ssn = s.nextLine();
			if (isExist(ssn) == -1) {
				break;
			} else {
				System.err.println("Enter again!");
			}
		}
		System.out.println("Enter employee name: first name, last name:");
		firstName = s.nextLine();
		lastName = s.nextLine();
		while (true) {
			System.out.print("Enter birthDate: ");
			birthDate = s.nextLine();
			if (Validation.isValidDate(birthDate)) {
				break;
			} else {
				System.err.println("Enter again!");
			}
		}
		while (true) {
			System.out.print("Enter phone: ");
			phone = s.nextLine();
			if (Validation.isValidPhone(phone)) {
				break;
			} else {
				System.err.println("Enter again!");
			}
		}
		while (true) {
			System.out.print("Enter email: ");
			email = s.nextLine();
			if (Validation.isValidEmail(email)) {
				break;
			} else {
				System.err.println("Enter again!");
			}
		}

		return new Employee(ssn, firstName, lastName, birthDate, phone, email);
	}

	@Override
	public void inputHE() {
		// TODO Auto-generated method stub
		Department dpm = inputD();
		Employee emp = inputE();
		double rate, workingHours;
		System.out.println("Enter hourly employee information: rate and working hours:");
		rate = Double.parseDouble(s.nextLine());
		workingHours = Double.parseDouble(s.nextLine());
		Employee he = new HourlyEmployee(emp.getSsn(), emp.getFirstName(), emp.getLastName(), emp.getBirthDate(),
				emp.getPhone(), emp.getEmail(), rate, workingHours);
		emps.add(he);
		dpm.getListOfEmployee().add(he);
		dpms.add(new Department(dpm.getDepartmentName(), dpm.getListOfEmployee()));

		System.out.println("Added successfully!");
	}

	@Override
	public void inputSE() {
		// TODO Auto-generated method stub
		Department dpm = inputD();
		Employee emp = inputE();
		double commissionRate, grossSales, basicSalary;
		System.out.println("Enter salaried employee information: commission rate, gross sales and basic salary:");
		commissionRate = Double.parseDouble(s.nextLine());
		grossSales = Double.parseDouble(s.nextLine());
		basicSalary = Double.parseDouble(s.nextLine());
		Employee se = new SalariedEmployee(emp.getSsn(), emp.getFirstName(), emp.getLastName(), emp.getBirthDate(),
				emp.getPhone(), emp.getEmail(), commissionRate, grossSales, basicSalary);
		emps.add(se);
		dpm.getListOfEmployee().add(se);
		dpms.add(new Department(dpm.getDepartmentName(), dpm.getListOfEmployee()));

		System.out.println("Added successfully!");
	}

	@Override
	public void displayD() {
		// TODO Auto-generated method stub
		Iterator<Department> i = dpms.iterator();
		while (i.hasNext())
			System.out.println(i.next().toString1());
	}

	@Override
	public void displayE() {
		// TODO Auto-generated method stub
		Iterator<Employee> i = emps.iterator();
		while (i.hasNext())
			System.out.println(i.next().toString());
	}

	@Override
	public void updateE(String ssn) {
		// TODO Auto-generated method stub
		int pos = isExist(ssn);
		if (pos == -1) {
			System.err.println("ssn not found!");
		} else {
			Employee emp = emps.get(pos);
			String firstName, lastName, birthDate, phone, email;
			System.out.println("Enter employee name: first name, last name:");
			firstName = s.nextLine();
			emp.setFirstName(firstName);
			lastName = s.nextLine();
			emp.setLastName(lastName);
			while (true) {
				System.out.print("Enter birthDate: ");
				birthDate = s.nextLine();
				if (Validation.isValidDate(birthDate)) {
					emp.setBirthDate(birthDate);
					break;
				} else {
					System.err.println("Enter again!");
				}

			}
			while (true) {
				System.out.print("Enter phone: ");
				phone = s.nextLine();
				if (Validation.isValidPhone(phone)) {
					emp.setPhone(phone);
					break;
				} else {
					System.err.println("Enter again!");
				}
			}
			while (true) {
				System.out.print("Enter email: ");
				email = s.nextLine();
				if (Validation.isValidEmail(email)) {
					emp.setEmail(email);
					break;
				} else {
					System.err.println("Enter again!");
				}
			}

			if (emp instanceof SalariedEmployee) {
				double commissionRate, grossSales, basicSalary;
				System.out
						.println("Enter salaried employee information: commission rate, gross sales and basic salary:");
				commissionRate = Double.parseDouble(s.nextLine());
				((SalariedEmployee) emp).setCommissionRate(commissionRate);
				grossSales = Double.parseDouble(s.nextLine());
				((SalariedEmployee) emp).setGrossSales(grossSales);
				basicSalary = Double.parseDouble(s.nextLine());
				((SalariedEmployee) emp).setBasicSalary(basicSalary);

				System.out.println("Updated successfully!");
			} else {
				double rate, workingHours;
				System.out.println("Enter hourly employee information: rate and working hours:");
				rate = Double.parseDouble(s.nextLine());
				((HourlyEmployee) emp).setRate(rate);
				workingHours = Double.parseDouble(s.nextLine());
				((HourlyEmployee) emp).setWorkingHours(workingHours);

				System.out.println("Updated successfully!");
			}

		}
	}

	@Override
	public void deleteE(String ssn) {
		// TODO Auto-generated method stub
		int pos = -1;
		boolean isExist = false;
		for (Department dpm : dpms) {
			for (int i = 0; i < dpm.getListOfEmployee().size(); i++) {
				if (dpm.getListOfEmployee().get(i).getSsn().equalsIgnoreCase(ssn))
					pos = i;
			}

			if (pos != -1) {
				dpm.getListOfEmployee().remove(pos);
				isExist = true;
				break;
			}
		}
		if(isExist == false) {
			System.err.println("ssn not found!");
		}
		System.out.println("Deleted successfully!");
	}

	@Override
	public void classify() {
		// TODO Auto-generated method stub
		List<Employee> se = new ArrayList<>();
		List<Employee> he = new ArrayList<>();
		for (Employee emp : emps) {
			if (emp instanceof SalariedEmployee) {
				se.add(emp);
			} else {
				he.add(emp);
			}
		}
		System.out.println("Salaried Employee: " + se);
		System.out.println("Hourly Employee: " + he);
	}

	@Override
	public void searchByDepartment(String departmentName) {
		// TODO Auto-generated method stub
		boolean isExist = false;
		for (Department dpm : dpms) {
			if (departmentName.equalsIgnoreCase(dpm.getDepartmentName())) {
				System.out.println(dpm.getListOfEmployee());
				isExist = true;
				break;
			}
		}
		if (isExist == false) {
			System.err.println("Department not found!");
		}
	}

	@Override
	public void searchByName(String lastName) {
		// TODO Auto-generated method stub
		boolean isExist = false;
		for (Employee emp : emps) {
			if (lastName.equalsIgnoreCase(emp.getLastName())) {
				System.out.println(emp.toString());
				isExist = true;
				break;
			}
		}
		if (isExist == false) {
			System.err.println("Department not found!");
		}
	}

	@Override
	public void report() {
		// TODO Auto-generated method stub
		Iterator<Department> i = dpms.iterator();
		while (i.hasNext())
			System.out.println(i.next().toString());
	}

}
