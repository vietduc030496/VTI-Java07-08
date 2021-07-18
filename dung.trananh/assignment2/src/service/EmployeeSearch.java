package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.*;
public class EmployeeSearch {
	static Scanner in = new Scanner(System.in);
	
	public static void EmpSearch(ArrayList<Department> d) {
		int choice = 10;
		while (choice != 0) {
			System.out.println("Select type of search: ");
			System.out.println("-----------------------");
			System.out.println("1. Search by dept name:  ");
			System.out.println("2. Search by emp name:  ");
			System.out.println("0. Exit");
			choice = Integer.parseInt(in.nextLine());
			switch (choice) {
			case 1:
				searchDept(d);
				break;
			case 2:
				searchEmp(d);
				break;
			case 0:
				break;

			}
		}
	}
	
	public static void searchDept(ArrayList<Department> d) {
		System.out.println("Nhap ten department: ");
		String dept = in.nextLine();
		for (Department de : d) {
			if(de.getDepartmentName().equalsIgnoreCase(dept)) {
				System.out.println(de.getListOfEmployee());
			}
		}
		
	}
	public static void searchEmp(ArrayList<Department> d) {
		System.out.println("Nhap firstname employee: ");
		String emp = in.nextLine();
		for (Department de: d) {
			List<Employee> l = new ArrayList<>(de.getListOfEmployee());
			for (int i=0;i<l.size();i++) {
				if(l.get(i).getFirstName().equalsIgnoreCase(emp)) {
					System.out.println("Thong tin nhan vien do la: ");
					l.get(i).toString();
				}
			}
		}
	}

}
