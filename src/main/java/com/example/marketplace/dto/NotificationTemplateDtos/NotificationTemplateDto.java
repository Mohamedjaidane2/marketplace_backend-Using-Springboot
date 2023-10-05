package com.example.marketplace.dto.NotificationTemplateDtos;

import com.example.marketplace.dto.NotificationDtos.NotificationDto;
import com.example.marketplace.entity.Notification;
import com.example.marketplace.entity.NotificationTemplate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class NotificationTemplateDto {

    private Integer notificationTemplateId;

    private String type;

    private String subjectTemplate;

    private String bodyTemplate;

    private List<NotificationDto> notifications;

    @Override
    public String toString() {
        return "NotificationTemplateDto{" +
                "notificationTemplate=" + notificationTemplateId +
                ", type='" + type + '\'' +
                ", subjectTemplate='" + subjectTemplate + '\'' +
                ", bodyTemplate='" + bodyTemplate + '\'' +
                ", notifications=" + notifications +
                '}';
    }

    public static NotificationTemplateDto customMapping (NotificationTemplate template){
        return NotificationTemplateDto.builder()
                .notificationTemplateId(template.getNotificationTemplate())
                .type(template.getType())
                .subjectTemplate(template.getSubjectTemplate())
                .bodyTemplate(template.getBodyTemplate())
                .notifications(NotificationDto.customListMapping(template.getNotifications()))
                .build();
    }

}
