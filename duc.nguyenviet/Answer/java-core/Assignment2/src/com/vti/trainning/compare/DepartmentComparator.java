package com.vti.trainning.compare;

import java.util.Comparator;

import com.vti.trainning.entity.Department;

public class DepartmentComparator implements Comparator<Department> {

	@Override
	public int compare(Department o1, Department o2) {
		return o1.getDepartmentName().compareTo(o2.getDepartmentName());
	}

}
