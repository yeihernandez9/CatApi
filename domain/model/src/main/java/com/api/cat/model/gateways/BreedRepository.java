package com.api.cat.model.gateways;

import com.api.cat.model.Breed;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.List;

public interface BreedRepository {
    Mono<String> findById(String id);

    Mono<Void> delete(String id);

    Mono<Breed> save(Breed order);

    Flux<String> getAll() throws IOException;

    Flux<String> getAllSearch(String name) throws IOException;

    Flux<Breed> findByStatus(String status);
}
