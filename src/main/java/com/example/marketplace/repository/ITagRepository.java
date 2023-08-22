package com.example.marketplace.repository;

import com.example.marketplace.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITagRepository extends JpaRepository<Tag,Integer> {
}
