package com.vti.springsecurity.controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestSecurityController {

	@GetMapping("/admin/get")
	public String getAdmin() {
		return "Hi admin";
	}

	@GetMapping("/employee/get")
	public String getUser() {
		return "Hi user";
	}

	@GetMapping("/employee")
	@PreAuthorize("hasRole('ROLE_EMPLOYEE')")
	public String test() {
		return "employee";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminTest() {
		return "admin";
	}
}
