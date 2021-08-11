package com.vti.demo.dto;

import com.vti.demo.entity.Employee;
import javax.validation.constraints.Pattern;

public class EmployeeDto {
	private Long id;

	private String firstName, lastName;
	
	@Pattern(regexp = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$", message = "Wrong email format")
	private String email;
	
	@Pattern(regexp = "(84|0[3|5|7|8|9])+([0-9]{8})\\b", message = "Wrong phone format")
	private String phone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeDto(Employee entity) {
		if (entity != null) {
			this.id = entity.getId();
			this.firstName = entity.getFirstName();
			this.lastName = entity.getLastName();
			this.email = entity.getEmail();
			this.phone = entity.getPhone();
		}
	}

}
