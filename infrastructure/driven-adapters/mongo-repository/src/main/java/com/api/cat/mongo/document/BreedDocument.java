package com.api.cat.mongo.document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "breeds")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BreedDocument {
    @Id
    private String id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createAt;

    private String name;

    private String description;
    private String status;

}
