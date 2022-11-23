package com.example.service;

import com.example.entity.Login;

import java.util.List;

public interface LoginService {

    void addUserCredentials(Login login);

    List<Login> getAllUserCredentials();

}
