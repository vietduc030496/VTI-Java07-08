package com.vti.stringboottest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.stringboottest.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
