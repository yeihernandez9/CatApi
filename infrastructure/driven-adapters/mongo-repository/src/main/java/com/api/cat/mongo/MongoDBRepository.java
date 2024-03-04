package com.api.cat.mongo;

import com.api.cat.mongo.document.BreedDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import reactor.core.publisher.Flux;

public interface MongoDBRepository extends ReactiveMongoRepository<BreedDocument/* change for adapter model */, String>, ReactiveQueryByExampleExecutor<BreedDocument/* change for adapter model */> {
    Flux<BreedDocument> findByStatus(String status);
}
