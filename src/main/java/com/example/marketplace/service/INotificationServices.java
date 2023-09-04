package com.example.marketplace.service;

import com.example.marketplace.dto.SuccessDto;
import com.example.marketplace.dto.entitiesDto.NotificationDto;
import com.example.marketplace.entity.Notification;

import java.util.List;

public interface INotificationServices {
    SuccessDto createNotification(NotificationDto notificationDto);

    NotificationDto getNotificationById(Integer notificationId) ;

    List<NotificationDto> getNotificationsByUserId(Integer userId);
    SuccessDto markNotificationAsRead(Integer notificationId);

    SuccessDto deleteNotification(Integer notificationId);
}
