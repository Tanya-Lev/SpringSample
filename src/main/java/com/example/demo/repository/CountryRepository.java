package com.example.demo.repository;

import com.example.demo.entity.Country;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CountryRepository extends MongoRepository<Country,String> {
    @Override
    List<Country> findAllById(Iterable<String> strings);
}
