package com.vti.spring1.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.spring1.dto.LoginRequest;
import com.vti.spring1.dto.LoginResponse;
import com.vti.spring1.dto.RefreshTokenDto;
import com.vti.spring1.dto.ResponseDto;
import com.vti.spring1.dto.UserDto;
import com.vti.spring1.service.AuthService;
import com.vti.spring1.service.IRefreshTokenService;

import lombok.AllArgsConstructor;



@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final IRefreshTokenService refreshTokenService;

    @PostMapping("/signup")
    public ResponseEntity<ResponseDto<UserDto>> signup(@RequestBody UserDto userDto){
        return new ResponseEntity<>(authService.signup(userDto),HttpStatus.OK);
    }

    @GetMapping(value="/accountverification/{token}")
    public ResponseEntity<String>  verifyAccount(@PathVariable("token") String token) {
        authService.verifyAccount(token);
        return new ResponseEntity<>("account is verified",HttpStatus.OK);
    }
    
    @PostMapping(value = "/login")
    public ResponseEntity<LoginResponse> loginResponse(@RequestBody LoginRequest loginRequest) {
       return new ResponseEntity<LoginResponse>(authService.login(loginRequest), HttpStatus.OK) ;
    }

    @PostMapping(value="/refresh/token")
    public ResponseEntity<LoginResponse> refreshToken(@Valid @RequestBody RefreshTokenDto refreshToken) {
        return authService.refreshToken(refreshToken)!=null?
        new ResponseEntity<>(authService.refreshToken(refreshToken), HttpStatus.CREATED): 
        new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value="/logout")
    public ResponseEntity<String> logoutEntity(@Valid @RequestBody RefreshTokenDto refreshToken) {
        refreshTokenService.deleteToken(refreshToken.getRefreshToken());
        return ResponseEntity.status(HttpStatus.OK).body("delete successfully!");
    }
}
