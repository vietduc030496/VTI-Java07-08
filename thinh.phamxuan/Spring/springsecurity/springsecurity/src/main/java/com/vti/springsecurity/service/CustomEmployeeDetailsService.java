package com.vti.springsecurity.service;
import com.vti.springsecurity.config.CustomEmployeeDetails;
import com.vti.springsecurity.entity.Employee;
import com.vti.springsecurity.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomEmployeeDetailsService implements UserDetailsService {
    @Autowired
    private EmployeeService employeeService;

    @Override
    public CustomEmployeeDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    	Employee employee = employeeService.findByUserName(userName);
		return CustomEmployeeDetails.fromEmployeeEntityToCustomEmployeeDetails(employee);

    }
}
