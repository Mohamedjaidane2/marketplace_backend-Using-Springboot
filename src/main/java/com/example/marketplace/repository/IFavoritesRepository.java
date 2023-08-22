package com.example.marketplace.repository;

import com.example.marketplace.entity.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFavoritesRepository extends JpaRepository<Favorites,Integer> {
}
