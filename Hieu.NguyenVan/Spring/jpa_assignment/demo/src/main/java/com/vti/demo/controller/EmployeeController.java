package com.vti.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vti.demo.entity.Employee;
import com.vti.demo.services.EmployeeService;

@Controller
@RequestMapping("/view")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService; 
	
	@GetMapping("employee")
	public String getAllEmployee(Model model) {
		List<Employee> listEmployee = employeeService.getAllEmplopyee();
		model.addAttribute("listEmployee",listEmployee);
		return "ViewEmployee";
	}
	@GetMapping("employee/{id}")
	public String getAllEmployee(Model model,@PathVariable int id) {
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee",employee);
		return "FormCreateEmployee";
	}
	@GetMapping("/employee/create")
	public String createEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee",employee);
		return "FormCreateEmployee"; 
	}
	
	@PostMapping("/employee/save")
	public String createEmployee (Employee employee) {
		employeeService.save(employee);
		return "redirect:/view/employee";
	}
	
	@GetMapping("/employee/delete/{id}")
	public String deleteEmployee(@PathVariable int id ) {
		employeeService.removeEmployee(id);
		return "redirect:/view/employee";
	}
	
	
}
