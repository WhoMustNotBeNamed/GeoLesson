package ru.hse.coursework.geolesson.service.impl.sea;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hse.coursework.geolesson.model.Country;
import ru.hse.coursework.geolesson.model.Sea;
import ru.hse.coursework.geolesson.repository.SeaRepository;
import ru.hse.coursework.geolesson.service.CountryService;
import ru.hse.coursework.geolesson.service.SeaService;

import java.util.List;

@Service
@AllArgsConstructor
public class SeaServiceImpl implements SeaService {
    private SeaRepository seaRepository;
    private CountryService countryService;

    @Override
    public void addSea(Sea sea) {
        if (sea == null) {
            throw new IllegalArgumentException("Sea cannot be null");
        } else if (seaRepository.getSeaByName(sea.getName()).isPresent()) {
            throw new IllegalArgumentException("Sea already exists");
        }
        for (String countryName : sea.getCountries().split(", ")) {
            Country country = countryService.getCountryByName(countryName);
            if (country == null) {
                throw new IllegalArgumentException("Country not found: " + countryName);
            } else if (country.getSeas().contains(sea)) {
                throw new IllegalArgumentException("Sea already exists in the country");
            }
            country.getSeas().add(sea);
        }
        seaRepository.save(sea);
    }

    @Override
    public Sea getSeaByName(String name) {
        return seaRepository.getSeaByName(name).orElse(null);
    }

    @Override
    public List<Sea> getAllSeas() {
        return seaRepository.findAll();
    }

    @Override
    public void deleteSeaByName(String name) {
        if (seaRepository.getSeaByName(name).isEmpty()) {
            throw new IllegalArgumentException("Sea does not exist");
        }

        seaRepository.deleteByName(name);
    }
}
