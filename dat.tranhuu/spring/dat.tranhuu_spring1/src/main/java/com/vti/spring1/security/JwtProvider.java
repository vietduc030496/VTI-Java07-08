package com.vti.spring1.security;

import java.time.Instant;
import java.util.Date;



import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;

@Service
public class JwtProvider {
    
    private final String secretKey= "thisistokensecretqwertyuiopasdfghjklzxcvbnm";

    public String generateToken(Authentication authentication){
        User principal =  (User) authentication.getPrincipal();
        return Jwts.builder().setSubject(principal.getUsername()).setIssuedAt(Date.from(Instant.now()))
        .signWith(Keys.hmacShaKeyFor(secretKey.getBytes()))
        .setExpiration(Date.from(Instant.now().plusSeconds(900))).compact();
    }

    public String generateTokenWithUsername(String username){
        return Jwts.builder().setSubject(username).setIssuedAt(Date.from(Instant.now()))
        .signWith(Keys.hmacShaKeyFor(secretKey.getBytes()))
        .setExpiration(Date.from(Instant.now().plusSeconds(900))).compact();
    }


    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (SignatureException ex) {
            return false;
        } catch (MalformedJwtException ex) {
            return false;
        } catch (ExpiredJwtException ex) {
            return false;
        } catch (UnsupportedJwtException ex) {
            return false;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    public String getUsernameFromToken(String token){
        Claims claims= Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
