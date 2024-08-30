package com.e_sys.languageinterceptor.mapper;

import com.e_sys.languageinterceptor.configs.LanguageInterceptor;
import com.e_sys.languageinterceptor.entities.Translation;
import com.e_sys.languageinterceptor.responses.TranslationResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TranslationMapper {

    TranslationMapper INSTANCE = Mappers.getMapper(TranslationMapper.class);

    @Mapping(target = "text", source = ".", qualifiedByName = "mapToText")
    TranslationResponse toTranslationResponse(Translation translation);

    @Named("mapToText")
    default String mapToText(Translation translation) {
        String language = LanguageInterceptor.getCurrentLanguage();
        return switch (language) {
            case "az" -> translation.getAz();
            case "ru" -> translation.getRu();
            default -> translation.getEn();
        };
    }
}
