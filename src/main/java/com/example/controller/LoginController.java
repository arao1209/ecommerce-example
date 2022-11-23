package com.example.controller;

import com.example.entity.Login;
import com.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping(path = "ecommerce/v1/addUserCredentials")
    public ResponseEntity<Object> addUserCredentials(@Valid @RequestBody Login login){
        loginService.addUserCredentials(login);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "ecommerce/v1/getAllUserCredentials")
    public ResponseEntity<List<Login>> getAllUserCredential(){
        return new ResponseEntity<>(loginService.getAllUserCredentials(), HttpStatus.FOUND);
    }
}
