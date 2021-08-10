package com.vti.demo.service;

import java.util.List;

import com.vti.demo.entity.Department;

public interface DepartmentService {

	public void save(Department department);

	public List<Department> getDepartment();

}
