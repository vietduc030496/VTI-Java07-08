package com.vti.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.spring.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
