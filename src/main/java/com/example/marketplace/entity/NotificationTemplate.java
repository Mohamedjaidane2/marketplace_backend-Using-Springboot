package com.example.marketplace.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "notificationTemplate")
public class NotificationTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer notificationTemplate;
    private String type;
    private String subjectTemplate;
    private String bodyTemplate;
    @OneToMany(mappedBy="template")
    private List<Notification> notifications;


}
