package com.playstore.owner_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.playstore.owner_service.dto.AppDTO;
import com.playstore.owner_service.service.AppService;

@RestController
@RequestMapping("/api/apps")
public class AppRestController {

    private final AppService appService;

    @Autowired
    public AppRestController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping("/visible")
    public List<AppDTO> getVisibleApps() {
        return appService.getVisibleApps();
    }
}
