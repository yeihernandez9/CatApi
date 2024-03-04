package com.api.cat.consumer;

import com.api.cat.model.Breed;
import com.api.cat.model.gateways.BreedRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.List;

@Component
public class RestConsumer implements BreedRepository{
    private final OkHttpClient client;
    private final ObjectMapper mapper;
    private final String url;

    private final OkHttpClient okHttpClient;
    private final ObjectMapper objectMapper;

    public RestConsumer(OkHttpClient client,
                        ObjectMapper mapper,
                        @Value("${adapter.restconsumer.url}") String url, OkHttpClient okHttpClient, ObjectMapper objectMapper) {
        this.client = client;
        this.mapper = mapper;
        this.url = url;
        this.okHttpClient = okHttpClient;
        this.objectMapper = objectMapper;
    }


    @Override
    public Mono<String> findById(String id) {
            Request request = new Request.Builder()
                    .url(url.concat("/breeds/").concat(String.valueOf(id)))
                    .get()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("x-api-key", "live_JBT0Ah0Nt12iyl2IpjQVLDWjcLk0GQwf4zI9wBMfmfejKmcC31mOJp4yJz5TsOUP")
                    .build();

            try (Response response = client.newCall(request).execute()) {
                if (response.isSuccessful()) {
                    String responseBody = response.body().string();
                    return Mono.just(responseBody);
                } else {
                    throw new IOException("Error al realizar la solicitud: " + response.code());
                }
            } catch (IOException e) {
                return Mono.error(e);
            }

    }

    @Override
    public Mono<Void> delete(String id) {
        return null;
    }

    @Override
    public Mono<Breed> save(Breed order) {
        return null;
    }

    @Override
    public Flux<String> getAll() throws IOException {
        Request request = new Request.Builder()
                .url(url.concat("/breeds"))
                .get()
                .addHeader("Content-Type", "application/json")
                .addHeader("x-api-key", "live_JBT0Ah0Nt12iyl2IpjQVLDWjcLk0GQwf4zI9wBMfmfejKmcC31mOJp4yJz5TsOUP")
                .build();

        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            String responseBody = response.body().string();
            //List<Breed> breeds = mapper.readValue(responseBody, new TypeReference<List<Breed>>() {});
            return Flux.fromIterable(responseBody.chars().mapToObj(c -> String.valueOf((char) c))::iterator);
        } else {
            throw new IOException("Error al realizar la solicitud: " + response.code());
        }

    }

    @Override
    public Flux<String> getAllSearch(String name) throws IOException {
        Request request = new Request.Builder()
                .url(url.concat("/breeds/search?q=").concat(String.valueOf(name)).concat("&attach_image=1"))
                .get()
                .addHeader("Content-Type", "application/json")
                .addHeader("x-api-key", "live_JBT0Ah0Nt12iyl2IpjQVLDWjcLk0GQwf4zI9wBMfmfejKmcC31mOJp4yJz5TsOUP")
                .build();

        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            String responseBody = response.body().string();
            //List<Breed> breeds = mapper.readValue(responseBody, new TypeReference<List<Breed>>() {});
            return Flux.fromIterable(responseBody.chars().mapToObj(c -> String.valueOf((char) c))::iterator);
        } else {
            throw new IOException("Error al realizar la solicitud: " + response.code());
        }
    }

    @Override
    public Flux<Breed> findByStatus(String status) {
        return null;
    }
}
