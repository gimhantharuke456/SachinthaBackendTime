package com.backend.sachinthabackend;

import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        // Assuming you have a running MongoDB instance on localhost, default port
        return new MongoTemplate(MongoClients.create(), "spm_backend");
    }
}
