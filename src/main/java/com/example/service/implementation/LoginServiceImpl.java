package com.example.service.implementation;

import com.example.entity.Login;
import com.example.repository.LoginRepository;
import com.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepository;


    @Override
    public void addUserCredentials(Login login) {
        loginRepository.save(login);
    }

    @Override
    public List getAllUserCredentials() {
        return loginRepository.findAll();
    }
}
