package com.playstore.user_service.controller;

import com.playstore.user_service.entity.User;
import com.playstore.user_service.service.DashboardService;
import com.playstore.user_service.service.NotificationService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final DashboardService dashboardService;
    private final NotificationService notificationService;

    public DashboardController(DashboardService dashboardService, NotificationService notificationService) {
        this.dashboardService = dashboardService;
        this.notificationService = notificationService;
    }

    @GetMapping("/dashboard")
    public String showDashboard(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("apps", dashboardService.fetchVisibleApps());

        if (user != null) {
            // Add user object to model
            model.addAttribute("user", user);

            // Add notifications count directly as Integer
            Integer notificationsCount = notificationService.countNotificationsForUser(user.getId());
            model.addAttribute("notificationsCount", notificationsCount);
        }

        return "dashboard";
    }

}
