package com.example.demo.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entity.Employee;


public class CustomEmployeeDetails implements UserDetails {
	
	private String username;
	private String password;
	private Collection<? extends GrantedAuthority> grantedAuthorities;
	
	public static CustomEmployeeDetails fromEmployeeEntityToCustomEmployeeDetails(Employee employee) {
		CustomEmployeeDetails ced = new CustomEmployeeDetails();
		ced.username = employee.getUsername();
		ced.password = employee.getPassword();
		ced.grantedAuthorities = Collections.singletonList(new SimpleGrantedAuthority(employee.getRole().getRole_name()));
		return ced;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
