package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/signup")
	public String showSignUpForm(Employee employee) {
		return "addEmployee";
	}
	
	@PostMapping("/add")
    public String addUser(Employee employee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addEmployee";
        }
        
        employeeService.save(employee);
        return "redirect:/index";
    }
	
	@GetMapping("/index")
	public String showEmployeeList(Model model) {
	    model.addAttribute("emps", employeeService.getEmployee());
	    return "index";
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
	    Employee employee = employeeService.getEmployeeById(id);   
	    model.addAttribute("employee", employee);
	    return "updateEmployee";
	}
	
	@PostMapping("/update/{id}")
	public String updateEmployee(@PathVariable("id") int id, Employee employee, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        employee.setId(id);
	        return "updateEmployee";
	    }
	        
	    employeeService.save(employee);
	    return "redirect:/index";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
	    employeeService.deleteByID(id);
	    return "redirect:/index";
	}
	
}
