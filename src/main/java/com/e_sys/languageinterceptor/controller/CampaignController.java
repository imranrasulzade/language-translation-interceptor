package com.e_sys.languageinterceptor.controller;

import com.e_sys.languageinterceptor.dto.CampaignDto;
import com.e_sys.languageinterceptor.service.CampaignService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/campaigns")
@RequiredArgsConstructor
public class CampaignController {
    private final CampaignService service;

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getLang(@RequestHeader("language") String lang, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.getByID(id));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getLang(@RequestHeader("language") String lang, @PathVariable Long id, HttpServletRequest request) {
        CampaignDto campaignDto = service.getByID(id);
        request.setAttribute("responseBody", campaignDto);
        return ResponseEntity.status(HttpStatus.OK).body(campaignDto);
    }
}
