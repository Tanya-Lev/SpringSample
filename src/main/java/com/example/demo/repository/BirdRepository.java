package com.example.demo.repository;

import com.example.demo.entity.Bird;
import com.example.demo.entity.Country;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BirdRepository extends MongoRepository<Bird,String> {
}
