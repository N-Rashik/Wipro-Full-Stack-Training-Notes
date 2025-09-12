package com.playstore.owner_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.playstore.owner_service.entity.Notification;
import com.playstore.owner_service.entity.Owner;
import com.playstore.owner_service.repository.NotificationRepository;
import com.playstore.owner_service.repository.OwnerRepository;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final OwnerRepository ownerRepository;

    public NotificationService(NotificationRepository notificationRepository,
                               OwnerRepository ownerRepository) {
        this.notificationRepository = notificationRepository;
        this.ownerRepository = ownerRepository;
    }

    // Create notification for an owner
    public void createNotification(Long ownerId, String message) {
        Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("Owner not found with ID: " + ownerId));

        Notification notification = new Notification();
        notification.setOwner(owner);
        notification.setMessage(message);

        notificationRepository.save(notification);
    }

    // Get notifications for an owner
    public List<Notification> getNotificationsForOwner(Long ownerId) {
        return notificationRepository.findByOwner_IdOrderByCreatedAtDesc(ownerId);
    }

    // Count unread notifications for an owner
    public List<Notification> countUnread(Long ownerId) {
        if (!ownerRepository.existsById(ownerId)) {
            return List.of();
        }
        return notificationRepository.findByOwner_IdOrderByCreatedAtDesc(ownerId);
    }

}
