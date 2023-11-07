package com.example.marketplace.repository;

import com.example.marketplace.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ITagRepository extends JpaRepository<Tag,Integer> {
    Optional<Tag> findByTagName(String Name);
}
