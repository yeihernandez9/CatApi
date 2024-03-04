package com.api.cat.usecase.breeds;

import com.api.cat.model.gateways.BreedRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

@RequiredArgsConstructor
public class BreedsUseCase {
    private final BreedRepository repository;

    public Flux<String> getBreed() throws IOException {
        return repository.getAll();
    }


}
