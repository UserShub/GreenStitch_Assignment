package com.example.GreenStitch.exceptions;

public class UserAlreadyExistsException extends RuntimeException{
    String email;

    public UserAlreadyExistsException(String email){
        super(String.format("User with email %s is already registered!",email));
        this.email = email;
    }

}
