package com.example.marketplace.repository;

import com.example.marketplace.entity.DiscountRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDiscountRequestRepository extends JpaRepository<DiscountRequest,Integer> {
}
