package com.playstore.owner_service.controller;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.playstore.owner_service.dto.AppDTO;
import com.playstore.owner_service.entity.App;
import com.playstore.owner_service.entity.Owner;
import com.playstore.owner_service.service.AppService;
import com.playstore.owner_service.service.FileStorageService;
import com.playstore.owner_service.service.OwnerService;

@Controller
@RequestMapping("/owner/app")
public class AppController {

    private final AppService appService;
    private final FileStorageService fileStorageService;
    private final OwnerService ownerService;

    @Autowired
    public AppController(AppService appService,
                         FileStorageService fileStorageService,
                         OwnerService ownerService) {
        this.appService = appService;
        this.fileStorageService = fileStorageService;
        this.ownerService = ownerService;
    }

    // ================= Create App =================
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("appDTO", new AppDTO());
        return "create_app";
    }

    @PostMapping("/create")
    public String createApp(@ModelAttribute AppDTO appDTO, Model model) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String ownerEmail = auth.getName();
            Owner currentOwner = ownerService.getOwnerByEmail(ownerEmail);

            // Store files
            String iconFileName = fileStorageService.storeIcon(appDTO.getIconFile());
            String appFileName = fileStorageService.storeAppFile(appDTO.getAppFile());

         
            App app = new App();
            app.setName(appDTO.getName());
            app.setVersion(appDTO.getVersion());
            app.setDescription(appDTO.getDescription());
            app.setVisible(true);
            app.setAppUrl(appFileName);              
            app.setIconUrl("/uploads/icons/" + iconFileName); 
            app.setOwner(currentOwner);
            app.setCategory(appDTO.getCategory());

            appService.createApp(app);

            return "redirect:/owner/app/dashboard?ownerId=" + currentOwner.getId();

        } catch (Exception e) {
            model.addAttribute("error", "Error uploading files: " + e.getMessage());
            return "create_app";
        }
    }

    // ================= Edit App =================
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        App app = appService.getAppById(id);
        AppDTO appDTO = new AppDTO(app); 
        model.addAttribute("appDTO", appDTO);
        model.addAttribute("appId", app.getId());
        return "edit_app";
    }

    @PostMapping("/edit/{id}")
    public String updateApp(@PathVariable Long id, @ModelAttribute AppDTO appDTO) {
        App app = appService.getAppById(id);
        app.setName(appDTO.getName());
        app.setCategory(appDTO.getCategory());
        app.setVersion(appDTO.getVersion());
        app.setDescription(appDTO.getDescription());

        if (appDTO.getIconFile() != null && !appDTO.getIconFile().isEmpty()) {
            String iconFileName = fileStorageService.storeIcon(appDTO.getIconFile());
            app.setIconUrl("/uploads/icons/" + iconFileName);
        }

        if (appDTO.getAppFile() != null && !appDTO.getAppFile().isEmpty()) {
            String appFileName = fileStorageService.storeAppFile(appDTO.getAppFile());
            app.setAppUrl(appFileName); // only filename in DB
        }

        appService.updateApp(app);
        return "redirect:/owner/app/dashboard?ownerId=" + app.getOwner().getId();
    }

    // ================= Dashboard =================
    @GetMapping("/dashboard")
    public String showDashboard(@RequestParam Long ownerId,
                                @RequestParam(required = false) String category,
                                @RequestParam(required = false) String keyword,
                                Model model) {

        Owner owner = ownerService.getOwnerById(ownerId);
        model.addAttribute("owner", owner);

        List<AppDTO> apps = appService.getAppDTOsByOwner(owner);

        // Filter by category
        if (category != null && !category.isEmpty() && !category.equalsIgnoreCase("all")) {
            apps = apps.stream()
                       .filter(app -> app.getCategory() != null &&
                                      app.getCategory().equalsIgnoreCase(category))
                       .collect(Collectors.toList());
        }

        // Filter by keyword
        if (keyword != null && !keyword.isEmpty()) {
            apps = apps.stream()
                       .filter(app -> app.getName().toLowerCase().contains(keyword.toLowerCase()))
                       .collect(Collectors.toList());
        }

        // Unique categories
        Set<String> categories = appService.getAppDTOsByOwner(owner).stream()
                .map(AppDTO::getCategory)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        model.addAttribute("apps", apps);
        model.addAttribute("categories", categories);
        model.addAttribute("selectedCategory", category);
        model.addAttribute("keyword", keyword);

        return "dashboard";
    }

    // ================= Delete App =================
    @GetMapping("/delete/{id}")
    public String deleteApp(@PathVariable Long id) {
        App app = appService.getAppById(id);
        Long ownerId = app.getOwner().getId();
        appService.deleteApp(id);
        return "redirect:/owner/app/dashboard?ownerId=" + ownerId;
    }

    // ================= Toggle Visibility =================
    @GetMapping("/toggle/{id}")
    public String toggleVisibility(@PathVariable Long id) {
        App app = appService.toggleVisibility(id);
        return "redirect:/owner/app/dashboard?ownerId=" + app.getOwner().getId();
    }

    // ================= Download Count =================
    @GetMapping("/download/{id}")
    public String incrementDownload(@PathVariable Long id) {
        App app = appService.getAppById(id);
        app.setDownloadCount(app.getDownloadCount() + 1);
        appService.updateApp(app);
        return "redirect:/owner/app/dashboard?ownerId=" + app.getOwner().getId();
    }
}
