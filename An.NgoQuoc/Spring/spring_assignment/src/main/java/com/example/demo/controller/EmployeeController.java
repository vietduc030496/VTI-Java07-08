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

import com.example.demo.dto.EmployeeDto;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employee")
	public String createEmployee(@RequestBody EmployeeDto employeeDto) {
		employeeService.saveOrUpdate(employeeDto);
		return "success";
	}
	
	@GetMapping("/employee")
	public List<EmployeeDto> getAll() {
		return employeeService.findAll();
	}
	
	@GetMapping("/employee/{id}")
	public EmployeeDto getById(@PathVariable("id") Long id) {
		return employeeService.findOneById(id);
	}
	
	@PutMapping("/employee/{id}")
	public String updateEmployee(@RequestBody EmployeeDto employeeDto,@PathVariable("id") Long id ) {
		employeeDto.setId(id);
		employeeService.saveOrUpdate(employeeDto);
		return "success";
	}
	
	@DeleteMapping("/employee/{id}")
	public String deleteById(@PathVariable("id") Long id ) {
		employeeService.deleteById(id);
		return "success";
	}
	
	@DeleteMapping("/employee")
	public String deleteEmployee(@RequestBody EmployeeDto employeeDto) {
		employeeService.delete(employeeDto);
		return "success";
	}
}
