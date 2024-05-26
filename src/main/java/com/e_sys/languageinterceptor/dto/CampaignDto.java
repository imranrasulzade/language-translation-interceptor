package com.e_sys.languageinterceptor.dto;

import lombok.Data;

@Data
public class CampaignDto {
    private Long id;
    private TranslationDto header;
    private TranslationDto contentHeader;
    private TranslationDto content;
    private CampaignTypeDto campaignType;

}
