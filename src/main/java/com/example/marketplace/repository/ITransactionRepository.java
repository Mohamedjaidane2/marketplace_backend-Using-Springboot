package com.example.marketplace.repository;

import com.example.marketplace.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITransactionRepository extends JpaRepository<Transaction,Integer> {

}
