package com.e_sys.languageinterceptor.controller;

import com.e_sys.languageinterceptor.service.CampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/campaigns")
@RequiredArgsConstructor
public class CampaignController {
    private final CampaignService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> getLang(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.getByID(id));
    }

    @GetMapping
    public String foo() {
        return "OK";
    }
}
