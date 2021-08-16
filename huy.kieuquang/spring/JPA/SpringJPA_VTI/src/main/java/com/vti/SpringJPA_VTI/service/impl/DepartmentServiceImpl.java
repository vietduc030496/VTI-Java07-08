package com.vti.SpringJPA_VTI.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.SpringJPA_VTI.entity.Department;
import com.vti.SpringJPA_VTI.repo.DepartmentRepository;
import com.vti.SpringJPA_VTI.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	private DepartmentRepository departmentRepo;

	@Override
	public void save(Department department) {
		departmentRepo.save(department);
	}

	@Override
	public List<Department> getAllDepartment() {
		return departmentRepo.findAll();
	}

}
