package com.example.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "cities")
public class City {
    @Id
    private long id;
    private String name;
    private Region region;
}
