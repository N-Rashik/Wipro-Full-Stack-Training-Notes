package com.playstore.owner_service.dto;

import java.time.LocalDateTime;

public class NotificationDTO {

    private Long id;
    private String message;
    private boolean readStatus;
    private LocalDateTime createdAt;
    private Long ownerId;

    public NotificationDTO() {}

    public NotificationDTO(Long id, String message, boolean readStatus, LocalDateTime createdAt, Long ownerId) {
        this.id = id;
        this.message = message;
        this.readStatus = readStatus;
        this.createdAt = createdAt;
        this.ownerId = ownerId;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public boolean isReadStatus() { return readStatus; }
    public void setReadStatus(boolean readStatus) { this.readStatus = readStatus; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public Long getOwnerId() { return ownerId; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }
}
