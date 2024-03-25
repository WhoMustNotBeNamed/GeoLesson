package ru.hse.coursework.geolesson.service;

import ru.hse.coursework.geolesson.model.Country;
import ru.hse.coursework.geolesson.model.Mountain;

import java.util.List;

public interface MountainService {
    void addMountain(Mountain mountain, Country country);
    Mountain getMountainByName(String name);
    List<Mountain> getAllMountains();
    void deleteMountainByName(String name);
}
