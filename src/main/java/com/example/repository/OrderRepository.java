package com.example.repository;

import com.example.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

    @Modifying
    @Query(value = "select * from orders o where o.customer_id = :customer_id", nativeQuery = true)
    List<Order> getOrdersByCustomerId(@Param(value = "customer_id") int customer_id);

    @Modifying
    @Query(value = "select * from orders o where o.product_id = :product_id", nativeQuery = true)
    List<Order> getOrdersByProductId(@Param(value = "product_id") int product_id);

}
