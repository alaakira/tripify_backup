package com.tripify.demo.exceptions;

public class IncorrectCodeException extends RuntimeExceptionTemplate{

    public static final String message = "Incorrect Code";

    @Override
    public String getMessage() {
        return message;
    }
}

