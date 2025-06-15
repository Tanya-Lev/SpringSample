package com.example.demo.service;

import com.example.demo.dto.request.CreateCountryRequest;
import com.example.demo.dto.response.CreateCountryResponse;
import com.example.demo.dto.response.ReadCountryResponse;
import com.example.demo.entity.Country;
import com.example.demo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@RequiredArgsConstructor
@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;


    @Override
    public CreateCountryResponse createCountry(CreateCountryRequest request) {
        Country country = new Country();
        country.setName(request.name());

        Country dbResponse = countryRepository.save(country);

        CreateCountryResponse createCountryResponse = new CreateCountryResponse(dbResponse.getId().toString(), dbResponse.getName());
        return createCountryResponse;
    }

    @Override
    public ReadCountryResponse getCountryById(String id) {

        Country country = countryRepository.findById(id).get();

        ReadCountryResponse readCountryResponse = new ReadCountryResponse(country.getId().toString(), country.getName());
        return readCountryResponse;
    }

    @Override
    public List<ReadCountryResponse> getAllCountry() {
        List<Country> countries = countryRepository.findAll();
        List<ReadCountryResponse> responseList = new ArrayList<>();
        for (Country country : countries) {
            ReadCountryResponse readCountryResponse = new ReadCountryResponse(
                    country.getId().toString(),
                    country.getName()
            );
            responseList.add(readCountryResponse);
        }
        return responseList;
    }

    @Override
    public boolean deleteCountryById(String id) {
        if (countryRepository.existsById(id)) {
            countryRepository.deleteById(id);
            return true;
        } else return false;
    }

}
