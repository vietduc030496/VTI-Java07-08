package com.vti.SpringJPA_VTI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.SpringJPA_VTI.dto.JwtEmployeeDetail;
import com.vti.SpringJPA_VTI.entity.Employee;

@Service
public class JwtEmployeeDetailService {
	@Autowired
	private EmployeeService employeeService;
	
	public JwtEmployeeDetail loadUserByUsername(String username) {
		Employee employee = employeeService.findByLogin(username);
		return JwtEmployeeDetail.fromEmDetailToEmployee(employee);
	}
}
