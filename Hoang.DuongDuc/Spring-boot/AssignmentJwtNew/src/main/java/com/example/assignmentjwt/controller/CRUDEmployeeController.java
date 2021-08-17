package com.example.assignmentjwt.controller;

import com.example.assignmentjwt.entity.Employee;
import com.example.assignmentjwt.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
@RestController
public class CRUDEmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Employee> getListEmployee() {
        return employeeService.getListEmployee();
    }

    @GetMapping("/employees/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Employee getEmployeeById(@PathVariable("id") int id) {
        return employeeService.getEmployeeById(id);
    }

    // chi get dc username
    @GetMapping("/employees/me")
    @PreAuthorize("hasAnyRole('USER, ADMIN')")
    public String getMyInfo( Principal principal){
//        if (principal instanceof Employee) return (Employee) principal;
        return principal.getName();
//        return  null;
    }


    //admin duoc update
    @PutMapping("/employees/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String update(@PathVariable int id, @RequestBody Employee employee) {
        return employeeService.update(id, employee);
    }

    @DeleteMapping("/employees/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String delete(@PathVariable int id) {
        return employeeService.delete(id);
    }
}
