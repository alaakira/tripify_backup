package com.tripify.demo.exceptions;

public class AlreadyExistsException extends RuntimeException{

    private static final String message = " already exists.";

    public AlreadyExistsException(String message) {
        super(message + AlreadyExistsException.message);
    }
}
