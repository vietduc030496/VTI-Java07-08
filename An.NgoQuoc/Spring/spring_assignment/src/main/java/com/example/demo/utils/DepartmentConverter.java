package com.example.demo.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.demo.dto.DepartmentDto;
import com.example.demo.entity.Department;

@Component
public class DepartmentConverter {
	private ModelMapper modelMapper;
	public Department toEntity(DepartmentDto departmentDto) {
		modelMapper = new ModelMapper();
		Department department  = modelMapper.map(departmentDto, Department.class);
		return department;
	}
	public DepartmentDto toDTO(Department department) {
		modelMapper = new ModelMapper();
		DepartmentDto departmentDto = modelMapper.map(department, DepartmentDto.class);
		return departmentDto;
	}
}
