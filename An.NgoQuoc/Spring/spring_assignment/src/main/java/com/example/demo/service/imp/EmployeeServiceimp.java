package com.example.demo.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import com.example.demo.utils.EmployeeConverter;

@Service
public class EmployeeServiceimp implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private EmployeeConverter employeeConverter;

	@Override
	public void saveOrUpdate(EmployeeDto employeeDto) {
		Employee employee = employeeConverter.toEntity(employeeDto);
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

}
