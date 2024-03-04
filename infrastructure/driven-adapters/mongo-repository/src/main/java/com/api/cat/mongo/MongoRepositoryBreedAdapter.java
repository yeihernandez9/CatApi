package com.api.cat.mongo;

import com.api.cat.model.Breed;
import com.api.cat.mongo.document.BreedDocument;
import com.api.cat.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.function.Function;
@Repository
public class MongoRepositoryBreedAdapter extends AdapterOperations<Breed, BreedDocument, String, MongoDBRepository> {
    public MongoRepositoryBreedAdapter(MongoDBRepository repository, ObjectMapper mapper) {

        super(repository, mapper, d -> mapper.map(d, Breed.class));
    }
}
