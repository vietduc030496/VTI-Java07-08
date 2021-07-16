package service;

import java.util.ArrayList;
import java.util.List;

import entity.*;

public class EmployeeClassify {
	public static void EmpClassify(ArrayList<Department> de) {
		List<SalariedEmployee> Se = new ArrayList<>();
		List<HourlyEmployee> He = new ArrayList<>();
		for (Department d : de) {
			for (int i = 0; i < d.getListOfEmployee().size(); i++) {
				if (d.getListOfEmployee().get(i) instanceof SalariedEmployee) {
					Se.add((SalariedEmployee)d.getListOfEmployee().get(i));
				} else {
					He.add((HourlyEmployee)d.getListOfEmployee().get(i));
				}
			}
		}
		System.out.println("List of HourlyEmployee: ");
		for (HourlyEmployee h : He) {
			h.toString();
		}
		System.out.println("-----------------------");
		System.out.println("List of SalariedEmployee: ");
		for (SalariedEmployee s : Se) {
			s.toString();
		}
	}
}
