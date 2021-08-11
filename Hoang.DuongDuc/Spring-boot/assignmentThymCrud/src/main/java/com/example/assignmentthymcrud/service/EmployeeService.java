package com.example.assignmentthymcrud.service;

import com.example.assignmentthymcrud.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    void saveEmployee(Employee employee);

    void deleteEmployee(Integer id);

    Optional<Employee> findEmployeeById(Integer id);

}
