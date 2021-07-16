package service;

import java.util.ArrayList;

import entity.Department;

public class Report {
	public static void report(ArrayList<Department> d) {
		if (d.size() == 0) {
			System.out.println("Khong co phong ban nao");
		} else {
			System.out.println("So luong phong ban" + d.size());
			for (Department de : d) {
				System.out.println("Ten phong ban: " + de.getDepartmentName());
				System.out.println("So luong nhan vien: " + de.getListOfEmployee().size());
			}
		}
	}

}
