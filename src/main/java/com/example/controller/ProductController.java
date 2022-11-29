package com.example.controller;

import com.example.entity.Product;
import com.example.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Log4j2
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(path = "ecommerce/v1/addProduct")
    public void addProducts(@Valid @RequestBody Product product){
        log.info("Add Product Request {}", product.getId());
        productService.addProduct(product);
        log.info("Product Added {}", product.getId());
    }

    @GetMapping(path = "ecommerce/v1/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts(){
        log.info("All product fetched from DB");
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.FOUND);
    }

    @GetMapping(path = "ecommerce/v1/getProductByVendorId")
    public ResponseEntity<List<Product>> getProductByVendorId(@RequestParam int vendor_id){
        log.info("get product based on vendor id {}", vendor_id);
        return new ResponseEntity<>(productService.getProductsByVendorId(vendor_id), HttpStatus.FOUND);
    }

    @PatchMapping(path = "ecommerce/v1/updateProductName")
    public ResponseEntity<Object> updateProductName(@RequestParam String name, @RequestParam int id){
        log.info("Update Product Name request id {} name {}", id, name);

        Product product = new Product();

        product.setId(id);
        product.setName(name);
        log.info("Product Name Updated id {} name {}", id, name);

        productService.updateProductName(product);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }

    @PatchMapping(path = "ecommerce/v1/updateProductPrice")
    public ResponseEntity<Object> updateProductPrice(@RequestParam double price, @RequestParam int id){
        log.info("Update Product price request id {} price {}", id, price);

        Product product = new Product();
        product.setPrice(price);
        product.setId(id);

        productService.updateProductPrice(product);
        log.info("Product Price Updated id {} price {}", id, price);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "ecommerce/v1/deleteProduct")
    public ResponseEntity<Object> deleteProduct(@RequestParam int id){
        log.info("Product Delete request id {}", id);

        productService.deleteProduct(id);
        log.info("Product Deleted id {}", id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
