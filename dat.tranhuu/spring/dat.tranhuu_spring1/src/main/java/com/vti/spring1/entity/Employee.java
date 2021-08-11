package com.vti.spring1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = true, length = 100)
	private String firstName;

	@Column(nullable = true, length = 100)
	private String lastName;

	@Column(nullable = true, length = 10)
	private String phone;

	@Column(nullable = true, length = 100)
	private String email;
}
