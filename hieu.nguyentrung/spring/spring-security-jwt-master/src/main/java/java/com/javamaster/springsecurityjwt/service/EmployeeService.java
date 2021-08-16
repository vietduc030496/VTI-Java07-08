package java.com.javamaster.springsecurityjwt.service;

import java.com.javamaster.springsecurityjwt.entity.DepartmentEntity;
import java.com.javamaster.springsecurityjwt.entity.EmployeeEntity;
import java.com.javamaster.springsecurityjwt.repository.DepartmentEntityRepository;
import java.com.javamaster.springsecurityjwt.repository.EmployeeEntityRepository;
import java.com.javamaster.springsecurityjwt.request.RegistrationRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeEntityRepository employeeEntityRepository;
	
	
	@Autowired
	private DepartmentEntityRepository departmentEntityRepository;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public EmployeeEntity saveEmployee(RegistrationRequest registrationRequest) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setPassword(registrationRequest.getPassword());
		employeeEntity.setLogin(registrationRequest.getLogin());

		DepartmentEntity employeeDepartment = departmentEntityRepository.findByName(registrationRequest.getDepartmentName());
		if (employeeDepartment == null) {
			DepartmentEntity dept = new DepartmentEntity();
			dept.setDepartmentName(registrationRequest.getDepartmentName());
			departmentEntityRepository.save(dept);
			employeeDepartment = departmentEntityRepository.findByName(registrationRequest.getDepartmentName());
		}

		employeeEntity.setDepartmentEntity(employeeDepartment);
		employeeEntity.setPassword(passwordEncoder.encode(employeeEntity.getPassword()));
		return employeeEntityRepository.save(employeeEntity);
	}

	public EmployeeEntity findByLogin(String login) {
		return employeeEntityRepository.findByLogin(login);
	}

	public EmployeeEntity findByLoginAndPassword(String login, String password) {
		EmployeeEntity employeeEntity = findByLogin(login);
		if (employeeEntity != null) {
			if (passwordEncoder.matches(password, employeeEntity.getPassword())) {
				return employeeEntity;
			}
		}
		return null;
	}
}
