package com.example.service;


import com.example.entity.Admin;

import java.util.List;

public interface AdminService {

    void addAdmin(Admin admin);

    List<Admin> getAllAdmin();

    void updateAdminName(Admin admin);

    void deleteAdminName(int id);

}
