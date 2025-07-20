package com.example.demo.service;

import com.example.demo.dto.request.CreateRegionRequest;
import com.example.demo.dto.response.GetAllRegionByCountryResponse;
import com.example.demo.dto.response.RegionResponse;
import com.example.demo.entity.Country;
import com.example.demo.entity.Region;
import com.example.demo.repository.CountryRepository;
import com.example.demo.repository.RegionRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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
        region.setCountryId(country.getId());

        //Сохраняем регион
        Region savedRegion = regionRepository.save(region);

        return new RegionResponse(
                savedRegion.getId().toString(),
                savedRegion.getName(),
                country.getName()
        );
    }

    @Override
    public RegionResponse getRegionById(String id) {
        Region region = regionRepository.findById(id).get();

        String countryId = region.getCountryId().toString();
        Country country = countryRepository.findById(countryId).get();
        //Country country = countryRepository.findById(region.getCountryId().toString()).get(); в одну строку

        RegionResponse getRegionByIdResponse = new RegionResponse(region.getId().toString(), region.getName(), country.getName());
        return getRegionByIdResponse;
    }

    @Override
    public List<GetAllRegionByCountryResponse> getAllRegionByCountry(String id) {
        ObjectId countryObjectId = new ObjectId(id);

        List<Region> regions = regionRepository.findAllByCountryId(countryObjectId);
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

        Set<String> countryIds = regions.stream()
                .map(Region::getCountryId)
                .map(ObjectId::toString)
                .collect(Collectors.toSet());

        List<Country> countries = countryRepository.findAllById(countryIds);
        Map<ObjectId, Country> countryMap = countries.stream()
                .collect(Collectors.toMap(Country::getId, c -> c));

        return regions.stream()
                .map(region -> {
                    Country country = countryMap.get(region.getCountryId());
                    return new RegionResponse(
                            region.getId().toString(),
                            region.getName(),
                            country != null ? country.getName() : "Unknown"
                    );
                })
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteRegionById(String id) {
        if (regionRepository.existsById(id)) {
            regionRepository.deleteById(id);
            return true;
        } else return false;
    }
}
