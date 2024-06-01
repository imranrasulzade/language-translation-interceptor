package com.e_sys.languageinterceptor.controller;

import com.e_sys.languageinterceptor.dto.PartnerDto;
import com.e_sys.languageinterceptor.payloads.PartnerPayload;
import com.e_sys.languageinterceptor.service.PartnerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("partners")
public class PartnerController {
    private final PartnerService service;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAllPartners());
    }

    @PostMapping
    public void create(@RequestBody @Valid PartnerPayload partnerPayload){
        service.create(partnerPayload);
        ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid PartnerDto partnerDto){
        return ResponseEntity.ok().body(service.update(partnerDto));
    }
}
