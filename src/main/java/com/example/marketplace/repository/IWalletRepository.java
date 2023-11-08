package com.example.marketplace.repository;

import com.example.marketplace.dto.WalletDtos.WalletDto;
import com.example.marketplace.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IWalletRepository extends JpaRepository<Wallet,Integer> {
    Optional<Wallet> findByAccount_AccountId(Integer id);
}
