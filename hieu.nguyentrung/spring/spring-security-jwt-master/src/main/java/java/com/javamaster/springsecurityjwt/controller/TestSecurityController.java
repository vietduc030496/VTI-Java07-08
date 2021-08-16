package java.com.javamaster.springsecurityjwt.controller;

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
		return "Hi employee";
	}

	@GetMapping("/employee")
	@PreAuthorize("hasRole('ROLE_EMPLOYEE')")
	public String test() {
		return "tesstin";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminTest() {
		return "admin";
	}
}
