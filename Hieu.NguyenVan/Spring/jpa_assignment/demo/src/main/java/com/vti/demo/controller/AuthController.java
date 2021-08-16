package com.vti.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vti.demo.config.jwt.JwtProvider;
import com.vti.demo.entity.UserEntity;
import com.vti.demo.request.AuthRequest;
import com.vti.demo.request.RegistrationRequest;
import com.vti.demo.response.AuthResponse;
import com.vti.demo.services.UserService;





@RestController
public class AuthController {
	@Autowired
	private UserService userService;
	@Autowired
	private JwtProvider jwtProvider;

	@PostMapping("/register")
	public String registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
		userService.saveUser(registrationRequest);
		return "OK";
	}

	@PostMapping("/auth")
	public AuthResponse auth(@RequestBody AuthRequest request) {
		UserEntity userEntity = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
		String token = jwtProvider.generateToken(userEntity.getLogin());
		return new AuthResponse(token);
	}
}
