package com.vti.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.demo.entity.Employee;
import com.vti.demo.services.EmployeeService;

@RestController
@RequestMapping(path = "/api", produces = "application/json")
@CrossOrigin(origins = "*")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employee")
	public List<Employee> getAllEmployee() {

		return employeeService.getAllEmplopyee();
	}
	
	@GetMapping("/employee/{id}")
	public Employee getAllEmployee(@PathVariable("id") int id) {

		return  employeeService.getEmployeeById(id);
	}
	
	@PostMapping("/employee")
	public String addEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		return "add success";
		
	}
	@PutMapping("/employee")
	public String updateEmployee(@RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
		return "saved employee";
	}
	
	@DeleteMapping("/employee/{id}")
	public String deleteEmployee (@PathVariable int id) {
		employeeService.removeEmployee(id);
		
		return "remove success";
	}

}
