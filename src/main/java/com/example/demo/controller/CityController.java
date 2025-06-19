package com.example.demo.controller;

import com.example.demo.dto.request.CreateCountryRequest;
import com.example.demo.dto.response.CountryResponse;
import com.example.demo.dto.response.GetCountryByIdResponse;
import com.example.demo.service.CityService;
import com.example.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CityController {
    @RestController
    @RequestMapping("/city")
    public class CountryController {
        @Autowired
        private CityService cityService;

        @PostMapping("/create")
        public CountryResponse createCountryFromController(@RequestBody CreateCountryRequest request) {
            CountryResponse response = cityService.createCountry(request);
            return response;
        }

//        @GetMapping()
//        public GetCityById getCityById(@RequestParam(name = "id") String id){
//            return cityService.getCityById(id);
//        }

        @GetMapping("/readAll")
        public List<CountryResponse> getAllCountry(){
            return cityService.getAllCountry();
        }

        @DeleteMapping("/delete")
        public boolean deleteCityById(@RequestParam(name = "id") String id){
            return cityService.deleteCityById(id);
        }

    }
}
