package com.vti.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vti.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query("select emp from Employee emp where id = ?1")
	Employee getById(Long id);

}
