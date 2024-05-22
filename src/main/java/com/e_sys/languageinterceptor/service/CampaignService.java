package com.e_sys.languageinterceptor.service;

import com.e_sys.languageinterceptor.dto.CampaignDto;
import com.e_sys.languageinterceptor.entities.Campaign;
import com.e_sys.languageinterceptor.repository.CampaignRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CampaignService {
    private final CampaignRepository campaignRepository;
    private final ModelMapper modelMapper;

    public CampaignDto getByID(String lang, Long id) {
        Campaign campaign = campaignRepository.findById(id).orElseThrow(() -> new RuntimeException("Entity not found"));
        return modelMapper.map(campaign, CampaignDto.class);
    }
}
