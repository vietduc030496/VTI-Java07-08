package com.vti.stringboottest.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.vti.stringboottest.entity.Employee;

import lombok.Data;

@Data
public class EmployeeDTO {
	private Long id;

	@NotBlank(message = "Name is mandatory")
	@Size(max = 50, message = "Last name must be between 0 and 50 characters")
	private String lastName;

	@Size(max = 50, message = "Last name must be between 0 and 50 characters")
	@NotBlank(message = "Name is mandatory")
	private String firstName;

	@Email
	@NotBlank(message = "Email is mandatory")
	private String email;

	@NotBlank(message = "Phone is mandatory")
	@Size(min = 0, max = 10, message = "Last name must be between 0 and 10 characters")
	private String phone;

	public EmployeeDTO() {

	}

	public void loadFromEntity(Employee entity) {
		this.id = entity.getId();
		this.firstName = entity.getFirstName();
		this.lastName = entity.getLastName();
		this.phone = entity.getPhone();
		this.email = entity.getEmail();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
