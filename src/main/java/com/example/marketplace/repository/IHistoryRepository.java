package com.example.marketplace.repository;

import com.example.marketplace.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHistoryRepository extends JpaRepository<History,Integer> {
}
