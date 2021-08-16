package com.vti.demo.services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.demo.entity.Department;
import com.vti.demo.repository.DepartmentRepository;
import com.vti.demo.services.DepartmentService;
@Service
public class DepartmentServiceImplement implements DepartmentService {

	@Autowired
	private DepartmentRepository deRepo;
	
	@Override
	public List<Department> findAll() {
		
		return deRepo.findAll();
	}

	@Override
	public Department findOneById(int id) {
		
		return deRepo.getById(id);
	}

	@Override
	public void update(Department department) {
		deRepo.save(department);
		
		
	}

	@Override
	public void save(Department department) {
		deRepo.save(department);
		
	}

	@Override
	public void deleteById(int id) {
		deRepo.deleteById(id);
		
	}

}
