package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrderExceptionController {

    @ExceptionHandler(value = OrderNotFoundException.class)
    public ResponseEntity<Object> orderNotFoundException(OrderNotFoundException exception){
        return new ResponseEntity<>("Order is not found "+exception.getId(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = OrderStatusInvalidException.class)
    public ResponseEntity<Object> orderStatusInvalidException(OrderStatusInvalidException exception){
        return new ResponseEntity<>("Order ID: "+exception.getId()+ " Status "+exception.getStatus()+" Invalid", HttpStatus.NOT_FOUND);
    }

}
