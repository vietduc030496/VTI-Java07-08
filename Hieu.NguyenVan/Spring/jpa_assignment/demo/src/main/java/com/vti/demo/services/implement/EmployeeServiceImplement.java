package com.vti.demo.services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.demo.entity.Employee;
import com.vti.demo.repository.EmployeeRepository;
import com.vti.demo.services.EmployeeService;

@Service
public class EmployeeServiceImplement implements EmployeeService {
	@Autowired
	private EmployeeRepository emRepo;

	@Override
	public void save(Employee employee) {
		emRepo.save(employee);

	}

	@Override
	public List<Employee> getAllEmplopyee() {
		return emRepo.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {

		return emRepo.getById(id);
	}

	@Override
	public void updateEmployee(Employee employee) {
		emRepo.save(employee);

	}

	@Override
	public void removeEmployee(int id) {
		// TODO Auto-generated method stub
		emRepo.deleteById(id);
		;
	}

}
