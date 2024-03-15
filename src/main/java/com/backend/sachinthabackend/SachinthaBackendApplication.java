package com.backend.sachinthabackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "com.backend.sachinthabackend.repositary")
@SpringBootApplication
public class SachinthaBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(SachinthaBackendApplication.class, args);
    }
}
