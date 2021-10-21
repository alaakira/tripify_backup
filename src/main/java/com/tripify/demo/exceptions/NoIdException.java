package com.tripify.demo.exceptions;

public class NoIdException extends RuntimeExceptionTemplate {

    public static final String message = "Id not found";

    @Override
    public String getMessage() {
        return message;
    }
}
