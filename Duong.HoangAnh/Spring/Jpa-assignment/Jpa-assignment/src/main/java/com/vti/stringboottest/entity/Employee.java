package com.vti.stringboottest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vti.stringboottest.dto.EmployeeDTO;

import lombok.Data;

@Data
@Entity
@Table(name = "Employee")
public class Employee {
	@Id
	@Column(name = "Employee_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Last_Name")
	private String lastName;

	@Column(name = "First_Name")
	private String firstName;

	@Column(name = "Email")
	private String email;

	@Column(name = "Phone")
	private String phone;

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
	
	public void loadFromDTO(EmployeeDTO empDTO) {
		this.id = empDTO.getId();
		this.firstName = empDTO.getFirstName();
		this.lastName = empDTO.getLastName();
		this.phone = empDTO.getPhone();
		this.email = empDTO.getEmail();
	}
}
