//package com.e_sys.languageinterceptor.configs;
//
//import com.e_sys.languageinterceptor.dto.TranslationDto;
//import org.springframework.core.MethodParameter;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.server.ServerHttpRequest;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.lang.Nullable;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
//
//import java.lang.reflect.Field;
//import java.util.HashSet;
//import java.util.Set;
//import java.util.logging.Logger;
//
//@ControllerAdvice
//public class TranslationInterceptor implements ResponseBodyAdvice<Object> {
//    private static final Logger logger = Logger.getLogger(TranslationInterceptor.class.getName());
//
//    @Override
//    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
//        return true; // Tüm yanıtlarda geçerli olacak
//    }
//
//    @Nullable
//    @Override
//    public Object beforeBodyWrite(@Nullable Object body, MethodParameter returnType, MediaType selectedContentType,
//                                  Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
//                                  ServerHttpResponse response) {
//        String lang = request.getHeaders().getFirst("lang");
//        if (lang != null && body != null) {
//            processTranslationDtos(body, lang, new HashSet<>());
//        }
//        return body;
//    }
//
//    private void processTranslationDtos(Object obj, String lang, Set<Object> processedObjects) {
//        if (obj == null || processedObjects.contains(obj)) {
//            return;
//        }
//
//        // Ekleme işlemi mevcut set'e yapılıyor
//        processedObjects.add(obj);
//
//        if (obj instanceof TranslationDto) {
//            setTranslationDtoFields((TranslationDto) obj, lang);
//        } else if (obj instanceof Iterable) {
//            for (Object item : (Iterable<?>) obj) {
//                processTranslationDtos(item, lang, processedObjects);
//            }
//        } else {
//            for (Field field : obj.getClass().getDeclaredFields()) {
//                field.setAccessible(true);
//                try {
//                    Object fieldValue = field.get(obj);
//                    processTranslationDtos(fieldValue, lang, processedObjects);
//                } catch (IllegalAccessException e) {
//                    logger.warning("Field erişim hatası: " + e.getMessage());
//                }
//            }
//        }
//    }
//
//    private void setTranslationDtoFields(TranslationDto dto, String lang) {
//        if (dto == null) {
//            return;
//        }
//        logger.info("Processing TranslationDto with lang: " + lang);
//        switch (lang) {
//            case "az":
//                dto.setRu(null);
//                dto.setEn(null);
//                break;
//            case "ru":
//                dto.setAz(null);
//                dto.setEn(null);
//                break;
//            case "en":
//                dto.setAz(null);
//                dto.setRu(null);
//                break;
//            default:
//                dto.setAz(null);
//                dto.setRu(null);
//                dto.setEn(null);
//                break;
//        }
//    }
//}
