package com.vti.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.demo.entity.Department;
import com.vti.demo.services.DepartmentService;

@RestController
@RequestMapping(path="/api/department" , produces = "aplication/json" )
@CrossOrigin("*")
public class DepartmentRestController {
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping()
	public String createDepartment(@RequestBody @Valid Department department) {
		departmentService.update(department);
		return "Add success";
	}
	@GetMapping()
	public List<Department> getAll() {
		return departmentService.findAll();
	}
	@GetMapping("/{id}")
	public Department getById(@PathVariable("id") int id) {
		return departmentService.findOneById(id);
	}
	@PutMapping("/{id}")
	public String updateEmployee(@RequestBody @Valid Department department,@PathVariable("id") int id ) {
		department.setId(id);
		departmentService.update(department);
		return "success";
	}
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable("id") int id ) {
		departmentService.deleteById(id);
		return "success";
	}
}
