package com.vti.demo.service.implement;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.demo.entity.Department;
import com.vti.demo.repository.DepartmentRepository;
import com.vti.demo.service.DepartmentService;

@Service
public class DepartmentServiceImplement implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepo;

	@Override
	@Transactional
	public void save(Department department) {
		departmentRepo.save(department);
	}

	@Override
	@Transactional
	public List<Department> getDepartment() {
		return departmentRepo.findAll();
	}

}
