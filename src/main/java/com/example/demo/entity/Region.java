package com.example.demo.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "regions")
public class Region {
    @Id
    private ObjectId id;
    private String name;
    private Country country;
}
