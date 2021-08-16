package com.vti.demo.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {

    private String token;

	public AuthResponse(String token) {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
