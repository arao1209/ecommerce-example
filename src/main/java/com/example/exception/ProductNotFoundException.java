package com.example.exception;

public class ProductNotFoundException extends RuntimeException{

    private int id;
    public ProductNotFoundException(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

}
