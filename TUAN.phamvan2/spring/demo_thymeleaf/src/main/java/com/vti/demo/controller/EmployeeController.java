package com.vti.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vti.demo.dto.EmployeeDto;
import com.vti.demo.service.EmployeeService;

@Controller
@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	@PostMapping("/add")
	public String add(Model model) {
		EmployeeDto dto = new EmployeeDto();
		model.addAttribute("object", dto);
		return "employee/addEmployee";
	}
	
	@PutMapping("/update")
	public String update(Model model, @PathVariable("id") Long id) {
		EmployeeDto dto = service.findById(id).getObject();
		model.addAttribute("object", dto);
		return "employee/addEmployee";
	}
	
	@GetMapping("/getAll")
	public String getAll(Model model) {
		List<EmployeeDto> employees = empService.getAll();
		model.addAttribute("employees", employees);
		return "employee/employee";
	}

	@GetMapping("/delete/{id}")
	public String delete( @PathVariable("id") Long id) {
		service.delete(id);
		return "redirect:/employee";
	}
}
