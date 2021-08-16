package com.vti.springsecurity.service;
import java.util.List;

import com.vti.springsecurity.entity.Department;
import com.vti.springsecurity.entity.Employee;
public interface DepartmentService {
	public void saveDepartment(Department department);
	public List<Department> getAllDepartment();
}
