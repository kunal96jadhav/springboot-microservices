package com.lcwd.user.controller;

import com.lcwd.user.dto.AuthResponse;
import com.lcwd.user.dto.LoginRequest;
import com.lcwd.user.dto.RegisterRequest;
import com.lcwd.user.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}