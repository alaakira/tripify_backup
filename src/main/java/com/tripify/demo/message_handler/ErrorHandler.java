package com.tripify.demo.message_handler;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.tripify.demo.exceptions.*;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@ControllerAdvice
@RestController
public class ErrorHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(AlreadyExistRuntimeException.class)
    public ResponseEntity<ApplicationError> handleAlreadyExistRuntimeException(AlreadyExistRuntimeException exception){
        exception.printStackTrace();
        ApplicationError error = new ApplicationError();
        error.setCode(HttpStatus.CONFLICT.value());
        error.setMessage(exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundRuntimeException.class)
    public ResponseEntity<ApplicationError> handleAlreadyExistRuntimeException(NotFoundRuntimeException exception){
        exception.printStackTrace();
        ApplicationError error = new ApplicationError();
        error.setCode(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IncorrectPasswordException.class)
    public ResponseEntity<ApplicationError> handleIncorrectPasswordException(IncorrectPasswordException exception, WebRequest webRequest) {
        exception.printStackTrace();
        ApplicationError error = new ApplicationError();
        error.setCode(HttpStatus.NON_AUTHORITATIVE_INFORMATION.value());
        error.setMessage(exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
    }

    @ExceptionHandler(TokenExpiredException.class)
    public ResponseEntity<ApplicationError> handleExpiredTokenException(TokenExpiredException exception, WebRequest webRequest) {
        exception.printStackTrace();
        ApplicationError error = new ApplicationError();
        error.setCode(HttpStatus.UNAUTHORIZED.value());
        error.setMessage(exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(IncorrectCodeException.class)
    public ResponseEntity<ApplicationError> handleUserFoundException(IncorrectCodeException exception, WebRequest webRequest) {
        exception.printStackTrace();
        ApplicationError error = new ApplicationError();
        error.setCode(HttpStatus.CONFLICT.value());
        error.setMessage(exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NoIdException.class)
    public ResponseEntity<ApplicationError> handleUserFoundException(NoIdException exception, WebRequest webRequest) {
        exception.printStackTrace();
        ApplicationError error = new ApplicationError();
        error.setCode(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoEnoughSeatsException.class)
    public ResponseEntity<ApplicationError> handleUserFoundException(NoEnoughSeatsException exception, WebRequest webRequest) {
        exception.printStackTrace();
        ApplicationError error = new ApplicationError();
        error.setCode(255);
        error.setMessage(exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }
    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ex.printStackTrace();
        ApplicationError error = new ApplicationError();
        error.setCode(HttpStatus.NOT_IMPLEMENTED.value());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_IMPLEMENTED);
    }

    // This method handles constraint violation exception raised by DB.
    // Similarly other type exceptions like custom exception and HTTP status related
    //exception can be handled here.
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApplicationError> handleConstraintViolationException(ConstraintViolationException exception) {
        exception.printStackTrace();
        ApplicationError error = new ApplicationError();
        error.setCode(HttpStatus.CONFLICT.value());
        error.setMessage(exception.getCause().getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<ApplicationError> handleInvalidTokenException(InvalidTokenException exception){
        exception.printStackTrace();
        ApplicationError error = new ApplicationError();
        error.setCode(HttpStatus.CONFLICT.value());
        error.setMessage(exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApplicationError> handleAccessDeniedException(AccessDeniedException exception){
        exception.printStackTrace();
        ApplicationError error = new ApplicationError();
        error.setCode(HttpStatus.UNAUTHORIZED.value());
        error.setMessage(exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception exception, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        exception.printStackTrace();
        ApplicationError error = new ApplicationError();
        error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setMessage(exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<ApplicationError> handleInvalidDataExceptionException(InvalidDataException exception, WebRequest webRequest) {
        exception.printStackTrace();
        ApplicationError error = new ApplicationError();
        error.setCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
        error.setMessage(exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApplicationError> handleUnknownException(Exception exception, WebRequest webRequest) {
        try {
            FileWriter fileWriter = new FileWriter("exceptions.txt",true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            exception.printStackTrace(printWriter);
            fileWriter.close();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        exception.printStackTrace();
        ApplicationError error = new ApplicationError();
        error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setMessage(exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }


//    // Below method is to handle _SqlExceptionHelper_ exception
//    @ExceptionHandler(SqlExceptionHelper.class)
//    public ResponseEntity<ApplicationError> handleConstraintViolationException(SqlExceptionHelper ex) {
//        // write your own logic to return user friendly response
//    }
}
