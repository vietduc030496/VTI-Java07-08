package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/new")
	public String addEmployee(ModelMap model) {
		model.addAttribute("employee", new EmployeeDto());
		return "employee/addEmployee";
	}
	@PostMapping()
	public String saveEmployee(ModelMap model,EmployeeDto employeeDto) {
		employeeService.saveOrUpdate(employeeDto);
		List<EmployeeDto> listEmployeeDto = employeeService.findAll();
		model.addAttribute("listemployee", listEmployeeDto);
		return "employee/listEmployee";
	}
	@GetMapping()
	public String getAll(ModelMap model) {
		List<EmployeeDto> listEmployeeDto = employeeService.findAll();
		model.addAttribute("listemployee", listEmployeeDto);
		return "employee/listEmployee";
	}
	
	@GetMapping("/{id}")
	public String getById(ModelMap model, @PathVariable("id") Long id) {
		EmployeeDto employeeDto =  employeeService.findOneById(id);
		model.addAttribute("employee", employeeDto);
		return "employee/getEmployee";
	}
	
	@PostMapping("/update/{id}")
	public String updateEmployee(ModelMap model,EmployeeDto employeeDto,@PathVariable("id") Long id ) {
		employeeDto.setId(id);
		employeeService.saveOrUpdate(employeeDto);
		
		List<EmployeeDto> listEmployeeDto = employeeService.findAll();
		model.addAttribute("listemployee", listEmployeeDto);
		return "employee/listEmployee";
	}
	@GetMapping("/delete/{id}")
	public String deleteById(ModelMap model,@PathVariable("id") Long id ) {
		employeeService.deleteById(id);
		List<EmployeeDto> listEmployeeDto = employeeService.findAll();
		model.addAttribute("listemployee", listEmployeeDto);
		return "employee/listEmployee";
	}
}
