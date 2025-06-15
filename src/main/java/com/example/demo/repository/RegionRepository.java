package com.example.demo.repository;

import com.example.demo.entity.Country;
import com.example.demo.entity.Region;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegionRepository extends MongoRepository<Region,String> {
}
