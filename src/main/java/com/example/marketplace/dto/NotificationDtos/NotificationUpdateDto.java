package com.example.marketplace.dto.NotificationDtos;

import com.example.marketplace.dto.NotificationTemplateDtos.NotificationTemplateDto;
import com.example.marketplace.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class NotificationUpdateDto {

    private String content;

    private boolean read;

    private User user;

    private NotificationTemplateDto template;
}
