package com.e_sys.languageinterceptor.responses;

import lombok.Data;

@Data
public class PartnerResponse {
    private Long id;
    private TranslationResponse name;
    private String email;
    private String phone;
    private Boolean status;
}
