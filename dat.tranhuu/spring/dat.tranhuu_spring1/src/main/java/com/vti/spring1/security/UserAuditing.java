package com.vti.spring1.security;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class UserAuditing implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        String name="CustomerOfCurrentUser";
        if(SecurityContextHolder.getContext().getAuthentication().isAuthenticated()){
            name=SecurityContextHolder.getContext().getAuthentication().getName();
        }
        return Optional.ofNullable(name);
    }
}
