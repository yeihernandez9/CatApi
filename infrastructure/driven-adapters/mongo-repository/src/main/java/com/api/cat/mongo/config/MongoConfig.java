package com.api.cat.mongo.config;

import com.mongodb.ConnectionString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mongo.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MongoConfig {

    @Bean
    public MongoDBSecret dbSecret(@Value("${spring.data.mongodb.uri}") String uri) {
        return MongoDBSecret.builder()
                .uri(uri)
                .build();
    }

    @Bean
    public ReactiveMongoClientFactory mongoProperties(MongoDBSecret secret) {
        List<MongoClientSettingsBuilderCustomizer> list = new ArrayList<>();
        list.add(mongoDBDefaultSettings(secret.getUri()));
        return new ReactiveMongoClientFactory(list);
    }

    public MongoClientSettingsBuilderCustomizer mongoDBDefaultSettings(String uri) {
        return builder -> builder.applyConnectionString(new ConnectionString(uri))
                .applyToSslSettings(
                        blockBuilder -> blockBuilder.enabled(false)
                );
    }
}
