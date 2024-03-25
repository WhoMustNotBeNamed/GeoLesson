package ru.hse.coursework.geolesson.service.impl.country;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hse.coursework.geolesson.model.Country;
import ru.hse.coursework.geolesson.repository.CountryRepository;
import ru.hse.coursework.geolesson.service.CountryService;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {
    private CountryRepository countryRepository;
    @Override
    @Transactional
    public void addCountry(Country country) {
        if (country == null) {
            throw new IllegalArgumentException("Country cannot be null");
        } else if (countryRepository.getCountryByName(country.getName()).isPresent()) {
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

    @Override
    public void deleteCountryByName(String name) {
        if (countryRepository.getCountryByName(name).isEmpty()) {
            throw new IllegalArgumentException("Country does not exist");
        }
        countryRepository.deleteByName(name);
    }
}
