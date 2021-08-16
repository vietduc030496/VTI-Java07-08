package com.vti.SpringJPA_VTI.dto;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.vti.SpringJPA_VTI.entity.Employee;

public class JwtEmployeeDetail implements UserDetails {
	private String login;
	private String password;
	private Collection<? extends GrantedAuthority> grantedAuthorities;

	public static JwtEmployeeDetail fromEmDetailToEmployee(Employee employee) {
		JwtEmployeeDetail jed = new JwtEmployeeDetail();
		jed.login = employee.getLogin();
		jed.password = employee.getPassword();
		jed.grantedAuthorities = Collections.singletonList(new SimpleGrantedAuthority(employee.getRole().getName()));
		return jed;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
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
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
