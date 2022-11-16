package com.example.service.implementation;

import com.example.entity.Admin;
import com.example.repository.AdminRepository;
import com.example.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void updateAdminName(Admin admin) {
        adminRepository.save(admin);
    }

    @Override
    public void deleteAdminName(int id) {
        adminRepository.deleteById(id);
    }
}
