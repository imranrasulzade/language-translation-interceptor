package com.e_sys.languageinterceptor.configs;

import com.e_sys.languageinterceptor.dto.CampaignDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class TranslationInterceptorV2 implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String lang = request.getHeader("lang");

        CampaignDto campaignDto = (CampaignDto) request.getAttribute("responseBody");

        if (campaignDto != null && campaignDto.getHeader() != null) {
            String text = "";
            switch (lang) {
                case "az":
                    text = campaignDto.getHeader().getAz();
                case "ru":
                    text = campaignDto.getHeader().getRu();
                case "en":
                    text = campaignDto.getHeader().getEn();
                default:
                    throw new IllegalArgumentException("Unsupported language: " + lang);
            }

            // Set the mapped text in the CampaignDto
//            campaignDto.setText(text);
        }

        return true;
    }
}

