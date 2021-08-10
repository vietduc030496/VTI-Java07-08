package com.vti.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vti.demo.entity.Department;
import com.vti.demo.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/department")
	public String addDepartment(@RequestBody Department department) {
		departmentService.save(department);
		return "success";
	}

	@GetMapping("/department")
	public List<Department> getDepartment() {
		return departmentService.getDepartment();
	}
}
