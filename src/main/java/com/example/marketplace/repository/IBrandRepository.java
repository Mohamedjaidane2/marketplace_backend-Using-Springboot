package com.example.marketplace.repository;

import com.example.marketplace.entity.Brand;
import com.example.marketplace.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IBrandRepository extends JpaRepository<Brand,Integer> {
    Optional<Brand> findByBrandName(String Name);
}
