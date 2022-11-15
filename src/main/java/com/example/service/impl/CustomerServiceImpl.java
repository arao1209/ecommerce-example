package com.example.service.impl;

import com.example.entity.Customer;
import com.example.repository.CustomerRepository;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getCustomerById(int id){
       Optional<Customer> customer = customerRepository.findById(id);

       if(customer.isPresent()){
           return customer.get();
       }
       else{
           // need to implement exception here
           return new Customer();
       }

    }
}
