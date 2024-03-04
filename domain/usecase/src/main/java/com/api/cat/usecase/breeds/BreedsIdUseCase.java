package com.api.cat.usecase.breeds;

import com.api.cat.model.gateways.BreedRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class BreedsIdUseCase {

    private final BreedRepository repository;

    public Mono<String> getBreedId(String id) {
        return repository.findById(id);
    }
}
