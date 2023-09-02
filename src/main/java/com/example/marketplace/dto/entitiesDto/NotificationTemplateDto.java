package com.example.marketplace.dto.entitiesDto;

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

    private Integer notificationTemplate;

    private String type;

    private String subjectTemplate;

    private String bodyTemplate;

    private List<NotificationDto> notifications;

    @Override
    public String toString() {
        return "NotificationTemplateDto{" +
                "notificationTemplate=" + notificationTemplate +
                ", type='" + type + '\'' +
                ", subjectTemplate='" + subjectTemplate + '\'' +
                ", bodyTemplate='" + bodyTemplate + '\'' +
                ", notifications=" + notifications +
                '}';
    }

    public static NotificationTemplateDto customMapping (NotificationTemplate template){
        return NotificationTemplateDto.builder()
                .notificationTemplate(template.getNotificationTemplate())
                .type(template.getType())
                .subjectTemplate(template.getSubjectTemplate())
                .bodyTemplate(template.getBodyTemplate())
                .notifications(NotificationDto.customListMapping(template.getNotifications()))
                .build();
    }

}
