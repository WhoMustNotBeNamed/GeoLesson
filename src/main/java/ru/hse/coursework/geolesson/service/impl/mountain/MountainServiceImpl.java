package ru.hse.coursework.geolesson.service.impl.mountain;

import jakarta.transaction.Transactional;
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

    // Метод для добавления горы
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

    // Метод для обновления информации о горе
    @Override
    public void updateMountain(Mountain mountain) {
        if (mountain == null) {
            throw new IllegalArgumentException("Mountain cannot be null");
        } else if (mountainRepository.getMountainByName(mountain.getName()).isEmpty()) {
            throw new IllegalArgumentException("Mountain does not exist");
        }

        mountainRepository.getMountainByName(mountain.getName()).ifPresent(m -> {
            m.setHeight(mountain.getHeight());
            m.setLength(mountain.getLength());
            m.setHighestPoint(mountain.getHighestPoint());
            m.setClimate(mountain.getClimate());
            m.setResources(mountain.getResources());
            m.setOrigin(mountain.getOrigin());
            m.setCountries(mountain.getCountries());
            mountainRepository.save(m);
        });
    }

    // Метод для получения горы по имени
    @Override
    public Mountain getMountainByName(String name) {
        return mountainRepository.getMountainByName(name).orElse(null);
    }

    // Метод для получения всех гор
    @Override
    public List<Mountain> getAllMountains() {
        return mountainRepository.findAll();
    }

    // Метод для удаления горы по имени
    @Override
    @Transactional
    public void deleteMountainByName(String name) {
        if (mountainRepository.getMountainByName(name).isEmpty()) {
            throw new IllegalArgumentException("Mountain does not exist");
        }
        countryService.getAllCountries().forEach(country ->
                country.getMountains().removeIf(mountain -> mountain.getName().equals(name)));
        mountainRepository.deleteByName(name);
    }
}

