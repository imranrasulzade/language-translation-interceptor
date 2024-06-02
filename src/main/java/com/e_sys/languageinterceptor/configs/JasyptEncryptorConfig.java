package com.e_sys.languageinterceptor.configs;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
Edit Configurations -> Modify options -> Add VM options. and copy this line. (my-secret-key = your secret key)
-Djasypt.encryptor.password=my-secret-key
 ***/

@Configuration
public class JasyptEncryptorConfig {

    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(System.getProperty("jasypt.encryptor.password"));
        return encryptor;
    }
}
