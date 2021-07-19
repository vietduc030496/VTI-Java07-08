package vti.exercise1.entity;

import java.util.*;

public class Department {
	private String departmentName;
	private List<Employee> listOfEmployee = null;

	public Department(String department) {
		this.listOfEmployee = new ArrayList<Employee>();
		this.departmentName = department;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentname(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Employee> getListOfEmployee() {
		return this.listOfEmployee;
	}

	public void setListOfEmployee(List<Employee> listOfEmployee) {
		this.listOfEmployee = listOfEmployee;
	}
	
	public int getAmountEmployee() {
		return this.listOfEmployee == null ? 0: this.listOfEmployee.size();
	}

	public void display() {
		System.out.println(this.departmentName);
	}
}
