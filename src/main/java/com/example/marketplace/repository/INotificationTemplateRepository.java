package com.example.marketplace.repository;

import com.example.marketplace.entity.NotificationTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INotificationTemplateRepository extends JpaRepository<NotificationTemplate,Integer> {
}
