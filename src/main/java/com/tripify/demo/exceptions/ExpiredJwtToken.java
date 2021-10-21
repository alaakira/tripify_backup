package com.tripify.demo.exceptions;

public class ExpiredJwtToken extends RuntimeException{

    private static final String message = "Token has been expired";

    public ExpiredJwtToken() {
        super(message);
    }
}
