package com.vti.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
