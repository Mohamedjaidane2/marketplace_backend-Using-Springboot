package com.example.marketplace.controller;

import com.example.marketplace.dto.NotificationDtos.NotificationDto;
import com.example.marketplace.dto.NotificationDtos.NotificationNewDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.service.INotificationServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/notification")
@RequestMapping("/api/notification")
@RestController
@RequiredArgsConstructor
public class NotificationController {
    private final INotificationServices notificationService;

    @PostMapping("/create")
    @ApiOperation(value = "Create notification")
    public ResponseEntity<SuccessDto> createNotification(@RequestBody NotificationNewDto notificationNewDto) {
        return ResponseEntity.ok(notificationService.createNotification(notificationNewDto));
    }

    @GetMapping("/{notificationId}")
    @ApiOperation(value = "Get notification by ID")
    public ResponseEntity<NotificationDto> getNotificationById(@PathVariable Integer notificationId) {
        NotificationDto notification = notificationService.getNotificationById(notificationId);
        return ResponseEntity.ok(notification);
    }

    @GetMapping("/user/{userId}")
    @ApiOperation(value = "Get notifications by user ID")
    public ResponseEntity<List<NotificationDto>> getNotificationsByUserId(@PathVariable Integer userId) {
        List<NotificationDto> notifications = notificationService.getNotificationsByUserId(userId);
        return ResponseEntity.ok(notifications);
    }

    @PutMapping("/markRead/{notificationId}")
    @ApiOperation(value = "Mark notification as read")
    public ResponseEntity<SuccessDto> markNotificationAsRead(@PathVariable Integer notificationId) {
        return ResponseEntity.ok(notificationService.markNotificationAsRead(notificationId));
    }

    @DeleteMapping("/delete/{notificationId}")
    @ApiOperation(value = "Delete notification by ID")
    public ResponseEntity<SuccessDto> deleteNotification(@PathVariable Integer notificationId) {
        return ResponseEntity.ok(notificationService.deleteNotification(notificationId));
    }
}
