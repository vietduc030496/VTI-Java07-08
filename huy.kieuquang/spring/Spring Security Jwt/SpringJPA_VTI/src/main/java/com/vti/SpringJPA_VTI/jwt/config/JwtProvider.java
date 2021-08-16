package com.vti.SpringJPA_VTI.jwt.config;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.vti.SpringJPA_VTI.dto.JwtEmployeeDetail;
import com.vti.SpringJPA_VTI.service.JwtEmployeeDetailService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtProvider{
	// get from properties
    @Value("$(jwt.secret)")
    private String jwtSecret;
    
    @Autowired
    private JwtEmployeeDetailService jwtEmDetailService;

    public String generateToken(String login) {
        Date date = Date.from(LocalDate.now().plusDays(15).atStartOfDay(ZoneId.systemDefault()).toInstant());
        return Jwts.builder()
                .setSubject(login)
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
//            log.severe("invalid token");
        }
        return false;
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
    
    // jwtEmDetail contain authority when loadUserByUsername() --> fromEmDetailToEmployee() at JwtEmployeeDetail
    public Authentication getAuthentication(String token) {
    	JwtEmployeeDetail jwtEmDetail = jwtEmDetailService.loadUserByUsername(getUsernameFromToken(token));
    	return new UsernamePasswordAuthenticationToken(jwtEmDetail, "", jwtEmDetail.getAuthorities());
    }
    
    public String getTokenFromRequest(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		// check header Authorization
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7);
		}
		return null;
	}
}
