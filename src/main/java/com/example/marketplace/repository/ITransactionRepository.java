package com.example.marketplace.repository;

import com.example.marketplace.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransactionRepository extends JpaRepository<Transaction,Integer> {
}
