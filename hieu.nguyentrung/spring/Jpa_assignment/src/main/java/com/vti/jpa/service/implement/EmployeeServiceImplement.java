package com.vti.jpa.service.implement;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.jpa.entity.Employee;
import com.vti.jpa.repository.EmployeeRepository;
import com.vti.jpa.service.EmployeeService;

@Service
public class EmployeeServiceImplement implements EmployeeService {
	
	
	@Autowired
	private EmployeeRepository employeeRepository;

	
	//add employee
	@Override
	@Transactional
	public void addEmp(Employee employee) {
		employeeRepository.save(employee);
		
	}

	
	//get all employee
	@Override
	@Transactional
	public List<Employee> getEmployee() {
		return employeeRepository.findAll();
	}
	
	
	//get employee by id
	@Override
	@Transactional
	public Employee getEmployeeByID(int employeeID) {
		Optional<Employee> empData = employeeRepository.findById(employeeID);
		return empData.get();
	}

	
	//update employee by id
	@Override
	@Transactional
	public void updateEmp(int employeeID, Employee employee) {
		Optional<Employee> empData = employeeRepository.findById(employeeID);
		if(empData.isPresent()) {
			Employee emp = empData.get();
			emp.setFirstName(employee.getFirstName());
			emp.setLastName(employee.getLastName());
			emp.setEmail(employee.getEmail());
			emp.setPhone(employee.getPhone());
			employeeRepository.save(emp);
		}
		
	}


	//delete all employee
	@Override
	public void deleteAllEmp() {
		employeeRepository.deleteAll();	
	}


	//delete employee by id
	@Override
	public void deleteEmpByID(int employeeID) {
		employeeRepository.deleteById(employeeID);
	}	
}
