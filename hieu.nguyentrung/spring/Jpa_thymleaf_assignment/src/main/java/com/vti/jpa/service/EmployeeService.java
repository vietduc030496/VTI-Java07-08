package com.vti.jpa.service;

import java.util.List;

import com.vti.jpa.dto.EmployeeDTO;

public interface EmployeeService {
	
	
	public void addEmp(EmployeeDTO employeeDTO);

	
	public EmployeeDTO updateEmp(long employeeID, EmployeeDTO employeeDTO);

	
	public List<EmployeeDTO> getEmployee();

	
	public EmployeeDTO getEmployeeByID(long employeeID);

	
	public List<EmployeeDTO> deleteEmpByID(long employeeID);
	
}
