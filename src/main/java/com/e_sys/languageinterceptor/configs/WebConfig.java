//package com.e_sys.languageinterceptor.configs;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//    private final TranslationInterceptor translationInterceptor;
//
//    @Autowired
//    public WebConfig(TranslationInterceptor translationInterceptor) {
//        this.translationInterceptor = translationInterceptor;
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(translationInterceptor);
//    }
//}
