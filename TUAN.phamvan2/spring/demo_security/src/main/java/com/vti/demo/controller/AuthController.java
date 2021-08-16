package com.vti.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vti.demo.config.jwt.JwtProvider;
import com.vti.demo.entity.User;
import com.vti.demo.request.AuthRequest;
import com.vti.demo.request.RegistrationRequest;
import com.vti.demo.response.AuthResponse;
import com.vti.demo.service.UserService;

@RestController
public class AuthController {
	@Autowired
	private UserService userService;
	@Autowired
	private JwtProvider jwtProvider;

	@PostMapping("/register")
	public String registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
		userService.saveUser(registrationRequest);
		return "Registered successfully!";
	}

	@PostMapping("/auth")
	public AuthResponse auth(@RequestBody AuthRequest request) {
		User user = userService.findByLoginAndPassword(request.getUsername(), request.getPassword());
		String token = jwtProvider.generateToken(user.getUsername());
		return new AuthResponse(token);
	}
}
