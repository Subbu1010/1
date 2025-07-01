package com.security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "sec_lkp_perms_cat")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecLkpPermsCat {
    
    @Id
    @Column(name = "perms_cat_id")
    private Integer permsCatId;
    
    @Column(name = "perms_cat_nm", length = 30)
    private String permsCatNm;
    
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