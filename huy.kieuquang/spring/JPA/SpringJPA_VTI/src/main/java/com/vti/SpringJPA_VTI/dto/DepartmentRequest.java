package com.vti.SpringJPA_VTI.dto;

import javax.validation.constraints.NotBlank;



public class DepartmentRequest {
	// blank > empty
	@NotBlank(message = "name is blank")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
