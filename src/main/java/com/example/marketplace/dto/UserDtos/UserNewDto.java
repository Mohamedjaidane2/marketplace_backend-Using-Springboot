package com.example.marketplace.dto.UserDtos;

import com.example.marketplace.dto.NotificationDtos.NotificationDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    private String loginStatus;

    @JsonIgnore
    private Date creationDate;

    @JsonIgnore
    private List<NotificationDto> notifications;
}
