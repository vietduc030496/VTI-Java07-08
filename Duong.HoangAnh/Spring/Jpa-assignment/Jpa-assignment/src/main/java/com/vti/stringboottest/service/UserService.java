package com.vti.stringboottest.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.vti.stringboottest.dto.UserDTO;
import com.vti.stringboottest.entity.User;


public interface UserService extends UserDetailsService {
    
    public User findByUsername(String username);

	public UserDetails loadUserByUserId(Long id);
    
	public void save(UserDTO userDto);
}