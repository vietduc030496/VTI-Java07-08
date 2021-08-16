package com.example.assignmentjwt.repository;


import com.example.assignmentjwt.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    Employee findByLogin(String login);
}
