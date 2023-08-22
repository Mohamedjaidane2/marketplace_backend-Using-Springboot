package com.example.marketplace.repository;

import com.example.marketplace.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INotificationRepository extends JpaRepository<Notification,Integer> {
}
