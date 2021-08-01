package entity;

import java.util.ArrayList;
import java.util.List;

public class Department {
	private String departmentName;
	private List listOfEmployee;

	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(String departmentName) {
		super();
		this.departmentName = departmentName;
	}

	public Department(String departmentName, List listOfEmployee) {
		super();
		this.departmentName = departmentName;
		this.listOfEmployee = listOfEmployee;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List getListOfEmployee() {
		return listOfEmployee;
	}

	public void setListOfEmployee(List listOfEmployee) {
		this.listOfEmployee = listOfEmployee;
	}

	public void addSalariedEmployee(SalariedEmployee sE) {
		this.listOfEmployee.add(sE);
	}

	public void addHourlyEmployee(HourlyEmployee hE) {
		this.listOfEmployee.add(hE);
	}

	public void Display() {
		System.out.println("Department [departmentName=" + departmentName + ", listOfEmployee=" + listOfEmployee + "]\n");
	}
	
}
