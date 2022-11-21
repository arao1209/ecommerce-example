package com.example.exception.advice;

import com.example.exception.VendorNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class VendorExceptionController {

    @ExceptionHandler(value = VendorNotFoundException.class)
    public ResponseEntity<Object> vendorNotFoundException(VendorNotFoundException e){
        return new ResponseEntity<>("Vendor Id: "+e.getId()+" Not Found", HttpStatus.NOT_FOUND);
    }

}
