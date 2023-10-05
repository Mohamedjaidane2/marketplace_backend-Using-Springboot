package com.example.marketplace.service;


import com.example.marketplace.dto.NotificationTemplateDtos.NotificationTemplateDto;
import com.example.marketplace.dto.NotificationTemplateDtos.NotificationTemplateNewDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;

import java.util.List;

public interface INotificationTemplateServices {

    SuccessDto createNotificationTemplate(NotificationTemplateNewDto template);
    NotificationTemplateDto getNotificationTemplateById(Integer templateId);
    List<NotificationTemplateDto> getAllNotificationTemplates();
    SuccessDto deleteNotificationTemplate(Integer templateId) ;
}

