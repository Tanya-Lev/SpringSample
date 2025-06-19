package com.example.demo.controller;

import com.example.demo.dto.request.CreateCountryRequest;
import com.example.demo.dto.response.CountryResponse;
import com.example.demo.dto.response.GetCountryByIdResponse;
import com.example.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @PostMapping("/create")
    public CountryResponse createCountryFromController(@RequestBody CreateCountryRequest request) {
        CountryResponse response = countryService.createCountry(request);
        return response;
    }

    @GetMapping()
    public GetCountryByIdResponse getCountryById(@RequestParam(name = "id") String id){
        return countryService.getCountryById(id);
    }

    @GetMapping("/readAll")
    public List<CountryResponse> getAllCountry(){
        return countryService.getAllCountry();
    }

    @DeleteMapping("/delete")
    public boolean deleteCountryById(@RequestParam(name = "id") String id){
        return countryService.deleteCountryById(id);
    }

}
