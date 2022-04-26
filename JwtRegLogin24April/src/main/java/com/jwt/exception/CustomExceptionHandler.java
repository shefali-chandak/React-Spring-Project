package com.jwt.exception;
import com.jwt.payload.ApiResponse;
import com.jwt.payload.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.UnexpectedTypeException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Object> handleAuthenticationException(AuthenticationException authenticationException) {
        return new ResponseEntity<>(new ApiResponse(new ErrorResponse(authenticationException.getMessage())), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(new ApiResponse(new ErrorResponse(ex.getMessage())), HttpStatus.METHOD_NOT_ALLOWED);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(new ApiResponse(new ErrorResponse(ex.getMessage())),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler (UsernameNotFoundException.class)
    protected ResponseEntity<Object> handleUsernameNotFoundException(UsernameNotFoundException usernameNotFoundException) {
        return new ResponseEntity<>(new ApiResponse(new ErrorResponse(usernameNotFoundException.getMessage())),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnexpectedTypeException.class)
    protected ResponseEntity<Object> handleUnexpectedTypeException(UnexpectedTypeException unexpectedTypeException) {
        return new ResponseEntity<>(new ApiResponse(new ErrorResponse(unexpectedTypeException.getMessage())), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    protected ResponseEntity<Object> handleNullPointerException(NullPointerException nullPointerException) {
        return new ResponseEntity<>(new ApiResponse(new ErrorResponse(nullPointerException.getMessage())), HttpStatus.BAD_REQUEST);
    }

}