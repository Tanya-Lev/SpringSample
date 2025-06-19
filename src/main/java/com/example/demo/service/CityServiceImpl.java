package com.example.demo.service;

import com.example.demo.dto.request.CreateCountryRequest;
import com.example.demo.dto.response.CountryResponse;

import java.util.List;

public class CityServiceImpl implements CityService{

    @Override
    public CountryResponse createCountry(CreateCountryRequest request) {
        return null;
    }

//    @Override
//    public GetCityByIdResponse GetCityById(String id) {
//        return null;
//    }

    @Override
    public List<CountryResponse> getAllCountry() {
        return List.of();
    }

    @Override
    public boolean deleteCityById(String id) {
        return false;
    }
}
