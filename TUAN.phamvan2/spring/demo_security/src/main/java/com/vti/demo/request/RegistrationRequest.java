package com.vti.demo.request;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class RegistrationRequest {

	@NotEmpty
	private String username;

	@NotEmpty
	private String password;

	@NotEmpty
	private String role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
