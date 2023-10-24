package com.example.marketplace.controller;

import com.example.marketplace.dto.NotificationTemplateDtos.NotificationTemplateDto;
import com.example.marketplace.dto.NotificationTemplateDtos.NotificationTemplateNewDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.service.INotificationTemplateServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/notification-template")
@RequestMapping("/api/notification-template")
@RestController
@RequiredArgsConstructor
public class NotificationTemplateController {
    private final INotificationTemplateServices notificationTemplateService;

    @PostMapping("/create")
    @ApiOperation(value = "Create notification template")
    public ResponseEntity<SuccessDto> createNotificationTemplate(@RequestBody NotificationTemplateNewDto template) {
        return ResponseEntity.ok(notificationTemplateService.createNotificationTemplate(template));
    }

    @GetMapping("/{templateId}")
    @ApiOperation(value = "Get notification template by ID")
    public ResponseEntity<NotificationTemplateDto> getNotificationTemplateById(@PathVariable Integer templateId) {
        NotificationTemplateDto template = notificationTemplateService.getNotificationTemplateById(templateId);
        return ResponseEntity.ok(template);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get all notification templates")
    public ResponseEntity<List<NotificationTemplateDto>> getAllNotificationTemplates() {
        List<NotificationTemplateDto> templates = notificationTemplateService.getAllNotificationTemplates();
        return ResponseEntity.ok(templates);
    }

    @DeleteMapping("/delete/{templateId}")
    @ApiOperation(value = "Delete notification template by ID")
    public ResponseEntity<SuccessDto> deleteNotificationTemplate(@PathVariable Integer templateId) {
        return ResponseEntity.ok(notificationTemplateService.deleteNotificationTemplate(templateId));
    }
}
