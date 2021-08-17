package com.example.assignmentjwt.repository;


import com.example.assignmentjwt.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
    Employee findByLogin(String login);
}
