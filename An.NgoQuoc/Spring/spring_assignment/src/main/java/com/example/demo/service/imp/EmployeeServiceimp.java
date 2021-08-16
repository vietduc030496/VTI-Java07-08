package com.example.demo.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DepartmentDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Role;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.EmployeeService;
import com.example.demo.utils.EmployeeConverter;

@Service
public class EmployeeServiceimp implements EmployeeService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private EmployeeConverter employeeConverter;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void saveOrUpdate(EmployeeDto employeeDto) {
		if(employeeDto.getId() != null) {
			//tìm theo id xem có ko, ko có trả về NoSuchElementException
			findOneById(employeeDto.getId());
		}
		//tìm theo id xem có ko, ko có trả về NoSuchElementException
		DepartmentDto departmentDto = departmentService.findOneById(employeeDto.getDepartment_id());
		Role role = roleRepository.findByName(employeeDto.getRole_name());
		if(role == null) {
			Role newRole = new Role();
			newRole.setName(employeeDto.getRole_name());
			roleRepository.save(newRole);
			//lấy lại role vừa lưu mới
			role = roleRepository.findByName(employeeDto.getRole_name());
		}
				
		employeeDto.setDepartment_name(departmentDto.getName());
		
		Employee employee = employeeConverter.toEntity(employeeDto);
		employee.setPassword(passwordEncoder.encode(employee.getPassword()));
		employee.setRole(role);
		employeeRepo.save(employee);
		
	}	

	@Override
	public List<EmployeeDto> findAll() {
		List<EmployeeDto> listDTO = new ArrayList<>();
		List<Employee> listEmployee = employeeRepo.findAll();
		for (Employee employee : listEmployee) {
			EmployeeDto employeeDto = employeeConverter.toDTO(employee);
			listDTO.add(employeeDto);
		}
				
		return listDTO;
	}

	@Override
	public EmployeeDto findOneById(Long id) {
		EmployeeDto employeeDto = employeeConverter.toDTO(employeeRepo.findById(id).get());
		return employeeDto;
	}


	@Override
	public void deleteById(Long id) {
		employeeRepo.deleteById(id);
		
	}

	@Override
	public void delete(EmployeeDto employeeDto) {
		Employee employee = employeeConverter.toEntity(employeeDto);
		employeeRepo.delete(employee);		
	}

	@Override
	public Employee findByUsername(String name) {
		return employeeRepo.findByUsername(name);
	}
	
	public Employee findByLoginAndPassword(String username, String password) {
		Employee employee = findByUsername(username);
		if (employee != null) {
			if (passwordEncoder.matches(password, employee.getPassword())) {
				return employee;
			}
		}
		return null;
	}

}
