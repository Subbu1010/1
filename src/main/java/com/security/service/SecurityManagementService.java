package com.security.service;

import com.security.dto.*;
import com.security.entity.*;
import com.security.repository.*;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SecurityManagementService {
    
    private static final Logger log = LogManager.getLogger(SecurityManagementService.class);

    private final SecLkpRoleRepository roleRepository;
    private final SecLkpChanRepository channelRepository;
    private final SecLkpAudLvlRepository auditLevelRepository;
    private final SecLkpPermsRepository permissionsRepository;
    private final SecLkpRolePermsRepository rolePermissionsRepository;
    private final SecLkpPermsCatRepository permissionCategoryRepository;

    // In-memory cache
    private final Map<String, List<SecLkpRole>> rolesCache = new ConcurrentHashMap<>();
    private final Map<String, List<SecLkpChan>> channelsCache = new ConcurrentHashMap<>();
    private final Map<String, List<SecLkpAudLvl>> auditLevelsCache = new ConcurrentHashMap<>();
    private final Map<String, List<SecLkpPerms>> permissionsCache = new ConcurrentHashMap<>();
    private final Map<String, List<SecLkpRolePerms>> rolePermissionsCache = new ConcurrentHashMap<>();
    private final Map<String, List<SecLkpPermsCat>> permissionCategoriesCache = new ConcurrentHashMap<>();

    @Scheduled(cron = "0 */5 * * * ?") // Run every 5 minutes
    public void loadDataIntoCache() {
        log.info("Starting scheduled data load into cache every 5 minutes");
        
        try {
            // Load all active data into cache
            List<SecLkpRole> activeRoles = roleRepository.findActiveRoles();
            rolesCache.put("active", activeRoles);
            
            List<SecLkpChan> activeChannels = channelRepository.findActiveChannels();
            channelsCache.put("active", activeChannels);
            
            List<SecLkpAudLvl> activeAuditLevels = auditLevelRepository.findActiveAuditLevels();
            auditLevelsCache.put("active", activeAuditLevels);
            
            List<SecLkpPerms> activePermissions = permissionsRepository.findActivePermissions();
            permissionsCache.put("active", activePermissions);
            
            List<SecLkpPermsCat> activePermissionCategories = permissionCategoryRepository.findActivePermissionCategories();
            permissionCategoriesCache.put("active", activePermissionCategories);
            
            // Load all role permissions
            List<SecLkpRolePerms> allRolePermissions = rolePermissionsRepository.findAll();
            rolePermissionsCache.put("all", allRolePermissions);
            
            log.info("Successfully loaded data into cache. Roles: {}, Channels: {}, Audit Levels: {}, Permissions: {}, Role Permissions: {}, Permission Categories: {}", 
                    activeRoles.size(), activeChannels.size(), activeAuditLevels.size(), 
                    activePermissions.size(), allRolePermissions.size(), activePermissionCategories.size());
                    
        } catch (Exception e) {
            log.error("Error loading data into cache: {}", e.getMessage(), e);
        }
    }

    public List<RoleResponse> getRoles() {
        log.info("Getting active roles from cache");
        List<SecLkpRole> activeRoles = rolesCache.get("active");
        
        if (activeRoles == null) {
            log.warn("Cache is empty, loading data from database");
            loadDataIntoCache();
            activeRoles = rolesCache.get("active");
        }
        
        return activeRoles.stream()
                .map(this::mapToRoleResponse)
                .collect(Collectors.toList());
    }

    public List<ChannelResponse> getChannels() {
        log.info("Getting active channels from cache");
        List<SecLkpChan> activeChannels = channelsCache.get("active");
        
        if (activeChannels == null) {
            log.warn("Cache is empty, loading data from database");
            loadDataIntoCache();
            activeChannels = channelsCache.get("active");
        }
        
        return activeChannels.stream()
                .map(this::mapToChannelResponse)
                .collect(Collectors.toList());
    }

    public List<AuditLevelResponse> getAuditLevels() {
        log.info("Getting active audit levels from cache");
        List<SecLkpAudLvl> activeAuditLevels = auditLevelsCache.get("active");
        
        if (activeAuditLevels == null) {
            log.warn("Cache is empty, loading data from database");
            loadDataIntoCache();
            activeAuditLevels = auditLevelsCache.get("active");
        }
        
        return activeAuditLevels.stream()
                .map(this::mapToAuditLevelResponse)
                .collect(Collectors.toList());
    }

    public List<PermissionResponse> getPermissions(String roleId, String permsCategoryName) {
        log.info("Getting permissions for roleId: {} and category: {}", roleId, permsCategoryName);
        
        // Get data from cache
        List<SecLkpPerms> activePermissions = permissionsCache.get("active");
        List<SecLkpRolePerms> allRolePermissions = rolePermissionsCache.get("all");
        List<SecLkpPermsCat> activePermissionCategories = permissionCategoriesCache.get("active");
        
        if (activePermissions == null || allRolePermissions == null || activePermissionCategories == null) {
            log.warn("Cache is empty, loading data from database");
            loadDataIntoCache();
            activePermissions = permissionsCache.get("active");
            allRolePermissions = rolePermissionsCache.get("all");
            activePermissionCategories = permissionCategoriesCache.get("active");
        }
        
        // Find the permission category
        SecLkpPermsCat category = activePermissionCategories.stream()
                .filter(cat -> cat.getPermsCatNm().equals(permsCategoryName))
                .findFirst()
                .orElse(null);
        
        if (category == null) {
            log.warn("Permission category not found: {}", permsCategoryName);
            return List.of();
        }
        
        // Get role permissions for the given role
        List<SecLkpRolePerms> rolePerms = allRolePermissions.stream()
                .filter(rp -> rp.getRoleId().equals(roleId))
                .collect(Collectors.toList());
        
        // Get permissions for the category
        List<SecLkpPerms> categoryPerms = activePermissions.stream()
                .filter(p -> p.getPermsCatId().equals(category.getPermsCatId()))
                .collect(Collectors.toList());
        
        // Find matching permissions
        return categoryPerms.stream()
                .filter(perm -> rolePerms.stream()
                        .anyMatch(rp -> rp.getPermsId().equals(perm.getPermsId())))
                .map(this::mapToPermissionResponse)
                .collect(Collectors.toList());
    }

    private RoleResponse mapToRoleResponse(SecLkpRole role) {
        return new RoleResponse(
                role.getRoleId(),
                role.getRoleNm(),
                role.getAdGrp(),
                role.getRecOrd(),
                null // defaultFlag is null as per requirement
        );
    }

    private ChannelResponse mapToChannelResponse(SecLkpChan channel) {
        return new ChannelResponse(
                channel.getChanId(),
                channel.getChanNm(),
                channel.getAdGrp(),
                channel.getRecOrd(),
                null // defaultFlag is null as per requirement
        );
    }

    private AuditLevelResponse mapToAuditLevelResponse(SecLkpAudLvl auditLevel) {
        return new AuditLevelResponse(
                auditLevel.getAudLvlId(),
                auditLevel.getAudLvlNm(),
                auditLevel.getAdGrp(),
                auditLevel.getAppvrSoeid(),
                auditLevel.getAppvrFname(),
                auditLevel.getAppvrLname(),
                auditLevel.getAppvrGrp(),
                auditLevel.getResrId(),
                auditLevel.getRecOrd(),
                null // defaultFlag is null as per requirement
        );
    }

    private PermissionResponse mapToPermissionResponse(SecLkpPerms permission) {
        return new PermissionResponse(
                permission.getPermsId(),
                permission.getPermsNm(),
                permission.getAdGrp(),
                null // defaultFlag is null as per requirement
        );
    }
} 