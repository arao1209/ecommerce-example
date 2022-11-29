package com.example.controller;

import com.example.entity.Customer;
import com.example.entity.Order;
import com.example.exception.OrderNotFoundException;
import com.example.exception.OrderStatusInvalidException;
import com.example.service.CustomerService;
import com.example.service.OrderService;
import com.example.util.Constant;
import lombok.extern.log4j.Log4j2;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Log4j2
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "ecommerce/v1/addOrder")
    public ResponseEntity<Object> addOrder(@Valid @RequestBody Order order){
        log.info("Add Order Request: {}",order.getId());
        orderService.addOrder(order);
        log.info("Order Added in DB: {}",order.getId());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "ecommerce/v1/getOrdersByCustomerId")
    public ResponseEntity<List<Order>> getOrdersByCustomerId(@RequestParam int customer_id){
        log.info("Get Order by customer id: {}",customer_id);

        return new ResponseEntity<>(orderService.getOrdersByCustomerId(customer_id), HttpStatus.FOUND);
    }

    @GetMapping(path = "ecommerce/v1/getOrdersByProductId")
    public ResponseEntity<List<Order>> getOrdersByProductId(@RequestParam int product_id){
        log.info("Get Order by product id: {}",product_id);
        return new ResponseEntity<>(orderService.getOrdersByProductId(product_id), HttpStatus.FOUND);
    }

    @GetMapping(path = "ecommerce/v1/getAllOrdersFromAllCustomers")
    public ResponseEntity<List<Order>> getAllOrdersFromAllCustomer(){
        log.info("Requested for all data from order table");
        List<Order> orderList = orderService.getAllOrdersFromAllCustomers();
        log.info("Data Fetched from Order Table in DB");
        return new ResponseEntity<>(orderList, HttpStatus.FOUND);
    }

    @GetMapping(path = "ecommerce/v1/sortOrdersByPriceByCustomerID")
    public ResponseEntity<List<Order>> sortOrdersByPriceByCustomerID(@RequestParam int customer_id, @RequestParam String sortValue, @RequestParam String sortType){
        Optional<Object> optionalOrder =  orderService.sortOrdersByPriceByCustomerID(customer_id, sortValue, sortType);

        List<Order> o;
        if(optionalOrder.isPresent()) {
             o = (List<Order>) optionalOrder.get();
        }
        else{
            o =new ArrayList<>();
        }
        return new ResponseEntity<>(o, HttpStatus.FOUND);
    }

    @GetMapping(path = "ecommerce/v1/getOrderCountPlacedByCustomer")
    public ResponseEntity<Object> getOrderCountPlacedByCustomer(@RequestParam int customer_id){

        Optional<Object> optionalOrder = orderService.getOrderCountPlacedByCustomer(customer_id);
        Customer customer = customerService.getCustomerById(customer_id);
        String customerFName = customer.getFName();
        HashMap<String, Integer> listHashMap = new HashMap<>();
        if (optionalOrder.isPresent()){
            List<Order> orderList = (List<Order>) optionalOrder.get();
            log.info("Total Order {} placed by Customer id {} ", orderList.size(), customer_id);
            listHashMap.put(customerFName, orderList.size());
        }
        return new ResponseEntity<>(listHashMap, HttpStatus.FOUND);

    }

    @GetMapping(path = "ecommerce/v1/getOrdersCountPlacedByAllCustomer")
    public ResponseEntity<HashMap<String, Integer>> getOrdersCountPlacedByAllCustomer(){

        HashMap<String, Integer> stringIntegerHashMap = orderService.getOrdersCountPlacedByAllCustomer();
        return new ResponseEntity<>(stringIntegerHashMap, HttpStatus.FOUND);
    }

    @PutMapping(path = "ecommerce/v1/updateOrderStatus")
    public ResponseEntity<Object> updateOrderStatus(@RequestParam String id, String status) {
        log.info("Update Order request: {}",id);
        Boolean flag = Constant.validOrderStatus().contains(status);
        log.info("Update order status: {}",status);
        Order order;
        if (Boolean.TRUE.equals(flag)){
            order = new Order();
            order.setId(id);
            order.setStatus(status);
            orderService.updateOrderStatus(order);
            log.info(" Order Status updated {} {}", id, status);
            return new ResponseEntity<>(order, HttpStatus.ACCEPTED);
        }
        else{
            log.error("Invalid order status {} {} ", id, status);
            throw new OrderStatusInvalidException(id, status);
        }

    }
}
