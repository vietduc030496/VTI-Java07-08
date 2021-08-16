package com.example.demo.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class DepartmentDto {
	
	private Long id;
	
	@NotBlank
	private String name;
}
