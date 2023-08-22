package com.example.marketplace.repository;

import com.example.marketplace.entity.RequestedDiscount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRequestedDiscountRepository extends JpaRepository<RequestedDiscount,Integer> {
}
