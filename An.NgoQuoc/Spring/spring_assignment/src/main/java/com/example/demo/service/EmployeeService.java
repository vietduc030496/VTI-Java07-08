package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;

public interface EmployeeService {
	public void saveOrUpdate(EmployeeDto employeeDto);
	
	public List<EmployeeDto> findAll();
	
	public EmployeeDto findOneById(Long id);
	
	public void deleteById(Long id);
	
	public void delete(EmployeeDto employeeDto);
	
	public Employee findByUsername(String name);
	
	public Employee findByLoginAndPassword(String username, String password);
}
