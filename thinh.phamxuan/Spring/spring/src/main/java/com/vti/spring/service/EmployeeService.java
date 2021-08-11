package com.vti.spring.service;

import java.util.List;
import java.util.Optional;

import com.vti.spring.entity.Employee;

public interface EmployeeService {
	public void saveEmployee(Employee employee);
	public List<Employee> getAllEmployee();
	public Optional<Employee> findEmployeeById(int id);
	public void deleteEmployee(int id);
	

}
