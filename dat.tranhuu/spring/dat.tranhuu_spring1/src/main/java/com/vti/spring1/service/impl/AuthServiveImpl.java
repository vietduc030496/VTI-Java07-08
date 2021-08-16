package com.vti.spring1.service.impl;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vti.spring1.dto.LoginRequest;
import com.vti.spring1.dto.LoginResponse;
import com.vti.spring1.dto.NotificationEmail;
import com.vti.spring1.dto.RefreshTokenDto;
import com.vti.spring1.dto.ResponseDto;
import com.vti.spring1.dto.RoleDto;
import com.vti.spring1.dto.UserDto;
import com.vti.spring1.entity.Role;
import com.vti.spring1.entity.User;
import com.vti.spring1.entity.VerificationToken;
import com.vti.spring1.exception.ShoppingException;
import com.vti.spring1.repository.RoleRepository;
import com.vti.spring1.repository.UserRepository;
import com.vti.spring1.repository.VerificationTokenRepository;
import com.vti.spring1.security.JwtProvider;
import com.vti.spring1.service.AuthService;
import com.vti.spring1.service.IRefreshTokenService;
import com.vti.spring1.types.YESNO;
import com.vti.spring1.utils.MailService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthServiveImpl implements AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final VerificationTokenRepository verificationTokenRepository;
    private final MailService mailService;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final IRefreshTokenService refreshTokenService;

    @Override
    public ResponseDto<UserDto> signup(UserDto userDto) {
        User user= new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setEnabled(false);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        List<Role> roles= new ArrayList<>();
        if(userDto.getRoles()!=null && userDto.getRoles().size()>0){
            for(RoleDto roleDto: userDto.getRoles()){
                if(roleDto.getId()>0l){
                    roles.add(roleRepository.getById(roleDto.getId()));
                }
                
            }
        }
        user.setRoles(roles);
        try{
            user= userRepository.save(user);
            ResponseDto<UserDto> res= new ResponseDto<>();
            res.setObject(new UserDto(user));
            res.setStatus(YESNO.YES);
            res.setMessage("Please check email");
            String token=generateVerifictionToken(user);
            mailService.sendMail(new NotificationEmail("Please activate your account","Thank you for signup to NuclearShop" +
                "please click on the below url to activate your account:" +
                "http://localhost:8888/api/auth/accountverification/"+token,user.getEmail()));
            return res;
        }catch (Exception e){
            ResponseDto<UserDto> res= new ResponseDto<>();
            res.setError("account is exist");
            res.setStatus(YESNO.NO);
            System.out.println("error");
            return res;
        }
    }

    private String generateVerifictionToken(User user) {
        String token= UUID.randomUUID().toString();
        VerificationToken verificationToken= new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);

        verificationTokenRepository.save(verificationToken);
        return token;
    }

    @Override
    public void verifyAccount(String token) {
        Optional<VerificationToken> verificationToken= verificationTokenRepository.findByToken(token);
        verificationToken.orElseThrow(() -> new ShoppingException("invalid token"));
        enabledUse(verificationToken.get());
    }

    private void enabledUse(VerificationToken verificationToken) {
        String username=verificationToken.getUser().getUsername();
        User user =userRepository.findByUsername(username).orElseThrow(()-> new ShoppingException("user is not found with username:"+username));
        user.setEnabled(true);
        userRepository.save(user);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);
        return LoginResponse.builder().authenToken(token).username(loginRequest.getUsername())
                .expiresAt(Instant.now().plusSeconds(900)).refreshToken(refreshTokenService.generateToken().getToken()).build();
    }

    @Override
    public LoginResponse refreshToken(RefreshTokenDto refreshToken) {
        if (refreshTokenService.validateToken(refreshToken.getRefreshToken())) {
            String token = jwtProvider.generateTokenWithUsername(refreshToken.getUsername());
            return LoginResponse.builder().authenToken(token).refreshToken(refreshToken.getRefreshToken())
                    .expiresAt(Instant.now().plusSeconds(900)).username(refreshToken.getUsername()).build();
        }
        return null;
    }

    @Override
    public boolean isLoggedIn() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated();
    }
}
