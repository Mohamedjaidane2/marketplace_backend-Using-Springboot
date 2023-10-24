package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.NotificationTemplateDtos.NotificationTemplateDto;
import com.example.marketplace.dto.NotificationTemplateDtos.NotificationTemplateNewDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.service.INotificationTemplateServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationTemplateServiceImpl implements INotificationTemplateServices {
    @Override
    public SuccessDto createNotificationTemplate(NotificationTemplateNewDto template) {
        return null;
    }

    @Override
    public NotificationTemplateDto getNotificationTemplateById(Integer templateId) {
        return null;
    }

    @Override
    public List<NotificationTemplateDto> getAllNotificationTemplates() {
        return null;
    }

    @Override
    public SuccessDto deleteNotificationTemplate(Integer templateId) {
        return null;
    }
}
