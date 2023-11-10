package com.example.marketplace.repository;

import com.example.marketplace.entity.Address;
import com.example.marketplace.entity.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IInformationRepository extends JpaRepository<Information,Integer> {

}
