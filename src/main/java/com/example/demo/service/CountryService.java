package com.example.demo.service;

import com.example.demo.dto.request.CreateCountryRequest;
import com.example.demo.dto.response.CreateCountryResponse;
import com.example.demo.dto.response.ReadCountryResponse;

import java.util.List;

public interface CountryService {
    public CreateCountryResponse createCountry(CreateCountryRequest request);
    public ReadCountryResponse getCountryById(String id);
    public List<ReadCountryResponse> getAllCountry();
    public boolean deleteCountryById(String id);

}
