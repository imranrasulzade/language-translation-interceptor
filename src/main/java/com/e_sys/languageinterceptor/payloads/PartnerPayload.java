package com.e_sys.languageinterceptor.payloads;

import lombok.Data;

@Data
public class PartnerPayload {
    private TranslationPayload name;
    private String email;
    private String phone;
    private Boolean status;
}
