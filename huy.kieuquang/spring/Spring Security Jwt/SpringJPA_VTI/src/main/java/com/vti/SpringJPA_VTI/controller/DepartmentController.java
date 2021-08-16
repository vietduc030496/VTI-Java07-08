package com.vti.SpringJPA_VTI.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vti.SpringJPA_VTI.dto.DepartmentRequest;
import com.vti.SpringJPA_VTI.entity.Department;
import com.vti.SpringJPA_VTI.service.DepartmentService;

@RestController
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/department")
	public String create(@RequestBody @Valid DepartmentRequest deptRequest) {
		Department dept = new Department();
		dept.setName(deptRequest.getName());
		departmentService.save(dept);
		return "create success";
	}
	
	@GetMapping("/department")
	public List<Department> getAll(){
		return departmentService.getAllDepartment();
	}
}
