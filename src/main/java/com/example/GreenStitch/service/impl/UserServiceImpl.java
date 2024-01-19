package com.example.GreenStitch.service.impl;

import com.example.GreenStitch.configuration.JwtService;
import com.example.GreenStitch.exceptions.InvalidPassWordException;
import com.example.GreenStitch.exceptions.UserAlreadyExistsException;
import com.example.GreenStitch.exceptions.UserNotFoundException;
import com.example.GreenStitch.models.User;
import com.example.GreenStitch.payloads.LoginRequest;
import com.example.GreenStitch.payloads.LoginResponse;
import com.example.GreenStitch.payloads.RegisterRequest;
import com.example.GreenStitch.payloads.RegisterResponse;
import com.example.GreenStitch.repository.UserRepository;
import com.example.GreenStitch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        String email = registerRequest.getEmail();
        if(this.userRepository.findByEmail(email).isPresent())
            throw new UserAlreadyExistsException(email);

        User user = User.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(registerRequest.getRole())
                .build();
        userRepository.save(user);

        return RegisterResponse
                .builder()
                .message(String.format("User with email %s created successfully!",email))
                .build();
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {

        String email = loginRequest.getEmail();

        User user = this.userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(email));

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        String jwtToken = jwtService.generateToken(user);
        return LoginResponse
                .builder()
                .token(jwtToken)
                .build();
    }
}
