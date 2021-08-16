package com.vti.SpringJPA_VTI.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vti.SpringJPA_VTI.entity.Employee;
import com.vti.SpringJPA_VTI.entity.Role;
import com.vti.SpringJPA_VTI.jwt.request.RegistrationRequest;
import com.vti.SpringJPA_VTI.repo.DepartmentRepository;
import com.vti.SpringJPA_VTI.repo.EmployeeRepository;
import com.vti.SpringJPA_VTI.repo.RoleRepository;
import com.vti.SpringJPA_VTI.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private DepartmentRepository departmentRepo;

	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

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
		employeeRepo.deleteById(id);
		;
	}

	@Override
	public Employee findByLogin(String login) {
		return employeeRepo.findByLogin(login);
	}

	@Override
	public void saveEncode(RegistrationRequest registrationRequest) {
		Employee employee = new Employee();
		employee.setLogin(registrationRequest.getLogin());
		employee.setPassword(registrationRequest.getPassword());

		Role employeeRole = roleRepo.findByName(registrationRequest.getRole());

		if (employeeRole == null) {
			Role role = new Role();
			role.setName(registrationRequest.getRole());

			roleRepo.save(role);
			employeeRole = roleRepo.findByName(registrationRequest.getRole());
		}
		
		employee.setDepartment(departmentRepo.findById(registrationRequest.getDepartmentId()).get());
		employee.setRole(employeeRole);
		employee.setPassword(passwordEncoder.encode(employee.getPassword()));
		
		employeeRepo.save(employee);
	}

	@Override
	public Employee findByLoginAndPassword(String login, String password) {
		Employee employee = findByLogin(login);
		if(employee != null) {
			if(passwordEncoder.matches(password, employee.getPassword())) {
				return employee;
			}
		}
		return null;
	}

}
