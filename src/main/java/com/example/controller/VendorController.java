package com.example.controller;

import com.example.entity.Vendor;
import com.example.service.VendorService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Log4j2
@RestController
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @PostMapping(path = "ecommerce/v1/addVendor")
    public ResponseEntity<Object> addVendor(@Valid @RequestBody Vendor vendor){
        log.info("Add vendor request id {}", vendor.getId());
        vendorService.addVendor(vendor);
        log.info("Vendor Added id {} name {}", vendor.getId(), vendor.getName());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }

    @GetMapping(path = "ecommerce/v1/getAllVendor")
    public ResponseEntity<List<Vendor>> getAllVendor(){

        log.info("All Vendor listed");

        return new ResponseEntity<>(vendorService.getAllVendors(), HttpStatus.FOUND);

    }

    @PatchMapping(path = "ecommerce/v1/updateVendorName")
    public ResponseEntity<Object> updateVendorName(@RequestParam int id, @RequestParam String name){
        log.info("Update vendor request id {} name {}", id, name);

        vendorService.updateVendorName(id, name);

        log.info("Updated vendor  id {} name {}", id, name);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "ecommerce/v1/deleteVendorName")
    public ResponseEntity<Object> deleteVendor(@RequestParam int id){
        log.info("Delete vendor request id {} ", id);

        vendorService.deleteVendor(id);
        log.info("Deleted vendor id {} ", id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
