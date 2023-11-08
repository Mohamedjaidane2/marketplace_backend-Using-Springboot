package com.example.marketplace.repository;

import com.example.marketplace.entity.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IAdvertisementRepository extends JpaRepository<Advertisement, Integer> {
    List<Advertisement> findAdvertisementByAccount_AccountId(Integer accountId);
}
