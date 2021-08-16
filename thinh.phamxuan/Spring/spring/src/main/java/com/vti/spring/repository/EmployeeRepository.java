package com.vti.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository; 
import com.vti.spring.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
