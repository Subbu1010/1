package com.security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "sec_lkp_perms")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecLkpPerms {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "perms_cat_id")
    private Integer permsCatId;
    
    @Column(name = "perms_id", length = 50)
    private String permsId;
    
    @Column(name = "perms_nm", length = 50)
    private String permsNm;
    
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