package com.example.marketplace.repository;

import com.example.marketplace.entity.RequestOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRequestOrderRepository extends JpaRepository<RequestOrder,Integer> {
}
