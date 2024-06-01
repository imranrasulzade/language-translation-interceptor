package com.e_sys.languageinterceptor.dto;

import lombok.Data;

@Data
public class PartnerDto {
    private Long id;
    private TranslationDto name;
    private String email;
    private String phone;
    private Boolean status;
}
