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
    private ObjectId countryId;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObjectId getCountryId() {
        return countryId;
    }

    public void setCountryId(ObjectId countryId) {
        this.countryId = countryId;
    }
}
