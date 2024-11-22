package com.Springpor.Springpor.exception;

public class UserAlreadyExsist extends RuntimeException{
    public UserAlreadyExsist(String message) {
        super(message);
    }
}
