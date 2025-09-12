package com.playstore.user_service.service;

import com.playstore.user_service.feign.NotificationClient;
import com.playstore.user_service.dto.DownloadNotificationDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationClient notificationClient;

    public NotificationService(NotificationClient notificationClient) {
        this.notificationClient = notificationClient;
    }

    public List<DownloadNotificationDTO> getNotifications(Long userId) {
        return notificationClient.getNotificationsForUser(userId);
    }

    public Integer countNotificationsForUser(Long userId) {
        return notificationClient.countNotificationsForUser(userId);
    }
}
