package com.vti.springsecurity.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.vti.springsecurity.config.jwt.JwtProvider;
import com.vti.springsecurity.entity.Employee;
import com.vti.springsecurity.request.AuthRequest;
import com.vti.springsecurity.request.RegistrationRequest;
import com.vti.springsecurity.response.AuthResponse;
import com.vti.springsecurity.service.EmployeeService;


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
		Employee employee = employeeService.findByLoginAndPassword(request.getUsername(), request.getPassword());
		String token = jwtProvider.generateToken(employee.getUsername());
		return new AuthResponse(token);
	}
}
