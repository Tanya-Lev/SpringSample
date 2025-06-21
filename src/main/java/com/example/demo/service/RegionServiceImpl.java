package com.example.demo.service;

import com.example.demo.dto.request.CreateRegionRequest;
import com.example.demo.dto.response.GetAllRegionByCountryResponse;
import com.example.demo.dto.response.RegionResponse;
import com.example.demo.entity.Country;
import com.example.demo.entity.Region;
import com.example.demo.repository.CountryRepository;
import com.example.demo.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private RegionRepository regionRepository;

    @Override
    public RegionResponse createRegion(CreateRegionRequest request) {
        Country country = countryRepository.findById(request.countryId()).get();

        //Создаём регион и устанавливаем имя и страну
        Region region = new Region();
        region.setName(request.name());
        region.setCountry(country); // устанавливаем объект, он сохранится как ссылка

        //Сохраняем регион
        Region savedRegion = regionRepository.save(region);

        return new RegionResponse(
                savedRegion.getId().toString(),
                savedRegion.getName(),
                savedRegion.getCountry().getName() // страна будет загружена из @DBRef
        );
    }

    @Override
    public RegionResponse getRegionById(String id) {
        Region region = regionRepository.findById(id).get();
        RegionResponse getRegionByIdResponse = new RegionResponse(region.getId().toString(), region.getName(), region.getCountry().getName());
        return getRegionByIdResponse;
    }

    @Override
    public List<GetAllRegionByCountryResponse> getAllRegionByCountry(String id) {
        List<Region> regions = regionRepository. findAllByCountry_Id(id);
        List<GetAllRegionByCountryResponse> responseList = new ArrayList<>();
        for (Region region : regions) {
            GetAllRegionByCountryResponse getAllRegionByCountryResponse = new GetAllRegionByCountryResponse(
                    region.getId().toString(),
                    region.getName()
            );
            responseList.add(getAllRegionByCountryResponse);
        }
        return responseList;
    }

    @Override
    public List<RegionResponse> getAllRegion() {
        List<Region> regions = regionRepository.findAll();
        List<RegionResponse> responseList = new ArrayList<>();
        for (Region region : regions) {
            RegionResponse regionResponse = new RegionResponse(
                    region.getId().toString(),
                    region.getName(),
                    region.getCountry().getName()
            );
            responseList.add(regionResponse);
        }
        return responseList;
    }

    @Override
    public boolean deleteRegionById(String id) {
        if (regionRepository.existsById(id)) {
            regionRepository.deleteById(id);
            return true;
        } else return false;
    }
}
