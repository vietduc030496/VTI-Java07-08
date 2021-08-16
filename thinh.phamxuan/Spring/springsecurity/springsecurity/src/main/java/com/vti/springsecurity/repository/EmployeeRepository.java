package com.vti.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; 
import com.vti.springsecurity.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	Employee findByUserName(String userName);
}
