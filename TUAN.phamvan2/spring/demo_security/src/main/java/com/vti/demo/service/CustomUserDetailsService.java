package com.vti.demo.service;

import com.vti.demo.config.CustomUserDetails;
import com.vti.demo.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userService.findByUsername(username);
       return CustomUserDetails.fromUserEntityToCustomUserDetails(user);
    }
}
