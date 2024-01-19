package com.example.GreenStitch.exceptions;

import com.example.GreenStitch.constants.AppConstants;

public class InvalidPassWordException extends RuntimeException{
    public InvalidPassWordException(){
        super(AppConstants.INVALID_PASSWORD);
    }
}
