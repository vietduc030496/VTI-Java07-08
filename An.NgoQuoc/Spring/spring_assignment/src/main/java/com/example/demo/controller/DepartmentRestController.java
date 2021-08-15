package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DepartmentDto;
import com.example.demo.service.DepartmentService;

@RestController
@RequestMapping("/api/department")
public class DepartmentRestController {
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping()
	public String createDepartment(@RequestBody @Valid DepartmentDto departmentDto) {
		departmentService.saveOrUpdate(departmentDto);
		return "success";
	}
	@GetMapping()
	public List<DepartmentDto> getAll() {
		return departmentService.findAll();
	}
	@GetMapping("/{id}")
	public DepartmentDto getById(@PathVariable("id") Long id) {
		return departmentService.findOneById(id);
	}
	@PutMapping("/{id}")
	public String updateEmployee(@RequestBody DepartmentDto departmentDto,@PathVariable("id") Long id ) {
		departmentDto.setId(id);
		departmentService.saveOrUpdate(departmentDto);
		return "success";
	}
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable("id") Long id ) {
		departmentService.deleteById(id);
		return "success";
	}
	
	@DeleteMapping()
	public String deleteEmployee(@RequestBody DepartmentDto departmentDto) {
		departmentService.delete(departmentDto);
		return "success";
	}
}
