package com.vti.springsecurity.service;


import java.util.List;
import java.util.Optional;

import com.vti.springsecurity.entity.Employee;
import com.vti.springsecurity.request.RegistrationRequest;
public interface EmployeeService {
	public void saveEmployee(Employee employee);
	public List<Employee> getAllEmployee();
	public Optional<Employee> findEmployeeById(int id);
	public void deleteEmployee(int id);
	public Employee saveEmployee(RegistrationRequest registrationRequest);
	public Employee findByLoginAndPassword(String userName, String password);
	public Employee findByUserName(String userName);
}