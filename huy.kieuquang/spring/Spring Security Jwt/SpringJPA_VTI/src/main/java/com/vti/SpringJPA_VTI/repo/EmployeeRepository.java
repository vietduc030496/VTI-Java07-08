package com.vti.SpringJPA_VTI.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.SpringJPA_VTI.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	Employee findByLogin(String login);
}
