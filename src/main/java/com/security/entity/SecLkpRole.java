package com.security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "sec_lkp_role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecLkpRole {
    
    @Id
    @Column(name = "role_id", length = 50)
    private String roleId;
    
    @Column(name = "role_nm", length = 50)
    private String roleNm;
    
    @Column(name = "role_desc", length = 255)
    private String roleDesc;
    
    @Column(name = "ad_grp", length = 100)
    private String adGrp;
    
    @Column(name = "rec_ord")
    private Integer recOrd;
    
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