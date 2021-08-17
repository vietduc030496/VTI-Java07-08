package com.vti.stringboottest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.stringboottest.dto.UserDTO;
import com.vti.stringboottest.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public String registerUser(@RequestBody @Valid UserDTO userDto) {
		userService.save(userDto);
		return "OK";
	}

//	@PostMapping("/auth")
//	public AuthResponse auth(@RequestBody AuthRequest request) {
//		UserEntity userEntity = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
//		String token = jwtProvider.generateToken(userEntity.getLogin());
//		return new AuthResponse(token);
//	}
}
