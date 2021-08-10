package com.example.demo.service.implement;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

import com.example.demo.repository.*;

@Service
public class EmployeeServiceImplement implements EmployeeService{
	
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	@Transactional
	public void save(Employee employee) {
		empRepo.save(employee);
		
	}

	@Override
	@Transactional
	public List<Employee> getEmployee() {
		return empRepo.findAll();
	}

	@Override
	@Transactional
	public Employee getEmployeeById(int id) {
		Optional<Employee> empResponse =  empRepo.findById(id);
		Employee employee = empResponse.get();
		return employee;
	}

	@Override
	@Transactional
	public void deleteAllEmployee() {
		empRepo.deleteAll();		
	}

	@Override
	@Transactional
	public void update(int id, Employee employee) {
		Optional <Employee> empData = empRepo.findById(id);
		if(empData.isPresent()) {
			Employee emp = empData.get();
			emp.setFirstname(employee.getFirstname());
			emp.setLastname(employee.getLastname());
			emp.setEmail(employee.getEmail());
			emp.setPhone(employee.getPhone());
			empRepo.save(emp);
		}
		
	}

}
