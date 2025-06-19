package com.example.demo.repository;

import com.example.demo.entity.Region;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RegionRepository extends MongoRepository<Region,String> {
    List<Region> findAllByCountry_Id(String country_id);
}
