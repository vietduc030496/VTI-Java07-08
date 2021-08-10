package com.vti.spring1.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.vti.spring1.entity.Employee;

import lombok.Data;

@Data
public class EmployeeDto {
	private Long id;

	@Size(max = 100, message = "first name max 100 charecter")
	private String firstName;

	@Size(max = 100, message = "last name max 100 charecter")
	private String lastName;

	@Pattern(regexp = "^0[0-9]*", message = "the phone only number")
	@Size(max = 10,min = 10, message = "the phone has 10 charecter")
	private String phone;

	@Email
	private String email;

	public EmployeeDto() {

	}

	public EmployeeDto(Employee entity) {
		this.id = entity.getId();
		this.firstName = entity.getFirstName();
		this.lastName = entity.getLastName();
		this.phone = entity.getPhone();
		this.email = entity.getEmail();

	}

}
