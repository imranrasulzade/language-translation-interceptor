package com.e_sys.languageinterceptor.dto;

import lombok.Data;

@Data
public class AboutDto {
    private Long id;
    private TranslationDto title;
    private TranslationDto content;
}
