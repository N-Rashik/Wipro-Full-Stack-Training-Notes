package com.playstore.owner_service.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.playstore.owner_service.client.UserServiceClient;
import com.playstore.owner_service.dto.AppDTO;
import com.playstore.owner_service.dto.CommentDTO;
import com.playstore.owner_service.entity.App;
import com.playstore.owner_service.repository.AppRepository;
import com.playstore.owner_service.service.AppService;
import com.playstore.owner_service.service.NotificationService;

@Controller
@RequestMapping("/owner/app")
public class OwnerAppController {

    private final UserServiceClient userServiceClient;
    private final AppService appService;
    private final NotificationService notificationService;
    private final AppRepository appRepository;

    @Autowired
    public OwnerAppController(UserServiceClient userServiceClient,
                              AppService appService,
                              NotificationService notificationService,AppRepository appRepository) {
        this.userServiceClient = userServiceClient;
        this.appService = appService;
        this.notificationService = notificationService;
        this.appRepository=appRepository;
    }

    // ================= VIEW COMMENTS =================
    @GetMapping("/comments/{id}")
    public String viewComments(@PathVariable Long id, Model model) {
        List<CommentDTO> comments = userServiceClient.getComments(id);
        model.addAttribute("comments", comments);
        model.addAttribute("appId", id);
        return "comments"; 
    }

    // ================= EDIT APP & NOTIFY =================
    @PostMapping("/{id}/edit")
    public String editApp(@PathVariable Long id,
                          @ModelAttribute AppDTO appDTO,
                          RedirectAttributes redirectAttributes) {
        App app = appService.updateApp(id, appDTO);

       
        notificationService.createNotification(
            null, 
            "The app " + app.getName() + " has been updated to version " + app.getVersion()
        );

        redirectAttributes.addFlashAttribute("success", "App updated and notification created!");
        return "redirect:/owner/dashboard";
    }
    @GetMapping("/getApp/{id}")
    public ResponseEntity<AppDTO> getAppById(@PathVariable Long id) {
        Optional<App> appOpt = appRepository.findById(id);
        if (appOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        App app = appOpt.get();
        AppDTO dto = new AppDTO(app); 
        return ResponseEntity.ok(dto);
    }
    @GetMapping
    public List<App> getAllApps() {
        return appService.getAllApps();
    }
    
}
