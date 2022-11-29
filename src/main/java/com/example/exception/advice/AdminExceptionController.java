package com.example.exception.advice;

import com.example.exception.AdminNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdminExceptionController {

    @ExceptionHandler(value = AdminNotFoundException.class)
    public ResponseEntity<Object> adminNotFoundException(AdminNotFoundException e){
        
        return new ResponseEntity<>("Admin id "+e.getId()+" Not Found", HttpStatus.NOT_FOUND);
    }

}
