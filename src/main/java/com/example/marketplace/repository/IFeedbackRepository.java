package com.example.marketplace.repository;

import com.example.marketplace.entity.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFeedbackRepository extends JpaRepository<FeedBack,Integer> {
}
