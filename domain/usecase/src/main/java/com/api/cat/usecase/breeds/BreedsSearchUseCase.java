package com.api.cat.usecase.breeds;

import com.api.cat.model.gateways.BreedRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.io.IOException;

@RequiredArgsConstructor
public class BreedsSearchUseCase {

    private final BreedRepository repository;
    public Flux<String> getBreed(String name) throws IOException {
        return repository.getAllSearch(name);
    }
}
