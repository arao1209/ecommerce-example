package com.example.exception;

public class OrderStatusInvalidException extends RuntimeException{

    private String status;
    private String id;

    public OrderStatusInvalidException(String id, String status){
        this.id = id;
        this.status = status;
    }

   public String getStatus(){
        return status;
   }

   public String getId(){
        return id;
   }

}

