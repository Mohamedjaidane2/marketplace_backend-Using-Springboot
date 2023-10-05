package com.example.marketplace.dto.UserDtos;

import com.example.marketplace.dto.NotificationDtos.NotificationDto;
import com.example.marketplace.entity.Notification;
import com.example.marketplace.entity.Transaction;
import com.example.marketplace.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserDto {
    private Integer id;

    private String password;

    private String email;

    private String loginStatus;

    private Date creationDate;

    private List<NotificationDto> notifications;

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", loginStatus='" + loginStatus + '\'' +
                ", creationDate=" + creationDate +
                ", notifications=" + notifications +
                '}';
    }
    public static UserDto customMapping (User user){
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .loginStatus(user.getLoginStatus())
                .creationDate(user.getCreationDate())
                .notifications(NotificationDto.customListMapping(user.getNotifications()))
                .build();
    }
}
