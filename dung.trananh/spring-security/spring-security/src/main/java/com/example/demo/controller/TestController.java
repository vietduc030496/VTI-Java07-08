package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/manager/get")
	public String getAdmin() {
		return "Hi manager";
	}

	@GetMapping("/employee/get")
	public String getUser() {
		return "Hi employee";
	}

	@GetMapping("/employee")
	@PreAuthorize("hasRole('EMPLOYEE')")
	public String test() {
		return "employee";
	}

	@GetMapping("/manager")
	@PreAuthorize("hasRole('MANAGER')")
	public String adminTest() {
		return "manager";
	}
}
