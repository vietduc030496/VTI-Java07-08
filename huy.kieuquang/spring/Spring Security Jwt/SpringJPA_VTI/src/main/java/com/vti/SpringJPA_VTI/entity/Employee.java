package com.vti.SpringJPA_VTI.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

//	private String firstName;
//	private String lastName;
//	private String email;
//	private String phone;
	private String login;
	private String password;
	
	@ManyToOne(targetEntity = Department.class)
	@JoinColumn(name = "department_id")
	private Department department;
	
	@ManyToOne(targetEntity = Role.class)
	@JoinColumn(name = "role_id")
	private Role role;

}
