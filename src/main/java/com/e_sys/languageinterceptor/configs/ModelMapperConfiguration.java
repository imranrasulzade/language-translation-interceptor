package com.e_sys.languageinterceptor.configs;

import com.e_sys.languageinterceptor.dto.TranslationDto;
import com.e_sys.languageinterceptor.entities.Translation;
import com.e_sys.languageinterceptor.responses.TranslationResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {
    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setPropertyCondition(new NotNullCondition<>());

        modelMapper.addMappings(new PropertyMap<Translation, TranslationResponse>() {
            @Override
            protected void configure() {
                using(context -> getLang(context.getSource()))
                        .map(source, destination.getText());
            }
        });

        modelMapper.addMappings(new PropertyMap<TranslationDto, TranslationResponse>() {
            @Override
            protected void configure() {
                using(context -> getLang(context.getSource()))
                        .map(source, destination.getText());
            }
        });

        return modelMapper;
    }

    private <S> String getLang(S source) {
        String language = LanguageInterceptor.getCurrentLanguage();
        if (source instanceof Translation translation) {
            return switch (language.toLowerCase()) {
                case "en" -> translation.getEn();
                case "ru" -> translation.getRu();
                default -> translation.getAz();
            };
        } else if (source instanceof TranslationDto translationDto) {
            return switch (language.toLowerCase()) {
                case "en" -> translationDto.getEn();
                case "ru" -> translationDto.getRu();
                default -> translationDto.getAz();
            };
        }
        return null;
    }

}