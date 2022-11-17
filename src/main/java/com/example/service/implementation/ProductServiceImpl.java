package com.example.service.implementation;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public List<Product> getProductsByVendorId(int id){
        return productRepository.getProductsByVendorId(id);
    }

    @Override
    @Transactional
    public void updateProductName(Product product) {
            productRepository.updateProductName(product.getName(), product.getId());
    }

    @Override
    @Transactional
    public void updateProductPrice(Product product) {
        productRepository.updateProductPrice(product.getPrice(), product.getId());
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
