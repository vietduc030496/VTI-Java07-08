package com.example.assignmentjwt.controller;

import com.example.assignmentjwt.config.jwt.JwtProvider;
import com.example.assignmentjwt.entity.Employee;
import com.example.assignmentjwt.request.AuthRequest;
import com.example.assignmentjwt.request.RegistrationRequest;
import com.example.assignmentjwt.response.AuthResponse;
import com.example.assignmentjwt.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private JwtProvider jwtProvider;

	@PostMapping("/register")
	public String registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
		employeeService.saveUser(registrationRequest);
		return "OK";
	}

	@PostMapping("/auth")
	public AuthResponse auth(@RequestBody AuthRequest request) {
		Employee employee = employeeService.findByLoginAndPassword(request.getLogin(), request.getPassword());
		String token = jwtProvider.generateToken(employee.getLogin());
		return new AuthResponse(token);
	}
}
