package com.example.service.implementation;

import com.example.entity.Vendor;
import com.example.repository.VendorRepository;
import com.example.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    @Override
    public void addVendor(Vendor vendor) {
        vendorRepository.save(vendor);
    }

    @Override
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    @Override
    public void updateVendorName(Vendor vendor) {

        vendorRepository.save(vendor);
    }

    @Override
    public void deleteVendor(int id) {
        vendorRepository.deleteById(id);
    }
}
