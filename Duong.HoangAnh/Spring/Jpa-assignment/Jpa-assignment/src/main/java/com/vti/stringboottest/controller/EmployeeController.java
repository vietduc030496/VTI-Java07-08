package com.vti.stringboottest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vti.stringboottest.dto.EmployeeDTO;
import com.vti.stringboottest.service.EmployeeService;

@Controller
@RequestMapping("/api/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping()
	public List<EmployeeDTO> getListEmployee() {
		return employeeService.getListEmployee();
	}
	
	@PostMapping("/save")  
	  public String save(EmployeeDTO empDTO) {  
		employeeService.save(empDTO);  
	    return "redirect:/";  
	  }  
	
	@GetMapping("/{id}")
	public EmployeeDTO getById(@PathVariable("id") Long id) {
		return employeeService.getById(id);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteById(@PathVariable("id") Long id, Model model) {
		employeeService.deleteByID(id);
		return "redirect:/";
	}
	
	@DeleteMapping()
	public String deleteAll() {
		employeeService.deleteAll();
		return "success";
	}
}
