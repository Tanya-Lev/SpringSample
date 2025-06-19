package com.example.demo.controller;

import com.example.demo.dto.request.CreateRegionRequest;
import com.example.demo.dto.response.GetAllRegionByCountryResponse;
import com.example.demo.dto.response.RegionResponse;
import com.example.demo.entity.Country;
import com.example.demo.entity.Region;
import com.example.demo.repository.CountryRepository;
import com.example.demo.repository.RegionRepository;
import com.example.demo.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/region")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @PostMapping("/create")
    public RegionResponse createRegion(@RequestBody CreateRegionRequest request) {
        RegionResponse response = regionService.createRegion(request);
        return response;
    }

    @GetMapping()
    public RegionResponse getRegionById(@RequestParam(name = "id") String id) {
        return regionService.getRegionById(id);
    }

    @GetMapping("/readAllByCountry")
    public List<GetAllRegionByCountryResponse> getAllRegionByCountry(@RequestParam(name = "countryId") String id) {
        return regionService.getAllRegionByCountry(id);
    }

    @GetMapping("/readAll")
    public List<RegionResponse> getAllRegion() {
        return regionService.getAllRegion();
    }

    @DeleteMapping("/delete")
    public boolean deleteRegionById(@RequestParam(name = "id") String id) {
        return regionService.deleteRegionById(id);
    }

}
