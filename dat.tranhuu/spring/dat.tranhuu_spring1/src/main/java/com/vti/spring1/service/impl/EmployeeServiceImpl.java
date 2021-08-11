package com.vti.spring1.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.spring1.dto.EmployeeDto;
import com.vti.spring1.dto.ResponseDto;
import com.vti.spring1.entity.Employee;
import com.vti.spring1.repository.EmployeeRepository;
import com.vti.spring1.service.EmployeeService;
import com.vti.spring1.types.YESNO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EntityManager manager;

	@Autowired
	private EmployeeRepository employeeRepository;

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeDto> findAll() {
		String SQL = " SELECT new com.vti.spring1.dto.EmployeeDto(s) from Employee s WHERE 1=1 ";
		Query q = manager.createQuery(SQL, EmployeeDto.class);

		List<EmployeeDto> result = q.getResultList();
		return result;
	}

	@Override
	@Transactional
	public ResponseDto<EmployeeDto> findById(Long id) throws EntityNotFoundException {
		ResponseDto<EmployeeDto> res = new ResponseDto<EmployeeDto>();
		Employee entity = employeeRepository.getById(id);

		if (entity != null) {
			res.setStatus(YESNO.YES);
			res.setObject(new EmployeeDto(entity));
			res.setMessage("ok");
		} else {
			res.setStatus(YESNO.NO);
			res.setMessage("not found");
		}
		return res;
	}

	@SuppressWarnings("deprecation")
	@Override
	public EmployeeDto saveOrUpdate(EmployeeDto dto) {
		if (dto != null) {
			Employee entity = null;
			if (dto.getId() != null) {
				entity = employeeRepository.getOne(dto.getId());
			}
			if (entity == null) {
				entity = new Employee();
			}
			entity.setEmail(dto.getEmail());
			entity.setFirstName(dto.getFirstName());
			entity.setLastName(dto.getLastName());
			entity.setPhone(dto.getPhone());

			entity = employeeRepository.save(entity);
			if (entity != null) {
				return new EmployeeDto(entity);
			} else {
				return null;
			}
		}
		return null;
	}

	@Override
	public ResponseDto<EmployeeDto> delete(Long id) {
		ResponseDto<EmployeeDto> res = new ResponseDto<EmployeeDto>();
		Employee entity = employeeRepository.getById(id);
		if (entity != null) {
			employeeRepository.delete(entity);
			res.setStatus(YESNO.YES);
			res.setObject(new EmployeeDto(entity));
			res.setMessage("delete success");
		} else {
			res.setStatus(YESNO.NO);
			res.setMessage("not found");
		}
		return res;

	}

}
