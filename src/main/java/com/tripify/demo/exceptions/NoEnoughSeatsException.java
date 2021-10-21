package com.tripify.demo.exceptions;

public class NoEnoughSeatsException extends RuntimeExceptionTemplate {


    public static final String message = "No enough seats";

    @Override
    public String getMessage() {
        return message;
    }
}
