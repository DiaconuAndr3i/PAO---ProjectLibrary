package com.springboot.system.Library.error;

import com.springboot.system.Library.error.status.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(NotFound.class)
    public ResponseEntity<?> resourceNotFound(NotFound obj, WebRequest request) {
        Error Error = new Error(new Date(), obj.getMessage());
        return new ResponseEntity<>(Error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExcpetion(Exception ex, WebRequest request) {
        Error Error = new Error(new Date(), ex.getMessage());
        return new ResponseEntity<>(Error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
