package com.vti.spring1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.vti.spring1.dto.EmployeeDto;
import com.vti.spring1.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;

	@GetMapping(value = "/")
	public String getHomePage() {
		return "home";
	}

	
	@GetMapping(value = "/employee")
	public String list(Model model) {
		List<EmployeeDto> list = service.findAll();
		model.addAttribute("list", list);
		return "employee/list";
	}
	
	
	@GetMapping(value = "/employee/add")
	public String add(Model model) {
		EmployeeDto dto = new EmployeeDto();
		model.addAttribute("object", dto);
		return "employee/add";
	}
	
	@PostMapping(value = "/employee/add")
	public String addP(@ModelAttribute EmployeeDto e) {
		service.saveOrUpdate(e);
		return "redirect:/employee";
	}
	
	@GetMapping(value = "/employee/edit/{id}")
	public String edit(Model model, @PathVariable("id") Long id) {
		EmployeeDto dto = service.findById(id).getObject();
		model.addAttribute("object", dto);
		return "employee/add";
	}
	
	@PostMapping(value = "/employee/edit/{id}")
	public String editP(@ModelAttribute EmployeeDto e) {
		service.saveOrUpdate(e);
		return "redirect:/employee";
	}
	@GetMapping(value = "/employee/delete/{id}")
	public String delete( @PathVariable("id") Long id) {
		service.delete(id);
		return "redirect:/employee";
	}
}
