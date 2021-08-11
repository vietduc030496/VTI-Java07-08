package com.vti.SpringJPA_VTI.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.SpringJPA_VTI.entity.Employee;
import com.vti.SpringJPA_VTI.repo.EmployeeRepository;
import com.vti.SpringJPA_VTI.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Override
	public void create(Employee employee) {
		employeeRepo.save(employee);
	}

	@Override
	public List<Employee> getAll() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee getByID(int id) {
		return employeeRepo.findById(id).get();
	}

	@Override
	public void update(Employee employee) {
		employeeRepo.save(employee);
	}

	@Override
	public void delete(int id) {
		employeeRepo.deleteById(id);;
	}

}
