package com.example.demo.service;

import com.example.demo.dto.request.CreateCityRequest;
import com.example.demo.dto.request.CreateCountryRequest;
import com.example.demo.dto.response.CityResponse;
import com.example.demo.dto.response.CountryResponse;
import com.example.demo.dto.response.GetAllCityByRegionResponse;
import com.example.demo.entity.City;
import com.example.demo.entity.Country;
import com.example.demo.entity.Region;
import com.example.demo.repository.CityRepository;
import com.example.demo.repository.CountryRepository;
import com.example.demo.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private RegionRepository regionRepository;
    @Autowired
    private CityRepository cityRepository;

    @Override
    public CityResponse createCity(CreateCityRequest request) {//Это метод, который получает DTO-запрос (входные данные от пользователя) и возвращает DTO-ответ после создания страны.
        final City city = new City();//Создаём новую сущность города, которую будем сохранять в базу.
        Region region = regionRepository.findById(request.regionId()).get();//Извлекаю регион из базы данных по regionId, который пришёл в запросе.

        city.setName(request.name());//Устанавливаем имя города из полученного запроса, мы берём его name().
        city.setRegion(region);//Привязываю регион к городу.
        City savedCity = cityRepository.save(city);//Сохраняю город в MongoDB. После этого savedCity будет содержать уже сгенерированный ID.

        CityResponse createCityResponse = new CityResponse(
                savedCity.getId().toString(),
                savedCity.getName(),
                savedCity.getRegion().getName(),
                region.getCountry().getName()
        );//Собираю и возвращаю DTO-ответ CityResponse.

        return createCityResponse;
    }

    @Override
    public CityResponse GetCityById(String id) {
        City city = cityRepository.findById(id).get();

        CityResponse getCityByIdResponse = new CityResponse(
                city.getId().toString(),
                city.getName(),
                city.getRegion().getName(),
                city.getRegion().getCountry().getName()
        );

        return getCityByIdResponse;
    }

    @Override
    public List<GetAllCityByRegionResponse> getAllCityByRegion(String id) {
        List<City> cities = cityRepository.findAllByRegion_Id(id);
        List<GetAllCityByRegionResponse> responseList = new ArrayList<>();

        for (City city : cities){
            GetAllCityByRegionResponse cityResponse = new GetAllCityByRegionResponse(
                    city.getId().toString(),
                    city.getName(),
                    city.getRegion().getCountry().getName()
            );
            responseList.add(cityResponse);
        }
        return responseList;
    }

    @Override
    public List<CityResponse> getAllCity() {
        List<City> cities = cityRepository.findAll();
        List<CityResponse> responseList = new ArrayList<>();

        for (City city : cities){
            CityResponse cityResponse = new CityResponse(
                    city.getId().toString(),
                    city.getName(),
                    city.getRegion().getName(),
                    city.getRegion().getCountry().getName()
            );
            responseList.add(cityResponse);
        }
        return responseList;
    }

    @Override
    public boolean deleteCityById(String id) {
        if (cityRepository.existsById(id)) {
            cityRepository.deleteById(id);
            return true;
        } else return false;
    }
}
