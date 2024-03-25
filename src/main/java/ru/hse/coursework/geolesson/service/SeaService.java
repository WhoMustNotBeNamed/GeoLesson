package ru.hse.coursework.geolesson.service;

import ru.hse.coursework.geolesson.model.Country;
import ru.hse.coursework.geolesson.model.Sea;

import java.util.List;

public interface SeaService {
    void addSea(Sea sea, Country country);
    Sea getSeaByName(String name);
    List<Sea> getAllSeas();
    void deleteSeaByName(String name);
}
