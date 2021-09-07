package com.example.lhtjwtlogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;


@SpringBootApplication()


public class LhtJwtLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(LhtJwtLoginApplication.class, args);
    }

}
