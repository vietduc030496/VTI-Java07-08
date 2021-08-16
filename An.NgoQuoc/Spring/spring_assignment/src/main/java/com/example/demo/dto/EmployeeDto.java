package com.example.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


import lombok.Data;

@Data
public class EmployeeDto {

	private Long id;
	
	@NotBlank()
	private String fristName;
	
	@NotBlank
	private String lastName;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	@Pattern(regexp = "([0-9]{7,15})\\b")
	private String phone;
	
	@NotNull
	private Long department_id;
	
	private String department_name;
	
	@NotNull
	private String role_name;
	
	@NotNull
	private String username;
	
	@NotNull
	private String password;

}
