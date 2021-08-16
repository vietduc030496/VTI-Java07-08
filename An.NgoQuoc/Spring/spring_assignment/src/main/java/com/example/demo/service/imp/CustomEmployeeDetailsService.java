package com.example.demo.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.config.CustomEmployeeDetails;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@Component
public class CustomEmployeeDetailsService implements UserDetailsService {
    @Autowired
    private EmployeeService employeeService;

	@Override
	public CustomEmployeeDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee employee = employeeService.findByUsername(username);
        return CustomEmployeeDetails.fromUserEntityToCustomUserDetails(employee);
	}

}
