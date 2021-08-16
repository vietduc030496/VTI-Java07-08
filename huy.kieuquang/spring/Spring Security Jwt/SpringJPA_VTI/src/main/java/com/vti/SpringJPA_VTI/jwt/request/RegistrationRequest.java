package com.vti.SpringJPA_VTI.jwt.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class RegistrationRequest {
	@NotEmpty
	private String login;

	@NotEmpty
	private String password;

	@NotEmpty
	private String role;
	
	@NotNull(message = "enter departId")
	private int departmentId;
}
