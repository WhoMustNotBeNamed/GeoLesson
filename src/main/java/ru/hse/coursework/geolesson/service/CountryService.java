package ru.hse.coursework.geolesson.service;

import ru.hse.coursework.geolesson.model.Country;

import java.util.List;

public interface CountryService {
    // Метод для добавления страны
    void addCountry(Country country);

    // Метод для получения страны по имени
    Country getCountryByName(String name);

    // Метод для получения всех стран
    List<Country> getAllCountries();

    // Метод для получения стран по континенту
    List<Country> getCountriesByContinent(String continent);

    // Метод для обновления информации о стране
    void updateCountry(Country country);

    // Метод для удаления страны по имени
    void deleteCountryByName(String name);
}
