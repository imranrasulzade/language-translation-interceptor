package com.e_sys.languageinterceptor.service;

import com.e_sys.languageinterceptor.dto.PartnerDto;
import com.e_sys.languageinterceptor.entities.Partner;
import com.e_sys.languageinterceptor.mapper.PartnerMapper;
import com.e_sys.languageinterceptor.payloads.PartnerPayload;
import com.e_sys.languageinterceptor.repository.PartnerRepository;
import com.e_sys.languageinterceptor.responses.PartnerResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PartnerService {
    private final ModelMapper modelMapper;
    private final PartnerRepository partnerRepository;
    private final PartnerMapper partnerMapper;

    public List<PartnerResponse> getAllPartners() {
        List<PartnerDto> dtoList = Arrays.asList(modelMapper.map(partnerRepository.findAll(), PartnerDto[].class));
        return Arrays.asList(modelMapper.map(dtoList, PartnerResponse[].class));
    }

    public List<PartnerResponse> getAllWithMapStruct() {
        List<PartnerResponse> list = partnerRepository.findAll().stream().map(partnerMapper::toPartnerResponse).toList();
        return list;
    }

    public void create(PartnerPayload partnerPayload) {
        partnerRepository.save(modelMapper.map(partnerPayload, Partner.class));
    }

    public PartnerResponse update(PartnerDto partnerDto) {
        Partner partner = partnerRepository.save(modelMapper.map(partnerDto, Partner.class));
        return modelMapper.map(partner, PartnerResponse.class);
    }

}
