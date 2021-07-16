package service;

import java.util.ArrayList;

import entity.*;

public class DepartmentDisplay {
	public static void DeDisplay(ArrayList<Department> d) {
		if (d.size() == 0) {
			System.out.println("Khong co phong ban nao");
		} else {
			for (Department de : d) {
				System.out.println("Ten phong ban: "+de.getDepartmentName());
				System.out.println("So luong nhan vien: "+de.getListOfEmployee().size());
			}
		}
	}
}
