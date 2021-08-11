package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.*;

public interface EmployeeService {
	public void save(Employee employee);
	
	public List<Employee> getEmployee();
	
	public Employee getEmployeeById(int id);
	
	public void deleteAllEmployee();
	
	public void update(int id,Employee employee);
}
