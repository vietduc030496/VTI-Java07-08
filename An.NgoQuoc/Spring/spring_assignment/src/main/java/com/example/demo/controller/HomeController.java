package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.JwtProvider;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class HomeController {
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private JwtProvider jwtProvider;


	@PostMapping("/auth")
	public AuthResponse auth(@RequestBody AuthRequest request) {
		Employee employee = employeeService.findByLoginAndPassword(request.getUsername(), request.getPassword());
		String token = jwtProvider.generateToken(employee.getUsername());
		return new AuthResponse(token);
	}
}
