package com.example.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity(name = "products")
@RequiredArgsConstructor
@Data
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "name")
    @NotEmpty
    private String name;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

//    @Override
//    public int compareTo(Product p){
//        if(getPrice() == 0.0 || p.getPrice() == 0.0) {
//            return 0;
//        }
//
//    }
}


