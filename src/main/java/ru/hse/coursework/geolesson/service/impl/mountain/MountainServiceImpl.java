package ru.hse.coursework.geolesson.service.impl.mountain;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hse.coursework.geolesson.model.Country;
import ru.hse.coursework.geolesson.model.Mountain;
import ru.hse.coursework.geolesson.repository.MountainRepository;
import ru.hse.coursework.geolesson.service.CountryService;
import ru.hse.coursework.geolesson.service.MountainService;

import java.util.List;

@Service
@AllArgsConstructor
class MountainServiceImpl implements MountainService {
    private MountainRepository mountainRepository;
    private CountryService countryService;
    @Override
    public void addMountain(Mountain mountain) {
        if (mountain == null) {
            throw new IllegalArgumentException("Mountain cannot be null");
        } else if (mountainRepository.getMountainByName(mountain.getName()).isPresent()) {
            throw new IllegalArgumentException("Mountain already exists");
        }

        for (String countryName : mountain.getCountries().split(", ")) {
            Country country = countryService.getCountryByName(countryName);
            if (country == null) {
                throw new IllegalArgumentException("Country not found: " + countryName);
            } else if (country.getMountains().contains(mountain)) {
                throw new IllegalArgumentException("Mountain already exists in the country");
            }
            country.getMountains().add(mountain);
        }

        mountainRepository.save(mountain);
    }

    @Override
    public Mountain getMountainByName(String name) {
        return mountainRepository.getMountainByName(name).orElse(null);
    }

    @Override
    public List<Mountain> getAllMountains() {
        return mountainRepository.findAll();
    }

    @Override
    public void deleteMountainByName(String name) {
        if (mountainRepository.getMountainByName(name).isEmpty()) {
            throw new IllegalArgumentException("Mountain does not exist");
        }
        mountainRepository.deleteByName(name);
    }
}
