package com.playstore.owner_service.client;

import com.playstore.owner_service.dto.NotificationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification-service")
public interface NotificationClient {

    
    @PostMapping("/notifications/send")
    void sendNotification(@RequestBody NotificationDTO notificationDTO);
}
