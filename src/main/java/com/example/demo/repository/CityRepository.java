package com.example.demo.repository;

import com.example.demo.entity.City;
import com.example.demo.entity.Country;
import com.example.demo.entity.Region;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CityRepository extends MongoRepository<City,String> {
    List<City> findAllByRegionId(ObjectId regionId);
}
