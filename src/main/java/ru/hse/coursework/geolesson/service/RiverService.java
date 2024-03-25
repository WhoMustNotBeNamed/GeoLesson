package ru.hse.coursework.geolesson.service;

import ru.hse.coursework.geolesson.model.Country;
import ru.hse.coursework.geolesson.model.River;

import java.util.List;

public interface RiverService {
    void addRiver(River river, Country country);
    River getRiverByName(String name);
    List<River> getAllRivers();
    void deleteRiverByName(String name);
}
