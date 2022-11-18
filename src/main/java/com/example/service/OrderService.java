package com.example.service;
import com.example.entity.Order;

import java.util.List;

public interface OrderService {

    void addOrder(Order order);

    List<Order> getAllOrder();

    List<Order> getOrdersByCustomerId(int customer_id);

    List<Order> getOrdersByProductId(int product_id);

    void updateOrderStatus(Order order);

    void deleteOrder(String id);

}
