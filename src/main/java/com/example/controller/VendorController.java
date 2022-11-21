package com.example.controller;

import com.example.entity.Vendor;
import com.example.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @PostMapping(path = "ecommerce/v1/addVendor")
    public ResponseEntity<Object> addVendor(@Valid @RequestBody Vendor vendor){

        vendorService.addVendor(vendor);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }

    @GetMapping(path = "ecommerce/v1/getAllVendor")
    public ResponseEntity<List<Vendor>> getAllVendor(){

        return new ResponseEntity<>(vendorService.getAllVendors(), HttpStatus.FOUND);

    }

    @PatchMapping(path = "ecommerce/v1/updateVendorName")
    public ResponseEntity<Object> updateVendorName(@RequestParam int id, @RequestParam String name){

        vendorService.updateVendorName(id, name);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "ecommerce/v1/deleteVendorName")
    public ResponseEntity<Object> deleteVendor(@RequestParam int id){

        vendorService.deleteVendor(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
