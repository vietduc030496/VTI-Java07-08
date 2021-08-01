package service;

import java.util.List;

import entity.Department;

public class ReportService {
	public static void report(List<Department> d) {
		if (d.size() == 0) {
			System.out.println("There are no departments !!!");
		} else {
			System.out.println("Amout of deparment : " + d.size());
			for (Department de : d) {
				System.out.println("Department name : " + de.getDepartmentName());
				System.out.println("Amout of employee: " + de.getListOfEmployee().size());
			}
		}
	}
}
