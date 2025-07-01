package com.security.controller;

import com.security.dto.*;
import com.security.service.SecurityManagementService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/security")
@RequiredArgsConstructor
public class SecurityManagementController {

    private static final Logger log = LogManager.getLogger(SecurityManagementController.class);
    private final SecurityManagementService service;

    @GetMapping("/getRoles")
    public ResponseEntity<List<RoleResponse>> getRoles() {
        log.info("Received request to get roles");
        List<RoleResponse> roles = service.getRoles();
        log.info("Returning {} roles", roles.size());
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/getChannels")
    public ResponseEntity<List<ChannelResponse>> getChannels() {
        log.info("Received request to get channels");
        List<ChannelResponse> channels = service.getChannels();
        log.info("Returning {} channels", channels.size());
        return ResponseEntity.ok(channels);
    }

    @GetMapping("/getAuditLevels")
    public ResponseEntity<List<AuditLevelResponse>> getAuditLevels() {
        log.info("Received request to get audit levels");
        List<AuditLevelResponse> auditLevels = service.getAuditLevels();
        log.info("Returning {} audit levels", auditLevels.size());
        return ResponseEntity.ok(auditLevels);
    }

    @PostMapping("/getPermission")
    public ResponseEntity<List<PermissionResponse>> getPermission(@RequestBody PermissionRequest request) {
        log.info("Received request to get permissions for roleId: {} and category: {}", 
                request.getRoleId(), request.getPermsCategoryName());
        List<PermissionResponse> permissions = service.getPermissions(request.getRoleId(), request.getPermsCategoryName());
        log.info("Returning {} permissions", permissions.size());
        return ResponseEntity.ok(permissions);
    }
} 