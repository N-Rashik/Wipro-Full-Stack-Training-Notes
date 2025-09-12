package com.playstore.owner_service.exception;

public class AppAlreadyExistsException extends RuntimeException {
    
    public AppAlreadyExistsException(String message) {
        super(message);
    }
}
