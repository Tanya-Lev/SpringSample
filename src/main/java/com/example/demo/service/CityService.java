package com.example.demo.service;

import com.example.demo.dto.request.CreateCountryRequest;
import com.example.demo.dto.response.CountryResponse;
import com.example.demo.dto.response.GetCountryByIdResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CityService {

    public CountryResponse createCountry(CreateCountryRequest request);
//    public GetCityByIdResponse GetCityById(String id);
    public List<CountryResponse> getAllCountry();
    public boolean deleteCityById(String id);





}
