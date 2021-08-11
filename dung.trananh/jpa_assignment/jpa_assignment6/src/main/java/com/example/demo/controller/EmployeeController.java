package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.EmployeeService;
import com.example.demo.entity.*;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployee(){
		return employeeService.getEmployee();
	}
	
	@GetMapping("/employee/{id}")
	public Employee getEmployeeByID(@PathVariable("id") Integer id){
		return employeeService.getEmployeeById(id);
	}
	
	@PostMapping("/employee")
	public String addEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		return "success";
	}
	
	@DeleteMapping("/employee")
	public String deleteAllEmp() {
		employeeService.deleteAllEmployee();
		return "success";
	}
	
	@PutMapping("/employee/{id}")
	public String updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {
		employeeService.update(id, employee);
		return "success";
	}
	
}
