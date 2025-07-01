package com.security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "sec_lkp_role_perms")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecLkpRolePerms {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "role_id", length = 50)
    private String roleId;
    
    @Column(name = "perms_id", length = 50)
    private String permsId;
    
    @Column(name = "def_flag", length = 10)
    private String defFlag;
    
    @Column(name = "actvd_dt")
    private LocalDate actvdDt;
    
    @Column(name = "deprecated_dt")
    private LocalDate deprecatedDt;
    
    @Column(name = "created_by", length = 10)
    private String createdBy;
    
    @Column(name = "created_on")
    private LocalDate createdOn;
    
    @Column(name = "updated_by", length = 10)
    private String updatedBy;
    
    @Column(name = "updated_on")
    private LocalDate updatedOn;
} 