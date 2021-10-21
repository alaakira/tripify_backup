package com.tripify.demo.exceptions;

public class InvalidDataException extends RuntimeException{

    public static String message = "Invalid Data";

    public InvalidDataException(){
        super(message);
    }

}
