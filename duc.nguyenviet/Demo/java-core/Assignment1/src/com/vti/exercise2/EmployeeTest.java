package com.vti.exercise2;

public class EmployeeTest {

	public static void main(String[] args) {
		Employee firstEmp = new Employee("viet", "duc", 1_000_000);
		Employee secordEmp = new Employee("ngoc", "anh", 2_000_000);

		System.out.println(firstEmp.getSalary() + "VND");
		System.out.println(secordEmp.getSalary() + "VND");

		System.out.println("------------------------");
		System.out.println("Sau khi tang 10% luong");
		firstEmp.setSalary(firstEmp.getSalary() * 1.1);
		secordEmp.setSalary(secordEmp.getSalary() * 1.1);

		System.out.println(firstEmp.getSalary() + "VND");
		System.out.println(secordEmp.getSalary() + "VND");
	}

}
