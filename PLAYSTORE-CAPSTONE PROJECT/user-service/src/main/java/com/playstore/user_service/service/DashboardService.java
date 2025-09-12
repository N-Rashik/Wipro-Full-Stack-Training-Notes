package com.playstore.user_service.service;

import com.playstore.user_service.dto.AppDTO;
import com.playstore.user_service.feign.OwnerServiceClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    private final OwnerServiceClient ownerServiceClient; // Use OwnerServiceClient

    public DashboardService(OwnerServiceClient ownerServiceClient) {
        this.ownerServiceClient = ownerServiceClient;
    }

    public List<AppDTO> fetchVisibleApps() {
        return ownerServiceClient.getVisibleApps();
    }
}
