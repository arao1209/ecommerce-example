package com.example.exception;

public class CustomerNotFoundException extends RuntimeException{

    private int id;

    public CustomerNotFoundException(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }
}
