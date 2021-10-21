package com.tripify.demo.exceptions;

public class AlreadyExistRuntimeException extends RuntimeException{

    public AlreadyExistRuntimeException() {
        super("Already exists");
    }

    public AlreadyExistRuntimeException(String message) {
        super(message);
    }

}
