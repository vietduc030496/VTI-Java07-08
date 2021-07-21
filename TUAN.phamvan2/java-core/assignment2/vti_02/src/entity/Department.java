package entity;

import java.util.List;

public class Department {
	private String departmentName;
	private List<Employee> listOfEmployee;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(String departmentName, List<Employee> listOfEmployee) {
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

	public List<Employee> getListOfEmployee() {
		return listOfEmployee;
	}

	public void setListOfEmployee(List<Employee> listOfEmployee) {
		this.listOfEmployee = listOfEmployee;
	}
	
	public String toString1() {
		return "Department [Department name: " + departmentName + ", Number of employees: " + listOfEmployee.size() + "]";
	}


	@Override
	public String toString() {
		return "Department [Department name: " + departmentName + ", List of employee: " + listOfEmployee + "]";
	}

}
