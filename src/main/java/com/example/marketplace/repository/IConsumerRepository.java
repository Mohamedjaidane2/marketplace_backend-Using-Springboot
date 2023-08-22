package com.example.marketplace.repository;

import com.example.marketplace.entity.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConsumerRepository extends JpaRepository<Consumer,Integer> {
}
