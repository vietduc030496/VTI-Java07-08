package com.vti.spring1.service;

import javax.validation.Valid;

import com.vti.spring1.dto.LoginRequest;
import com.vti.spring1.dto.LoginResponse;
import com.vti.spring1.dto.RefreshTokenDto;
import com.vti.spring1.dto.ResponseDto;
import com.vti.spring1.dto.UserDto;

public interface AuthService {
    ResponseDto<UserDto> signup(UserDto userDto);
    void verifyAccount(String token);
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(@Valid RefreshTokenDto refreshToken);
    boolean isLoggedIn();
}
