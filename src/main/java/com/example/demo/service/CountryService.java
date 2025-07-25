package com.example.demo.service;

import com.example.demo.dto.request.CreateCountryRequest;
import com.example.demo.dto.response.CountryResponse;
import com.example.demo.dto.response.GetCountryByIdResponse;

import java.util.List;

public interface CountryService {
    public CountryResponse createCountry(CreateCountryRequest request);
    public GetCountryByIdResponse getCountryById(String id);
    public List<CountryResponse> getAllCountry();
    public boolean deleteCountryById(String id);

}
