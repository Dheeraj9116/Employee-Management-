package com.Springpor.Springpor.exception;

public class BadlogCredentials extends RuntimeException{
    public BadlogCredentials(String message){
        super(message);
    }
}
