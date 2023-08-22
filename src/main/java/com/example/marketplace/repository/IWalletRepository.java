package com.example.marketplace.repository;

import com.example.marketplace.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWalletRepository extends JpaRepository<Wallet,Integer> {
}
