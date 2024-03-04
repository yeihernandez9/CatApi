package com.api.cat.api;

import com.api.cat.usecase.breeds.BreedsIdUseCase;
import com.api.cat.usecase.breeds.BreedsSearchUseCase;
import com.api.cat.usecase.breeds.BreedsUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

@RestController
@RequestMapping(value = "/api/breed", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class BreedApiRest {

    private final BreedsUseCase service;
    private final BreedsIdUseCase service_id;

    private final BreedsSearchUseCase service_search;

    @GetMapping()
    public Flux<String> getBreeds() throws IOException {
        try {
            return service.getBreed();
        } catch (IOException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "error on external service"
            );
        }
    }

    @GetMapping("/search_id")
    public Mono<String> getBreedId(
            @RequestParam(name = "id") String id
    ) throws IOException {
        return service_id.getBreedId(id);
    }


    @GetMapping("/search")
    public Flux<String> getBreedSearch(
            @RequestParam(name = "name") String name
    ) throws IOException {
        return service_search.getBreed(name);
    }
}
