package com.tripify.demo.exceptions;

public class NotFoundRuntimeException extends RuntimeException{

    public NotFoundRuntimeException() {
        super("Not found");
    }

    public NotFoundRuntimeException(String message) {
        super(message);
    }
}
