package com.tripify.demo.exceptions;

public class IdNotFoundException extends RuntimeException{

    private static final String message = "Id Not Found";

    public IdNotFoundException() {
        super(message);
    }

    public IdNotFoundException(String message) {
        super(message);
    }
}
