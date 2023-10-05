package com.example.marketplace.dto.NotificationTemplateDtos;

import com.example.marketplace.dto.NotificationDtos.NotificationDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class NotificationTemplateNewDto {

    private String type;

    private String subjectTemplate;

    private String bodyTemplate;

    private List<NotificationDto> notifications;
}
