package com.example.GreenStitch.controller;

import com.example.GreenStitch.constants.AppConstants;
import com.example.GreenStitch.payloads.*;
import com.example.GreenStitch.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(AppConstants.BASE_URL)
public class ApiController {
    @Autowired
    private UserService userService;
    @PostMapping(AppConstants.REGISTER_ENDPOINT)
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity<>(new ExceptionResponse(bindingResult.getAllErrors().toString()),HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(this.userService.register(registerRequest), HttpStatus.CREATED);
    }

    @PostMapping(AppConstants.LOGIN_ENDPOINT)
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity<>(new ExceptionResponse(bindingResult.getAllErrors().toString()),HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(this.userService.login(loginRequest), HttpStatus.OK);
    }

    @GetMapping(AppConstants.HELLO_ENDPOINT)
    public ResponseEntity<ApiResponse> getMessage() {
        return new ResponseEntity<>(new ApiResponse(AppConstants.HELLO_RESPONSE),HttpStatus.OK);
    }
}
