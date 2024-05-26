//package com.e_sys.languageinterceptor.controller;
//
//import com.e_sys.languageinterceptor.dto.TranslationDto;
//import com.e_sys.languageinterceptor.entities.Translation;
//import com.e_sys.languageinterceptor.repository.TranslationRepository;
//import lombok.RequiredArgsConstructor;
//import org.modelmapper.ModelMapper;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//@RequestMapping("/translation")
//@RequiredArgsConstructor
//public class TranslationController {
//    private final TranslationRepository translationRepository;
//    private final ModelMapper modelMapper;
//
//    @GetMapping("{id}")
//    public TranslationDto getTranslations(@PathVariable Long id) {
//        Translation translation = translationRepository.findById(id).orElse(null);
//        return modelMapper.map(translation, TranslationDto.class);
//    }
//
//
//}
