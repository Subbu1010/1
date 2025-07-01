package com.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChannelResponse {
    private String chanId;
    private String chanNm;
    private String adGrp;
    private Integer recOrd;
    private String defaultFlag;
} 