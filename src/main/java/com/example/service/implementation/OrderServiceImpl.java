package com.example.service.implementation;

import com.example.entity.Customer;
import com.example.entity.Order;
import com.example.entity.Product;
import com.example.exception.CustomerNotFoundException;
import com.example.exception.OrderNotFoundException;
import com.example.exception.ProductNotFoundException;
import com.example.exception.SameOrderStatusException;
import com.example.repository.CustomerRepository;
import com.example.repository.OrderRepository;
import com.example.repository.ProductRepository;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void addOrder(Order order) {

        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        order.setId(uuidAsString);
        orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getOrdersByCustomerId(int customer_id) {

        Optional<Customer> customer = customerRepository.findById(customer_id);
        if(customer.isPresent()) {
            return orderRepository.getOrdersByCustomerId(customer_id);
        }
        else {
            throw new CustomerNotFoundException(customer_id);
        }
    }

    @Override
    public List<Order> getOrdersByProductId(int product_id){

        Optional<Product> productOptionalFromDB = productRepository.findById(product_id);
        if(productOptionalFromDB.isPresent()){
            return orderRepository.getOrdersByProductId(product_id);
        }
        else{
            throw new ProductNotFoundException(product_id);
        }
    }

    @Override
    public void updateOrderStatus(Order order) {

        Optional<Order> orderOptionalFromDB = orderRepository.findById(order.getId());

        try{
            if(orderOptionalFromDB.isPresent()){

                Order updatedOrder = orderOptionalFromDB.get();

                if(updatedOrder.getStatus().equals(order.getStatus())){

                    throw new SameOrderStatusException(order);
                }

                updatedOrder.setStatus(order.getStatus());
                orderRepository.save(updatedOrder);
            }
            else{

                throw new OrderNotFoundException(order.getId());
            }
        }
        catch (OrderNotFoundException e){

            // TODO : Logger
            throw new OrderNotFoundException(order.getId());

        }
        catch (SameOrderStatusException e){
            throw new SameOrderStatusException(order);

        }




    }

    @Override
    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }
}
