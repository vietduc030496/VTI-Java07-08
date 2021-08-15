package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping()
	public String createEmployee(@RequestBody @Valid EmployeeDto employeeDto) {
		employeeService.saveOrUpdate(employeeDto);
		return "success";
	}
	
	@GetMapping()
	public List<EmployeeDto> getAll() {
		return employeeService.findAll();
	}
	
	@GetMapping("/{id}")
	public EmployeeDto getById(@PathVariable("id") Long id) {
		return employeeService.findOneById(id);
	}
	
	@PutMapping("/{id}")
	public String updateEmployee(@RequestBody @Valid EmployeeDto employeeDto,@PathVariable("id") Long id ) {
		employeeDto.setId(id);
		employeeService.saveOrUpdate(employeeDto);
		return "success";
	}
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable("id") Long id ) {
		employeeService.deleteById(id);
		return "success";
	}
	
	@DeleteMapping()
	public String deleteEmployee(@RequestBody EmployeeDto employeeDto) {
		employeeService.delete(employeeDto);
		return "success";
	}
}
