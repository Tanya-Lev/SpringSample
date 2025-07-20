package com.example.demo.controller;

import com.example.demo.dto.request.CreateCityRequest;
import com.example.demo.dto.response.CityResponse;
import com.example.demo.dto.response.GetAllCityByRegionResponse;
import com.example.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping("/create")
    public CityResponse createCity(@RequestBody CreateCityRequest request) {
        CityResponse response = cityService.createCity(request);
        return response;
    }

    @GetMapping()
    public CityResponse getCityById(@RequestParam(name = "id") String id) {
        return cityService.GetCityById(id);
    }

    @GetMapping("/readAllByRegion")
    public List<GetAllCityByRegionResponse> getAllCityByRegion(String id) {
        return cityService.getAllCityByRegion(id);
    }

    @GetMapping("/readAll")
    public List<CityResponse> getAllCity() {
        return cityService.getAllCity();
    }

    @DeleteMapping("/delete")
    public boolean deleteCityById(@RequestParam(name = "id") String id) {
        return cityService.deleteCityById(id);
    }

}

