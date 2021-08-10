package com.vti.SpringJPA_VTI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vti.SpringJPA_VTI.entity.Employee;
import com.vti.SpringJPA_VTI.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/create")
	public String createEmployee(@RequestBody Employee employee) {
		employeeService.create(employee);
		return "create sucess";
	}
	
	@GetMapping("/getAll")
	public List<Employee> getAll(){
		return employeeService.getAll();
	}
	
	@GetMapping("/get/{id}")
	public Employee getByID(@PathVariable("id") int id) {
		return employeeService.getByID(id);
	}
	
	@PostMapping("/update")
	public String updateEmployee(@RequestBody Employee employee) {
		employeeService.update(employee);
		return "update sucess";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		employeeService.delete(id);
		return "deleted";
	}
}
