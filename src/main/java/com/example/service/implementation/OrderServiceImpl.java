package com.example.service.implementation;

import com.example.entity.Order;
import com.example.repository.OrderRepository;
import com.example.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

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
        return orderRepository.getOrdersByCustomerId(customer_id);
    }

    @Override
    public List<Order> getOrdersByProductId(int product_id){
        return orderRepository.getOrdersByProductId(product_id);
    }

    @Override
    public void updateOrderStatus(Order order) {

        Optional<Order> orderOptionalFromDB = orderRepository.findById(order.getId());

        if(orderOptionalFromDB.isPresent()){
            Order updatedOrder = orderOptionalFromDB.get();
            updatedOrder.setStatus(order.getStatus());
            orderRepository.save(updatedOrder);
        }
        // TODO : if not present put exception

    }

    @Override
    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }
}
