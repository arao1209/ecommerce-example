package com.example.controller;


import com.example.entity.Customer;
import com.example.service.CustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService; //Its beauty of spring-boot, through interface can access its implementation

    private static final Logger logger = LogManager.getLogger(CustomerController.class);

    @GetMapping(path = "ecommerce/v1/getCustomerById")
    public Customer getCustomerById(Customer customer){

        return customerService.getCustomerById(customer.getId());

    }

}
