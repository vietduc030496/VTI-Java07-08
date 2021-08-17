package com.vti.stringboottest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vti.stringboottest.dto.EmployeeDTO;
import com.vti.stringboottest.service.EmployeeService;

@Controller
public class HomeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	public String home(Model model) {
		List<EmployeeDTO> listEmployee = employeeService.getListEmployee();

		model.addAttribute("listEmployee", listEmployee);
		return "home";
	}

	@GetMapping("/createEmployee")
	public String createEmployee(Model model) {
		return "createEmployee";
	}
	
	@GetMapping("/editEmployee/{id}")
	public String editEmployee(@PathVariable("id") Long employeeID, Model model) {
		EmployeeDTO empDTO = employeeService.getById(employeeID);  
	    model.addAttribute("empDTO", empDTO); 
		return "editEmployee";
	}
}
