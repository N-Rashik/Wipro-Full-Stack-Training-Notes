package com.playstore.user_service.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.playstore.user_service.dto.AppDTO;

@RestController
@RequestMapping("/api/apps")
public class AppRestController {

    private final RestTemplate restTemplate;

    public AppRestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/visible")
    public List<AppDTO> getAppsFromOwner() {
        return Arrays.asList(
            restTemplate.getForObject("http://localhost:8081/owner/apps", AppDTO[].class)
        );
    }
}
