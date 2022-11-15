package com.example.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity(name = "orders")
public class Order {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "status")
    @NotEmpty(message = "status length should be > 0")
    @Size(min = 5, max = 15, message = "Status length must be between 5 to 15")
    private String status;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Order() {
    }

    public Order(String id, String status, Customer customer) {
        this.id = id;
        this.status = status;
        this.customer = customer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
