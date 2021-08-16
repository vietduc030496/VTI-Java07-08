package com.vti.jpa.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.vti.jpa.dto.EmployeeDTO;
import com.vti.jpa.entity.Employee;

@Component
public class EmployeeConverterUtil {
	
	
	private ModelMapper modelMapper;
	
	
	public Employee toEntity(EmployeeDTO employeeDTO) {
		modelMapper = new ModelMapper();
		Employee employee = modelMapper.map(employeeDTO, Employee.class);
		return employee;
	}

	
	public EmployeeDTO toDTO(Employee employee) {
		modelMapper = new ModelMapper();
		EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
		return employeeDTO;
	}
}
