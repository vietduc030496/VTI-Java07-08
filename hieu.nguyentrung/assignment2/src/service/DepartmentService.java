package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.Department;
import entity.Employee;
import constant.*;

public class DepartmentService {
	Scanner scanner = new Scanner(System.in);
	public String depName;

	public Department DepartmentInput() {
		System.out.println("Enter department: ");
//		String depName;
		while (true) {
			depName = scanner.nextLine();
			if (Check.isValidDepartment(depName)) {
//				System.out.println("Succeccfull !!");
				break;
			} else {
				System.out.println("Invalid format, please re-fill !!");
				System.out.println("Correct format example : D1(D+number 1 to 9)");
			}
		}
		List<Employee> list = new ArrayList<>();
		Department dep = new Department(depName, list);
		return dep;
	}

	public void DisplayDepartment(List<Department> dep) {
		if (dep.size() == 0) {
			System.out.println("Department doesn't exist !!");
		} else {
			for (Department d : dep) {
				System.out.println("Name of department : " + d.getDepartmentName());
				System.out.println("Amount of employees : " + d.getListOfEmployee().size());
			}
		}
	}

	public int Exist(List<Department> dep, String DepartmentName) {
		for (int i = 0; i < dep.size(); i++) {
			if (dep.get(i).getDepartmentName().equalsIgnoreCase(DepartmentName))
				return i;
		}
		return -1;
	}

	public void DeleteDepartment(List<Department> dep, String DepartmentName) {
		int position = Exist(dep, DepartmentName);
		if (position == -1) {
			System.out.println("Delete operation failed. Please try again!");
		} else {
			dep.remove(position);
			System.out.println("Successful delete!");
		}
	}

	public void UpdateDepartment(List<Department> dep, String DepartmentName) {
		int position = Exist(dep, DepartmentName);
		if (position == -1) {
			System.out.println("Doesn't exist!");
		} else {
			Department de = dep.get(position);
			System.out.print("Enter new department :");
			DepartmentName = scanner.nextLine();
			de.setDepartmentName(DepartmentName);
			System.out.println("Successful update!");
		}
	}

}
