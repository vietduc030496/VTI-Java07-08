package com.vti.spring.service;

import java.util.List;
import java.util.Optional;

import com.vti.spring.entity.Employee;

public interface EmployeeService {
	public void save(Employee employee);
	public void update(int id,Employee employee);
	public List<Employee> getEmployee();
	public Optional<Employee> getEmployeeById(int id);
	public void deleteEmployeeById(int id);
	

}
