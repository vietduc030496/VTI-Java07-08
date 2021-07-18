package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.*;

public class DeleteEmployee {
	static Scanner in = new Scanner(System.in);

	public static void delEmployee(ArrayList<Department> d) {
		System.out.println("Nhap ssn can xoa: ");
		String id = in.nextLine();
		for (Department de : d) {
			List<Employee> l = new ArrayList<>(de.getListOfEmployee());
			for (int i = 0; i < l.size(); i++) {
				if(l.get(i).getSsn().equals(id)) {
					l.remove(i);
					de.setListOfEmployee(l);
				}
			}
		}
	}
}
