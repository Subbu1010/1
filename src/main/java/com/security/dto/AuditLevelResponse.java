package com.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditLevelResponse {
    private String audLvlId;
    private String audLvlNm;
    private String adGrp;
    private String appvrSoeid;
    private String appvrFname;
    private String appvrLname;
    private String appvrGrp;
    private String resrId;
    private Integer recOrd;
    private String defaultFlag;
} 