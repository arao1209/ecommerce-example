package com.example.service;

import com.example.entity.Vendor;

import java.util.List;

public interface VendorService {

        void addVendor(Vendor vendor);

        List<Vendor> getAllVendors();

        void updateVendorName(int id, String name);

        void deleteVendor(int id);

}

