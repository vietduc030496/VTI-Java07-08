package com.vti.springsecurity.service.implement;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.springsecurity.entity.Department;
import com.vti.springsecurity.repository.DepartmentRepository;
import com.vti.springsecurity.service.DepartmentService;

@Service
public class DepartmentServiceImplement implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepo;
	
	@Override
	@Transactional
	public void saveDepartment(Department department) {
		// TODO Auto-generated method stub
		departmentRepo.save(department);
	}

	@Override
	@Transactional
	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		return (List<Department>) departmentRepo.findAll();
	}

}
