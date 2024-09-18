package com.example.repository;

import com.example.ProductEnquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductEnquiryRepository extends JpaRepository<ProductEnquiry, Long> {
}
