package com.example.demo.repository;

import com.example.demo.entity.Region;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RegionRepository extends MongoRepository<Region,String> {
    List<Region> findAllByCountryId(ObjectId countryId);

}
