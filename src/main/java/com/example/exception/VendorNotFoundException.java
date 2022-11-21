package com.example.exception;

public class VendorNotFoundException extends RuntimeException{

    private int id;
    public VendorNotFoundException(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }
}
