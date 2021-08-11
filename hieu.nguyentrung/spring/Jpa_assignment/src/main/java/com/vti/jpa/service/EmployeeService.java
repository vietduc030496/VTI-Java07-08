package com.vti.jpa.service;

import java.util.List;

import com.vti.jpa.entity.Employee;

public interface EmployeeService {
	
	
	public void addEmp(Employee employee);
		
	
	public void updateEmp(int employeeID, Employee employee);
	
	
	public List<Employee> getEmployee();
	
	
	public Employee getEmployeeByID(int employeeID);
	
	
	public void deleteAllEmp();
	
	
	public void deleteEmpByID(int employeeID);


}
