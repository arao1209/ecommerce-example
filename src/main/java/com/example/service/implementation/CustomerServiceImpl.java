package com.example.service.implementation;

import com.example.entity.Customer;
import com.example.repository.CustomerRepository;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void addCustomer(Customer customer){

        customerRepository.save(customer);

    }

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

    @Override
    public List<Customer> getAllCustomer(){

        List<Customer> customerList =  customerRepository.findAll();

        return customerList;
    }

    @Override
    public void updateCustomer(Customer customer){

        customerRepository.save(customer);

    }

    @Override
    public void deleteCustomerById(int id){

        customerRepository.deleteById(id);

    }
}
