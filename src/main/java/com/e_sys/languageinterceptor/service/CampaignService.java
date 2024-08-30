package com.e_sys.languageinterceptor.service;

import com.e_sys.languageinterceptor.dto.CampaignDto;
import com.e_sys.languageinterceptor.entities.Campaign;
import com.e_sys.languageinterceptor.mapper.CampaignMapper;
import com.e_sys.languageinterceptor.repository.CampaignRepository;
import com.e_sys.languageinterceptor.responses.CampaignResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CampaignService {
    private final CampaignRepository campaignRepository;
    private final ModelMapper modelMapper;
    private final CampaignMapper campaignMapper;

    public CampaignDto getByID(Long id) {
        Campaign campaign = campaignRepository.findById(id).orElseThrow(() -> new RuntimeException("Entity not found"));
        return modelMapper.map(campaign, CampaignDto.class);
    }

    public List<CampaignResponse> get(){
        List<Campaign> campaigns = campaignRepository.findAll();
        List<CampaignResponse> responses = campaigns.stream().map(campaignMapper::toResponse).toList();
        return responses;
    }
}
