package com.e_sys.languageinterceptor.configs;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;



@Component
public class LanguageInterceptor implements HandlerInterceptor {

    private static final ThreadLocal<String> currentLanguage = new ThreadLocal<>();

    public static String getCurrentLanguage() {
        return currentLanguage.get();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String language = request.getHeader("language");
        currentLanguage.set(language);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        currentLanguage.remove();
    }
}
