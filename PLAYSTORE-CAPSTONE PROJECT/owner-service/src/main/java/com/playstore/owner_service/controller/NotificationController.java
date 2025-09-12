package com.playstore.owner_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.playstore.owner_service.entity.Notification;
import com.playstore.owner_service.service.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/user/{userId}")
    public List<Notification> getNotifications(@PathVariable Long userId) {
        return notificationService.getNotificationsForOwner(userId);
    }

    @GetMapping("/user/{userId}/count")
    public ResponseEntity<List<Notification>> countNotifications(@PathVariable Long userId) {
        List<Notification> count = notificationService.countUnread(userId);
        return ResponseEntity.ok(count); // Sets Content-Type: application/json
    }

}
