package com.vti.stringboottest.dto;

import com.vti.stringboottest.entity.Employee;

import lombok.Data;

@Data
public class EmployeeDTO {
	private Long  id;
	private String lastName;
	private String firstName;
	private String email;
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

	public Long  getId() {
		return id;
	}

	public void setId(Long  id) {
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
