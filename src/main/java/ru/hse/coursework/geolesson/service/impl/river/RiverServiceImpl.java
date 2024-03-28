package ru.hse.coursework.geolesson.service.impl.river;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hse.coursework.geolesson.model.Country;
import ru.hse.coursework.geolesson.model.River;
import ru.hse.coursework.geolesson.service.CountryService;
import ru.hse.coursework.geolesson.service.RiverService;
import ru.hse.coursework.geolesson.repository.RiverRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class RiverServiceImpl implements RiverService {
    private RiverRepository riverRepository;
    private CountryService countryService;

    @Override
    public void addRiver(River river) {
        if (river == null) {
            throw new IllegalArgumentException("River cannot be null");
        } else if (riverRepository.getRiverByName(river.getName()).isPresent()) {
            throw new IllegalArgumentException("River already exists");
        }
        for (String countryName : river.getCountries().split(", ")) {
            Country country = countryService.getCountryByName(countryName);
            if (country == null) {
                throw new IllegalArgumentException("Country not found: " + countryName);
            } else if (country.getRivers().contains(river)) {
                throw new IllegalArgumentException("River already exists in the country");
            }
            country.getRivers().add(river);
        }
        riverRepository.save(river);
    }

    @Override
    public River getRiverByName(String name) {
        return riverRepository.getRiverByName(name).orElse(null);
    }

    @Override
    public List<River> getAllRivers() {
        return riverRepository.findAll();
    }

    @Override
    public void deleteRiverByName(String name) {
        if (riverRepository.getRiverByName(name).isEmpty()) {
            throw new IllegalArgumentException("River does not exist");
        }

        riverRepository.deleteByName(name);
    }
}
