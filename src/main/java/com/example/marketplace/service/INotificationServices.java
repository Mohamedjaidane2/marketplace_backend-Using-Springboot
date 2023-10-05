package com.example.marketplace.service;

import com.example.marketplace.dto.NotificationDtos.NotificationDto;
import com.example.marketplace.dto.NotificationDtos.NotificationNewDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;

import java.util.List;

public interface INotificationServices {
    SuccessDto createNotification(NotificationNewDto notificationNewDto);

    NotificationDto getNotificationById(Integer notificationId) ;

    List<NotificationDto> getNotificationsByUserId(Integer userId);

    SuccessDto markNotificationAsRead(Integer notificationId);

    SuccessDto deleteNotification(Integer notificationId);
}
