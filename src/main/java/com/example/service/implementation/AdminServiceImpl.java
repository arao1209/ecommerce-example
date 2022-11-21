package com.example.service.implementation;

import com.example.entity.Admin;
import com.example.exception.AdminNotFoundException;
import com.example.repository.AdminRepository;
import com.example.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public void addAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    @Override
    public List<Admin> getAllAdmin() {
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
        }
        else{
            throw new AdminNotFoundException(id);
        }
    }

    @Override
    public void deleteAdminName(int id) {

        Optional<Admin> adminOptionalDB = adminRepository.findById(id);
        if (adminOptionalDB.isPresent()){
            adminRepository.deleteById(id);
        }
        else{
            throw new AdminNotFoundException(id);
        }

    }
}
