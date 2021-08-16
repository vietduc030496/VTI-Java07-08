package com.example.demo.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entity.Employee;

public class CustomEmployeeDetails implements UserDetails{
	private String username;
    private String password;
    private Collection<? extends GrantedAuthority> grantedAuthorities;
    
    public static CustomEmployeeDetails fromUserEntityToCustomUserDetails(Employee employee) {
    	CustomEmployeeDetails c = new CustomEmployeeDetails();
        c.username = employee.getUsername();
        c.password = employee.getPassword();
        c.grantedAuthorities = Collections.singletonList(new SimpleGrantedAuthority(employee.getRole().getName()));
        return c;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
