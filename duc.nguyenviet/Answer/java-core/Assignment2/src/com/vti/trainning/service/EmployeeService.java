package com.vti.trainning.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.trainning.constant.EmployeeConstant;
import com.vti.trainning.entity.Employee;
import com.vti.trainning.entity.HourlyEmployee;
import com.vti.trainning.entity.SalariedEmployee;
import com.vti.trainning.utils.DateUtils;
import com.vti.trainning.utils.RegexUtils;

public class EmployeeService {

	private Scanner scan = new Scanner(System.in);

	public List<Employee> createEmployee(int type, int quantity) {
		List<Employee> lstEmployees = new ArrayList<>();
		Employee emp;
		for (int i = 0; i < quantity; i++) {
			emp = inputData(type);
			lstEmployees.add(emp);
		}

		return lstEmployees;
	}

	private Employee inputData(int type) {
		System.out.println("Hay nhap thong tin cho nhan vien");
		System.out.println("--------------------------------");
		System.out.println("Nhap ten dem");
		String firstName = scan.nextLine();

		System.out.println("Nhap ten");
		String lastName = scan.nextLine();

		System.out.println("Nhap ngay sinh");
		String birthDay = scan.nextLine();
		while (!DateUtils.checkValidDate(birthDay)) {
			System.out.println("Nhap sai, hay nhap theo format ngay/thang/nam");
			birthDay = scan.nextLine();
		}

		System.out.println("Nhap so dien thoai");
		String phone = scan.nextLine();
		while (!RegexUtils.checkValidPhone(phone)) {
			System.out.println("Nhap sai, hay nhap lai theo format 10 chu so");
			phone = scan.nextLine();
		}

		System.out.println("Nhap email");
		String email = scan.nextLine();
		while (!RegexUtils.checkValidEmail(email)) {
			System.out.println("Nhap sai hay nhap lai");
			email = scan.nextLine();
		}

		if (type == EmployeeConstant.HOURLY_EMP_TYPE) {
			System.out.println("Nhap tien cong");
			double wage = scan.nextDouble();

			System.out.println("Nhap so gio lam viec");
			double workingHour = scan.nextDouble();

			HourlyEmployee emp = new HourlyEmployee();
			emp.setFirstName(firstName);
			emp.setLastName(lastName);
			emp.setBirthDate(birthDay);
			emp.setPhone(phone);
			emp.setEmail(email);
			emp.setWage(wage);
			emp.setWorkingHours(workingHour);

			return emp;
		} else {
			System.out.println("Nhap ti le hoa hong");
			double commissionRate = scan.nextDouble();

			System.out.println("Nhap tong doanh thu");
			double grossSales = scan.nextDouble();

			System.out.println("Nhap luong co ban");
			double basicSalary = scan.nextDouble();

			SalariedEmployee emp = new SalariedEmployee();
			emp.setFirstName(firstName);
			emp.setLastName(lastName);
			emp.setBirthDate(birthDay);
			emp.setPhone(phone);
			emp.setEmail(email);
			emp.setCommissionRate(commissionRate);
			emp.setGrossSales(grossSales);
			emp.setBasicSalary(basicSalary);

			return emp;
		}
	}

}
