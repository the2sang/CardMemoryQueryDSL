package com.the2ang.cardmemory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CardMemoryQueryDslApplication {

    public static void main(String[] args) {
        SpringApplication.run(CardMemoryQueryDslApplication.class, args);
    }

}
