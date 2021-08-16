package com.vti.spring1.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.spring1.entity.RefreshToken;
import com.vti.spring1.repository.IRefreshTokenRepository;
import com.vti.spring1.service.IRefreshTokenService;

@Service
public class RefreshTokenService implements IRefreshTokenService{

    @Autowired 
    private IRefreshTokenRepository refreshTokenRepo;

    @Override
    public RefreshToken generateToken() {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setToken(UUID.randomUUID().toString());
        return refreshTokenRepo.save(refreshToken);
    }

    @Override
    public Boolean validateToken(String token) {
        RefreshToken token1= refreshTokenRepo.findByToken(token).get();
        if(token1!=null){
            return true;
        }
        return false;
    }

    @Override
    public void deleteToken(String token) {
        refreshTokenRepo.deleteById(refreshTokenRepo.findByToken(token).get().getId());
    }
    
}
