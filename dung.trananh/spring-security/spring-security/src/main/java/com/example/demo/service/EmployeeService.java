package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Role;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.request.RegistrationRequest;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Employee saveEmployee(RegistrationRequest registrationRequest) {
		Employee employee = new Employee();
		employee.setPassword(registrationRequest.getPassword());
		employee.setUsername(registrationRequest.getUsername());

		Role employeeRole = roleRepo.findByName(registrationRequest.getRolename());
		if (employeeRole == null) {
			Role role = new Role();
			role.setRole_name(registrationRequest.getRolename());
			roleRepo.save(role);
			employeeRole = roleRepo.findByName(registrationRequest.getRolename());
		}

		employee.setRole(employeeRole);
		employee.setPassword(passwordEncoder.encode(employee.getPassword()));
		return empRepo.save(employee);
	}
	
	public Employee findByUserName(String username) {
		return empRepo.findByUserName(username);
	}
	
	public Employee findByUserNameAndPassword(String username, String password) {
		Employee employee = findByUserName(username);
		if (employee != null) {
			if (passwordEncoder.matches(password, employee.getPassword())) {
				return employee;
			}
		}
		return null;
	}
}
