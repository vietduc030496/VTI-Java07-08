package entity;

import java.util.List;

public class Department {
	private String departmentName;
	List<Employee> listOfEmployee;

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Employee> getListOfEmployee() {
		return listOfEmployee;
	}

	public void setListOfEmployee(List<Employee> listOfEmployee) {
		this.listOfEmployee = listOfEmployee;
	}

	public Department() {
		super();
	}

	public Department(String departmentName, List<Employee> listOfEmployee) {
		super();
		this.departmentName = departmentName;
		this.listOfEmployee = listOfEmployee;
	}

	public void display() {
		System.out.println(
				"departmentName: " + this.departmentName + ", number of employee: " + this.getListOfEmployee().size());
	}
}
