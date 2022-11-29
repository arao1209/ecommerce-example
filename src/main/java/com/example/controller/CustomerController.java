package com.example.controller;

import com.example.entity.Customer;
import com.example.service.CustomerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Log4j2
@RestController
public class CustomerController {

    @Autowired
    CacheManager cacheManager;
    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "ecommerce/v1/addCustomer")
    public ResponseEntity<Object> addCustomer(@Valid @RequestBody Customer customer) {

        log.info("Customer add request received, Customer Id {} ", customer.getId());

        customerService.addCustomer(customer);

        log.info("Customer added into Database, Customer Id {} ", customer.getId());

        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping(path = "ecommerce/v1/getCustomerById")
    public ResponseEntity<Customer> getCustomerById(@RequestParam int id) {

        log.info("Fetching customer by id {} ", id);

        Customer customer = customerService.getCustomerById(id);

        return new ResponseEntity<>(customer, HttpStatus.FOUND);

    }

    @GetMapping(path = "ecommerce/v1/getAllCustomer")
    public ResponseEntity<List<Customer>> getAllCustomer() {

        List<Customer> customerList = customerService.getAllCustomer();

        log.info("Fetched All Customers from DB");

        return new ResponseEntity<>(customerList, HttpStatus.FOUND);
    }

    @PutMapping(path = "ecommerce/v1/updateCustomerByUserName")
    public ResponseEntity<Object> updateCustomer(@Valid @RequestBody Customer customer) {

        log.info("Update customer request received, and id is {} ", customer.getId());

        customerService.updateCustomer(customer);

        log.info("Updated customer and id is {} ", customer.getId());

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "ecommerce/v1/deleteCustomerById")
    public ResponseEntity<Object> deleteCustomerById(@RequestParam int id) {

        log.info("Customer delete request received...{} ", id);

        customerService.deleteCustomerById(id);

        log.info("Deleted customer by id {} ", id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "ecommerce/v1/clearCache")
    public ResponseEntity<Object> clearCache(@RequestParam String cacheName) {
        log.info("clear cache request received {}", cacheName);

        customerService.deleteAllCache(cacheName);
        log.info("cleared cache {}", cacheName);

        return new ResponseEntity<>("Cache Cleared", HttpStatus.NO_CONTENT);
    }

}
