package com.example.assignmentjpa.service;

import com.example.assignmentjpa.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    public void save(Employee employee);

    public List<Employee> getListEmployee();

    public Employee getEmployeeById(int id);

    public String update(int id, Employee employee);

    public String delete(int id);
}
