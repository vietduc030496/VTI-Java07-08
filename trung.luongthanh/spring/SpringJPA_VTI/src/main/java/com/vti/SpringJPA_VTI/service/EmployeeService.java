package com.vti.SpringJPA_VTI.service;

import java.util.List;

import com.vti.SpringJPA_VTI.entity.Employee;

public interface EmployeeService {
	public void create(Employee employee);
	
	public List<Employee> getAll();
	
	public Employee getByID(int id);
	
	public void update(Employee employee);
	
	public void delete(int id);
}
