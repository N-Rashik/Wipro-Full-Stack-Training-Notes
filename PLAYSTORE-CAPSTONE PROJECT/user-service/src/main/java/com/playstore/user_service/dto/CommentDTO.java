package com.playstore.user_service.dto;

public class CommentDTO {
    private String userName;
    private String message;
    private String createdAt;

    public CommentDTO(String userName, String message, String createdAt) {
        this.userName = userName;
        this.message = message;
        this.createdAt = createdAt;
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

    
}
