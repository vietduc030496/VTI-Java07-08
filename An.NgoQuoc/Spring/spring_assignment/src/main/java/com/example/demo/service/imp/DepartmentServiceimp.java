package com.example.demo.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DepartmentDto;
import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DepartmentService;
import com.example.demo.utils.DepartmentConverter;

@Service
public class DepartmentServiceimp implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private DepartmentConverter departmentConverter;
	@Override
	public void saveOrUpdate(DepartmentDto departmentDto) {
		if(departmentDto.getId() != null) {
			//tìm theo id xem có ko, ko có trả về NoSuchElementException
			 findOneById(departmentDto.getId());
		}
		Department department = departmentConverter.toEntity(departmentDto);
		departmentRepository.save(department);
	}

	@Override
	public List<DepartmentDto> findAll() {
		List<DepartmentDto> listDTO = new ArrayList<>();
		List<Department> listDepartment = departmentRepository.findAll();
		for (Department department : listDepartment) {
			DepartmentDto departmentDto = departmentConverter.toDTO(department);
			listDTO.add(departmentDto);
		}			
		return listDTO;
	}

	@Override
	public DepartmentDto findOneById(Long id) {
		DepartmentDto departmentDto = departmentConverter.toDTO(departmentRepository.findById(id).get());
		return departmentDto;
	}

	@Override
	public void deleteById(Long id) {
		departmentRepository.deleteById(id);
	}

	@Override
	public void delete(DepartmentDto departmentDto) {
		departmentRepository.delete(departmentConverter.toEntity(departmentDto));
		
	}
}
