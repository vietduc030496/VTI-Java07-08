package com.vti.stringboottest.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.stringboottest.dto.EmployeeDTO;
import com.vti.stringboottest.entity.Employee;
import com.vti.stringboottest.repository.EmployeeRepository;
import com.vti.stringboottest.service.EmployeeService;

@Service
public class EmployeeServiceImplement implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public void save(EmployeeDTO empDTO) {
		Employee emp = new Employee();
		emp.loadFromDTO(empDTO);
		employeeRepo.save(emp);
	}

	@Override
	public List<EmployeeDTO> getListEmployee() {
		List<Employee> listEmployee = new ArrayList<Employee>();
		List<EmployeeDTO> listEmployeeDTO = new ArrayList<EmployeeDTO>();
		listEmployee = employeeRepo.findAll();
		for (Employee emp : listEmployee) {
			EmployeeDTO empDTO = new EmployeeDTO();
			empDTO.loadFromEntity(emp);
			listEmployeeDTO.add(empDTO);
		}
		return listEmployeeDTO;
	}

	@Override
	public void update(long id, EmployeeDTO empDTO) {
	}

	@Override
	public void deleteByID(long id) {
		employeeRepo.deleteById(id);
	}

	@Override
	public void deleteAll() {
		employeeRepo.deleteAll();
	}

	@Override
	public EmployeeDTO getById(long id) {
		Employee emp = employeeRepo.getById(id);
		EmployeeDTO empDTO = new EmployeeDTO();
		empDTO.loadFromEntity(emp);
		return empDTO;
	}

}
