package com.e_sys.languageinterceptor.service;

import com.e_sys.languageinterceptor.dto.AboutDto;
import com.e_sys.languageinterceptor.entities.About;
import com.e_sys.languageinterceptor.repository.AboutRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AboutService {
    private final AboutRepository aboutRepository;
    private final ModelMapper modelMapper;
    public AboutDto getByID(Long id) {
        About about = aboutRepository.findById(id).orElse(null);
        return modelMapper.map(about, AboutDto.class);
    }
}
