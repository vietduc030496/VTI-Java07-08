package com.vti.springsecurity.service.implement;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vti.springsecurity.entity.Role;
import com.vti.springsecurity.entity.Employee;
import com.vti.springsecurity.repository.RoleRepository;
import com.vti.springsecurity.repository.EmployeeRepository;
import com.vti.springsecurity.request.RegistrationRequest;
import com.vti.springsecurity.service.EmployeeService;
@Service
public class EmployeeServiceImplement  implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;


	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployee() {
		return (List<Employee>) employeeRepository.findAll();
	}
	
	@Override
	@Transactional
	public Optional<Employee> findEmployeeById(int id) {
		return employeeRepository.findById(id);
	}



	@Override
	@Transactional
	public void deleteEmployee(int id){
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
		
	}
	@Override
	@Transactional
	public Employee saveEmployee(RegistrationRequest registrationRequest) {
		Employee employee = new Employee();
		employee.setPassword(registrationRequest.getPassword());
		employee.setUsername(registrationRequest.getUsername());
		Role roleEmployee = roleRepository.findByName(registrationRequest.getRole());
		if (roleEmployee == null) {
			Role role = new Role();
			role.setName(registrationRequest.getRole());
			roleRepository.save(role);
			roleEmployee = roleRepository.findByName(registrationRequest.getRole());
		}

		employee.setRole(roleEmployee);
		employee.setPassword(passwordEncoder.encode(employee.getPassword()));
		return employeeRepository.save(employee);
	}
	@Override
	@Transactional
	public Employee findByLoginAndPassword(String userName, String password) {
		Employee employee = findByUserName(userName);
		if (employee != null) {
			if (passwordEncoder.matches(password, employee.getPassword())) {
				return employee;
			}
		}
		return null;
	}
	@Override
	@Transactional
	public Employee findByUserName(String userName) {
		// TODO Auto-generated method stub
		return employeeRepository.findByUserName(userName);
	}
}
