package com.example.service;

import com.example.entity.Product;

import java.util.List;

public interface ProductService {

    void addProduct(Product product);

    List<Product> getAllProducts();

    List<Product> getProductsByVendorId(int id);

    void updateProductName(Product product);

    void updateProductPrice(Product product);

    void deleteProduct(int id);

}
