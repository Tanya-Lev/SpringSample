package com.example.demo.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "birds")
public class Bird {
    @Id
    private ObjectId id;
    private String name;
    private String description;
    private List<City> origin;
    private List<String> tags;
}
