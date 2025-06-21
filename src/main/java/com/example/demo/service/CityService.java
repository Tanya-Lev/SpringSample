package com.example.demo.service;

import com.example.demo.dto.request.CreateCityRequest;
import com.example.demo.dto.response.*;

import java.util.List;

public interface CityService {

    public CityResponse createCity(CreateCityRequest request);
    public CityResponse GetCityById(String id);
    public List<GetAllCityByRegionResponse> getAllCityByRegion(String id);
    public List<CityResponse> getAllCity();
    public boolean deleteCityById(String id);










}
