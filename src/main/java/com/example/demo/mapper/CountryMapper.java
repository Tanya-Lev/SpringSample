package com.example.demo.mapper;

import com.example.demo.dto.response.CountryResponse;
import com.example.demo.entity.Country;

public class CountryMapper {
    public static CountryResponse toCountryResponse(Country country){
        return new CountryResponse(
                country.getId().toString(),
                country.getName()
        );
    }
}
