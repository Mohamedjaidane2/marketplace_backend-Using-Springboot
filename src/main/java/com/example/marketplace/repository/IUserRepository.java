package com.example.marketplace.repository;

import com.example.marketplace.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {

    User findByEmail (String email);
}
