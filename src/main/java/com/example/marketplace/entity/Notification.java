package com.example.marketplace.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer notificationId;

    private String content;

    @Column(name = "is_read")
    private Boolean read;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User app_user;

    @ManyToOne
    @JoinColumn(name = "notificationTemplate_id", nullable = false)
    private NotificationTemplate template;

}
