package com.example.assignmentjwt.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestSecurityController {

	@GetMapping("/admin/get")
	@PreAuthorize("hasRole('ADMIN')")
	public String getAdmin() {
		return "admin lam gi";
	}

	@GetMapping("/user/get")
	@PreAuthorize("hasRole('USER')")
	public String getUser() {
		return "Hi user";
	}

	@GetMapping("/user")
	@PreAuthorize("hasRole('USER')")
	public String test() {
		return "Test user";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminTest() {
		return "admin";
	}
}
