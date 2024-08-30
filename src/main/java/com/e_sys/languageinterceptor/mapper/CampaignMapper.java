package com.e_sys.languageinterceptor.mapper;

import com.e_sys.languageinterceptor.entities.Campaign;
import com.e_sys.languageinterceptor.responses.CampaignResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = TranslationMapper.class)
public interface CampaignMapper {

    CampaignMapper INSTANCE = Mappers.getMapper(CampaignMapper.class);

//    @Mapping(target = "header", source = "header")
    CampaignResponse toResponse(Campaign campaign);


}
