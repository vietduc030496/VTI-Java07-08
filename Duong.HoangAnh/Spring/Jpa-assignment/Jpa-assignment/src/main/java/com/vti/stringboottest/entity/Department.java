package com.vti.stringboottest.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Department")
public class Department {
	@Id
	@Column(name = "Department_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Name")
	private String name;

	@OneToMany(targetEntity = Employee.class, mappedBy = "id", orphanRemoval = false, fetch = FetchType.LAZY)
	private Set<Employee> employees;

	public Long getDepartmentId() {
		return id;
	}

	public void setDepartmentId(Long departmentId) {
		this.id = departmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
