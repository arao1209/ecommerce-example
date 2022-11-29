package com.example.service;
import com.example.entity.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface OrderService {

    void addOrder(Order order);

    List<Order> getAllOrder();

    List<Order> getOrdersByCustomerId(int customer_id);

    List<Order> getOrdersByProductId(int product_id);

    List<Order> getAllOrdersFromAllCustomers();

    Optional<Object> sortOrdersByPriceByCustomerID(int customer_id, String sortValue, String sortType);

    Optional<Object> getOrderCountPlacedByCustomer(int customer_id);

    HashMap<String, Integer> getOrdersCountPlacedByAllCustomer();

    void updateOrderStatus(Order order);

    void deleteOrder(String id);

}
