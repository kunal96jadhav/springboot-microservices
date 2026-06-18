package com.lcwd.user.service.impl;

import com.lcwd.user.dto.AuthResponse;
import com.lcwd.user.dto.LoginRequest;
import com.lcwd.user.dto.RegisterRequest;
import com.lcwd.user.entities.AuthUser;
import com.lcwd.user.repository.AuthUserRepository;
import com.lcwd.user.security.JwtUtil;
import com.lcwd.user.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthUserRepository authUserRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(AuthUserRepository authUserRepository,
                           PasswordEncoder passwordEncoder) {
        this.authUserRepository = authUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String register(RegisterRequest request) {

        AuthUser user = AuthUser.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole() == null ? "USER" : request.getRole())
                .build();

        authUserRepository.save(user);

        return "User registered successfully";
    }

    @Override
    public AuthResponse login(LoginRequest request) {

        AuthUser user = authUserRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        String token = JwtUtil.generateToken(user.getUsername());

        return new AuthResponse(token);
    }
}