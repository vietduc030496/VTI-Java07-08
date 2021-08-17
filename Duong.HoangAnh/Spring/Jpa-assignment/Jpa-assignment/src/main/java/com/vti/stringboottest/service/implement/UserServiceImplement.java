package com.vti.stringboottest.service.implement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vti.stringboottest.config.CustomUserDetails;
import com.vti.stringboottest.dto.UserDTO;
import com.vti.stringboottest.entity.Role;
import com.vti.stringboottest.entity.User;
import com.vti.stringboottest.repository.UserRepository;
import com.vti.stringboottest.service.RoleService;
import com.vti.stringboottest.service.UserService;

@Service
public class UserServiceImplement implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleService roleService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User findByUsername(String username) {

		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		// Kiểm tra xem user có tồn tại trong database không?
		User user = findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new CustomUserDetails(user);
	}

	@Override
	public UserDetails loadUserByUserId(Long id) {
		// Kiểm tra xem user có tồn tại trong database không?
		Optional<User> userOp = userRepository.findById(id);
		User user = null;
		if (userOp.isPresent()) {
			user = userOp.get();
		}
		return new CustomUserDetails(user);
	}

	@Override
	public void save(UserDTO userDto) {
		User user = new User();
		user.setUserName(userDto.getUserName());
		user.setPassword(userDto.getPassword());
		System.out.println(userDto.getPassword());
		Role role = roleService.findById(userDto.getRoleId());
		if (role != null) {
			user.setRole(role);
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

}
