package com.vti.spring1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table
@Entity
public class Employee extends BaseEntity<String>{


	@Column(nullable = true, length = 100)
	private String firstName;

	@Column(nullable = true, length = 100)
	private String lastName;

	@Column(nullable = true, length = 10)
	private String phone;

	@Column(nullable = true, length = 100)
	private String email;
	
	@ManyToOne(targetEntity = Department.class)
	@JoinColumn(name="department_id")
	private Department department;
}
