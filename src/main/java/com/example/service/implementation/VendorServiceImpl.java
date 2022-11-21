package com.example.service.implementation;

import com.example.entity.Vendor;
import com.example.exception.VendorNotFoundException;
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
    public void updateVendorName(int id, String name) {

        Optional<Vendor> vendorOptional = vendorRepository.findById(id);
        if(vendorOptional.isPresent()){
            Vendor vendorForDB = new Vendor();
            vendorForDB.setName(name);
            vendorRepository.save(vendorForDB);
        }
        else{
            throw new VendorNotFoundException(id);
        }
    }

    @Override
    // TODO : Handle key constraint violation exception
    public void deleteVendor(int id) {
        Optional<Vendor> vendorOptional = vendorRepository.findById(id);
        if(vendorOptional.isPresent()){
            vendorRepository.deleteById(id);
        }
        else{
            throw new VendorNotFoundException(id);
        }
    }
}
