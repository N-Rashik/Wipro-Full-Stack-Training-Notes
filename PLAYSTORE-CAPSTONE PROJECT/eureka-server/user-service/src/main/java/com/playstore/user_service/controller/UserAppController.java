package com.playstore.user_service.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import com.playstore.user_service.dto.AppDTO;
import com.playstore.user_service.dto.CommentDTO;
import com.playstore.user_service.dto.DownloadNotificationDTO;
import com.playstore.user_service.dto.UserDTO;
import com.playstore.user_service.entity.App;
import com.playstore.user_service.entity.Comment;
import com.playstore.user_service.entity.User;
import com.playstore.user_service.feign.OwnerServiceClient;
import com.playstore.user_service.service.AppService;
import com.playstore.user_service.service.CommentService;
import com.playstore.user_service.service.NotificationService;
import com.playstore.user_service.service.RatingService;
import com.playstore.user_service.service.UserService;

@Controller
@RequestMapping("/user")
public class UserAppController {

    private final AppService appService;
    private final UserService userService;
    private final NotificationService notificationService;
    private final CommentService commentService;
    private final RatingService ratingService;
    private final OwnerServiceClient ownerServiceClient;

    @Autowired
    public UserAppController(AppService appService, UserService userService,
                             NotificationService notificationService, CommentService commentService,
                             RatingService ratingService,OwnerServiceClient ownerServiceClient) {
        this.appService = appService;
        this.userService = userService;
        this.notificationService = notificationService;
        this.commentService = commentService;
        this.ratingService = ratingService;
        this.ownerServiceClient=ownerServiceClient;
    }

    // ==================== DASHBOARD ====================
    @GetMapping("/dashboard")
    public String dashboard(@RequestParam(required = false) String search,
                            @RequestParam(required = false) String category,
                            Model model,
                            @AuthenticationPrincipal UserDetails userDetails) {

        List<AppDTO> apps;

        if (search != null && !search.isEmpty()) {
            apps = appService.searchAppsByName(search);
        } else if (category != null && !category.isEmpty()) {
            apps = appService.getAppsByCategory(category);
        } else {
            apps = appService.getAllVisibleApps();
        }
        
        apps.forEach(app -> {
            if (app.getIconUrl() == null || app.getIconUrl().isEmpty()) {
                app.setIconUrl("default-icon.png"); 
            }
        });

        model.addAttribute("apps", apps);
        model.addAttribute("search", search != null ? search : "");
        model.addAttribute("selectedCategory", category != null ? category : "");

        addUserToModel(model, userDetails);

        return "dashboard";
    }

    // ==================== SEPARATE INCREMENT ENDPOINT ====================
    @PostMapping("/app/increment-download/{id}")
    @ResponseBody
    public String incrementDownload(@PathVariable Long id) {
        App app = appService.getById(id);
        
        if (app != null) {
            int currentCount = app.getDownloadCount() == null ? 0 : app.getDownloadCount();
            app.setDownloadCount(currentCount + 1);
            appService.saveApp(app);
            return "SUCCESS";
        }
        return "FAIL";
    }

    // ==================== SUBMIT RATING ====================
    @PostMapping("/app/{id}/rate")
    @ResponseBody
    public String submitRating(@PathVariable Long id, @RequestParam Integer stars) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || "anonymousUser".equals(auth.getName())) return "FAIL";

        User user = userService.findByEmail(auth.getName());
        if (user != null && stars != null && stars >= 1 && stars <= 5) {
            ratingService.addOrUpdateRating(id, user.getId(), stars);
            return "SUCCESS";
        }
        return "FAIL";
    }

    // ==================== SUBMIT COMMENT ====================
    @PostMapping("/app/{id}/comment")
    @ResponseBody
    public String submitComment(@PathVariable Long id, @RequestBody Map<String, String> payload) {
        String message = payload.get("message");
        if (message == null || message.trim().isEmpty()) return "FAIL";

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || "anonymousUser".equals(auth.getName())) return "FAIL";

        User user = userService.findByEmail(auth.getName());
        if (user == null) return "FAIL";

        Comment comment = new Comment();
        comment.setAppId(id);
        comment.setUserId(user.getId());
        comment.setUserName(user.getName());
        comment.setMessage(message.trim());
        commentService.saveComment(comment);

        return "SUCCESS";
    }
    
    @GetMapping("/api/comments/app/{id}")
    @ResponseBody
    public List<CommentDTO> getCommentsForApp(@PathVariable Long id) {
        List<Comment> comments = commentService.getCommentsByAppId(id);

        // Convert to DTO
        return comments.stream()
            .map(c -> new CommentDTO(
                c.getUserName(),
                c.getMessage(),
                c.getCreatedAt() != null ? c.getCreatedAt().toString() : ""
            ))
            .toList();
    }



    // ==================== ADD USER INFO ====================
    private void addUserToModel(Model model, UserDetails userDetails) {
        if (userDetails == null) return;

        User user = userService.findByEmail(userDetails.getUsername());
        if (user != null) {
            Integer notificationsCount = 0;
            List<DownloadNotificationDTO> notifications = List.of(); 

            try {
                notificationsCount = notificationService.countNotificationsForUser(user.getId());
                notifications = notificationService.getNotifications(user.getId());
            } catch (Exception e) {
                System.out.println("Notification service error for userId " + user.getId() + ": " + e.getMessage());
            }

            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setName(user.getName());
            userDTO.setEmail(user.getEmail());

            model.addAttribute("user", userDTO);
            model.addAttribute("notificationCount", notificationsCount);
            model.addAttribute("notifications", notifications);
        }
    }
}
