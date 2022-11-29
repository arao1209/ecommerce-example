package com.example.controller;

import com.example.entity.Admin;
import com.example.service.AdminService;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Log4j2
@RestController
public class AdminController {

//    private static final Logger logger = LogManager.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    @PostMapping(path = "ecommerce/v1/addAdmin")
    public ResponseEntity<Object> addAdmin(@Valid @RequestBody Admin admin){
        log.info("Admin ID and Name request received...{} {}", admin.getId(), admin.getName());
        adminService.addAdmin(admin);
        log.info("Admin ID, Name added to db {} ",admin.getId());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "ecommerce/v1/getAllAdmin")
    public ResponseEntity<List<Admin>> getAllAdmin(){
        log.info("All Admin Listed from DB...");
        return new ResponseEntity<>(adminService.getAllAdmin(), HttpStatus.FOUND);
    }

    @PatchMapping(path = "ecommerce/v1/updateAdminName")
    public ResponseEntity<Object> updateAdminName(@RequestParam int id, @RequestParam String name){
        log.info("Admin Name update request received...{} ",id);
        adminService.updateAdminName(id, name);
        log.info("Admin Name updated in DB...{} {}",id,name);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "ecommerce/v1/deleteAdminName")
    public ResponseEntity<Object> deleteAdminName(@RequestParam int id){
        log.info("Admin delete request received...{} ",id);
        adminService.deleteAdminName(id);
        log.warn("Admin deleted in DB..{} ",id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
