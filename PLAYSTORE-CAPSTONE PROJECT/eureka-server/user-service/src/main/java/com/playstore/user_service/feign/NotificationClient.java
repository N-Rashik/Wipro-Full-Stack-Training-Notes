package com.playstore.user_service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.playstore.user_service.dto.DownloadNotificationDTO;
import com.playstore.user_service.config.FeignConfig;

@FeignClient(
    name = "owner-service",
    path = "/notifications",
    configuration = FeignConfig.class
)
public interface NotificationClient {

    @GetMapping("/user/{userId}")
    List<DownloadNotificationDTO> getNotificationsForUser(@PathVariable("userId") Long userId);

    @GetMapping(value = "/user/{userId}/count", produces = MediaType.APPLICATION_JSON_VALUE)
    Integer countNotificationsForUser(@PathVariable("userId") Long userId);

}
