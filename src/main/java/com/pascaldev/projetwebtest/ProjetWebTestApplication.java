package com.pascaldev.projetwebtest;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
@Slf4j
public class ProjetWebTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetWebTestApplication.class, args);
        log.info(ProjetWebTestApplication.class.getSimpleName());
    }

}
