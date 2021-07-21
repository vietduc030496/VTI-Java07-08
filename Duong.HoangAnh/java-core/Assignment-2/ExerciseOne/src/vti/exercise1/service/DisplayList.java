package vti.exercise1.service;

import java.util.List;

import vti.exercise1.entity.Employee;
import vti.exercise1.entity.HourlyEmployee;
import vti.exercise1.entity.SalariedEmployee;

public class DisplayList {
	public void displayEmployee(List<Employee> list) {
		int index = 0;
		if (list.isEmpty()) {
			System.out.println("Danh sach nhan vien trong!");
		} else {
			System.out.println("********** LIST EMPLOYEE **********");
			for (Employee e : list) {
				System.out.print("Stt: " + ++index + " | ");
				if (e instanceof SalariedEmployee) {
					System.out.println("*Nhan vien chinh thuc*");
				} else if (e instanceof HourlyEmployee) {
					System.out.println("*Nhan vien lam theo gio*");
				}
				e.display();
			}
			System.out.println("**********************************");
		}
	}

	public void displayHourlyEmployee(List<Employee> list) {
		int index = 0;
		if (list.isEmpty()) {
			System.out.println("Danh sach nhan vien trong!");
		} else {
			System.out.println("******* LIST HOURLY EMPLOYEE *******");
			for (Employee e : list) {
				if (e instanceof HourlyEmployee) {
					System.out.println("Stt: " + ++index + " | ");
					e.display();
				}
			}
			System.out.println("**********************************");
		}
	}

	public void displaySalariedEmployee(List<Employee> list) {
		int index = 0;
		if (list.isEmpty()) {
			System.out.println("Danh sach nhan vien trong!");
		} else {
			System.out.println("******* LIST SALARIED EMPLOYEE *******");
			for (Employee e : list) {
				if (e instanceof SalariedEmployee) {
					System.out.println("Stt: " + ++index + " | ");
					e.display();
				}
			}
			System.out.println("**********************************");
		}
	}
}
