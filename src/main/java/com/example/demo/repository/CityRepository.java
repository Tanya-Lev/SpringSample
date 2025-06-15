package com.example.demo.repository;

import com.example.demo.entity.City;
import com.example.demo.entity.Country;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CityRepository extends MongoRepository<City,String> {
}
