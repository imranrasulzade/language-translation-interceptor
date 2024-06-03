# For run project Config for DB pass decode with Jasypt Encryptor

## 1. Library
build.gradle faylına əlavə edilməli
```groovy

dependencies {
// https://mvnrepository.com/artifact/com.github.ulisesbocchio/jasypt-spring-boot-starter
implementation group: 'com.github.ulisesbocchio', name: 'jasypt-spring-boot-starter', version: '3.0.5'
}

```

## 2. Yaml config
application-dev.yml və application-prod.yml fayllarına əlavə edilməli
```yaml

jasypt:
  encryptor:
    password: my-secret-key

```


## 3. Encrypt password
password encrypt olunmalı və yml-da ENC() daxilində yazılmalı
```yaml

spring:
  datasource:
     url: dburl
     username: dbusername
     password: ENC(your-encrypted-password)

```

## 4. Edit Configuration VM options
Intellij IDEA Ultimate
Edit Configuration -> More options -> Add VM options
paste this:
```txt

-Djasypt.encryptor.password=my-secret-key

```
