package com.vti.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.jpa.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
