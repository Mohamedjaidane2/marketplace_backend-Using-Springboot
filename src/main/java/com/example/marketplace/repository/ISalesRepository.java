package com.example.marketplace.repository;

import com.example.marketplace.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISalesRepository extends JpaRepository<Sales,Integer> {
}
