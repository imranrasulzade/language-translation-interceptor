package com.e_sys.languageinterceptor.responses;

import lombok.Data;

@Data
public class CampaignResponse {
    private Long id;
    private TranslationResponse header;
    private TranslationResponse contentHeader;
    private TranslationResponse content;
    private CampaignTypeResponse campaignType;
}
