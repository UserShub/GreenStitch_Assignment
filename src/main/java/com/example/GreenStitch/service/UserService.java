package com.example.GreenStitch.service;


import com.example.GreenStitch.payloads.LoginRequest;
import com.example.GreenStitch.payloads.LoginResponse;
import com.example.GreenStitch.payloads.RegisterRequest;
import com.example.GreenStitch.payloads.RegisterResponse;

public interface UserService {
    RegisterResponse register(RegisterRequest registerRequest);

    LoginResponse login(LoginRequest loginRequest);
}
