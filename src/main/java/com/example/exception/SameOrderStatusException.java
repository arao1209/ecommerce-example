package com.example.exception;

import com.example.entity.Order;

public class SameOrderStatusException extends RuntimeException{

    private Order order;

    public SameOrderStatusException(Order order){
        this.order = order;
    }

    public Order getOrder(){
        return order;
    }



}
