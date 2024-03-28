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
    public void updateCountry(Country country) {
        if (country == null) {
            throw new IllegalArgumentException("Country cannot be null");
        } else if (countryRepository.getCountryByName(country.getName()).isEmpty()) {
            throw new IllegalArgumentException("Country does not exist");
        }

        countryRepository.getCountryByName(country.getName()).ifPresent(c -> {
            c.setContinent(country.getContinent());
            c.setCapital(country.getCapital());
            c.setFlag(country.getFlag());
            c.setSquare(country.getSquare());
            c.setFormOfGovernment(country.getFormOfGovernment());
            c.setCurrency(country.getCurrency());
            c.setPopulation(country.getPopulation());
            c.setLanguage(country.getLanguage());
            c.setReligion(country.getReligion());
            c.setClimate(country.getClimate());
            c.setGdp(country.getGdp());
            c.setGdpPerCapita(country.getGdpPerCapita());
            c.setLevelOfDevelopment(country.getLevelOfDevelopment());
            c.setUnemployment(country.getUnemployment());
            c.setGoldReserves(country.getGoldReserves());
            c.setInflation(country.getInflation());
            c.setImports(country.getImports());
            c.setExports(country.getExports());
            c.setNaturalResources(country.getNaturalResources());
            c.setMineralResources(country.getMineralResources());
            c.setWaterResources(country.getWaterResources());
            c.setRecreationalResources(country.getRecreationalResources());
            c.setAgriculture(country.getAgriculture());
            c.setIndustry(country.getIndustry());
            c.setTransportSystem(country.getTransportSystem());
            c.setRuralPopulation(country.getRuralPopulation());
            c.setUrbanPopulation(country.getUrbanPopulation());
            c.setLiteracyRate(country.getLiteracyRate());
            countryRepository.save(c);
        });
    }

        @Override
    public void deleteCountryByName(String name) {
        if (countryRepository.getCountryByName(name).isEmpty()) {
            throw new IllegalArgumentException("Country does not exist");
        }
        countryRepository.deleteByName(name);
    }
}
