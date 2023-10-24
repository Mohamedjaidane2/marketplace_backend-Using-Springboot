package com.example.marketplace.repository;

import com.example.marketplace.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubCategoryRepository extends JpaRepository<SubCategory,Integer> {
}
