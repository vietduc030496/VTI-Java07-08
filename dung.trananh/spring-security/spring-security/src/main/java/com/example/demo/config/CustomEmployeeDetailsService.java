package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

public class CustomEmployeeDetailsService implements UserDetailsService{
	
	@Autowired
	private EmployeeService employeeService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee employee = employeeService.findByUserName(username);
		return CustomEmployeeDetails.fromEmployeeEntityToCustomEmployeeDetails(employee);
	}
	
	

}
