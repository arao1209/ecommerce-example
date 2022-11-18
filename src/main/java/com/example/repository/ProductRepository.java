package com.example.repository;

import com.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Modifying
    @Query("update products p set p.name = :name where id = :id")
    void updateProductName(@Param(value = "name") String name, @Param(value = "id") int id);

    @Modifying
    @Query("update products p set p.price = :price where id = :id")
    void updateProductPrice(@Param(value = "price") double price, @Param(value = "id") int id);

    @Modifying
    @Query(value = "select * from products where vendor_id = :id", nativeQuery = true)
    List<Product> getProductsByVendorId(@Param(value = "id") int id);
}
