package com.e_sys.languageinterceptor.configs;

import com.e_sys.languageinterceptor.dto.TranslationDto;
import com.e_sys.languageinterceptor.entities.Translation;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
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
}
