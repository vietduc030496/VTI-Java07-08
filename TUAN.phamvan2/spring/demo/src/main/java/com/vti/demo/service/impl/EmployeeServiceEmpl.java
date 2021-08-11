package com.vti.demo.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.demo.dto.EmployeeDto;
import com.vti.demo.entity.Employee;
import com.vti.demo.repository.EmployeeRepository;
import com.vti.demo.service.EmployeeService;

@Service
public class EmployeeServiceEmpl implements EmployeeService {

	@Autowired
    private EntityManager manager;
	
	@Autowired
	EmployeeRepository empRepo;

	@Override
	@Transactional
	public EmployeeDto saveOrUpdate(EmployeeDto dto, Long id) {
		// TODO Auto-generated method stub
		if (dto != null) {
			Employee entity = null;
			if (dto.getId() != null) {
				entity = empRepo.getOne(dto.getId());
				
				entity.setEmail(dto.getEmail());
				entity.setFirstName(dto.getFirstName());
				entity.setLastName(dto.getLastName());
				entity.setPhone(dto.getPhone());

				entity = empRepo.save(entity);
			}
			if (entity == null) {
				entity = new Employee();
				
				entity.setEmail(dto.getEmail());
				entity.setFirstName(dto.getFirstName());
				entity.setLastName(dto.getLastName());
				entity.setPhone(dto.getPhone());

				entity = empRepo.save(entity);
			}
			
			if (entity != null) {
				return new EmployeeDto(entity);
			} else {
				return null;
			}
		}
		return null;
	}

	@Override
	@Transactional
	public List<EmployeeDto> getAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT new com.vti.demo.dto.EmployeeDto(emp) from Employee emp WHERE 1 = 1";
		Query query = manager.createQuery(sql, EmployeeDto.class);
		
		List<EmployeeDto> result = query.getResultList();
		return result;
	}

	@Override
	@Transactional
	public EmployeeDto getById(Long id) {
		// TODO Auto-generated method stub
		if (id != null) {
			Employee entity = empRepo.getOne(id);
            if (entity != null) {
                return new EmployeeDto(entity);
            }
        }
        return null;
	}

	@Override
	@Transactional
	public Boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		if (id != null) {
			Employee entity = empRepo.getOne(id);
            if (entity != null) {
            	empRepo.deleteById(id);
                return true;
            }
        }
        return false;
	}

}
