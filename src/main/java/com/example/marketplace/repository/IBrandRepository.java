package com.example.marketplace.repository;

import com.example.marketplace.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandRepository extends JpaRepository<Brand,Integer> {
}
