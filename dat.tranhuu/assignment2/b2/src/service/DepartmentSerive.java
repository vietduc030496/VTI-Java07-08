package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.Department;
import entity.Employee;

public class DepartmentSerive {

	private Scanner input;

	public DepartmentSerive(Scanner input) {
		super();
		this.input = input;
	}

	public void searchNameDepart(String nameDepart, List<Department> list) {
		boolean isEmpty = true;
		for (Department department : list) {
			if (department.getDepartmentName().contains(nameDepart)) {
				isEmpty = false;
				System.out.println("employee of departmentName: " + department.getDepartmentName());
				for (Employee e : department.getListOfEmployee()) {
					e.display();
				}
			}
		}
		if (isEmpty) {
			System.out.println("not found departmentName: " + nameDepart);
		}
	}

	public Department input(String departmentName2) {
		List<Employee> list = new ArrayList<>();
		return new Department(departmentName2, list);
	}

}
