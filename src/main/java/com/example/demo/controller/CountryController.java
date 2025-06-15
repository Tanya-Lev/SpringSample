package com.example.demo.controller;

import com.example.demo.dto.request.CreateCountryRequest;
import com.example.demo.dto.response.CreateCountryResponse;
import com.example.demo.dto.response.ReadCountryResponse;
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
    public CreateCountryResponse createCountry(@RequestBody CreateCountryRequest request) {
        return countryService.createCountry(request);
    }
    @GetMapping()
    public ReadCountryResponse getCountryById(@RequestParam(name = "id") String id){
        return countryService.getCountryById(id);
    }
    @GetMapping("/readAll")
    public List<ReadCountryResponse> getAllCountry(){
        return countryService.getAllCountry();
    }
    @DeleteMapping("/delete")
    public boolean deleteCountryById(@RequestParam(name = "id") String id){
        return countryService.deleteCountryById(id);
    }

}
