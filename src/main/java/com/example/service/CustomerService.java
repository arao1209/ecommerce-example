package com.example.service;

import com.example.entity.Customer;

import java.util.List;

public interface CustomerService {

    void addCustomer(Customer customer);

    Customer getCustomerById(int id);

    List<Customer> getAllCustomer();

    void updateCustomer(Customer customer);

    void deleteCustomerById(int id);

}
