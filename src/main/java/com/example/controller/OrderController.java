package com.example.controller;

import com.example.entity.Order;
import com.example.exception.OrderNotFoundException;
import com.example.exception.OrderStatusInvalidException;
import com.example.service.OrderService;
import com.example.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(path = "ecommerce/v1/addOrder")
    public ResponseEntity<Object> addOrder(@Valid @RequestBody Order order){
        orderService.addOrder(order);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "ecommerce/v1/getOrdersByCustomerId")
    public ResponseEntity<List<Order>> getOrdersByCustomerId(@RequestParam int customer_id){
        return new ResponseEntity<>(orderService.getOrdersByCustomerId(customer_id), HttpStatus.FOUND);
    }

    @GetMapping(path = "ecommerce/v1/getOrdersByProductId")
    public ResponseEntity<List<Order>> getOrdersByProductId(@RequestParam int product_id){
        return new ResponseEntity<>(orderService.getOrdersByProductId(product_id), HttpStatus.FOUND);
    }

    @PutMapping(path = "ecommerce/v1/updateOrderStatus")
    public ResponseEntity<Object> updateOrderStatus(@RequestParam String id, String status) {

        Boolean flag = Constant.validOrderStatus().contains(status);
        Order order;
        if (Boolean.TRUE.equals(flag)){
            order = new Order();
            order.setId(id);
            order.setStatus(status);
            orderService.updateOrderStatus(order);
            return new ResponseEntity<>(order, HttpStatus.ACCEPTED);
        }
        else{
            throw new OrderStatusInvalidException(id, status);
        }

    }
}
