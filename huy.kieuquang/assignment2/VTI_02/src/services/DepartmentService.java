package services;

import java.util.ArrayList;
import java.util.List;

import entity.Department;
import entity.Employee;
import entity.HourlyEmployee;
import entity.SalariedEmployee;

public class DepartmentService {
	public void classify(List<Department> listDp) {
		for (Department dp : listDp) {
			System.out.println(dp.getDepartmentName());
			for (Employee e : dp.getListOfEmployee()) {
				System.out.println("Employee: "+e.getLastName()+" "+e.getClass().getName());
			}
		}
	}
	
	public void report(List<Department> listDp) {
		for (Department dp : listDp) {
			System.out.println(dp.getDepartmentName()+" "+dp.getListOfEmployee().size());
		}
	}
}
