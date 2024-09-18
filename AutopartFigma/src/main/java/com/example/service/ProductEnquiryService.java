package com.example.service;

import com.example.ProductEnquiry;
import com.example.repository.ProductEnquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductEnquiryService {

    @Autowired
    private ProductEnquiryRepository repository;

    public ProductEnquiry saveProductEnquiry(ProductEnquiry productEnquiry) {
        return repository.save(productEnquiry);
    }
}
