package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entity.*;

public class EmployeeClassify {
	public static void EmpClassify(ArrayList<Department> de) {
		List<SalariedEmployee> Se = new ArrayList<>();
		List<HourlyEmployee> He = new ArrayList<>();
		for (Department d : de) {
			for (int i = 0; i < d.getListOfEmployee().size(); i++) {
				if (d.getListOfEmployee().get(i) instanceof SalariedEmployee) {
					Se.add((SalariedEmployee) d.getListOfEmployee().get(i));
				} else {
					He.add((HourlyEmployee) d.getListOfEmployee().get(i));
				}
			}
		}
		Collections.sort(Se, new Comparator<SalariedEmployee>() {

			@Override
			public int compare(SalariedEmployee o1, SalariedEmployee o2) {				
				return o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
			}
			
		});
		Collections.sort(He, new Comparator<HourlyEmployee>() {

			@Override
			public int compare(HourlyEmployee o1,HourlyEmployee o2) {				
				return o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
			}
			
		});
		
		System.out.println("List of HourlyEmployee: ");
		for (HourlyEmployee h : He) {
			System.out.println(h.toString());
		}
		System.out.println("-----------------------");
		System.out.println("List of SalariedEmployee: ");
		for (SalariedEmployee s : Se) {
			System.out.println(s.toString());
		}
	}
}
