package com.example.marketplace.repository;

import com.example.marketplace.entity.Information;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInformationRepository extends JpaRepository<Information,Integer> {
}
