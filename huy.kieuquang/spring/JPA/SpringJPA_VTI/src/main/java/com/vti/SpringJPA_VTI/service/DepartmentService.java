package com.vti.SpringJPA_VTI.service;

import java.util.List;

import com.vti.SpringJPA_VTI.entity.Department;

public interface DepartmentService {
	public void save(Department department);
	
	public List<Department> getAllDepartment();

}
