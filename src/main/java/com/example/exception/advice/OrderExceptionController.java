package com.example.exception.advice;

import com.example.exception.OrderNotFoundException;
import com.example.exception.OrderStatusInvalidException;
import com.example.exception.SameOrderStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrderExceptionController {

    @ExceptionHandler(value = OrderNotFoundException.class)
    public ResponseEntity<Object> orderNotFoundException(OrderNotFoundException exception){
        return new ResponseEntity<>("Order ID "+exception.getId()+" is not found ", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = OrderStatusInvalidException.class)
    public ResponseEntity<Object> orderStatusInvalidException(OrderStatusInvalidException exception){
        return new ResponseEntity<>("Order ID: "+exception.getId()+ " is valid but, the Status "+exception.getStatus()+" is Invalid", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = SameOrderStatusException.class)
    public ResponseEntity<Object> sameOrderStatusException(SameOrderStatusException e){
        return new ResponseEntity<>("Same Order Status: "+e.getOrder().getStatus(), HttpStatus.NOT_ACCEPTABLE);
    }

}
