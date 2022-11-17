package com.example.controller;

import com.example.entity.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(path = "ecommerce/v1/addProduct")
    public void addProducts(@Valid @RequestBody Product product){
        productService.addProduct(product);
    }

    @GetMapping(path = "ecommerce/v1/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.FOUND);
    }

    @GetMapping(path = "ecommerce/v1/getProductByVendorId")
    public ResponseEntity<List<Product>> getProductByVendorId(@RequestParam int vendor_id){

        return new ResponseEntity<>(productService.getProductsByVendorId(vendor_id), HttpStatus.FOUND);

    }

    @PatchMapping(path = "ecommerce/v1/updateProductName")
    public ResponseEntity<Object> updateProductName(@RequestParam String name, @RequestParam int id){

        Product product = new Product();

        product.setId(id);
        product.setName(name);

        productService.updateProductName(product);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }

    @PatchMapping(path = "ecommerce/v1/updateProductPrice")
    public ResponseEntity<Object> updateProductPrice(@RequestParam double price, @RequestParam int id){

        Product product = new Product();
        product.setPrice(price);
        product.setId(id);

        productService.updateProductPrice(product);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "ecommerce/v1/deleteProduct")
    public ResponseEntity<Object> deleteProduct(@RequestParam int id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
