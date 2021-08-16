package com.vti.SpringJPA_VTI.service;

import java.util.List;

import com.vti.SpringJPA_VTI.entity.Employee;
import com.vti.SpringJPA_VTI.jwt.request.RegistrationRequest;

public interface EmployeeService {
	public void create(Employee employee);
	
	public List<Employee> getAll();
	
	public Employee getByID(int id);
	
	public void update(Employee employee);
	
	public void delete(int id);
	
	public Employee findByLogin(String login);
	
	public void saveEncode(RegistrationRequest registrationRequest);
	
	public Employee findByLoginAndPassword(String login, String password);
}
