package com.tripify.demo.exceptions;

public class RoleNotFoundException extends RuntimeException{

    public static final String message = "Required role is not found";

    public RoleNotFoundException() {
        super(message);
    }

}
