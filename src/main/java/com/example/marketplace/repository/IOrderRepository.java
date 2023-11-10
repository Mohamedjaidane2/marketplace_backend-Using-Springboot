package com.example.marketplace.repository;

import com.example.marketplace.entity.Account;
import com.example.marketplace.entity.Advertisement;
import com.example.marketplace.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order,Integer> {
    boolean existsByAccountAndAdvertisement(Account account, Advertisement advertisement);
}
