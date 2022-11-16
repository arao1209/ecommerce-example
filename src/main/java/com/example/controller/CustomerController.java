package com.example.controller;

import com.example.entity.Customer;
import com.example.service.CustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService; //Its beauty of spring-boot, through interface can access its implementation

    private static final Logger logger = LogManager.getLogger(CustomerController.class);

    @PostMapping(path = "ecommerce/v1/addCustomer")
    public ResponseEntity<Object> addCustomer(@Valid @RequestBody Customer customer){

        customerService.addCustomer(customer);

        logger.info("Customer added into Database, Customer Id {} ", customer.getId());

        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    // TODO : Need to implement Caching
    @GetMapping(path = "ecommerce/v1/getCustomerById")
    public ResponseEntity<Customer> getCustomerById(@RequestParam int id){

        logger.info("Fetching customer by id {} ",id);

        Customer customer = customerService.getCustomerById(id);

        return new ResponseEntity<>(customer, HttpStatus.FOUND);

    }

    @GetMapping(path = "ecommerce/v1/getAllCustomer")
    public ResponseEntity<List<Customer>> getAllCustomer(){

        List<Customer> customerList = customerService.getAllCustomer();

        return new ResponseEntity<>(customerList, HttpStatus.FOUND);
    }

    @PutMapping(path = "ecommerce/v1/updateCustomerByUserName")
    public ResponseEntity<Object> updateCustomer(@Valid @RequestBody Customer customer){

        customerService.updateCustomer(customer);

        logger.info("Updated customer and id is {} ",customer.getId());

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "ecommerce/v1/deleteCustomerById")
    public ResponseEntity<Object> deleteCustomerById(@RequestParam int id){

        customerService.deleteCustomerById(id);

        logger.info("Deleted customer by id {} ", id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
