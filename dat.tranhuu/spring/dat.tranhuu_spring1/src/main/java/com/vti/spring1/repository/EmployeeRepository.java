package com.vti.spring1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vti.spring1.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	@Query("select s from Employee s where id = ?1")
	Employee getById(Long id);
}
