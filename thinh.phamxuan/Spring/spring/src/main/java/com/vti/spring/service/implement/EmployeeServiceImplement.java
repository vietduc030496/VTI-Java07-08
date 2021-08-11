package com.vti.spring.service.implement;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.spring.entity.Employee;
import com.vti.spring.repository.EmployeeRepository;
import com.vti.spring.service.EmployeeService;

@Service
public class EmployeeServiceImplement implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	@Transactional
	public void save(Employee employee) {
		employeeRepo.save(employee);
	}

	@Override
	@Transactional
	public List<Employee> getEmployee() {
		return employeeRepo.findAll();
	}
	
	@Override
	public Optional<Employee> getEmployeeById(int id) {
		return employeeRepo.findById(id);
	}

	@Override
	public void update(int id,Employee employee) {
		employee.setId(id);
		employeeRepo.save(employee);

	}

	@Override
	public void deleteEmployeeById(int id){
		// TODO Auto-generated method stub
		employeeRepo.deleteById(id);
		
	}

	
}
