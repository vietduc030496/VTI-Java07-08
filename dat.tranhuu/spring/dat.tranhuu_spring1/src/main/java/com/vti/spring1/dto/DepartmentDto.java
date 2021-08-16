package com.vti.spring1.dto;

import java.util.List;

import lombok.Data;

@Data
public class DepartmentDto extends BaseDto<String>{
	
	
	private String name;
	private List<EmployeeDto> listEmployee;
}
