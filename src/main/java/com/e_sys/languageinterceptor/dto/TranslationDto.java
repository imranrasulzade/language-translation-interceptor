package com.e_sys.languageinterceptor.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
public class TranslationDto {
    private Long id;
    private String text;
    private String parentTable;
    private String parentId;
    private Boolean status;
}
