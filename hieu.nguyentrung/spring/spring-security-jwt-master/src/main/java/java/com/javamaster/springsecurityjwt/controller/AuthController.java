package java.com.javamaster.springsecurityjwt.controller;

import java.com.javamaster.springsecurityjwt.config.jwt.JwtProvider;
import java.com.javamaster.springsecurityjwt.entity.EmployeeEntity;
import java.com.javamaster.springsecurityjwt.request.AuthRequest;
import java.com.javamaster.springsecurityjwt.request.RegistrationRequest;
import java.com.javamaster.springsecurityjwt.response.AuthResponse;
import java.com.javamaster.springsecurityjwt.service.EmployeeService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
		EmployeeEntity userEntity = employeeService.findByLoginAndPassword(request.getLogin(), request.getPassword());
		String token = jwtProvider.generateToken(userEntity.getLogin());
		return new AuthResponse(token);
	}
}
