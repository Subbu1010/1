package com.security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "sec_lkp_aud_lvl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecLkpAudLvl {
    
    @Id
    @Column(name = "aud_lvl_id", length = 30)
    private String audLvlId;
    
    @Column(name = "aud_lvl_nm", length = 30)
    private String audLvlNm;
    
    @Column(name = "ad_grp", length = 100)
    private String adGrp;
    
    @Column(name = "appvr_soeid", length = 10)
    private String appvrSoeid;
    
    @Column(name = "appvr_fname", length = 50)
    private String appvrFname;
    
    @Column(name = "appvr_lname", length = 50)
    private String appvrLname;
    
    @Column(name = "appvr_grp", length = 100)
    private String appvrGrp;
    
    @Column(name = "resr_id", length = 30)
    private String resrId;
    
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