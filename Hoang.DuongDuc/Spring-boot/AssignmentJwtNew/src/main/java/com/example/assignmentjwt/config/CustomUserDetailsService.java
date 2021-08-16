package com.example.assignmentjwt.config;

import com.example.assignmentjwt.entity.Employee;
import com.example.assignmentjwt.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private EmployeeService employeeService;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeService.findByLogin(username);
        return CustomUserDetails.fromUserEntityToCustomUserDetails(employee);
    }
}
