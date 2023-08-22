package com.example.marketplace.repository;

import com.example.marketplace.entity.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdvertisementRepository extends JpaRepository<Advertisement,Integer> {
}
