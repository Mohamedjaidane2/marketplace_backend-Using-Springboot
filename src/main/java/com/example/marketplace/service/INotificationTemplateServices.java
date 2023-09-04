package com.example.marketplace.service;

import com.example.marketplace.dto.SuccessDto;
import com.example.marketplace.dto.entitiesDto.NotificationTemplateDto;

import java.util.List;

public interface INotificationTemplateServices {

    SuccessDto createNotificationTemplate(NotificationTemplateDto template);
    NotificationTemplateDto getNotificationTemplateById(Integer templateId);
    List<NotificationTemplateDto> getAllNotificationTemplates();
    SuccessDto deleteNotificationTemplate(Integer templateId) ;
}

