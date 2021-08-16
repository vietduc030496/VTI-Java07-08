package com.vti.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.RequestParam;  

import com.vti.spring.entity.Employee;
import com.vti.spring.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	  @RequestMapping("/")  
	  public String index(Model model) {  
	    List<Employee> employees = employeeService.getAllEmployee();  

	    model.addAttribute("employees", employees);  

	    return "index";  
	  }  

	  @RequestMapping(value = "add")  
	  public String addEmployee(Model model) {  
	    model.addAttribute("employee", new Employee());  
	    return "addEmployee";  
	  }  

	  @RequestMapping(value = "/edit", method = RequestMethod.GET)  
	  public String editEmployee(@RequestParam("id") int employeeId, Model model) {  
	    Optional<Employee> employeeEdit = employeeService.findEmployeeById(employeeId);  
	    employeeEdit.ifPresent(employee -> model.addAttribute("employee", employee));  
	    return "editEmployee";  
	  }  

	  @RequestMapping(value = "save", method = RequestMethod.POST)  
	  public String save(Employee employee) {  
	    employeeService.saveEmployee(employee);  
	    return "redirect:/";  
	  }  

	  @RequestMapping(value = "/delete", method = RequestMethod.GET)  
	  public String deleteEmployee(@RequestParam("id") int employeeId, Model model) {  
	    employeeService.deleteEmployee(employeeId);  
	    return "redirect:/";  
	  }  
}
