package com.vti.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestSecurityController {

	@GetMapping("/admin/get")
	public String getAdmin() {
		return "Hi admin";
	}

	@GetMapping("/user/get")
	public String getUser() {
		return "Hi user";
	}

	@GetMapping("/user")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String test() {
		return "tesstin";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminTest() {
		return "admin";
	}
}
