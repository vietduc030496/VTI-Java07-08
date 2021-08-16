package com.vti.spring1.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vti.spring1.entity.Role;
import com.vti.spring1.entity.User;
import com.vti.spring1.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional= userRepository.findByUsername(username);
        User user = userOptional.orElseThrow(()-> new UsernameNotFoundException("username not found: "+username));
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),user.isEnabled()
        ,true,true,true,grantedAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> grantedAuthorities(List<Role> roles){
        List<SimpleGrantedAuthority> list= new ArrayList<>();
        for(Role role: roles){
            list.add(new SimpleGrantedAuthority(role.getName()));
        }
        return list;
    }
    
}
