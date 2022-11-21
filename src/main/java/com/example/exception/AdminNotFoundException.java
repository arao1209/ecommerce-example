package com.example.exception;

public class AdminNotFoundException extends RuntimeException{

    private int id;

    public AdminNotFoundException(int id){
        this.id = id;
    }

    public int getId(){
        return id;

    }
}
