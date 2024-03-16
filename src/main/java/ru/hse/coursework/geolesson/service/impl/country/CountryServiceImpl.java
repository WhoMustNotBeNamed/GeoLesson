package ru.hse.coursework.geolesson.service.impl;

import ru.hse.coursework.geolesson.model.Country;
import ru.hse.coursework.geolesson.repository.CountryRepository;
import ru.hse.coursework.geolesson.service.CountryService;

import java.util.List;

public class CountryServiceImpl implements CountryService {
    private CountryRepository countryRepository;
    @Override
    public void addCountry(Country country) {
        if (country == null) {
            throw new IllegalArgumentException("Country cannot be null");
        }

        if (countryRepository.existsById(country.getName())) {
            throw new IllegalArgumentException("Country already exists");
        }

        countryRepository.save(country);
    }

    @Override
    public Country getCountryByName(String name) {
        return countryRepository.getCountryByName(name).orElse(null);
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}
