package ru.hse.coursework.geolesson.service;

import ru.hse.coursework.geolesson.model.Sea;

import java.util.List;

public interface SeaService {
    // Метод для добавления моря
    void addSea(Sea sea);

    // Метод для получения моря по имени
    Sea getSeaByName(String name);

    // Метод для получения всех морей
    List<Sea> getAllSeas();

    // Метод для обновления информации о море
    void updateSea(Sea sea);

    // Метод для удаления моря по имени
    void deleteSeaByName(String name);
}

