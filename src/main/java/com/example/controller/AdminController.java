package com.example.controller;

import com.example.entity.Admin;
import com.example.service.AdminService;
import com.example.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping(path = "ecommerce/v1/addAdmin")
    public ResponseEntity<Object> addAdmin(@Valid @RequestBody Admin admin){
        adminService.addAdmin(admin);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "ecommerce/v1/getAllAdmin")
    public ResponseEntity<List<Admin>> getAllAdmin(){
        return new ResponseEntity<>(adminService.getAllAdmin(), HttpStatus.FOUND);
    }

    @PatchMapping(path = "ecommerce/v1/updateAdminName")
    public ResponseEntity<Object> updateAdminName(@Valid @RequestBody Admin admin){
        adminService.updateAdminName(admin);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "ecommerce/v1/deleteAdminName")
    public ResponseEntity<Object> deleteAdminName(@RequestParam int id){
        adminService.deleteAdminName(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
