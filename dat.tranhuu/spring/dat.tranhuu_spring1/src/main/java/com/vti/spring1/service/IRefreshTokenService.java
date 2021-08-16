package com.vti.spring1.service;

import com.vti.spring1.entity.RefreshToken;

public interface IRefreshTokenService {
    RefreshToken generateToken();
    Boolean validateToken(String token);
    void deleteToken(String token);
}
