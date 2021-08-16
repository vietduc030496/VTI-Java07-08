package com.vti.demo.services;

import java.util.List;

import com.vti.demo.entity.Department;

public interface DepartmentService {
	
	
	public List<Department> findAll();
	public Department findOneById(int id);
	
	public void update(Department department);
	public void save(Department department);
	
	public void deleteById(int id);

}
