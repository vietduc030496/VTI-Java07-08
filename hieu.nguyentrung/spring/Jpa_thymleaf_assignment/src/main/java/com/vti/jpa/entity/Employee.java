package com.vti.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Employee")
public class Employee {

	
	@Id
	@Column(name = "employeeid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeID;
	
	
	@Column(name = "firstName")
	@NotBlank
	private String firstName;
	
	
	@Column(name = "lastName")
	@NotBlank
	private String lastName;
	
	
	@Column(name = "email")
	@Email
	private String email;
	
	
	@Column(name = "phone")
	@NotBlank
	private String phone;
	

}
