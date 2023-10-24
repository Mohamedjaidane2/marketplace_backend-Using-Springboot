package com.example.marketplace.dto.UserDtos;

import com.example.marketplace.dto.NotificationDtos.NotificationDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserNewDto {

    private String password;

    private String email;

    private String loginStatus;

    private Date creationDate;

    private List<NotificationDto> notifications;
}
