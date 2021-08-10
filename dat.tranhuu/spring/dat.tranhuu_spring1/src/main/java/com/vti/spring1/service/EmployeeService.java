package com.vti.spring1.service;

import java.util.List;

import com.vti.spring1.dto.EmployeeDto;
import com.vti.spring1.dto.ResponseDto;

public interface EmployeeService {

	List<EmployeeDto> findAll();
	
	ResponseDto<EmployeeDto> findById(Long id);
	
	EmployeeDto saveOrUpdate(EmployeeDto dto);
	
	ResponseDto<EmployeeDto> delete(Long id);
}
