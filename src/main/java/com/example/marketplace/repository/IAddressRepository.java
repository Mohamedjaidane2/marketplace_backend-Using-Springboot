package com.example.marketplace.repository;

import com.example.marketplace.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address,Integer> {
}
