package com.example.demo.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;

@Component
public class EmployeeConverter {
	private ModelMapper modelMapper;
	public Employee toEntity(EmployeeDto employeeDto) {
		modelMapper = new ModelMapper();
		Employee employee = modelMapper.map(employeeDto, Employee.class);
		Department department = new Department();
		department.setId(employeeDto.getDepartment_id());
		department.setName(employeeDto.getDepartment_name());
		employee.setDepartment(department);
		return employee;
	}
	public EmployeeDto toDTO(Employee employee) {
		modelMapper = new ModelMapper();
		EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
		employeeDto.setDepartment_id(employee.getDepartment().getId());
		employeeDto.setDepartment_name(employee.getDepartment().getName());
		return employeeDto;
	}
}
