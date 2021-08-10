package com.vti.demo.services;

import java.util.List;

import com.vti.demo.entity.Employee;


public interface EmployeeService {
	public void save(Employee employee);
	public List<Employee> getAllEmplopyee();
	public Employee getEmployeeById(int id);
	public void updateEmployee(Employee employee);
	public void removeEmployee(int id);
}
