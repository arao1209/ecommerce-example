package com.example.service.implementation;

import com.example.entity.Admin;
import com.example.exception.AdminNotFoundException;
import com.example.repository.AdminRepository;
import com.example.service.AdminService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public void addAdmin(Admin admin) {

        adminRepository.save(admin);
        log.info("Admin info added to repository");
    }

    @Override
    public List<Admin> getAllAdmin() {
        log.info("All admin list fetched from repository");

        return adminRepository.findAll();

    }

    @Override
    public void updateAdminName(int id, String name) {

        Optional<Admin> adminOptionalDB = adminRepository.findById(id);

        if (adminOptionalDB.isPresent()){
            Admin adminToSetInDB = new Admin();
            adminToSetInDB.setId(id);
            adminToSetInDB.setName(name);
            adminRepository.save(adminToSetInDB);
            log.info("Admin updated to repository");

        }
        else{
            log.error("Admin id {} not found in DB", id);
            throw new AdminNotFoundException(id);
        }
    }

    @Override
    public void deleteAdminName(int id) {

        Optional<Admin> adminOptionalDB = adminRepository.findById(id);
        if (adminOptionalDB.isPresent()){
            adminRepository.deleteById(id);
            log.error("Admin id {} deleted from repository", id);

        }
        else{
            log.error("Admin id {} not found in DB", id);
            throw new AdminNotFoundException(id);
        }

    }
}
