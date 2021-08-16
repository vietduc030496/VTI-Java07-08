package com.vti.spring1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.spring1.entity.RefreshToken;

public interface IRefreshTokenRepository extends JpaRepository<RefreshToken,Long>{
    Optional<RefreshToken> findByToken(String token);
    void deleteByToken(String token);
}

