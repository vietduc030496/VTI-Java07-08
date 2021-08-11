package com.vti.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vti.demo.dto.EmployeeDto;

@Service
public interface EmployeeService {
	
	EmployeeDto saveOrUpdate(EmployeeDto dto, Long id);

	List<EmployeeDto> getAll();

	EmployeeDto getById(Long id);

	Boolean deleteById(Long id);
	
}
