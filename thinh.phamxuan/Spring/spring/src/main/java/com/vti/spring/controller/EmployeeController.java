package com.vti.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vti.spring.entity.Employee;
import com.vti.spring.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employee")
	public String addEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		return "add success";
	}

	@GetMapping("/employee")
	public List<Employee> getEmployee() {
		return employeeService.getEmployee();
	}
	
	@GetMapping("/employee/{id}")
	public Optional getEmployeeById(@PathVariable("id") Integer id){
		return employeeService.getEmployeeById(id);
	}
	
	@DeleteMapping("/employee/{id}")
	public String deleteEmployeeByID(@PathVariable("id") Integer id) {
		employeeService.deleteEmployeeById(id);
		return "delete success";
	}
	
	@PutMapping("/employee/{id}")
	public String updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {
		employeeService.update(id, employee);
		return "update success";
	}
}
