package com.vti.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


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
	@Column(name = "Employee_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeID;
	
	
	@Column(name = "First_Name")
	private String firstName;
	
	
	@Column(name = "Last_Name")
	private String lastName;
	
	
	@Column(name = "Email")
	private String email;
	
	
	@Column(name = "Phone")
	private String phone;
	

}
