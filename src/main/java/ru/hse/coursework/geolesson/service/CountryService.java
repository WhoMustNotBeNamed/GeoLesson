package ru.hse.coursework.geolesson.service;

import ru.hse.coursework.geolesson.model.Country;

import java.util.List;

public interface CountryService {
    void addCountry(Country country);
    Country getCountryByName(String name);
    List<Country> getAllCountries();
    List<Country> getCountriesByContinent(String continent);
    void updateCountry(Country country);
    void deleteCountryByName(String name);
}
