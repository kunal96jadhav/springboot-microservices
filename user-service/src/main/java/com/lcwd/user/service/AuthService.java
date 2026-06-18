package com.lcwd.user.service;

import com.lcwd.user.dto.LoginRequest;
import com.lcwd.user.dto.RegisterRequest;
import com.lcwd.user.dto.AuthResponse;

public interface AuthService {

    String register(RegisterRequest request);

    AuthResponse login(LoginRequest request);

}