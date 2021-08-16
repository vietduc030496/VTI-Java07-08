package com.vti.SpringJPA_VTI.jwt.request;

import lombok.Data;

@Data
public class AuthRequest {
	private String login;
    private String password;
}
