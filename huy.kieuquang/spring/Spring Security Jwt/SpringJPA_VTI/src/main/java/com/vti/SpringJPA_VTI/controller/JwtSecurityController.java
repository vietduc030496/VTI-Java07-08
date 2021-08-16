package com.vti.SpringJPA_VTI.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vti.SpringJPA_VTI.entity.Employee;
import com.vti.SpringJPA_VTI.jwt.config.JwtProvider;
import com.vti.SpringJPA_VTI.jwt.request.AuthRequest;
import com.vti.SpringJPA_VTI.jwt.request.RegistrationRequest;
import com.vti.SpringJPA_VTI.jwt.response.AuthResponse;
import com.vti.SpringJPA_VTI.service.EmployeeService;


@RestController
public class JwtSecurityController {
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private JwtProvider jwtProvider;

	@PostMapping("/register")
	public String registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
		employeeService.saveEncode(registrationRequest);
		return "OK";
	}

	@PostMapping("/auth")
	public AuthResponse auth(@RequestBody AuthRequest request) {
		Employee employee = employeeService.findByLoginAndPassword(request.getLogin(), request.getPassword());
		String token = jwtProvider.generateToken(employee.getLogin());
		return new AuthResponse(token);
	}

//	@GetMapping("/admin/get")
//	public String getAdmin() {
//		return "Hi admin";
//	}
//
//	@GetMapping("/user/get")
//	public String getUser() {
//		return "Hi user";
//	}

	@GetMapping("/user")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String test() {
		return "user";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminTest() {
		return "admin";
	}
}
