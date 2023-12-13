package com.example.marketplace.repository;

import com.example.marketplace.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {
    Optional<Category> findByCategoryName (String name);
}
