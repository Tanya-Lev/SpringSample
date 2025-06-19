package com.example.demo.service;

import com.example.demo.dto.request.CreateCountryRequest;
import com.example.demo.dto.response.CountryResponse;
import com.example.demo.dto.response.GetCountryByIdResponse;
import com.example.demo.entity.Country;
import com.example.demo.mapper.CountryMapper;
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
    public CountryResponse createCountry(CreateCountryRequest request) {//Это метод, который получает DTO-запрос (входные данные от пользователя) и возвращает DTO-ответ после создания страны.
        final Country country = new Country();//Создаём новую сущность страны, которую будем сохранять в базу.
        country.setName(request.name());//Устанавливаем название страны из полученного запроса, мы берём его name().

        Country savedCountry = countryRepository.save(country);//Сохраняем страну в базу данных. Репозиторий возвращает объект Country с уже установленным id

        //CountryResponse CountryResponse = new CountryResponse(savedCountry.getId().toString(), savedCountry.getName());
        return CountryMapper.toCountryResponse(savedCountry);//Собираем DTO-ответ. Он содержит id и name, и его мы потом отправим клиенту.
    }

    @Override
    public GetCountryByIdResponse getCountryById(String id) {

        Country country = countryRepository.findById(id).get();

        GetCountryByIdResponse getCountryByIdResponse = new GetCountryByIdResponse(country.getName());
        return getCountryByIdResponse;
    }

    @Override
    public List<CountryResponse> getAllCountry() {
        List<Country> countries = countryRepository.findAll();
        List<CountryResponse> responseList = new ArrayList<>();
        for (Country country : countries) {
            CountryResponse getCountryByIdResponse = new CountryResponse(
                    country.getId().toString(),
                    country.getName()
            );
            responseList.add(getCountryByIdResponse);
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
