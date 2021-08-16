package com.example.demo.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.jwt.JwtProvider;
import com.example.demo.entity.Employee;
import com.example.demo.request.AuthRequest;
import com.example.demo.request.RegistrationRequest;
import com.example.demo.response.AuthResponse;
import com.example.demo.service.EmployeeService;

@RestController
public class AuthController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private JwtProvider jwtProvider;
	
	@PostMapping("/register")
	public String registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
		employeeService.saveEmployee(registrationRequest);
		return "OK";
	}

	@PostMapping("/auth")
	public AuthResponse auth(@RequestBody AuthRequest request) {
		Employee employee = employeeService.findByUserNameAndPassword(request.getUsername(), request.getPassword());
		String token = jwtProvider.generateToken(employee.getUsername());
		return new AuthResponse(token);
	}
}
