package com.e_sys.languageinterceptor.configs;

import com.e_sys.languageinterceptor.dto.AboutDto;
import com.e_sys.languageinterceptor.dto.CampaignDto;
import com.e_sys.languageinterceptor.dto.TranslationDto;
import com.e_sys.languageinterceptor.entities.About;
import com.e_sys.languageinterceptor.entities.Campaign;
import com.e_sys.languageinterceptor.entities.Translation;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Translation, TranslationDto>() {
            @Override
            protected void configure() {
                using(context -> {
                    Translation source = (Translation) context.getSource();
                    String language = LanguageInterceptor.getCurrentLanguage();
                    if ("en".equalsIgnoreCase(language)) {
                        return source.getEn();
                    } else if ("ru".equalsIgnoreCase(language)) {
                        return source.getRu();
                    } else if ("az".equalsIgnoreCase(language)) {
                        return source.getAz();
                    } else {
                        return source.getAz();
                    }
                }).map(source, destination.getText());
            }
        });
        return modelMapper;
    }


//    @Bean
//    public ModelMapper modelMapper() {
//        ModelMapper modelMapper = new ModelMapper();
//
//        Converter<Translation, String> translationConverter = new Converter<Translation, String>() {
//            @Override
//            public String convert(MappingContext<Translation, String> context) {
//                Translation source = context.getSource();
//                String language = LanguageInterceptor.getCurrentLanguage();
//
//                if (language != null) {
//                    switch (language.toLowerCase()) {
//                        case "en":
//                            return source.getEn();
//                        case "ru":
//                            return source.getRu();
//                        case "az":
//                            return source.getAz();
//                        default:
//                            return source.getAz();
//                    }
//                }
//                return source.getAz();
//            }
//        };
//
//        modelMapper.createTypeMap(Campaign.class, CampaignDto.class)
//                .addMappings(mapper -> {
//                    mapper.using(translationConverter).map(Campaign::getHeader, CampaignDto::setHeader);
//                    mapper.using(translationConverter).map(Campaign::getContentHeader, CampaignDto::setContentHeader);
//                    mapper.using(translationConverter).map(Campaign::getContent, CampaignDto::setContent);
//                });
//        modelMapper.createTypeMap(About.class, AboutDto.class)
//                .addMappings(mapper -> {
//                    mapper.using(translationConverter).map(About::getTitle, AboutDto::setTitle);
//                    mapper.using(translationConverter).map(About::getContent, AboutDto::setContent);
//                });
//
//        return modelMapper;
//    }
}
