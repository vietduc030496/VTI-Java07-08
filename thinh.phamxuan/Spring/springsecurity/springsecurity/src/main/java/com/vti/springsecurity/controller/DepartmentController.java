package com.vti.springsecurity.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.vti.springsecurity.entity.Department;
import com.vti.springsecurity.entity.Employee;
import com.vti.springsecurity.service.DepartmentService;

@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/add")
    public String addDepartment(@Valid Department department, BindingResult result, Model model) {
		departmentService.saveDepartment(department);
        return "addDepartment";
    }
	
	@GetMapping("/")
	public String index(Model model) {
	    List<Department> departments = departmentService.getAllDepartment();  
	    model.addAttribute("departments", departments);  
	    return "index";  
	}

}
