package com.vti.springsecurity.response;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {

    private String token;

	public AuthResponse(String token) {
		super();
		this.token = token;
	}
    
}
