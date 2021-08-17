package com.vti.stringboottest.service;

import java.util.List;

import com.vti.stringboottest.dto.EmployeeDTO;

public interface DepartmentService {
	public void save(EmployeeDTO empDTO);

	public List<EmployeeDTO> getListEmployee();

	public EmployeeDTO getById(long id);

	public void update(long id, EmployeeDTO empDTO);

	public void deleteByID(long id);

	public void deleteAll();
}
