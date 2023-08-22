package com.example.marketplace.repository;

import com.example.marketplace.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepository extends JpaRepository<Admin,Integer> {
}
