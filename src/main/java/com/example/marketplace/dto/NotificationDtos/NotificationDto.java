package com.example.marketplace.dto.NotificationDtos;

import com.example.marketplace.dto.NotificationTemplateDtos.NotificationTemplateDto;
import com.example.marketplace.entity.Information;
import com.example.marketplace.entity.Notification;
import com.example.marketplace.entity.NotificationTemplate;
import com.example.marketplace.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class NotificationDto {
    private Integer notificationId;

    private String content;

    private boolean read;

    private User user;

    private NotificationTemplateDto template;

    public static List<NotificationDto> customListMapping(List<Notification> notifications) {
    return (List<NotificationDto>) NotificationDto.builder().build();
    }

    @Override
    public String toString() {
        return "NotificationDto{" +
                "notificationId=" + notificationId +
                ", content='" + content + '\'' +
                ", read=" + read +
                ", user=" + user +
                ", template=" + template +
                '}';
    }

    public static NotificationDto customMapping (Notification notification){
        return NotificationDto.builder()
                .notificationId(notification.getNotificationId())
                .content(notification.getContent())
                .read(notification.isRead())
                .user(notification.getUser())
                .template(NotificationTemplateDto.customMapping(notification.getTemplate()))
                .build();
    }
}
