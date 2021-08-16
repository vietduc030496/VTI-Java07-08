package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.DepartmentDto;

public interface DepartmentService {
	public void saveOrUpdate(DepartmentDto departmentDto);
	
	public List<DepartmentDto> findAll();
	
	public DepartmentDto findOneById(Long id);
	
	public void deleteById(Long id);
	
	public void delete(DepartmentDto departmentDto);
}
