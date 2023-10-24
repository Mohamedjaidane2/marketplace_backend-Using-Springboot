package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.NotificationDtos.NotificationDto;
import com.example.marketplace.dto.NotificationDtos.NotificationNewDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.service.INotificationServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements INotificationServices {
    @Override
    public SuccessDto createNotification(NotificationNewDto notificationNewDto) {
        return null;
    }

    @Override
    public NotificationDto getNotificationById(Integer notificationId) {
        return null;
    }

    @Override
    public List<NotificationDto> getNotificationsByUserId(Integer userId) {
        return null;
    }

    @Override
    public SuccessDto markNotificationAsRead(Integer notificationId) {
        return null;
    }

    @Override
    public SuccessDto deleteNotification(Integer notificationId) {
        return null;
    }
}
