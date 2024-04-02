package ru.hse.coursework.geolesson.service;

import ru.hse.coursework.geolesson.model.Country;
import ru.hse.coursework.geolesson.model.River;

import java.util.List;

public interface RiverService {
    void addRiver(River river);
    River getRiverByName(String name);
    List<River> getAllRivers();
    void updateRiver(River river);
    void deleteRiverByName(String name);
}
