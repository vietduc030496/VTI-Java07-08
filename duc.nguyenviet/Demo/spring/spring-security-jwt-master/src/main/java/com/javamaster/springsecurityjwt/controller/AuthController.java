package com.javamaster.springsecurityjwt.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javamaster.springsecurityjwt.config.jwt.JwtProvider;
import com.javamaster.springsecurityjwt.entity.UserEntity;
import com.javamaster.springsecurityjwt.request.AuthRequest;
import com.javamaster.springsecurityjwt.request.RegistrationRequest;
import com.javamaster.springsecurityjwt.response.AuthResponse;
import com.javamaster.springsecurityjwt.service.UserService;

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
