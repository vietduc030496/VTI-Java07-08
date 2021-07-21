package com.vti.trainning.compare;

import java.util.Comparator;

import com.vti.trainning.entity.Employee;

public class EmployeeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getFullName().compareTo(o2.getFullName());
	}

}
