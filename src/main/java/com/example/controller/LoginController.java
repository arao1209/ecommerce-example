package com.example.controller;

import com.example.entity.Login;
import com.example.service.LoginService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Log4j2
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping(path = "ecommerce/v1/addUserCredentials")
    public ResponseEntity<Object> addUserCredentials(@Valid @RequestBody Login login){
        log.info("Login info request: {}",login.getId());
        loginService.addUserCredentials(login);
        log.info("Login info Added: {}",login.getId());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "ecommerce/v1/getAllUserCredentials")
    public ResponseEntity<List<Login>> getAllUserCredential(){
        log.info("list of Login User Info");
        return new ResponseEntity<>(loginService.getAllUserCredentials(), HttpStatus.FOUND);
    }
}
