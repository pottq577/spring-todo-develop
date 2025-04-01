package com.example.springtododevelop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringTodoDevelopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTodoDevelopApplication.class, args);
    }

}
