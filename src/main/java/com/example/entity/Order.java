package com.example.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.UUID;

@Entity(name = "orders")
@JsonInclude(JsonInclude.Include.NON_NULL)
@RequiredArgsConstructor
@Data

public class Order implements Comparable<Order> {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "status")
    @NotEmpty(message = "status length should be > 0")
    @Size(min = 5, max = 15, message = "Status length must be between 5 to 15")
    private String status;

    @OneToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;

    @Override
    public int compareTo(Order o){

        if(this.getProduct() == null || o.getProduct() == null){
            return 0;
        }
        if(this.getProduct().getPrice()>o.getProduct().getPrice()){
            return 1;
        }
        else return -1;
    }
}
