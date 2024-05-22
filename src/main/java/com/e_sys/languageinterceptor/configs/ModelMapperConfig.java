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
                    if ("en".equals(language)) {
                        return source.getEn();
                    } else if ("ru".equals(language)) {
                        return source.getRu();
                    } else if ("az".equals(language)) {
                        return source.getAz();
                    } else {
                        return null;
                    }
                }).map(source, destination.getText());
            }
        });
        return modelMapper;
    }
}
