package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.SuccessDto;
import com.example.marketplace.dto.entitiesDto.NotificationTemplateDto;
import com.example.marketplace.service.INotificationTemplateServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationTemplateServiceImpl implements INotificationTemplateServices {
    @Override
    public SuccessDto createNotificationTemplate(NotificationTemplateDto template) {
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
