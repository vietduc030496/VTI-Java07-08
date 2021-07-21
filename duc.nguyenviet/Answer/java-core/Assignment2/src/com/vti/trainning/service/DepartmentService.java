package com.vti.trainning.service;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.vti.trainning.compare.DepartmentComparator;
import com.vti.trainning.compare.EmployeeComparator;
import com.vti.trainning.constant.EmployeeConstant;
import com.vti.trainning.entity.Department;
import com.vti.trainning.entity.Employee;
import com.vti.trainning.entity.HourlyEmployee;
import com.vti.trainning.entity.SalariedEmployee;

public class DepartmentService {

	private EmployeeService employeeService;
	private List<Department> listDepartment;
	private Scanner scan;

	public DepartmentService() {
		employeeService = new EmployeeService();
		listDepartment = new ArrayList<>();
		listDepartment.add(new Department("Division 1", new ArrayList<>()));

		scan = new Scanner(System.in);
	}

	public void addDepartment() {
		System.out.println("---Hay nhap thong tin phong ban moi---");
		System.out.println("Ten phong ban: ");

		String departmentName = scan.nextLine();
		List<Employee> listEmployee = new ArrayList<>();
		Department department = new Department(departmentName, listEmployee);

		listDepartment.add(department);
		System.out.println("Them bo phan thanh cong");
	}

	public void getListDepartment() {
		if (listDepartment.isEmpty()) {
			System.out.println("Khong co bo phan nao, hay them bo phan moi");
		}

		Collections.sort(listDepartment, new DepartmentComparator());
		for (Department department : listDepartment) {
			department.display();
		}
	}

	public void addEmpByDept() {
		System.out.println("Moi nhap phong ban can them nhan vien");
		int index = 0;
		for (Department department : listDepartment) {
			System.out.println(index + 1 + ": " + department.getDepartmentName());
		}
		int deptChoice = scan.nextInt();
		if (deptChoice > listDepartment.size()) {
			System.out.println("Khong có bo phan nay, hay nhap lai");
			deptChoice = scan.nextInt();
		}

		System.out.println("Chon loai nhan vien");
		System.out.println("1: HourlyEmployee");
		System.out.println("2: SalariedEmployee");
		int empType = scan.nextInt();

		System.out.println("Nhap so nhan vien muon them");
		int quantity = scan.nextInt();

		Department department = listDepartment.get(deptChoice - 1);
		List<Employee> lstNewEmployee = employeeService.createEmployee(empType, quantity);
		department.getListOfEmployee().addAll(lstNewEmployee);

		System.out.println("Them thanh cong");
	}

	public void showInfoEmployeeByDept() {
		System.out.println("Moi nhap phong ban can xem thong tin nhan vien");
		int index = 0;
		for (Department department : listDepartment) {
			System.out.println(index + 1 + ": " + department.getDepartmentName());
		}
		int deptChoice = scan.nextInt();
		if (deptChoice > listDepartment.size()) {
			System.out.println("Khong có bo phan nay, hay nhap lai");
			deptChoice = scan.nextInt();
		}

		System.out.println("Chon loai nhan vien");
		System.out.println("1: HourlyEmployee");
		System.out.println("2: SalariedEmployee");
		System.out.println("3: Tat ca");
		int empType = scan.nextInt();

		Department department = listDepartment.get(deptChoice - 1);

		List<Employee> lstEmp = new ArrayList<>();
		if (empType == EmployeeConstant.HOURLY_EMP_TYPE) {
			lstEmp = department.getListOfEmployee().stream().filter(e -> (e instanceof HourlyEmployee))
					.collect(Collectors.toList());
		} else if (empType == EmployeeConstant.SALARY_EMP_TYPE) {
			lstEmp = department.getListOfEmployee().stream().filter(e -> (e instanceof SalariedEmployee))
					.collect(Collectors.toList());
		} else {
			lstEmp = department.getListOfEmployee();
		}

		Collections.sort(lstEmp, new EmployeeComparator());
		for (Employee employee : lstEmp) {
			System.out.println(employee);
		}
	}

	public void searchEmployeeByName() {
		System.out.println("Nhap ten nhan vien muon tim kiem thông tin");
		String name = scan.nextLine();

		List<Employee> result = new ArrayList<>();
		for (Department department : listDepartment) {
			result = department.getListOfEmployee().stream().filter(e -> e.getFullName().contains(name))
					.collect(Collectors.toList());
		}

		if (result.size() == 0) {
			System.out.println("Khong tim thay nhan vien nao");
			return;
		}

		Collections.sort(result, new EmployeeComparator());
		for (Employee employee : result) {
			System.out.println(employee);
		}
	}

	public void exportCsv() throws IOException {
		System.out.println("Moi nhap phong ban can xuat file thong tin nhan vien");
		int index = 0;
		for (Department department : listDepartment) {
			System.out.println(index + 1 + ": " + department.getDepartmentName());
		}
		int deptChoice = scan.nextInt();
		if (deptChoice > listDepartment.size()) {
			System.out.println("Khong có bo phan nay, hay nhap lai");
			deptChoice = scan.nextInt();
		}

		Department department = listDepartment.get(deptChoice - 1);
		StringBuilder sb = new StringBuilder();
		for (Employee emp : department.getListOfEmployee()) {
			sb.append(emp.getFullName());
			sb.append('-');
			sb.append(emp.getBirthDate());
			sb.append("\n");
		}

		LocalDateTime dateTime = LocalDateTime.now();
		String time = dateTime.format(DateTimeFormatter.ofPattern("mmhhddMMyyyy"));
		String fileName = "Thong tin nhan vien" + "-" + department.getDepartmentName() + "-" + time + ".txt";

		FileWriter writer = new FileWriter(fileName);
		writer.write(sb.toString());
		writer.close();
	}

}
