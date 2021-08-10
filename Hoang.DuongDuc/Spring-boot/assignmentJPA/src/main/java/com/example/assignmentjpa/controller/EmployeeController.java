package com.example.assignmentjpa.controller;

import com.example.assignmentjpa.entity.Employee;
import com.example.assignmentjpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public String addEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
        return "Success";
    }

    @GetMapping("/employees")
    public List<Employee> getListEmployee() {
        return employeeService.getListEmployee();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/employees/{id}")
    public String update(@PathVariable int id, @RequestBody Employee employee) {
        return employeeService.update(id, employee);
    }

    @DeleteMapping("/employees/{id}")
    public String delete(@PathVariable int id) {
        return employeeService.delete(id);
    }
}
