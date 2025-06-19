package com.example.demo.service;

import com.example.demo.dto.request.CreateRegionRequest;
import com.example.demo.dto.response.GetAllRegionByCountryResponse;
import com.example.demo.dto.response.GetCountryByIdResponse;
import com.example.demo.dto.response.RegionResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface RegionService {
    public RegionResponse createRegion(CreateRegionRequest request);
    public RegionResponse getRegionById(String id);
    public List<GetAllRegionByCountryResponse> getAllRegionByCountry(String id);
    public List<RegionResponse> getAllRegion();
    public boolean deleteRegionById(String id);

}
