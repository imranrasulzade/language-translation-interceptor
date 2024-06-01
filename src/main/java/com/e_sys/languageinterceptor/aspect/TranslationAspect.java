package com.e_sys.languageinterceptor.aspect;

import com.e_sys.languageinterceptor.entities.Translation;
import com.e_sys.languageinterceptor.repository.TranslationRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;


@Aspect
@Component
@RequiredArgsConstructor
public class TranslationAspect {
    private static final Logger log = LoggerFactory.getLogger(TranslationAspect.class);
    private final TranslationRepository translationRepository;

//    @SneakyThrows
    @AfterReturning(pointcut = "execution(* com.e_sys.languageinterceptor.repository.*.save(..))")
    public void afterSaveMethod(JoinPoint joinPoint) {
        try {
            Object entity = joinPoint.getArgs()[0];
            Field[] fields = entity.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.getType() == Translation.class) {
                    Translation translation = (Translation) field.get(entity);
                    if (translation != null) {
                        Field idField = entity.getClass().getDeclaredField("id");
                        idField.setAccessible(true);
                        Object parentId = idField.get(entity);
                        translation.setParentId(parentId.toString());

                        translation.setParentTable(entity.getClass().getSimpleName().toLowerCase());

                        translation.setStatus(true);
                        translationRepository.save(translation);
                        log.info("Action.log -> translation-log saved successfully!");
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("!something went wrong in translation-aspect!");
        }
    }
}
