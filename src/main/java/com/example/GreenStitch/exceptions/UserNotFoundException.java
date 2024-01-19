package com.example.GreenStitch.exceptions;

public class UserNotFoundException extends RuntimeException{
    String email;

    public UserNotFoundException(String email){
        super(String.format("User with email %s not found!",email));
        this.email = email;
    }
}
