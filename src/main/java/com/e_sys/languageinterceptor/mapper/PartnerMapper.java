package com.e_sys.languageinterceptor.mapper;

import com.e_sys.languageinterceptor.dto.PartnerDto;
import com.e_sys.languageinterceptor.entities.Partner;
import com.e_sys.languageinterceptor.responses.PartnerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = TranslationMapper.class)
public interface PartnerMapper {

    PartnerMapper INSTANCE = Mappers.getMapper(PartnerMapper.class);

    @Mapping(target = "name", source = "name")
    PartnerDto toPartnerDto(Partner partner);

    @Mapping(target = "name", source = "name")
    PartnerResponse toPartnerResponse(Partner partner);

}

