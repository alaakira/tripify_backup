package com.tripify.demo.exceptions;

public class InvalidTokenException extends RuntimeException {

    public static final String message = "Token is Invalid";

    public InvalidTokenException(){
        super(message);
    }

}
