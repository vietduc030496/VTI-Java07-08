package com.vti.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.vti.demo.entity.Role;
import com.vti.demo.repository.RoleRepository;
import com.vti.demo.repository.UserRepository;
import com.vti.demo.request.RegistrationRequest;
import com.vti.demo.entity.User;

public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public User saveUser(RegistrationRequest registrationRequest) {
		User user = new User();
		user.setPassword(registrationRequest.getPassword());
		user.setUsername(registrationRequest.getUsername());

		Role roleUser = roleRepository.findByName(registrationRequest.getRole());
		if (roleUser == null) {
			Role role = new Role();
			role.setName(registrationRequest.getRole());
			roleRepository.save(role);
			roleUser = roleRepository.findByName(registrationRequest.getRole());
		}

		user.setRole(roleUser);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	public User findByLoginAndPassword(String username, String password) {
		User user = findByUsername(username);
		if (user != null) {
			if (passwordEncoder.matches(password, user.getPassword())) {
				return user;
			}
		}
		return null;
	}

	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}
}
