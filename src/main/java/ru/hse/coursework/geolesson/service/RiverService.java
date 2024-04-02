package ru.hse.coursework.geolesson.service;

import ru.hse.coursework.geolesson.model.River;

import java.util.List;

public interface RiverService {
    // Метод для добавления реки
    void addRiver(River river);

    // Метод для получения реки по имени
    River getRiverByName(String name);

    // Метод для получения всех рек
    List<River> getAllRivers();

    // Метод для обновления информации о реке
    void updateRiver(River river);

    // Метод для удаления реки по имени
    void deleteRiverByName(String name);
}

