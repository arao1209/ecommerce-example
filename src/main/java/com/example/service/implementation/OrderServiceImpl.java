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
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Log4j2
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
    public List<Order> getAllOrdersFromAllCustomers(){
        log.info("In service layer");
        return orderRepository.getAllOrdersFromAllCustomers();
    }

    @Override
    public Optional<Object> sortOrdersByPriceByCustomerID(int customer_id, String sortValue, String sortType){

        List<Order> orderList;
        if(sortType.equals("ASC")){
            orderList = getOrdersByCustomerId(customer_id);
            Collections.sort(orderList);
            return Optional.of(orderList);
        }
        else if(sortType.equals("DESC")){
            orderList = getOrdersByCustomerId(customer_id);
            Comparator<Order> orderComparator = new Comparator<Order>() {
                @Override
                public int compare(Order o1, Order o2) {
                    if(o1.getProduct() == null || o2.getProduct() == null){
                        return 0;
                    }
                    else if(o1.getProduct().getPrice() > o2.getProduct().getPrice()){
                        return -1;
                    }
                    else{
                        return 1;
                    }
                }
            };
            Collections.sort(orderList, orderComparator);
            return Optional.of(orderList);
        }
        else{
            log.info("Invalid sort type");
        }
        return Optional.empty();
    }

    @Override
    public Optional<Object> getOrderCountPlacedByCustomer(int customer_id) {

        List<Order> orderList = orderRepository.getOrdersByCustomerId(customer_id);

        return Optional.of(orderList);
    }

    @Override
    public HashMap<String, Integer> getOrdersCountPlacedByAllCustomer(){

        List<Order> allCustomerOrderList = orderRepository.getAllOrdersFromAllCustomers();
        HashMap<String, Integer> orderAndCustomer = new HashMap<>();

        for(int i=0;i<allCustomerOrderList.size();i++){

            Order order = allCustomerOrderList.get(i);

//                Integer count = orderAndCustomer.get(order.getCustomer().getFName());
//                if(count == null){
//                    orderAndCustomer.put(order.getCustomer().getFName(), 1);
//                }
//                else{
//                    orderAndCustomer.put(order.getCustomer().getFName(), count+1);
//                }

            if(orderAndCustomer.containsKey(order.getCustomer().getFName())){
                orderAndCustomer.put(order.getCustomer().getFName(), 1+(orderAndCustomer.get(order.getCustomer().getFName())));
            }
            else{
                orderAndCustomer.put(order.getCustomer().getFName(), 1);
            }
        }
        return orderAndCustomer;
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
