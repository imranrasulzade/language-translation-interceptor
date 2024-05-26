package com.e_sys.languageinterceptor.repository;

import com.e_sys.languageinterceptor.entities.Translation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranslationRepository extends JpaRepository<Translation, Long> {

}
