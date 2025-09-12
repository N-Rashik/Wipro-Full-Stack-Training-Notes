package com.playstore.user_service.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class DownloadHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long appId;
    private LocalDateTime downloadedAt = LocalDateTime.now();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getAppId() {
		return appId;
	}
	public void setAppId(Long appId) {
		this.appId = appId;
	}
	public LocalDateTime getDownloadedAt() {
		return downloadedAt;
	}
	public void setDownloadedAt(LocalDateTime downloadedAt) {
		this.downloadedAt = downloadedAt;
	}

    // getters and setters
    
    
}
